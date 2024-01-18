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


## github actions 설정

- [Secrets 설정]
  - 위치: Settings > Secrets > New repository secret
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


## reference

* [AWS 시작 환경 설정](https://blog.bespinglobal.com/post/github-action-%EC%9C%BC%EB%A1%9C-ec2-%EC%97%90-%EB%B0%B0%ED%8F%AC%ED%95%98%EA%B8%B0/)
* ChatGPT 3.5
