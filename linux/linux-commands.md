# linux commands


- Print working directory
  - pwd  # 현재 경로 출력   ex) /home/user


- Make directory 
  - mkdir directory-name  # 디렉토리 생성
  - mkdir -p example/one/two  # 하위 디렉토리 생성

 
- List
  - ls  # 현재 디렉토리의 파일 목록 출력


- Change directory
  - cd directory-name  # 디렉토리 이동
  - cd ..  # 상위 디렉토리로 이동
  - cd ~  # 홈 디렉토리로 이동


- Copy
  - cp file-name new-file-name  # 파일 복사
  - cp -r directory-name new-directory-name  # 디렉토리 복사


- Remove
  - rm file-name  # 파일 삭제
  - rm -r directory-name  # 디렉토리 삭제
  - rm -rf directory-name  # 디렉토리 강제 삭제
  - rm -rf .git  # git 관련 파일 강제 삭제
  - trash file-name  # 파일을 휴지통으로 보냄(send to files to staging area)


- Move
  - mv file-name directory-name  # 파일 이동
  - mv file-name new-file-name  # 파일 이름 변경


- Create
  - touch file-name.txt  # 파일 생성


- Change Permissions
  - chmod +x myfile
  - r: 읽기, w: 쓰기, x: 실행  # 3개의 권한을 3자리 숫자로 표현 ex) 777 >> USER GROUP OTHERS
    - chmod 755 myfile  # 파일에 실행 권한 부여 
    - echo 'echo Hello $USER' > hello.sh
    - chmod +x hello.sh
    - ./hello.sh

- Escalate privileges (sudo)
  - sudo command  # 관리자 권한으로 실행


- shut down(poweroff)
  - shdo shutdown -h now  # 즉시 종료
  - sudo shutdown -h +10  # 10분 후 종료
  - sudo shutdown -h 20:25  # 20:25에 종료


- Read the manual(man)
  - man mkdir  # mkdir 명령어에 대한 설명 출력


- Find the file
  - find directory -name "file-name"  # 디렉토리에서 파일 찾기
  - find directory -name "*.txt"  # 디렉토리에서 txt 파일 찾기


- Find the file with grep
  - grep "search-text" file-name  # 파일에서 텍스트 찾기
  - grep -r "search-text" directory-name  # 디렉토리에서 텍스트 찾기


- Find the running process Info 
  - ps -ef | grep java  # java 프로세스 찾기


- Kill the process
  - kill -9 process-id  # 프로세스 종료 // -9: 강제 종료


- Network 
  - sudo lsof -i :443  # list of files: 443 포트 사용 프로세스 확인
  - sudo netstat -tuln | grep :443  # tuln: tcp, udp, listening, not-resolving

