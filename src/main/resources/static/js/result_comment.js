
/* 결과 화면 comment 데이터
    1 -> 4 순서로 고득점자
*/

const stage_1 = '아는게 뭐에요? 노력하자 아자아자!'
const stage_2 = '아싸도 인싸도 아닌 당신은 그럴싸!! 노래는 다 알지만 춤은 섭렵하지 못했군요ㅜㅜ'
const stage_3 = '핵인싸! 왕년에 뮤직뱅크 좀 봤나봐요~'
const stage_4 = '당신은 K-POP 고인물! 덕후력 200점 만점에 200점!'

const new_word_1 = '뼛속까지 어르신인 당신! 분발합시다'
const new_word_2 = '억지로 인싸인척 하느라 고생 좀 하시겠어요~'
const new_word_3 = 'SNS 좀 할 줄 아나봐요?'
const new_word_4 = '이 시대의 급식이!  세종대왕이 노하시겠어~ 심각한 인터넷 중독자는 아닌지?!'

// 점수 높을수록 아재임, A 선택지 많이 고를 수록 아재
const old_test_1 = '아재가 뭐에요? 응애응애 아재력 신생아 수준!'
const old_test_2 = '요즘 젊은이네요~ 아재보다는 대2병을 더 조심해야할 시기!'
const old_test_3 = '최소 응답하라 1988세대! 혹시 부장님 아니신가요??'
const old_test_4 = '★완벽한 아재님★ 당신의 솔직함에 박수를!'

// localStorage
// stage_score, new_word_score, old_test_score  - 밸런스 게임 점수 없음

// 프론트에 보여질 멘트 : 대충 임의로 comment_text라고 써놨음 (추후 변경하삼)

let score_stage = parseInt(sessionStorage.getItem('stage_score')); // localStorage는 문자열로만 저장되니까 숫자로 변환
let score_new = parseInt(sessionStorage.getItem('newWord_score')); // localStorage는 문자열로만 저장되니까 숫자로 변환
let score_az = parseInt(sessionStorage.getItem('azGame_score')); // localStorage는 문자열로만 저장되니까 숫자로 변환


let score_div;
let comment_div;
let img_div;
let comment_text;

// score_div = document.getElementById('score_div');
// comment_div = document.getElementById('comment_div');
img_div = document.getElementById('img_div');

console.log(score_div);

function set_content(game){
    switch (game){
        case 'stage':
            if (score_stage==100){
                comment_text = stage_4;
            } else if (score_stage>=60 && score_stage <100){
                comment_text = stage_3;
            } else if (score_stage>=40 && score_stage <60){
                comment_text = stage_2;
                // console.log('진입');
                // console.log(comment_text);
            }else{
                comment_text = stage_1;
            }
            // img_div.innerText = '';
        case 'az':
            if (score_az==100){
                comment_text = old_test_4;
            }else if (score_az>=60 && score_az <100){
                comment_text = old_test_3;
            }else if (score_az>=40 && score_az <60){
                comment_text = old_test_2;
            }else{
                comment_text = old_test_1;
            }
            // score_div.innerHTML =  score_az + '점!';
            // comment_div.innerText = comment_text;
            // img_div.innerText = '';
        case 'newWord':
            if (score_new==100){
                comment_text = new_word_4;
            } else if (score_new>=60 && score_new <100){
                comment_text = new_word_3;
            } else if (score_new>=40 && score_new <60){
                comment_text = new_word_2;
            }else{
                comment_text = new_word_1;
            }
            score_div.innerHTML =  score_new+'점!';
            comment_div.innerText = comment_text;
            // img_div.innerText = '';
    }

    // 스크립트 종료 후에 0점으로 초기화 시키기
    // sessionStorage.setItem('stage_score',0);
    // sessionStorage.setItem('stage_score',0);
    // sessionStorage.setItem('stage_score',0);

}
// score, comment, img 영역 가져와서 적용하기




