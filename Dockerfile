# Build stage
FROM maven:3.9.5-openjdk-21 AS build
WORKDIR /app
COPY D:/project\ FSD/portfolio/portfolio /app
COPY D:/project\ FSD/portfolio/portfolio/.mvn /app/.mvn
RUN ./mvnw clean package

# Package stage
FROM openjdk
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
