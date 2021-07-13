window.addEventListener('DOMContentLoaded', event => {
    // 모든 html에 user_name뿌리기
    let user_name;
    user_name = localStorage.getItem('user_name');
    console.log('유저이름: '+user_name);
    // user_name = NULL이면 false
    // 조건문 ? 선택문1 : 선택문2
    if (user_name){
        document.getElementById("nickname-area").innerText = user_name+"님! 환영합니다.";
    }
    else{

    }

});