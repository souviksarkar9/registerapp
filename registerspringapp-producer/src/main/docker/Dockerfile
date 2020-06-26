FROM ubuntu:latest
FROM souviksarkar9/java-jre-mvn-git-img 

LABEL maintainer = "Souvik Sarkar souviksarkar9@gmail.com.com"

RUN apt-get update 
WORKDIR /usr/local/bin/
COPY maven/registerspringapp-0.0.1-SNAPSHOT.jar producer-registeruserapp.jar 
CMD ["java" , "-jar" , "producer-registeruserapp.jar"]