pipeline {
 agent any
  stages {
     stage ('compile') {
     steps {
      echo "compile the code"
      }
     }
     stage ('build') {
      steps {
      echo "Building application"
       withMaven(maven : 'mvn_3.8.2') {
       sh "mvn clean install"
       }
      }
     }
  }
}
