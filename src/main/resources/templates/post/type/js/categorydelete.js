document.addEventListener('DOMContentLoaded', function () {
    // ... (기존 내용)

    // 삭제 버튼 처리
    const deleteButtons = document.querySelectorAll('.delete-button');
    deleteButtons.forEach(button => {
        button.addEventListener('click', function (e) {
            e.preventDefault();
            const categoryId = this.getAttribute('data-category-id');
            const postId = this.getAttribute('data-post-id');

            fetch(`/board/${categoryId}/post/${postId}`, {
                method: 'DELETE'
            })
                .then(response => {
                    if (response.ok) {
                        window.location.reload();
                    } else {
                        alert('삭제 실패');
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    });
});
