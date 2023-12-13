FROM openjdk:19-jdk-alpine
LABEL authors="jacki"
COPY  target/tienda-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]