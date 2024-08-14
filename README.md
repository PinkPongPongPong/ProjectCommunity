# ReadMeExample

## 💻 `프로젝트 소개`
 게임커뮤니티 사이트 
 
<br>

##  ⌨️ `개발 기간`
* 08/01 - 08/13

### 🧑‍🤝‍🧑 `멤버구성`
 - 강연진 :
 - 김강현 :
 - 강진영 :
 - 이규섭 :


### ⚙️ `개발 환경`
- 
  
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
###📋 게시판관리
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
## 🗣️ 후기

- 김강현 : 
- ...
