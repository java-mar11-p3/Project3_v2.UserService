pipeline {
   agent any
   stages {
      stage('Compile') {
         steps {
            sh 'mvn clean package'
         }
      }
      /*stage('Deploy') {
         steps {
            sh 'mvn package'
         }
      }*/
   }
}
