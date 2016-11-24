#!groovy

node {

    withEnv(['GRADLE_OPTS=-Dorg.gradle.daemon=false']) {
        sh 'echo ** $GRADLE_OPTS'
    }

    stage 'Checkout'
    git url: 'https://github.com/imuntyan/pipelinepoc.git'

    stage 'Build'
    sh "./gradlew clean build"
    //step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/TEST-*.xml'])

    stage 'Functional Tests'
    sh "./gradlew functional"

    stage 'BuildRunDocker'
    //sh 'docker kill pipelinepoc'
    //sh 'docker rm pipelinepoc'
    //sh 'docker build -t imuntyan/pipelinepoc .'
    //sh 'docker run -d --name pipelinepoc -p 8180:8180 imuntyan/pipelinepoc'

    def app = docker.build "imuntyan/pipelinepoc"

    stage 'DeployInDev'

    app.push()
    sh 'ci/kubernetes/kubectl-1.4.4 --kubeconfig /jenkins/config --namespace="dev" delete -f ci/kubernetes/dev/ingress.yaml'
    sh 'ci/kubernetes/kubectl-1.4.4 --kubeconfig /jenkins/config --namespace="dev" delete -f ci/kubernetes/service.yaml'
    sh 'ci/kubernetes/kubectl-1.4.4 --kubeconfig /jenkins/config --namespace="dev" delete -f ci/kubernetes/deployment.yaml'
    sh 'ci/kubernetes/kubectl-1.4.4 --kubeconfig /jenkins/config --namespace="dev" apply -f ci/kubernetes/dev/ingress.yaml'
    sh 'ci/kubernetes/kubectl-1.4.4 --kubeconfig /jenkins/config --namespace="dev" apply -f ci/kubernetes/service.yaml'
    sh 'ci/kubernetes/kubectl-1.4.4 --kubeconfig /jenkins/config --namespace="dev" apply -f ci/kubernetes/deployment.yaml'

    sh 'ci/scripts/check_depl.sh http://pipelinepoc.dev.k8.openlane.net/status'

    stage 'LoadTesting'

    sh 'status_url=http://pipelinepoc.dev.k8.openlane.net; export status_url; ./gradlew clean gatlingRun-com.openlane.pipelinepoc.stress.StatusPageSimpleSimulation'
    sh 'status_url=http://pipelinepoc.dev.k8.openlane.net; export status_url; ./gradlew clean gatlingRun-com.openlane.pipelinepoc.stress.StatusPageStressSimulation'

    //sh "./gradlew gatlingRun"
}
