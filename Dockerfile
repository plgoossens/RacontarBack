FROM maven:3.9.9-eclipse-temurin-24-alpine AS builder
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:23-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY --from=builder /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]