FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle settings.gradle gradle.properties ./
COPY src src

RUN chmod +x gradlew \
    && sed -i '/org.gradle.java.home/d' gradle.properties \
    && ./gradlew bootJar -x test

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 5004
ENTRYPOINT ["java","-jar","/app/app.jar"]
