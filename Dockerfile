FROM openjdk:8-jdk-alpine
ADD target/CountryInformation-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","app.jar"]