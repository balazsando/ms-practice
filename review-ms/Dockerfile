# Build stage
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17

LABEL authors="balazs.ando"
WORKDIR /app
COPY --from=builder /app/target/review-ms.jar app.jar

EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]