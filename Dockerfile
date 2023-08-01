FROM openjdk:17
WORKDIR /app

COPY ./target/music-library-service-0.0.1-SNAPSHOT.jar ./target/music-library-service-0.0.1-SNAPSHOT.jar

EXPOSE 8063

CMD ["java", "-jar", "./target/music-library-service-0.0.1-SNAPSHOT.jar"]


