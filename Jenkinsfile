pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                echo "Executing Clone Repository"
                git 'https://github.com/Divakar-V08/Cdl-Demo.git'
            }
        }

        stage('Build Application') {
            steps {
                echo "Executing Build Application"
                sh './mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Executing Build Docker Image"
                sh 'docker build -f ./Dockerfile.commercial -t cdl-commercial:v1 ./'
            }
        }
    }
}
