FROM ubuntu:latest
FROM souviksarkar9/java-jre-mvn-git-img 
LABEL maintainer = "Souvik Sarkar souviksarkar9@gmail.com.com"
RUN apt-get update 
WORKDIR /usr/local/bin/
COPY ./target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver-registeruserapp.jar 
CMD ["java" , "-jar" , "eurekaserver-registeruserapp.jar"]