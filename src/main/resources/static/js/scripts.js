/*!
* Start Bootstrap - Agency v7.0.4 (https://startbootstrap.com/theme/agency)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-agency/blob/master/LICENSE)
*/
//
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) { 
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    // document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 74,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

    // 실시간 추가중
    // 닉네임 모달 창 --> 변경 함수 (문구변경 + 닉네임 설정->닉네임 수정으로 문구변경 + 모달창 닫기)

    const name_btn = document.getElementById('btn-create-name');
    // 모든 html에 user_name뿌리기
    let user_name;
    user_name = localStorage.getItem('user_name');
    // user_name = NULL이면 false
    // 조건문 ? 선택문1 : 선택문2
    if (user_name){
        document.getElementById("nickname-area").innerText = user_name+"님! 환영합니다.";
        const btn_name=document.getElementById('btn-create-name');
        console.log(btn_name);
        btn_name.innerText ='닉네임 변경';
    }
    else{
    }

    const nickname_area = document.getElementById('confirm_button');
    nickname_area.addEventListener('click', function(){
        const name = document.getElementById('user_name').value;
        // 닉네임 로컬 스토리지에 저장
        localStorage.setItem('user_name', name);
        document.getElementById("nickname-area").innerText = name+"님! 환영합니다.";

        // localStorage에 값이 있으면 아래처럼 닉네임 변경으로 버튼 이름 바뀌게 만들어야될듯
        // var user_name = localStorage.getItem('user_name');
        // if user_name != null (저장된 값이 있음)

        // if (localStorage.getItem('user_name')!=null){
        //
        // }
        const btn_name=document.getElementById('btn-create-name');
        console.log(btn_name);
        btn_name.innerText ='닉네임 변경';

        const modal_1 = document.querySelector('.modal_box');
        const modal_2 = document.querySelector('.modal_texts');
        modal_1.style.display='none';
        modal_2.style.display='none';


    });

    const model_on = document.getElementById("btn-create-name");
    model_on.addEventListener('click', function(){
        const modal_1 = document.querySelector('.modal_box');
        const modal_2 = document.querySelector('.modal_texts');
        modal_1.style.display='block';
        modal_2.style.display='block';
    });

    const model_off = document.getElementById("close_button");
    model_off.addEventListener('click', function(){
        const modal_1 = document.querySelector('.modal_box');
        const modal_2 = document.querySelector('.modal_texts');
        modal_1.style.display='none';
        modal_2.style.display='none';
    });



});