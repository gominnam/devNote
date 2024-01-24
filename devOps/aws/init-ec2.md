# AWS EC2 시작 환경 설정 

- Amazon Elastic Compute Cloud(Amazon EC2)는  Amazon Web Services(AWS) 클라우드에서 온디맨드 확장 가능 컴퓨팅 용량을 제공합니다.<br>
- Amazon EC2를 사용하여 원하는 수의 가상 서버를 구축하고 보안 및 네트워킹을 구성하며 스토리지를 관리할 수 있습니다. <br>
  용량을 추가(스케일 업)하여 월간 또는 연간 프로세스 또는 웹 사이트 트래픽 급증 등 컴퓨팅 사용량이 많은 작업을 처리할 수 있습니다.
  사용량이 감소하면 용량을 다시 축소(스케일 다운)할 수 있습니다.
<br><br>

### EC2 인스턴스 생성 순서
```text
1. AWS Management Console에 로그인합니다.
2. EC2 대시보드로 이동하여 "인스턴스 시작"을 클릭합니다.
3. AMI(Amazon Machine Image) 선택: 원하는 AMI를 선택합니다. 일반적으로 Amazon Linux 또는 Amazon Linux 2를 선택합니다.
4. 인스턴스 유형 선택: 인스턴스 유형을 선택합니다. 개발 환경에 따라 적합한 유형을 선택합니다.
5. 인스턴스 구성: 원하는 설정을 선택하고, 인스턴스 수량 및 네트워크, 서브넷 등을 설정합니다.
6. 스토리지 추가: 원하는 스토리지 설정을 추가합니다.
7. 태그 추가: 필요한 경우 인스턴스에 태그를 추가합니다.
8. 보안 그룹 구성: 필요한 포트를 열거나 특정 IP 주소에 대한 액세스를 허용하는 보안 그룹을 구성합니다.
9. 검토 및 시작: 설정을 검토하고 "시작"을 클릭합니다. 키페어를 선택하거나 새로운 키페어를 생성하여 인스턴스에 연결할 수 있습니다.
```


### EC2 인스턴스 접속
```linux
- sudo yum update -y
- sudo yum install ruby -y
- sudo yum install wget -y
- cd /home/ec2-user
- wget https://aws-codedeploy-ap-northeast-2.s3.ap-northeast-2.amazonaws.com/latest/install
- chmod +x ./install
- sudo ./install auto
- sudo service codedeploy-agent status

//ssh pem file로 aws EC2 인스턴스 로그인하기
chmod 400 /path/to/private-key.pem
ssh -i "~/path/to/private-key.pem" ec2-user@퍼블릭 IPv4 DNS

//개발환경 설정 java17
- sudo yum install java-17-amazon-corretto
- java -version

//my-sql은 Amazon Linux 2는 CentOS 7과는 다르기 때문에 MySQL Community Server를 설치하는 데에 일부 라이브러리의 버전 충돌 문제가 발생하고 있습니다.  
- wget https://dev.mysql.com/get/mysql80-community-release-el7-3.noarch.rpm
- sudo rpm -ivh mysql80-community-release-el7-3.noarch.rpm
- sudo yum-config-manager --disable mysql80-community
- sudo yum-config-manager --enable mysql57-community
- sudo yum install -y mysql-community-server
- sudo service mysqld start //mysql 서버 부팅시 자동 시작
- sudo grep 'temporary password' /var/log/mysqld.log //임시 비밀번호 확인




```


## reference

- [AWS EC2](https://docs.aws.amazon.com/ko_kr/AWSEC2/latest/UserGuide/concepts.html)