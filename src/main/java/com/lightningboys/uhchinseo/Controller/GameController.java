package com.lightningboys.uhchinseo.Controller;

import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Domain.BalanceGame;
import com.lightningboys.uhchinseo.Domain.MusicStageGame;
import com.lightningboys.uhchinseo.Domain.NewWordGame;
import com.lightningboys.uhchinseo.Service.AzGameService;
import com.lightningboys.uhchinseo.Service.BalanceGameService;
import com.lightningboys.uhchinseo.Service.MusicGameService;
import com.lightningboys.uhchinseo.Service.NewWordGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final AzGameService azGameService;
    private final BalanceGameService balanceGameService;
    private final MusicGameService musicGameService;
    private final NewWordGameService newWordGameService;

//    게임 설명 화면
    @GetMapping("/balance")
    public String balanceSulmeong() {
        return "games/balance";
    }

    @GetMapping("/music")
    public String musicSulmeong() {
        return "games/stage";
    }

    @GetMapping("/ag")
    public String agSulmeong() {
        return "games/old_test";
    }

    @GetMapping("/newWord")
    public String newWordSulmeong() {
        return "games/new_word";
    }

//    게임 결과 화면

    @GetMapping("/balanceGameResult")
    public String balanceResult() {
        return "play/result";
    }

    @GetMapping("/musicGameResult")
    public String musicResult() {
        return "play/result";
    }

    @GetMapping("/agGameResult")
    public String agResult() {
        return "play/result";
    }

    @GetMapping("/newWordGameResult")
    public String newWordResult() {
        return "play/result";
    }


    @GetMapping("/azGame")

        public String azGame (Model model, @RequestParam("pageNum") int pageNum){
            Page<AZGame> azGame = azGameService.findAll(pageNum);
            List<AZGame> azGameList = new ArrayList<>();
            for (AZGame game : azGame){
                azGameList.add(game);
            }
            model.addAttribute("azGameList",azGameList);

        return "play/balance_play"; //azgame_play.html 없어서 임의로 balance_play.html로 연결함.

    }


    @ResponseBody
    @GetMapping("/balanceGame")
    public List<BalanceGame> BalanceGame(@RequestParam("pageNum") int pageNum) {
        Page<BalanceGame> BalanceGame = balanceGameService.findAll(pageNum);
        List<BalanceGame> balanceGameList = new ArrayList<>();
        for (BalanceGame balanceGame : BalanceGame) {
            balanceGameList.add(balanceGame);
        }
        return balanceGameList;
    }

    @ResponseBody
    @PostMapping("balanceGame")
    public String updateCnt(@RequestBody BalanceForm balanceForm) {
        Long id = balanceForm.getId();
        int balanceCnt = balanceForm.getBalanceCnt();
        balanceGameService.updateCnt(id, balanceCnt);
        return "updateSuccess";
    }


    @GetMapping("/musicGame")
    public String musicStageGame(Model model, @RequestParam("pageNum") int pageNum) {
        Page<MusicStageGame> musicStageGame = musicGameService.findAll(pageNum);
        List<MusicStageGame> musicStageGameList = new ArrayList<>();
        for (MusicStageGame game : musicStageGame) {
            musicStageGameList.add(game);
        }
        model.addAttribute("musicStageGameList", musicStageGameList);
        return "play/stage_play";
    }


    @ResponseBody
    @PostMapping("musicGame")
    public String updateScore(@RequestBody MusicForm musicForm){
        Long id = musicForm.getId();
        int score = musicForm.getScore();
        musicGameService.updateScore(id, score);
        return "update Success!";
    }


    @GetMapping("/newWordGame")
    public String newWordGame(Model model, @RequestParam("pageNum") int pageNum) {
        Page<NewWordGame> newWordGame = newWordGameService.findAll(pageNum);
        List<NewWordGame> newWordGameList = new ArrayList<>();
        for (NewWordGame game : newWordGame){
            newWordGameList.add(game);
        }
        model.addAttribute("newWordGameList", newWordGameList);

        return "play/new_word_play";
    }


    @ResponseBody
    @PostMapping("newWordGame")
    public String updateScore(@RequestBody NewWordForm newWordForm){
        Long id = newWordForm.getId();
        int score = newWordForm.getScore();
        newWordGameService.updateScore(id, score);
        return "update success";
    }

}
