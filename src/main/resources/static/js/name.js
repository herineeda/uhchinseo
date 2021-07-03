window.addEventListener('DOMContentLoaded', event => {
    const name_btn = document.getElementById('btn-create-name');
    // 모든 html에 user_name뿌리기
    let user_name;
    user_name = localStorage.getItem('user_name');
    // user_name = NULL이면 false
    // 조건문 ? 선택문1 : 선택문2
    if (user_name){
        name_btn.style.display = 'none';
        document.getElementById("nickname-area").innerText = user_name+"님! 환영합니다.";
    }
    else{

    }

});