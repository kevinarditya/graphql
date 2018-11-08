FROM openjdk:8-alpine
WORKDIR /app/
COPY ./target/ms-kevin-graphql-0.0.1-SNAPSHOT.jar wallet.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "wallet.jar"]