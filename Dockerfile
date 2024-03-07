# Start with a base image containing Java runtime
FROM adopt openjdk:17-jdk-hotspot

# Add Maintainer Info
LABEL maintainer="jspr200231@gmail.com"

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/my-app.jar .

CMD ["java", "-jar", "my-app.jar"]

EXPOSE 8080

HEALTHCHECK CMD ["curl", "-f", "http://localhost:8080/health"]
