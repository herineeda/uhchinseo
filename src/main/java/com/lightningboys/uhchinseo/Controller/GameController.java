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
import javax.servlet.http.HttpServletRequest;

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



    @ResponseBody
    @GetMapping("/azGame")
    public List<AZGame> azGame(@RequestParam("pageNum") int pageNum) {
        Page<AZGame> azGame = azGameService.findAll(pageNum);
        List<AZGame> azGameList = new ArrayList<>();
        for (AZGame game : azGame) {
            azGameList.add(game);
        }
        return azGameList;
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


    @ResponseBody
    @GetMapping("/musicGame")
    public List<MusicStageGame> musicStageGame(@RequestParam("pageNum") int pageNum) {
        Page<MusicStageGame> musicStageGame = musicGameService.findAll(pageNum);
        List<MusicStageGame> musicStageGameList = new ArrayList<>();
        for (MusicStageGame game : musicStageGame) {
            musicStageGameList.add(game);
        }
        return musicStageGameList;
    }

    @ResponseBody
    @PostMapping("musicGame")
    public String updateScore(@RequestBody MusicForm musicForm){
        Long id = musicForm.getId();
        int score = musicForm.getScore();
        musicGameService.updateScore(id, score);
        return "update Success!";
    }

    @ResponseBody
    @GetMapping("/newWordGame")
    public List<NewWordGame> newWordGame(@RequestParam("pageNum") int pageNum) {
        Page<NewWordGame> newWordGame = newWordGameService.findAll(pageNum);
        List<NewWordGame> newWordGameList = new ArrayList<>();
        for (NewWordGame game : newWordGame){
            newWordGameList.add(game);
        }
        return newWordGameList;
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
