pipeline {
    agent any
    tools{
        maven 'maven_3_8_7'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/maksingh91/weatherforecast']])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t mahaveer91/weatherforecast-cicd-image .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u mahaveer91 -p ${dockerhubpwd}'
                   }
                   sh 'docker push mahaveer91/weatherforecast-cicd-image'
                }
            }
        }
    }
}