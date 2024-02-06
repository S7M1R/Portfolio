FROM maven:3.2.0-openjdk-21 AS build
WORKDIR /app
COPY ../../.. /app/
RUN mvn clean package

#
# Package stage
#
FROM openjdk:21.0.1
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]