FROM eclipse-temurin:23-jre

ADD target/ProductService.jar /ProductService.jar
ADD docker/collector/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar

ENTRYPOINT java -javaagent:/opentelemetry-javaagent.jar -jar /ProductService.jar