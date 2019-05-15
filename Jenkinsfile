pipeline {
   agent any
   stages {
      stage('Compile') {
         steps {
            sh 'mvn clean compile'
         }
      }
      stage('Test'){
         steps {
            sh 'mvn test'
         }
      }
      stage('Package') {
         steps {
            sh 'mvn package'
         }
      }
            stage('Docker') {
         steps {
            sh 'sudo docker build -t sebenner/project_03:candidate-service .'
            sh 'sudo docker login -u sebenner -p password_123 docker.io'
            sh 'sudo docker push sebenner/project_03:candidate-service'
            sh 'sudo docker login -u sebenner -p password_123 docker.io'
            sh 'sudo docker run -P sebenner/project_03:candidate-service'
         }
      }
      /*stage('Deploy') {
         steps {
            sh 'mvn package'
         }
      }*/
   }
}
