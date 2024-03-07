# Start with a base image containing Java runtime
FROM maven:3.8.4-openjdk-17-slim AS build

# The application's .jar file
ARG JAR_FILE=target/*.jar

# cd into the app directory
WORKDIR /usr/src/app

# Copy the application's source code from the host to the docker image
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Specifies a new build stage with a new base image
FROM openjdk:17-slim

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's .jar file
ARG JAR_FILE=target/*.jar

# Copy the jar file from the build stage
COPY --from=build /usr/src/app/${JAR_FILE} app.jar