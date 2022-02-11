FROM openjdk:8-jdk-alpine
LABEL maintainer="rhuthuhegde"
VOLUME /library-system
ADD target/LibrarySystem-0.0.1-SNAPSHOT.jar library-system-spring.jar
ENTRYPOINT ["java","-jar","library-system-spring.jar"]