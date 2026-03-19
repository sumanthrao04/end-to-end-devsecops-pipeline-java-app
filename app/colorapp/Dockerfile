# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml first and pre-fetch dependencies
COPY app/colorapp/pom.xml .
RUN mvn dependency:go-offline

# Copy source code later
COPY app/colorapp/src ./src
RUN mvn clean package 



# Runtime stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]