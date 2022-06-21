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
- git reset HEAD [file]: git add를 취소한다.
    - -soft : index보존(add한 상태, staged 상태)
    - -mixed : index취소 (add하기 전 상태, unstaged 상태) [default]
    - -hard : index 취소 (add하기 전 상태, unstaged 상태), 디렉터리 파일 삭제
- git commit : 변경사항을 깃 저장소에 업로드한다.
    - 옵션을 넣지 않았을 경우
        1. vim의 에디터가 나온다.
        2. i를 눌러 insert로 에디터 상태를 변경한다.
        3. 메시지를 입력한다.
        4. esb를 눌러 insert 상태를 해제한다.
        5. :wq를 눌러 에디터를 나온다.
    - -m : 커밋 메시지를 작성한다.
    - --amend : 제일 최근에 커밋한 내용에 수정 및 추가를 할 수 있다.
- git log : 깃 저장소에 대한 커밋 정보들을 검색한다. 저자와 날짜, 이메일 등을 볼 수 있다.
    - --abbrev-commit : 로그의 해쉬값을 작은 단위로 나타낸다.
    - --oneline : 커밋이력 로그를 한줄로만 보여준다.
- git config --global core.editor "code --wait" : git commit을 하면 vim이 나오는 게 아니라 vscode 에디터에서 커밋메시지를 수정할 수 있게 한다.
    - 문제점 : git이 vscode를 못찾을 때
        1. control + shift + p를 눌러서 팔렛 열기
        2. code command ... 찾아야하는데 없음. (진행불가.)

- git branch : 브랜치읨 목록을 보여준다.
    - git branch [branch-name] : 브랜치를 생성한다.
- git switch [branch-name] : 이 명령어는 HEAD가 실행한 브랜치를 바라보게 한다.
    
    


### 초심자가 실수하는 부분
1. 어떤 프로젝트를 위해 하위 디렉토리에서 변경하는 파일이나 폴더는 깃에 의해 추적된다.
2. 현재 존재하고 있는 저장소 안에 다른 저장소를 초기화하고 싶지 않다는 것을 이해하는 것이 중요하다. (저장소 안에 init 금지)

### 커밋플로우 개요
- 커밋하는 것이 파일을 저장하는 것과는 다른 것이다. 파일을 저장하는 것 이상으로 어떤 것을 구축한다는 것.
- 커밋한 사항을 몇몇을 묶어서 그룹화할 수 있다. [Add를 통한 그룹화]
- git commit 시 .git 안에 있는 것들을 변경해서 새 커밋 폴더에 등록한다.

### Atomic Commits (원자적 커밋)
- 커밋의 단위를 최대한 분할하여 작업하는 게 중요하다. 또한 작게만 하는 게 아니라 단일 작업에 집중할 수 있도록 커밋을 유지해라.

### 현재시제의 커밋 메시지를 사용하라
- 현재시제란 어떤것을 만들다, X를 변경하다, X를 고치다 와 같은 동사를 의미한다.
- 동작을 변경하기 위해 코드베이스에 명령하는 것처럼 메시지를 작성한다.
- 현재시제를 사용하는 이유는 하나의 깃이 어느 시점에서 스스로 메시지를 생성하기 때문이고 우리는 병합하는 것에 대해 얘기할 때 병합, 풀, 리퀘스트 같이 현재시제의 메시지를 생성하기 때문이다.

### gitignore
형상관리에 업로드 하지 않을 파일을 관리한다.
- touch .gitignore 를 통해 파일 생성
- .gitignore 에 제외 대상 목록 작성
    - (/)가 있으면 디렉토리, 없으면 파일을 의미
- .gitignore 에 제외 대상 목록으로 지정되면 수정사항이 생겨도 status는 추적하지 못한다.

### branch
여러 방향으로 개발을 진행할 때 사용한다.
공통된 부분에서 브랜치를 통한 새로운 방향으로 개발을 진행 후 여러 케이스 중 가장 이해관계자와의 요구사항이 잘 처리된 브랜치를 병합한다.

- 마스터 브랜치란 (메인 브랜치)?
    - 깃은 항상 브랜치 위에 존재한다.
    - 우리가 브랜치를 따로 만들지 않아도 마스터브랜치가 존재한다. (git init을 통해 생성되는 기본 브랜치)
    - 여타 다른 브랜치와 동일하다. 차이점은 사용자가 직접 만들지 않았을 뿐이다.

- HEAD가 무엇인가?
    - HEAD의 의미 : 우리가 보거나 확인하고 있는 현재 위치를 말하는 것이다. 즉 어느브랜치를 바라보는지에 대한 화살표 같은 것
    