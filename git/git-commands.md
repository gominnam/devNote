# git commands


- 디렉토리에 있는 모든 파일 기록
  - git commit 
  - git commit -m "message"


- 브랜치(참조) 만들기
  - git branch branch-name
  - git checkout branch-name  # 브랜치로 이동


- 브랜치 삭제(delete)
  - git branch -d <branch name>


- 브랜치 병합(merge)
  - git merge branch-name


- 작업중인 변경사항 임시저장(stash) 
  - git stash save "message"
  - git stash list  # 임시저장 목록 확인
  - git stash apply stash@{0}  # stash 목록에서 0번째 stash 적용
  - git stash drop stash@{0}  # stash 목록에서 0번째 stash 삭제
  - git stash pop stash@{0}  # stash를 현재 작업 디렉토리에 적용하고, 적용한 stash를 제거

- 브랜치 리베이스(rebase)  # 가지 쳐서 예쁘게 관리할 수 있음(시간적 흐름도 더 명확)
  - git rebase branch-name
  - git rebase -i branch-name  # 인터렉티브 모드로 브랜치 관리

  
- Head 이동  # 트리 자료구조로 관리. 커밋 고유 값은 해쉬이므로 HEAD 이동 가능, 관리
  - git checkout HASHCODE(commit id)
  - git checkout HEAD^
  - git checkout HEAD^^
  - git checkout HEAD~2
  - git checkout HEAD~3


- 브랜치 이동
  - git branch -f branch-name commit-id(or hashcode)


- 히스토리 수정하기(reset)  # 이전 커밋으로 브랜치 이동("히스토리를 고쳐쓴다"는 점 때문에 다른 사람이 작업하는 리모트 브랜치에는 사용하지 않는 것이 좋음)
  - git reset commit-id(or hashcode)


- 히스토리 돌아가기(revert)  # 이전 커밋으로 브랜치 이동(이전 커밋을 취소하고 새로운 커밋을 만듦)
  - git revert commit-id(or hashcode)


- 브랜치 이동 후 커밋하기  # rebase와 비슷하지만 브랜치를 골라서 이동할 수 있음
  - git cherry-pick commit-id(or hashcode)


- 커밋 내용 정정하기(과거 커밋을 수정해야하는 경우 순서대로 작성)
  - git rebase -i HEAD~3  # 변경할 commit을 가장 뒤로 이동시키고 pick을 edit으로 변경git 
    - git commit --amend  # 커밋 수정
      - git rebase --continue  # 커밋 수정 후 rebase 계속 진행

## reference

* [Git learning](https://learngitbranching.js.org/)
