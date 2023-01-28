FROM openjdk:17-jdk-slim
EXPOSE 8080
ADD target/weatherforecast.jar weatherforecast.jar
ENTRYPOINT [ "java", "-jar", "/weatherforecast.jar"]