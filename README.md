# Git & Github 실무활용 완벽 가이드

### 명령어 정리
- pwd : 현재 디렉토리 경로 출력
- clear : cmd 내용 지우기
- open : 폴더나 파일 실행
- cat : 텍스트 파일의 내용을 화면에 출력하는 명령어
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
    - git branch -d [branch-name] : 브랜치를 삭제한다.
    - git branch -D [branch-name] : 병합여부와 상관없이 삭제한다.
    - git branch -m [branch-name] : 브랜치명을 변경한다.
    - git branch -v: 브랜치 목록과 최종커밋이력을 함께 
    보여준다.
    - git branch -M [brnach-name] : 마스터 브랜치를 변경한다.
    - git branch -r : 원격 추적 브랜치 확인하기
        - git commit 이후 git status를 확인하면 origin/master보다 N커밋 앞서있다는 말이 나온다. 이 말은 메인 브랜치와 origin/master는 똑같은 것을 가리키고 있다는 뜻이다.
        - 원격 추적 참조를 통해 얼마나 앞서있는지 알 수 있다.
- git switch [branch-name] : 이 명령어는 HEAD가 실행한 
브랜치를 바라보게 한다.
    - git switch -c [branch-name] : 브랜치를 생성하고 
    이동까지 한번에 처리한다.
    - git switch - : 직전의 브랜치로 이동한다.
- git checkout [branch-name] : 브랜치 이동을 위한 명령어이다. switch 이전 시대에 사용했지만 현재도 사용가능하다.
    - git checkout HEAD [file-name]: 수정을 해서 status 상태가 있지만 처리하고 싶지 않고 되돌리고 싶을 때 사용한다.
- git merge [branch-name] : HEAD가 가리키는 현재 브랜치에서 지정한 브랜치를 merge한다.
- git diff : 최종 커밋 이력과 현재 파일의 상태를 비교한다.
- git stash : 커밋하지 않은 변경사항들을 임시 저장하도록 해주고 불필요한 커밋으로 이력을 지저분해지는 것 없이 나중에 돌아올 수 있게 해준다.
    - git stash list : stash 저장 리스트를 출력한다.
    - git stash pop [] : stash 저장 정보를 불러온다.
    - git stash apply : peek 메서드와 비슷하다. 내용을 가져오지만 저장공간에 저장 이력을 지우지 않는다. (보통 B 브랜치에서 작업한 걸 마스터브랜치로 적용시킬 때 사용한다. 이력이 남아있어야 작업한 브랜치에서도 불러올 수 있기 때문.)
    - git stash drop []: 저장된 stash 정보를 삭제한다.
    - git stash clear : 저장된 모든 stash 정보를 삭제한다.
- git restore [file-name] : git checkout HEAD [file-name] 과 동일하게 상태가 변경된 파일을 최종커밋 상태로 되돌린다.
단 파일 생성후 생성 전으로 되돌리기는 안되는 듯 싶다.
    - git restore --source HEAD~N [file-name] : 그 파일만 HEAD~N의 위치로 돌아가는 듯?
    - git restore --staged [file-name] : git add를 통해 스테이지에 올려둔 파일을 내릴 수 있다.
- git reset [hashcode]: 커밋된 위치로 되돌릴 수 있다. 작업 내용은 롤백되지 않는다.
- git revert [hashcode] : 커밋을 새로만들고 해시코드 이전으로 되돌릴 수 있다. 커밋이력이 지워지지 않는다.
    - A가 1,2,3 커밋이력이 있고 B가 1,2,3,4의 커밋이력이 존재할 때 B가 4까지 작업을 완료했지만 A가 2,3의 작업을 지우고 싶을 때 reset을 하게되면 B의 4가 지워지기 때문에 A는 revert를 사용하여 이전 이력을 남기면서 내가 지우고 싶은 부분을 수정하여 재커밋할 수 있다.
- git clone [url] : 클라우드에 있는 파일을 다운로드한다.
- SSH 확인하기
    - ls -al ~/.ssh
    - SSH 설정 : https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account
    - 이후 진행 X 필요 시 진행할 예정
- git remote : 현재 저장소에 있는 원격들을 나열해서 보여준다.
    - git remote -v : 저장소의 원격들의 이름과 주소를 보여준다.
    - git remote add [name] [url] : 이름의 표준은 origin이고, url은 깃허브 리포지토리 생성 시 나오는 url을 넣어준다.
    - git remote rename [old] [new] : 원격 이름을 바꾼다.
    - git remote remove [name] : 원격을 삭제한다. 오픈소스의 경우 원격이 여러개라 삭제하는 일도 발생한다.
- git push [remote] [branch]: 클라우드에 커밋된 데이터를 저장한다.
    - git push -u [remote] [branch] : 상류(upstream)을 의미한다. 이 말은 깃에게 로컬 컴퓨터 내 저장소의 마스터 브랜치를 [remote] [branch]로 푸시하라는 뜻이다. 최초 1회 -u를 사용하면 이후 git push 만으로 [remote] [branch]를 생략할 수 있다.
    - git push [remote] [local-branch]:[remote-branch] 로컬에 있는 브랜치로 오리진 브랜치에 푸시할 수 있다.
        - ex : git push origin cats:master
- git fetch [remote] : 원격저장소(클라우드) 에 저장된 자료를 다운로드 한다. 단, 로컬의 working directory와 통합되지 않는다.
- git pull [remote] [branch] : git pull = git fetch + git merge


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
- 브랜치 변경 시 주의사항 
    -  A브랜치에서 B로 변경할 때 충돌되는 부분이 있다면 반드시 커밋을하고 이동해야 함. 안그러면 데이터 유실의 위험이 있음.
    - 그러나 A브랜치엔 없고 B브랜치에 신규로 만든 데이터는 따로 커밋을 하지 않아도 데이터 유실이 발생하지 않고, 병합됨.
    
