# Git & Github 실무활용 완벽 가이드

### 명령어 정리
- pwd : 현재 디렉토리 경로 출력
- open : 폴더나 파일 실행
- git config --global user.name "" : 유저명 변경
- git config --global user.email "" : 유저 이메일 변경
- cd .. : 상위 디렉토리 이동
- ls : 현재 디렉토리 리스트 출력
- ls -altr : 현재 디렉토리 리스트의 권한까지 출력
- touch [경로] 생성할 파일명... : 경로를 추가하던, 파일명만 입력하여 파일을 생성할 수 있다.
- mkdir [경로] 생성할 디렉토리명: 디렉토리를 생성할 수 있다.
- rm 삭제할 파일명 : 파일을 삭제한다.
- rm -rf 삭제할 디렉터리명: 디렉터리를 삭제한다. (rf 에서 recursive은 재귀, force 는 강제적을 뜻한다.)
    - rm은 영구삭제이기 때문에 조심히 사용해야 한다.
- ls -a : 숨김파일 목록도 보여준다.
- git status : 저장소와 비교하여 변경상태를 확인한다.
- git init : 새로운 깃 저장소를 실체화한다.
- git add : 
- git commit : 깃 저장소에 업데이트 한다.


### 초심자가 실수하는 부분
1. 어떤 프로젝트를 위해 하위 디렉토리에서 변경하는 파일이나 폴더는 깃에 의해 추적된다.
2. 현재 존재하고 있는 저장소 안에 다른 저장소를 초기화하고 싶지 않다는 것을 이해하는 것이 중요하다. (저장소 안에 init 금지)

### 커밋플로우 개요
- 커밋하는 것이 파일을 저장하는 것과는 다른 것이다. 파일을 저장하는 것 이상으로 어떤 것을 구축한다는 것.
- 커밋한 사항을 몇몇을 묶어서 그룹화할 수 있다.
- git commit 시 .git 안에 있는 것들을 변경해서 새 커밋 폴더에 등록한다.