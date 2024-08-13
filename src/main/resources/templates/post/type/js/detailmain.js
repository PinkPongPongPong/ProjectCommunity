const fetchData = async (boardNo) => {
    try {
        const response = await fetch(boardNo);
        if (!response.ok) {
            throw new Error(`Error: ${response.status}`);
        }
        return await response.json();

    } catch (error) {
        console.error('Error fetching data', error);
    }
};

// 게시글 데이터 로드
const loadBoardData = async () => {
    const boardData = await fecthData = ('/api/baords/123');
    if (boardData) {
        document.querySelector('.post-category').textContent = boardData.boardCategory;
        document.querySelector(`.post-info h2`).textContent = boardData.title;
        document.querySelector('.post-info p').textContent = `작성자 : ${boardData.memberNickname} | 조회수 ${boardData.postViews} | 추천수: ${boardData.postUpvoteCount}`
    }
}

// 댓글 데이터 가져오기
const loadComments = async (boardNo) => {
    const comments = await fetchData(`/api/comments/board/${boardNo}`);
    const commentsContainer = document.querySelector(".comment-section");
    commentsContainer.innerHTML = ''; // 기존 댓글 제거
    comments.forEach(comment => {
        const commentElement = document.createElement('div');
        commentElement.classList.add('comment');
        commentElement.innerHTML = `
        <strong>${comment.memberNickName}</string>
        <p>${comment.content}</p>
        <div class="vote-buttons">
            <button class="vote-button">👍 {${comment.commentUpvoteCount}</button>
            <button class="vote-button">삭제</button>
        </div>
`;
    commentsCOntainer.appendChild(commentElement);
    });
};

// 댓글 생성 이벤트 리스너
document.querySelector(`.comment-form`).addEventListener('submit', async (e) => {
    e.preventDefault();
    const content = e.target.querySelector('textarea').value;
    const boardNo = getBoardNo();
    const memberNo = await fetchMemberNo();
    const commentData = {
        content,
        boardNo,
        memberNo,
        memberNickName: ''/*현재 사용자 닉네임*/ // 로그인 상태에서 닉네임을 가져오는 방법
    };
    await fetchData('/api/comments', 'POST', commentData);
    loadComments(boardNo); // 댓글 새로고침
});

// 초기화
document.addEventListEner('DOMContentLoaded', () => {
    const boardNo = getBoardNo(); /*현재 게시판 번호 가져오기*/
    loadComments(boardNo);
});