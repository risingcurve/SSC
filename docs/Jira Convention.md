### 단위

- Epic
  - Story
  - Task

### Epic

- 프로젝트 설계하면서 가장 큰 단위의 기능
- 하나의 기능 및 제공되는 서비스 목록
- Story point는 0
- Epic Name과 Summary는 동일하게 작성

<aside>
💡 예시
[HW] 위치 측량
[TEST] 사용자 API

</aside>

### Story

- 회원에게 제공되는 서비스/기능 목록
- Story Point는 0

<aside>
💡 예시
[공통] PPT 작성
[공통] 데이터베이스 설계
[BE] 사용자 API

</aside>

### Task

- 해당 스토리에 관련한 상세 구현 사항
- Task의 Story point는 4 이하로 작성
- SubTask 작성 대신 확인 가능한 Task로 세분화하여 작성

<aside>
💡 예시
[BE] 사용자 조회 API
[FE] 사용자 정보 페이지

</aside>

### 네이밍 규칙

- 명사로 마무리

- 맨 앞에 대괄호를 사용해 카테고리 설정(영어는 대문자로 작성)

- 공통인 경우 프로젝트명_본인이름 형식으로 통일한다.
  
  ```jsx
  (예시)
  
  Story 요약이
  [공통] Jira Convention 회의
  인 경우,
  
  Task 요약은 
  [공통] Jira Convention 회의_한원종
  [공통] Jira Convention 회의_문승우
  [공통] Jira Convention 회의_안창용
  ...
  과 같은 방식을 작성한다.
  ```

### 카테고리

- 기획/ 설계 / HW / WEB / DB / 배포 / TEST / STUDY / 문서
  - EMBE, KERNEL, FE, BE, 공통
  - 기획 설계 개발

---

### Jira 사용 방법

- 매주 월요일 오전 스크럼때 새로운 스프린트 생성
- 총 240의 story point 필요
  - 월요일 오전에 한 명당 40 point의 이슈를 생성한다.
- jira 상단에 만들기 버튼을 눌러 이슈를 생성
  - 에픽, 스토리 포인트, 담당자 설정
  - 이슈의 하위 이슈를 만들어 상세하게 진행도 가능
- 백로그에 만들었던 이슈가 생성
  - 현재 존재하는 스프린트에 드래그 (예 1주차 스프린트)
- 활성 스프린트 창에서 대기 - 진행중 - 완료 세 단계가 있고 대기쪽에 이슈들이 모여있음