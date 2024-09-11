# ----------------------------- BACKEND -----------------------------
FROM maven:3-amazoncorretto-17

COPY backend/pom.xml /build/pom.xml
COPY backend/src /build/src
WORKDIR /build

RUN mvn clean package

# ----------------------------- RUN -----------------------------
FROM openjdk:17.0.2-jdk-slim-buster
WORKDIR /build
COPY --from=0 build/target/Quixor-1.0.0.jar build/app.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","build/app.jar"]