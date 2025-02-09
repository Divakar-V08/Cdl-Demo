pipeline {
    agent any

    triggers {
        githubPush()
    }

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
                sh './mvnw clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Executing Build Docker Image"
                sh 'docker build -t my-spring-app .'
            }
        }

        stage('Push to Docker Hub') {
            steps {
                echo "Executing Push to Docker Hub"
                withDockerRegistry([credentialsId: 'docker-hub-password', url: '']) {
                    sh 'docker tag my-spring-app your-dockerhub-username/my-spring-app'
                    sh 'docker push your-dockerhub-username/my-spring-app'
                }
            }
        }

        stage('Deploy to Server') {
            steps {
                echo "Executing Deploy to Server"
                sshagent(['server-ssh-key']) {
                    sh '''
                        ssh user@your-server "docker pull your-dockerhub-username/my-spring-app && \
                        docker stop springboot-container || true && \
                        docker rm springboot-container || true && \
                        docker run -d --name springboot-container -p 8080:8080 your-dockerhub-username/my-spring-app"
                    '''
                }
            }
        }
    }
}
