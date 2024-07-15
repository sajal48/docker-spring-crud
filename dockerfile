# Use OpenJDK 17 as the base image
FROM openjdk:21-jdk-slim
LABEL maintainer="newtonh48@gmail.com"

# Set the working directory in the container
WORKDIR /app

# Copy the pre-built jar file into the container
COPY build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]