FROM eclipse-temurin:17-jre-alpine
RUN apk add --no-cache tzdata
ENV TZ Europe/Berlin
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-XX:+UseStringDeduplication","-jar","/app.jar"]