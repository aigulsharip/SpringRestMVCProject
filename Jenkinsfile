pipeline {
    agent any
    tools {
        maven 'Maven 3.9.6'

    }

    environment {
        SONARQUBE_TOKEN = credentials('sonarqube-token')
    }

    // Polling interval 5 minutes
    triggers {
        pollSCM('*/5 * * * *')
    }

    stages {
        stage('Source') {
            steps {
                echo "Retriving the project from github"
                git branch: 'master',
                    changelog: false,
                    poll: true,
                    url: 'https://github.com/aigulsharip/SpringRestMVCProject.git'
            }
        }
        stage('Running Tests') {
            steps {
                echo "Running Test..."
                bat 'mvn test'
            }
        }
        stage('Build') {
            steps {
                echo "Cleaning and building the workspace..."
                bat 'mvn clean install'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('SonarQube') {
                        bat "mvn clean install sonar:sonar -Dsonar.login=${SONARQUBE_TOKEN} -Dsonar.java.binaries=target/classes"
                    }
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                script {
                    // Deploy to Tomcat using Deploy to container Plugin
                    deploy adapters: [tomcat9(credentialsId: '81d0af28-ef72-44b8-9aa5-60896046ffef', path: '', url: 'http://localhost:8090/')], contextPath: 'SpringProject', war: '**/*.war'
                }
            }
        }


    }
    post {
        always {
            // Publish JaCoCo coverage results to Jenkins
            jacoco(execPattern: '**/target/jacoco.exec')
        }
    }

}