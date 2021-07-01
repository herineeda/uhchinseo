
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
const new_word_4 = '이 시대의 급식이! 세종대왕이 노하시겠어~ 심각한 인터넷 중독자는 아닌지?!'

// 점수 높을수록 아재임, A 선택지 많이 고를 수록 아재
const old_test_1 = '아재가 뭐에요? 응애응애 아재력 신생아 수준!'
const old_test_2 = '요즘 젊은이네요! 아재보다는 대2병을 더 조심해야할 시기!'
const old_test_3 = '최소 응답하라 1988세대! 혹시 부장님 아니신가요??'
const old_test_4 = '★완벽한 아재님★ 당신의 솔직함에 박수를!'

// localStorage
// stage_score, new_word_score, old_test_score  - 밸런스 게임 점수 없음

// 프론트에 보여질 멘트 : 대충 임의로 comment_text라고 써놨음 (추후 변경하삼)

var score = parseInt(localStorage.getItem('stage_score')); // localStorage는 문자열로만 저장되니까 숫자로 변환
var score = parseInt(localStorage.getItem('new_word_score')); // localStorage는 문자열로만 저장되니까 숫자로 변환
var score = parseInt(localStorage.getItem('old_test_score')); // localStorage는 문자열로만 저장되니까 숫자로 변환

if (score==100){
    comment_text = 'stage_4';
} else if (score>=60 && score <100){
    comment_text = 'stage_3';
} else if (score>=40 && score <60){
    comment_text = 'stage_2';
}else{
    comment_text = 'stage_1';
}

if (score==100){
    comment_text = 'new_word_4';
} else if (score>=60 && score <100){
    comment_text = 'new_word_3';
} else if (score>=40 && score <60){
    comment_text = 'new_word_2';
}else{
    comment_text = 'new_word_1';
}

if (score==100){
    comment_text = 'old_test_4';
} else if (score>=60 && score <100){
    comment_text = 'old_test_3';
} else if (score>=40 && score <60){
    comment_text = 'old_test_2';
}else{
    comment_text = 'old_test_1';
}

