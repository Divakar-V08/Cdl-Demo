pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                echo "Executing Clone Repository"
                git branch: 'main', url: 'https://github.com/Divakar-V08/Cdl-Demo.git'
            }
        }

        stage('Build Application') {
            steps {
                echo "Executing Build Application"
                sh 'mvn clean install'
            }
        }

        stage('Build commercial-microservice Docker Image') {
            steps {
                sh 'docker stop cdl-commercial'
                sh 'docker rm cdl-commercial'
                sh 'docker rmi cdl-commercial:v1'

                echo "Executing Build Docker Image"
                sh 'docker build -f ./Dockerfile.commercial -t cdl-commercial:v1 ./'
            }
        }

        stage('Build industrial-microservice Docker Image') {
            steps {
                sh 'docker stop cdl-industrial'
                sh 'docker rm cdl-industrial'
                sh 'docker rmi cdl-industrial:v1'

                echo "Executing Build Docker Image"
                sh 'docker build -f ./Dockerfile.industrial -t cdl-industrial:v1 ./'
            }
        }

        stage('Build residential-microservice Docker Image') {
            steps {
                sh 'docker stop cdl-residential'
                sh 'docker rm cdl-residential'
                sh 'docker rmi cdl-residential:v1'

                echo "Executing Build Docker Image"
                sh 'docker build -f ./Dockerfile.residential -t cdl-residential:v1 ./'
            }
        }

        stage('Run commercial-microservice Docker Container') {
            steps {

                echo "Executing start Docker Image"
                sh 'docker run --name cdl-commercial -d -p 6081:8080 --restart=on-failure cdl-commercial:v1'
            }
        }

        stage('Run residential-microservice Docker Container') {
            steps {

                echo "Executing start Docker Image"
                sh 'docker run --name cdl-residential -d -p 6083:8080 --restart=on-failure cdl-residential:v1'
            }
        }

        stage('Run industrial-microservice Docker Container') {
            steps {

                echo "Executing start Docker Image"
                sh 'docker run --name cdl-industrial -d -p 6082:8080 --restart=on-failure cdl-industrial:v1'
            }
        }
    }
}
