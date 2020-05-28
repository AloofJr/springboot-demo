FROM openjdk:8-jdk-alpine

RUN apk add --no-cache bash
COPY ./target/demo-0.0.1-SNAPSHOT.jar /home/admin/myapp/
WORKDIR /home/admin/myapp/

EXPOSE 8080
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
