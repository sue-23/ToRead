pipeline {
    agent any  // 어떤 Jenkins 에이전트에서나 실행
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/sue-23/ToRead.git'
            }
        }
        stage('Build') {
            steps {
                // 빌드 명령어 실행 (예: Gradle 또는 Maven)
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                // 테스트 실행
                sh './gradlew test'
            }
        }
        stage('Deploy') {
            steps {
                // 배포 작업
                sh 'echo "Deploying application..."'
            }
        }
    }
    post {
        always {
            echo 'This will always run after the pipeline stages.'
        }
        success {
            echo 'Pipeline succeeded.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
