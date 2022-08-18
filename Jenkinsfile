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

    stage('Deploy') {
      steps {
        script {
          sh '''mvn dependency:purge-local-repository'''
          echo 'mvn deploy'
        }
      }
    }

    stage('Post-Build Scan - Code Dx') {
      steps {
        script {
          echo 'API call to IO controller to trigger post-build specific scans on Code Dx'
          def res = sh(script: "curl -d '{\"cdxProjectId\": \"3\", \"buildDownloadLink\": \" \"}' -H 'Content-Type: application/json' http://localhost:49160/post-build-code-dx", returnStdout: true)
          resJSON = readJSON text: res;
        }
      }
    }
  }
}
