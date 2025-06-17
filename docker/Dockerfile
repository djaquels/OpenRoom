FROM eclipse-temurin:23-jdk-alpine AS build
WORKDIR /app
COPY gradlew build.gradle ./
COPY gradle ./gradle
COPY src ./src
RUN ./gradlew build -Pprofile=prod -x test

FROM eclipse-temurin:23-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app/app.jar"]