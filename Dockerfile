FROM openjdk:17
EXPOSE 8080
LABEL maintainer="samjay.com"
ADD target/teacher2.0-0.0.1-SNAPSHOT.jar teacher2.0.jar
ENTRYPOINT ["java", "-jar", "teacher2.0.jar"]