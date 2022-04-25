FROM gradle:7.4.2-jdk11 AS gradle
COPY --chown=gradle:gradle .. /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11-jdk
COPY --from=gradle /home/gradle/src/build/libs/*.jar /app/dotaSparker-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","dotaSparker-0.0.1-SNAPSHOT.jar"]