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
###  🖱️ 기능명
- 공지사항기능 : 1. html화면에서 라우터를 거쳐서 데이터베이스에 입력하고, 입력된 데이터베이스를 화면에 출력
-               2. 입력된 데이터베이스 목록을 페이징 처리한다.
-               3. 특정 항목을 통해 상세 조회를 할 수 있다.

### 📋 게시판관리 
- 

## 🗣️ 후기

- 김강현 : 
- ...
