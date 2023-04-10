## Branch

- master
    - 배포 가능한 상태의 결과물
- develop
    - 구현한 기능을 병합하기 위한 브랜치
    - 통합 폴더의 기능
- feature
    - 개별 기능 구현 브랜치
    - 기능 개발 완료 시 삭제
    - 네이밍 규칙
        - feature/파트/기능
        - feature/be/login

---

## Merge

- MR은 Gitlab을 통해 요청 및 수락
- title : merge 하려는 브랜치
- description :
- merge 후 브랜치 삭제

---

## Commit

- 모든 커밋 메시지는 영어로 작성
- 기본적으로 commit 메시지는 아래와 같이 제목/본문/꼬리말로 구성
    
    ```bash
    type : subject
    
    body
    
    footer
    ```
    
- commit type
    - feat : 새로운 기능 추가
    - fix : 버그 수정
    - docs : 문서 내용 변경
    - style : 포맷, 세미콜론 수정 등 코드가 아닌 스타일에 관련된 수정
    - settings : 환경설정
    - refactor : 리팩토링 코드
    - test : 테스트 코드 추가 및 리팩토링 테스트 등
    - chore : build task 수정, 프로젝트 매니저 설정 수정 등
    - 타입은 소문자로 작성
    - 타입은 항상 대괄호 안에 파트를 입력하여 시작
    - [파트] 타입 → [BE] feat
- 제목(Subject)
    - 제목은 50자 이내로, 대문자로 시작하여 모두 소문자로 작성
    - 마침표로 끝나지 않도록 함
    - 과거 시제를 사용하지 않고 명령어로 작성
    - feat : logined [X] → [BE] feat : Login
- 본문(Body)
    - 선택사항
    - 부연 설명 필요 시 한글로 작성
- 꼬리말(Footer)
    - 선택사항
    - issue tracker id를 작성할 때 사용
    - Jira Code 작성 시 사용
- 예시

```bash
[파트] type : subject
[BE] feat : Login add

로그인 기능 구현
- 아이디, 패스워드

Issue tracker id : 486
JIRA Code : #123
```