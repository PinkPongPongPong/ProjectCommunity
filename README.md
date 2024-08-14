# ReadMeExample

## 💻 `프로젝트 소개`
게임커뮤니티 사이트 
FPS 라는 대중적인 장르의 대표적인 게임을 주축으로 더 다양한 게임의 커뮤니티를 만들어서 게임의 정보와 그 느낌,감정 을 공유
할 수 있는 그런 커뮤니티를 만들어 유입을 이끌어내고 새롭게 만든 이런 커뮤니티에서 신선함을 느낄 수 있는 커뮤니티 만들려고 했습니다.
<br>

##  ⌨️ `개발 기간`
- 기획단계 07/10 ~ 08/01
- 개발단계 08/01 ~ 08/13

### 🧑‍🤝‍🧑 `멤버구성`
 - 팀장: 강연진 
 - 팀원1: 김강현 
 - 팀원2: 강진영 
 - 팀원3: 이규섭 
### ⚙️ `개발 환경`

- CSS . Html . java . JavaScript . Spring Framework . Thymeleaf . MySql
  
### 📂 `패키지구조`
+---java
|   \---com
|       \---ohgiraffers
|           \---projectgin
|               |   ProjectginApplication.java
|               |   
|               +---auth
|               |   +---controller
|               |   |       AuthController.java
|               |   |       
|               |   +---principal
|               |   |       AuthPrincipal.java
|               |   |       
|               |   \---service
|               |           AuthService.java
|               |           
|               +---common
|               |       Pagenation.java
|               |       PagingButtonInfo.java
|               |       
|               +---config
|               |       NotificationConfig.java
|               |       SecurityConfig.java
|               |       
|               +---controller
|               |       AdminController.java
|               |       BoardController.java
|               |       CommentController.java
|               |       MainController.java
|               |       NotificationController.java
|               |       UserController.java
|               |       
|               \---model
|                   +---dto
|                   |       BoardCategoryDTO.java
|                   |       BoardDTO.java
|                   |       CommentDTO.java
|                   |       CommentUpvoteDTO.java
|                   |       MemberSignupDTO.java
|                   |       NotificationDTO.java
|                   |       PostCategoryDTO.java
|                   |       VoteDTO.java
|                   |       
|                   +---entity
|                   |       Board.java
|                   |       BoardCategory.java
|                   |       Comment.java
|                   |       CommentUpvote.java
|                   |       MemberEntity.java
|                   |       Notification.java
|                   |       PostCategory.java
|                   |       RoleType.java
|                   |       Vote.java
|                   |       
|                   +---repository
|                   |       BoardCategoryRepository.java
|                   |       BoardRepository.java
|                   |       CommentRepository.java
|                   |       MemberRepository.java
|                   |       NotificationRepository.java
|                   |       VoteRepository.java
|                   |       
|                   \---service
|                           AdminService.java
|                           BoardService.java
|                           CommentService.java
|                           MemberService.java
|                           NotificationService.java
|                           
\---resources
    |   application.yml
    |   
    +---static
    |   +---css
    |   |       style.css
    |   |       
    |   \---images
    |           article01.jpg
    |           battleground1.jpg
    |           bestBoard.jpg
    |           callofduty01.jpg
    |           capsule_616x353.jpg
    |           counterstrike.png
    |           FreeBoard.jpg
    |           GIN.PNG
    |           ginphoto.png
    |           list.png
    |           logo1.jfif
    |           NotificationBoard.jpg
    |           OIG2.IPvMlRxAgx5.jpg
    |           photo1.jpg
    |           photo2.jpg
    |           PlaythroughBoard.jpg
    |           rainbowsix.jpg
    |           slider1.jpg
    |           
    \---templates
        |   index.html
        |   main.css
        |   main.html
        |   
        +---admin
        |       board.html
        |       detail.html
        |       member.html
        |       notification.html
        |       notificationInput.html
        |       report.html
        |       
        +---auth
        |       login.html
        |       
        +---common
        |       article.html
        |       aside.html
        |       common.css.html
        |       footer.html
        |       header.html
        |       
        +---flagment
        |       content.html
        |       footer.html
        |       header.html
        |       login.html
        |       sidebar.html
        |       
        +---layout
        |       admin.html
        |       default.html
        |       
        +---notification
        +---post
        |   |   boardlist.html
        |   |   categorylist.html
        |   |   createboard.html
        |   |   detail.html
        |   |   freepostregist.html
        |   |   searchresults.html
        |   |   strategyboard.html
        |   |   strategyregist.html
        |   |   view.html
        |   |   
        |   \---type
        |       \---js
        |               categorydelete.js
        |               detailmain.js
        |               main.js
        |               
        \---user
                mypage.html
                signup.html
                
