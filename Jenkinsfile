def resJSON
def buildBreakerStatus

pipeline {
    agent any
    tools {
        maven 'Maven3'
    }
    stages {
        stage('Trigger IO Prescription & Code Dx Scan') {
            steps {
                script {
                    echo 'API call to IO controller to get prescription & trigger scans on Code Dx'
                    def res = sh(script: "curl -d '{\"ioProjectName\": \"devsecops-vulnado\", \"cdxProjectId\": \"3\", \"gitProjectName\": \"vulnado\", \"gitBranch\": \"dev\"}' -H 'Content-Type: application/json' http://localhost:49160/code-tx", returnStdout: true)
                    resJSON = readJSON text: res;
                }
            }
        }

        stage('Checkout Source Code') {
            steps {
                cleanWs()
                git branch: 'dev', url: 'https://github.com/devsecops-test/vulnado'
            }
        }

        stage('Build') {
            steps {
                sh '''mvn dependency:purge-local-repository'''
                sh '''mvn clean compile -Dmaven.test.skip=true'''
            }
        }

        stage('Test') {
            steps {
                sh '''mvn clean test'''
            }
        }

        stage('Package') {
            steps {
//                 sh '''mvn dependency:purge-local-repository'''
                sh '''mvn clean package -Dmaven.test.skip=true'''
            }
        }

        stage('IO Workflow & Security Sign-Off') {
            steps {
                script {
                    echo 'API call to IO to trigger Workflow & get build-breaker status'
                    def runId = resJSON.runId
                    def res = sh(script: "curl -d '{\"runId\": \"$runId\"}' -H 'Content-Type: application/json' http://localhost:49160/io-workflow", returnStdout: true)
                    echo "Build Breaker Status: $res";
                    if(res) {
                        buildBreakerStatus = true;
                    } else {
                        buildBreakerStatus = false;
                    }
                }
            }
        }

        stage('Deploy') {
            when {
                expression { buildBreakerStatus == false }
            }
            steps {
                script {
//                     sh '''mvn dependency:purge-local-repository'''
                    sh '''mvn clean package -Dmaven.test.skip=true'''
                }
            }
        }
    }
}
