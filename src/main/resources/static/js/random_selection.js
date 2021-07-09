// 기존 배열
const selection_origin = ['누난 너무예뻐','링딩동','루시퍼']
const answer_origin = ['Y','N','N']

// 새로 정렬이 완료된 배열
let ran_selection = [] // 선택지 랜덤 정렬된 것
let ran_answer = [] // 선택지에 맞게 정답 랜덤 정렬된 것

let rand_idx

function shuffleRandom(sel_arr, ans_arr){

    // 선택지 2개 짜리는 i<3 대신 i<2로 수정~!
    for(let i=0; i<3; i++){
        // console.log("배열 현재 길이는??",selection_origin.length)
        rand_idx = Math.floor(Math.random() * selection_origin.length);
        // console.log(rand_idx)

        ran_selection[i] = selection_origin[rand_idx];
        ran_answer[i] = answer_origin[rand_idx];
        // console.log(ran_selection)
        // console.log(ran_answer)

        selection_origin.splice(rand_idx, 1);
        answer_origin.splice(rand_idx, 1);
    }

    // console.log(ran_selection)
    // console.log(ran_answer)

    // 결과적으로 기존 배열에 있는 값들은 모두 사라지고
    // 새로 정렬이 완료된 배열에 값이 모두 차게 됨
}

shuffleRandom(selection_origin, answer_origin)


