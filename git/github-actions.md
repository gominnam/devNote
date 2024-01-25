# github actions


## github actions란?

- github actions는 Github 사이트에서 제공하는 `CI/CD(Continue Integration/Continue Deploy)` 서비스이다.
- Github에서 제공하는 서비스이기 때문에 Github에 저장된 소스코드를 사용한다.<br>
  Git에서 push나 merge와 같은 이벤트가 발생하면 Github에서 이를 감지하여 설정된 job을 실행한다.<br>
  이때 job은 workflow 라고도 부르며 .yml 형식으로 작성한다.



## AWS EC2에 배포하기

- [Role 생성] 
  - 위치: IAM > 역할 > 역할 만들기
  - EC2 선택 > Policy name[AWSCodeDeployFullAccess, AmazonS3FullAccess] 선택 > 역할 이름 입력 > 역할 만들기
  - CodeDeploy 용 Role 설정

- [EC2 생성]
  - 위치: EC2 > 인스턴스 시작 > Amazon Linux 2 AMI 선택 > t2.micro 선택 > 검토 및 시작 > 시작하기 > 기존 키 페어 선택 > 인스턴스 시작
  - 인스턴스 생성 후 인스턴스에 접속하여 필요한 패키지 설치(linux commands)
    - sudo yum update -y
    - sudo yum install ruby -y
    - sudo yum install wget -y
    - cd /home/ec2-user
    - wget https://aws-codedeploy-ap-northeast-2.s3.ap-northeast-2.amazonaws.com/latest/install
    - chmod +x ./install
    - sudo ./install auto
    - sudo service codedeploy-agent status

  - EC2 에서 디렉토리 생성한 경우
    - 쓰기 권한 설정 필요  ex) chmod -w /your/directory/file
    - sudo 코드로 파일 생성한 경우 ec2-user 변경  ex) sudo chown -R ec2-user:ec2-user /home/ec2-user/web/server/


## github actions 설정

- [Secrets 설정]
  - 위치: Settings > Secrets > New repository secret
  - Name: AWS_EC2_HOST, Value: EC2의 퍼블릭 IPv4 DNS
  - Name: AWS_ACCESS_KEY_ID, Value: IAM에서 생성한 엑세스 키
  - Name: AWS_SECRET_ACCESS_KEY, Value: IAM에서 생성한 시크릿 엑세스 키


## github actions workflow 설정

- [workflow 설정]
  - 위치: .github/workflows/deploy.yml
  - name: workflow 이름
  - on: 어떤 이벤트가 발생할 때 workflow를 실행할 것인지 설정
  - jobs: workflow가 실행될 때 실행할 job을 설정
  - steps: job이 실행될 때 실행할 명령어를 설정
  - uses: job이 실행될 때 사용할 action을 설정
  - with: action에서 사용할 변수를 설정
  - env: job이 실행될 때 사용할 환경변수를 설정
  - run: job이 실행될 때 실행할 명령어를 설정


## github actions workflow 설정 예시

```yml
name: Deploy to AWS EC2

on:
  push:
    branches:
      - cicd

jobs:
  deploy:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v2

      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'adopt'

      - name: Print current directory
        run: |
          pwd    

      - name: Build Spring Boot application
        run: |
          ./gradlew clean build -x test
          ls -l build/libs/
          pwd

      # Jar 파일을 EC2 인스턴스로 복사
      - name: Copy JAR to EC2 instance
        uses: appleboy/scp-action@master
        with:
          host: ${{ secrets.AWS_EC2_HOST }}
          username: ${{ secrets.AWS_USER_NAME }}
          key: ${{ secrets.AWS_SSH_PRIVATE_KEY }}
          source: "/github/workspace/build/libs/websocket-chat.jar"
          target: "/home/ec2-user/web/server"

      - name: SSH into EC2 and restart application
        uses: appleboy/ssh-action@master
        with:
          host: ${{ secrets.AWS_EC2_HOST }}
          username: ${{ secrets.AWS_USER_NAME }}
          key: ${{ secrets.AWS_SSH_PRIVATE_KEY }}
          port: ${{ secrets.AWS_EC2_PORT }}
          script: |
            cd /home/ec2-user/web/server/github/workspace/build/libs
            sudo systemctl restart websocket-chat

```


## reference

* [AWS 시작 환경 설정](https://blog.bespinglobal.com/post/github-action-%EC%9C%BC%EB%A1%9C-ec2-%EC%97%90-%EB%B0%B0%ED%8F%AC%ED%95%98%EA%B8%B0/)
* ChatGPT 3.5
* [github](https://github.com/gominnam/websocket-chat/)