### Merging
- 특정 커밋이 아니라 브랜치를 병합한다.
- 항상 현재 HEAD 브랜치에 병합한다. 즉 HEAD가 가리키는 브랜치가 메인이 된다.
- 커밋들은 각각의 부모 커밋이 존재하는데 이 때 하나의 부모 이상이 존재할 수도 있다. (다중 브랜치를 통한 병합상황)
- 서로다른 브랜치에서 각자 다른 작업 후 충돌나지 않는 경우 커밋메시지 처리 후 :wq로 병합할 수 있다.
- 충돌 시 사용자가 충돌된 부분을 직접 확인 후 처리해야 한다. 충돌 부분을 사용자가 선택 후 제거 후 커밋한다.
    1. 충돌 시 ====== 를 기준으로 HEAD와 합병하려는 브랜치 코드가 표시된다.
    2. 수정 후 커밋을 하면 병합이 이루어진다.

### git diff
- git diff 란 변경 사항들을 보여주는 명령어다.
- @@ OO값으로 수정된 라인 표시

### git stash
- git stash가 필요한 이유
    - 브랜치에 커밋하지 않은 작업이 있지만 다른 브랜치로 이동해야할 때. 이 때 이동하려는 A에 추가사항이 없고, B에서 추가된 내용만 있을 경우는 이동이 가능하지만, A와 B가 달라서 변경사항이 있을 경우엔 불가능하기 때문이다.

- git stash 동작원리
    - git stash save를 실행 시 Staging Area에 커밋하지 않은 내역을 저장해둔다.
    - git stash list를 사용하여 저장해둔 stas가져올 내용을 git stash pop으로 다시 호출할 수 있다.
    - 인덱스 이력은 스택 형태로 쌓인다.

### 분리된 헤드
- git checkout [hashCode] 입력 시 헤드를 분리시켜 시간이동을 할 수 있다.
- git switch [branch-name] || git checkout [branch-name] 으로 현재 커밋상태로 돌아올 수 있다.
- 일반적으로 헤드는 브랜치를 따라간다. 헤드는 커밋을 참조하지 않는다.
- 분리된 헤드란 브랜치는 최종 커밋상태에서 움직이지 않고, 헤드만 이동하여 로그상태를 확인한다.
- 사용 목적
    - 분리된 헤드를 통해 과거로 돌아가서 탐색 및 새로운 브랜치를 만들어서 새로운 방향으로 개발하기 위함.

### 헤드기반 참조
- git checkout HEAD~N 는 check out log기준 ~N개 이전의 헤드로 이동하기 입니다.

### 수정사항 취소하기
- git Restore는 git checkout 부담을 줄여준다.
- git restore의 두 번째 용도는 스테이지된 파일을 언스테이지하는 것이다.

### Git hub
- 깃허브란?
    - 한마디로 요약하면 깃 저장소를 위한 호스팅 플랫폼
    - 깃허브를 사용하면 클라우드에 깃 저장소를 넣을 수 있다.
    - 깃허브를 이용하면 협업에 좋다.
    - 대기업용이 유료이고, 개인은 무료로 이용 가능하다.

- 깃허브를 사용해야 하는 이유
    - 오픈소스 프로젝트
        - 버그 수정 및 소스 코드 공유
        - 제품사용자들로 구성된 커뮤니티 토론
    - 최신 정보 얻기
    - 협업하기

### git clone
- 로컬에 없고, 클라우드에 있는 디렉토리를 다운로드 할 수 있다.
- git이 존재하는 곳에서 사용하지 않도록 주의해야 한다.
    - git 내의 새폴더가 생기고 그 안에 초기화된 깃 저장소가 들어있기 때문이다.
- git clone은 깃허브에 연결되어 있지 않는다.
    - 이 말은 깃랩의 url도 clone이 가능하고 다른 클라우드도 가능한 곳이 존재한다.

### git hub ssh
- git config user.email
- git config user.name

- 위 두 명령어를 통해 어느 저장소든 정보를 노출할 수 있다. 이러한 문제를 방지하기 위해 git hub 는 ssh (secure shell) 를 관리할 수 있다.

### Add Github Repo
- Github 새 리포지토리 만들기.
- 새 리포지토리 주소 저장 후 저장소로 올릴 git directory 선택
- cmd 열고, git remote add [name] [url] 로 클라우드 연결하기.
- origin이란 ?
    - 오리진은 일반적인 깃 원격 이름이다.

### 메인 및 마스터 : 기본브랜치
- 보통 메인이나 마스터를 같이 브랜치로 사용하지 않는다. git branch -M [branch-name] 을 통해 마스터 브랜치를 변경할 순 있으나, 기존 마스터 브랜치로 푸시하다가 메인 브랜치로 변경하면 클라우드는 마스터 브랜치를 디폴트로 잡는다.
- 이 문제를 해결하기 위해 settings -> branchs -> Default branch에서 기본 브랜치를 변경하면 된다.

### 원격 추적 브랜치로 작업하기
- 클라우드에 올라간 origin/[branch] 가 로컬에 branch 목록에 없다고 하더라고 git switch [branch] 를 사용하면 깃이 로컬에서 그 브랜치를 만들고 동일한 이름의 원격 브랜치를 추적하도록 자동으로 설정한다.

### git fetch, git pull
- Git fetch :  클라우드에 저장된 변경사항을 가져오는데 사용할 수 있다. (변경사항은 다운로드할 수 있지만 로컬에 작업과는 통합되지 않는다.)
- Git Pull : 클라우드에 저장된 변경사항은 가져오며, 로컬의 작업과 통합된다.