docker build -t transacao-consumer .

docker run -d `
--name transacao-consumer `
--network kafka-net `
-e SPRING_KAFKA_BOOTSTRAP_SERVERS=kafka:9092 `
-e SPRING_DATASOURCE_URL=jdbc:h2:tcp://H2_database:9092/financeiro `
transacao-consumer