#!groovy

node {
    stage 'Checkout'
    git url: 'https://github.com/imuntyan/pipelinepoc.git'

    stage 'Build'
    sh "./gradlew clean build"
    //step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/TEST-*.xml'])

    stage 'BuildRunDocker'
    //sh 'docker kill pipelinepoc'
    //sh 'docker rm pipelinepoc'
    //sh 'docker build -t imuntyan/pipelinepoc .'
    //sh 'docker run -d --name pipelinepoc -p 8180:8180 imuntyan/pipelinepoc'

    def app = docker.build "imuntyan/pipelinepoc"

    stage 'DeployInDev'

    app.push()
    sh 'ci/kubernetes/kubectl-1.4.4 --kubeconfig /jenkins/config --namespace="dev" apply -f ci/kubernetes/dev/ingress.yaml'
    sh 'ci/kubernetes/kubectl-1.4.4 --kubeconfig /jenkins/config --namespace="dev" apply -f ci/kubernetes/service.yaml'
    sh 'ci/kubernetes/kubectl-1.4.4 --kubeconfig /jenkins/config --namespace="dev" apply -f ci/kubernetes/deployment.yaml'

}
