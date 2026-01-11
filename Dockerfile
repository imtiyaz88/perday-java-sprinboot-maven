# Multi-stage Dockerfile for building and running the Spring Boot app
FROM eclipse-temurin:21-jre
VOLUME /tmp
ARG JAR_FILE=target/expense-manager-0.0.1-SNAPSHOT.jar
COPY target/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
