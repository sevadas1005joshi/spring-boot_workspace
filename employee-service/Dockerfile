FROM openjdk:8
MAINTAINER sevadas joshi<sevadas.joshi@gmail.com>
ADD target/employee-service.jar employee-service.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","employee-service.jar"]