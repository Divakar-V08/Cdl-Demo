pipeline {
    agent any

    environment {
        IMAGE_NAME = "my-spring-app"
        CONTAINER_NAME = "springboot-container"
        DOCKER_HUB_USER = "your-dockerhub-username"
        DOCKER_HUB_PASS = credentials('docker-hub-password') // Set in Jenkins Credentials
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/your-repo/spring-boot-app.git'
            }
        }

        stage('Build Application') {
            steps {
                sh './mvnw clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub-password', url: '']) {
                    sh 'docker tag $IMAGE_NAME $DOCKER_HUB_USER/$IMAGE_NAME'
                    sh 'docker push $DOCKER_HUB_USER/$IMAGE_NAME'
                }
            }
        }

        stage('Deploy to Server') {
            steps {
                sshagent(['server-ssh-key']) {
                    sh '''
                        ssh user@your-server "docker pull $DOCKER_HUB_USER/$IMAGE_NAME && \
                        docker stop $CONTAINER_NAME || true && \
                        docker rm $CONTAINER_NAME || true && \
                        docker run -d --name $CONTAINER_NAME -p 8080:8080 $DOCKER_HUB_USER/$IMAGE_NAME"
                    '''
                }
            }
        }
    }
}