## 📌 주요 기능
###  🖱️ 공지사항
- 1. html화면에서 라우터를 거쳐서 데이터베이스에 입력하고, 입력된 데이터베이스를 화면에 출력
- 2. 입력된 데이터베이스 목록을 페이징 처리한다.
- 3. 특정 항목을 통해 상세 조회를 할 수 있다.
### 📋 게시판관리 
- 메인 게시판 작성(공동), 글 작성/수정 화면 작성, 글 조회 + 댓글 조회, 댓글 작성 화면 작성
###  🖱️ 회원관리
- 로그인 : 비회원이 로그인에서 아이디 와 비밀번호를 입력했을때 데이터베이스에 존재하는 아이디와 비밀번호이면 메인페이지로 이동
- 회원가입 : 비회원은 이름 닉네임 이메일 전화번호 이메일 을 입력해야하며 빈칸이 있으면 빈칸에 오류문구가 출력되며 회원가입이 되지않음
             중복된 아이디로 회원가입을 진행하면 로그인 페이지로 이동은 하지만 중복된 아이디로는 새로운 계정이 생성되지않음
- 마이페이지 : 로그인한 회원의 닉네임 이메일 전화번호를 확인할 수 있다.
### 📋 게시판관리
- 게시판 관리 기능은 관리자로 로그인할때만 보이도록 설정(부분구현)
- header, footer 작성해서 모든 화면에서 출력되도록(구현)
- 메인 화면의 이미지 클릭하면 해당 게시판으로 이동되도록(부분구현)
- 메인화면의 로그인 창이 스크롤에 따라 이동하지 않고 구상했던 자리에 유지되도록(구현실패)
- 글 조회 화면에서 삭제 클릭하면 '정말로 삭제하시겠습니까?' 팝업 뜨고 yes 클릭하면 삭제되게(미구현)
- 말머리를 선택하면 게시판에서 해당 말머리의 글들만 출력되도록(미구현)
- 게시판에서 말머리를 선택 가능하도록(구현)
- 게시판의 제목과 내용 부분에 placeholder 삽입(구현)
- 게시판의 댓글과 글에 추천 비추천 기능 넣어서 사용할 수 있도록(구현)
- 게시판 댓글에 프로필 사진이 표시되도록(구현)
- 게시판/메인화면에 검색기능 추가되도록(미구현)
- 
## 🗣️ 후기
- ## 김강현 :
  로그인 기능과 회원가입 기능은 어느정도 완성되었지만 마이페이지의 회원 정보 수정 삭제기능이 만들어지지 않아 조금 아쉬웠습니다. 
  #### 개선점 :
  조금더 코드의 대한 이해도가 필요할것 같습니다. 자료를 찾아봤을때 옛날 자료 와 지금 자료를 비교를 하면 쉽사리 코드가 파악이되지 않아 어려움이 있었습니다.
  jpa 와 crud 에 대한 공부가 더 필요한것 같습니다.
  #### 소감 :
  기획단계에서는 팀원들과 소통하며 방향성과 목표가 잡혔다고 생각하지만 방향성이 제대로 잡히지 않아 개발단계에서도 어려움이 있었지만
  지속적인 회의와 피드백으로 프로젝트 자체가 완성되지는 않았지만 팀원들과의 협업으로 이곳까지 왔다고 생각합니다.
  다음 프로젝에서는 좀더 계획적인 기획으로 개발단계에서도 문제가 없도록 사전준비에 더욱 신경을 써야한다는것을 알았습니다.
