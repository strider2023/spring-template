# Build a JAR File
FROM openjdk:8-jdk-alpine AS stage1
WORKDIR /opt/spring-demo-app
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
RUN ./gradlew build || return 0
COPY . ./
RUN ./gradlew build

# Create an Image
FROM openjdk:8-jdk-alpine
WORKDIR /root
# ENV MONGO_URL mongodb://localhost/belfastjug_sample_01
COPY --from=stage1 /opt/spring-demo-app/build/libs/demo-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
ENTRYPOINT ["sh", "-c", "java -jar demo-0.0.1-SNAPSHOT.jar"]