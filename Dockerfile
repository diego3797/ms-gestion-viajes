FROM openjdk:17
WORKDIR /app
COPY target/app-msgestionviajes.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
