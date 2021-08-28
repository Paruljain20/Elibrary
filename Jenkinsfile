pipeline {
 agent any
  stages {
     stage ('compile') {
     steps {
      echo 'compile the code'
      sh 'mvn clean'
      }
     }
     stage ('build') {
      steps {
      echo "Building application"
      sh 'mvn clean install'
      }
     }
  }
}
