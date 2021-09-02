pipeline {
 agent any
 tools {
  maven "3.2.5"
 }
  parameters {
      choice(name: 'DEPLOYMENT_VERSION', choices: ['1.1', '1.2'])
  }
  stages {
   stage("Build") {
    steps {
     sh "mvn -version"
     sh "mvn clean install"
    }
   }
  }
 post {
  always {
   cleanWs()
  }
 }
}
