FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD build/libs/pipelinepoc-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","/app.jar"]
EXPOSE 8080