pipeline {
 agent any
 tools {
  maven "3.2.5"
 }
  parameters {
      choice(name: 'DEPLOYMENT_ENVIRONMENT', choices: ['INT', 'QA'])
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
