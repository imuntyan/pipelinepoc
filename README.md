# pipelinepoc

This projects demonstrates the following features:
 
- setting up Jenkins pipelines
- Spring Boot application
- Building a Docker container for deployment
- Spock unit testing framework integration
- Gatling load testing framework integration
- Swagger integration (copied from https://github.com/reasonthearchitect/generator-spring-rest)
- Sonarqube integration (copied from https://github.com/reasonthearchitect/generator-spring-rest, version changed to work with sonarqube LTS 5.6.3)

### Jenkins pipelines

Docker binaries need to be available on the build machine. In order to avoid the docker-in-docker related problems a Jenkins server (v.2.32) has been set up on AWS EC2 instance with Amzn Linux and the Docker installed as well. The Jenkins server requires the Pipeline and Docker Pipeline plugins. The build uploads the docker image to the Dockerhub, so the `sudo -u jenkins docker login` command must be executed manually once before any tests are run.

There is no Github plugin configured that enables the Github to notify the Jenkins server about the changes in the source code. Any build therefore must be triggered manually.


### Load testing

The Load Testing build step deploys this application to the kubernetes cluster and then runs the stress tests against it. The application URL is specified in the Jenkinsfile. There is no `k8.openlane.net` domain under my control so the URL must be manually mapped to the appropriate IP address in the host DNS configuration. The URL is passed to the Gattling test through the environment variable set in the Jenkinsfile script. 

The `Jenkinsfile` script expects the kubernetes config file to be avaiable at `/jenkins/config` readable by the `jenkins` user.


