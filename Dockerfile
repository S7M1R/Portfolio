# Use an official Maven image as a build stage
FROM maven:3.8.4-openjdk-21 AS build
WORKDIR /app

# Copy the entire project to the container
COPY . .

# Build the application using Maven
RUN mvn clean package

# Use an official OpenJDK image as the final stage
FROM openjdk:21
WORKDIR /app

# Copy the JAR file from the build stage to the final stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Specify the command to run on container startup
ENTRYPOINT ["java", "-jar", "app.jar"]
