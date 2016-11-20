#!groovy

node {
    stage 'Checkout'
    git url: 'https://github.com/imuntyan/pipelinepoc.git'

    stage 'Build'
    sh "./gradlew clean build"
    //step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/TEST-*.xml'])

    stage 'BuildRunDocker'
    //sh 'docker kill <%= baseName %>'
    //sh 'docker rm <%= baseName %>'
    sh 'docker build -t imuntyan/pipelinepoc .'
    sh 'docker run -d --name pipelinepoc -p 8180:8180 imuntyan/pipelinepoc'

    //docker.build("imuntyan/pipelinepoc").run({"-d --name pipelinepoc -p 8080:8080"})

}
