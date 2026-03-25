docker build -t conciliacao-service .

docker run -d `
--name conciliacao-service `
--network kafka-net `
-e SPRING_KAFKA_BOOTSTRAP_SERVERS=kafka:9092 `
-e SPRING_DATASOURCE_URL=jdbc:h2:tcp://H2_database:9092/financeiro `
conciliacao-service