FROM eclipse-temurin:23-jdk-alpine
WORKDIR /app
COPY build/libs/*-boot.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app/app.jar"]