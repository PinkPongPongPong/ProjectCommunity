document.addEventListener('DOMContentLoaded', function () {
    // 로그인 폼 처리
    const loginForm = document.querySelector('form[action="/login"]');
    if (loginForm) {
        loginForm.addEventListener('submit', function (e) {
            e.preventDefault();

            // 폼 데이터 가져오기
            const memberId = document.querySelector('#memberId').value;
            const password = document.querySelector('#password').value;

            // 로그인 요청
            fetch('/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ memberId, password })
            })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        window.location.href = '/main';
                    } else {
                        alert('로그인 실패');
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    }
});