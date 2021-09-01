pipeline {
 agent any
 tools {
  maven "3.2.5"
 }
  stages {
   stage("Build") {
    steps {
     bat "mvn -version"
     bat "mvn clean install"
    }
   }
  }
 post {
  always {
   cleanWs()
  }
 }
}