- ## 이규섭 :
  진영님과 함께 게시판 전반을 맡았는데 처음부터 명확하게 책임을 분담하지 않아 중간에 한 번씩 서로 어디를 작성할지 확인하면서 시간이 더 걸리게 된 면이 있었습니다. 메인 화면 구성에서 각 구성 요소들을 제자리에 배치하는 과정에서 지나치게 오랜 시간이 걸려 
  전체적인 계획이 이그러졌는데 이 부분에서 개선점이 있을 수 있을 것 같습니다.(Figma 작성시 좀 더 구체적으로 명확하게 다양한 시점에서 작성할 것, 각자 구성요소들을 만들어오면 조율과정에서 시간이 오래 걸리니 작업시간을 고려해서 팀워크를 진행할 것?) 개인 
  적 으로는 지금 작성하는 코드 이외에도 전체적인 코딩 진행 속도에 좀 더 기여할 수 있었을 것이라는 아쉬움이 있고, 팀적으로는 스크럼에서 명확하게 그날그날의 할당량을 정하지 않고 다소 느슨하게 진행하다 보니 시간이 촉박한데도 다소 개발 속도에서 느려진 면 
  도 있었던 것 같습니다. 다행히 큰 문제가 되지는 않았지만 소통이 부족해 각자 프로그램을 자기 스타일대로 짜게 된 부분이 있어 소통을 통해 통일성을 좀 더 높일 수 있을 것 같습니다. 또한  프로젝트를 많은 부분을 진행하긴 했지만 전체적으로 피그마에서 제시되 
  었던 것들에 비해 많은 부분이 구현되지 못했는데, 작업 기한을 충분히 고려하지 못했던 면도 있었고, 피그마에서 만들었던 부분을 실제로 구현하려니 구성요소들이 생각처럼 배치되지 못한 일도 있었습니다. 전반적으로는 개인 차원에서나 팀 차원에서나 많은 개선점 
  을 찾을 수 있었습니다.
- ## 강진영 :
  #### 잘한 점 : 
  나는 맞은 역할에 대해서 최대한 협력적으로 역할 분담에 대해서 큰틀에서는 게시판 보드를 만드는 과정이 였기 때문에
  구체적인 역할 분담을 크게 정해지 못해도 구현 할 수 있는 것들은 최대한 해볼려고 했었다.
  그리고 병합하는 과정에서 문제가 생기면은 오류가 먼지 고민을 해보았고 충돌이 나지 않게 최대한 엔티티 수정을 하는데 있어서는 처음에 큰 틀을 
  짰었고 엔티티를 구성하는 것는 팀들과 충분히 의논한다음에 다같이 충돌이 나도 해결해 갔다.
  느낌점은 팀활동하면서 역할 분담에 대한 스크럼이 부족하면은 작업하는데 많은 힘이 든다는걸 많이 깨닳았다. 처음부터 해야할 것들을 을 계속 의논 하지 못했던 점이 아쉬웠었다. 오류코드가 났을때 서비스에서 동작을 하지 않았을 때 이유가 모델 맵퍼하고 엔티티 
  필드값이 소문자가 아니라 대문자로 정의 했었기 때문에 그걸 찾기 위해서 많이 머리가 아팠던거 같다. 그래서 혼자 찾기 힘들어서 gpt한테 고쳐야할 부분을 물어밨더니 오타가 났었고 모델 맵퍼에서 리턴 값이 잘못 정의 되 었었다.
- ## 강연진 :
  이론과 코드가 매칭이되는게 어렵고 공부 범위가 넓어서 막연한 부분이 많아서 코드 시작이 많이 어려웠습니다.
  팀원과 협력하여 진행하는부분에 있어 경험이 많지 않고, 
  내용을 많이 모르는 상황에서 팀장을 맡아 팀원들에게 많이 도움이 되지 못한거같습니다.
  저의 부족한 부분을 다른팀원들이 많이 매꾸어주고 도와주셔서 실습기간동안 많이 배웠으며
  좋은분들과 진행하게되서 감사하다고 생각합니다.
  전반적으로 부족하지만, 기능구현에 있어서 게시한 게시글 수정과 삭제부분에 있어서 끝까지 마무리 하지못했고
  양이 많아서 놓친 이론부분을 끝까지 공부해보고자합니다
