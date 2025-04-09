FROM maven:3.9.9-eclipse-temurin-24-alpine AS builder
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:23-jdk-alpine
EXPOSE 8080
RUN --mount=type=bind,id=gcloud,src=/etc/secrets/application_default_credentials.json,dst=/tmp/gcloud/application_default_credentials.json
#COPY /etc/secrets/application_default_credentials.json /tmp/gcloud/application_default_credentials.json
COPY --from=builder /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]