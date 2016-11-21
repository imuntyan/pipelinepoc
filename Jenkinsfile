#!groovy

podTemplate(label: 'buildpod', containers: [
        containerTemplate(name: 'gradle', image: 'frekele/gradle:3.2-jdk8', ttyEnabled: true, command: 'cat'),
        containerTemplate(name: 'docker', image: 'docker:1.12.3-dind', ttyEnabled: true, command: 'cat', privileged: true)
]
//        ,volumes: [secretVolume(secretName: 'shared-secrets', mountPath: '/etc/shared-secrets')]
) {

    node ('buildpod') {

        stage 'Checkout'
        git url: 'https://github.com/imuntyan/pipelinepoc.git'

        container('gradle') {
            stage 'Build'
            sh 'gradlew clean build'
        }

/*
        container('docker') {
            stage 'BuildRunDocker'
            sh 'docker build -t imuntyan/pipelinepoc .'
        }
*/

    }
}

/*
node {
    stage 'Checkout'
    git url: 'https://github.com/imuntyan/pipelinepoc.git'

    stage 'Build'
    sh "./gradlew clean build"
    //step([$class: 'JUnitResultArchiver', testResults: '**//*
build/test-results/TEST-*.xml'])

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

    sh 'status_url=http://pipelinepoc.dev.k8.openlane.net; export status_url; ./gradlew gatlingRun'

    //sh "./gradlew gatlingRun"
}
*/
