# Sistema de Faturamento

## Docker Network
```bash
docker network create kafka-net
```
## H2 database
```bash
docker run -d -p 9093:9092 -p 8082:8082 -v C:\volumes\h2-data:/h2-data --name="H2_database" --network kafka-net thomseno/h2
```
## Kafka
```bash
docker run -d `
--name kafka `
--network kafka-net `
-p 9092:9092 `
-e KAFKA_NODE_ID=1 `
-e KAFKA_PROCESS_ROLES=broker,controller `
-e KAFKA_LISTENERS=PLAINTEXT://:9092,CONTROLLER://:9093 `
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://kafka:9092 `
-e KAFKA_CONTROLLER_LISTENER_NAMES=CONTROLLER `
-e KAFKA_CONTROLLER_QUORUM_VOTERS=1@kafka:9093 `
-e KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT `
-e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 `
apache/kafka:latest
```
## Transacao Producer
```bash
docker run -d `
--name transacao-producer `
--network kafka-net `
-e SPRING_KAFKA_BOOTSTRAP_SERVERS=kafka:9092 `
transacao-producer  
```
