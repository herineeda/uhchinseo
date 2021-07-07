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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final AzGameService azGameService;
    private final BalanceGameService balanceGameService;
    private final MusicGameService musicGameService;
    private final NewWordGameService newWordGameService;

    @Autowired
    private final RandomNumber randomNumber = new RandomNumber();
    List<Integer> randomList = randomNumber.randomNumber();

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

    @GetMapping("/musicGameResult")
    public String musicResult() {
        return "play/result";
    }

    @GetMapping("/agGameResult")
    public String agResult() {
        return "play/result_old_test";
    }

    @GetMapping("/newWordGameResult")
    public String newWordResult() {
        return "play/result_new_word";
    }


    @GetMapping("/azGame")
    public String azGame (Model model, @RequestParam(value = "pageNum", defaultValue ="1") int pageNum){

        List<AZGame> azGame = azGameService.findRandomQ(randomList.get(pageNum - 1));
        model.addAttribute("azGameList",azGame);

        return "play/old_test_play";

    }

    @GetMapping("/balanceGame")
    public String BalanceGame(Model model, @RequestParam(value = "pageNum", defaultValue ="1") int pageNum) {
        List<BalanceGame> balanceGameList = balanceGameService.balanceGameList(randomList.get(pageNum-1));

        model.addAttribute("balanceGameList", balanceGameList);

        return "play/balance_play";
    }


    @GetMapping("/musicGame")
    public String musicStageGame(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
        List<MusicStageGame> musicStageGameList = musicGameService.musicStageGames(randomList.get(pageNum-1));

        model.addAttribute("musicStageGameList", musicStageGameList);
        return "play/stage_play";
    }


    @GetMapping("/newWordGame")
    public String newWordGame(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {

        List<NewWordGame> newWordGameList = newWordGameService.newWordGames(randomList.get(pageNum-1));

        model.addAttribute("newWordGameList", newWordGameList);

        return "play/new_word_play";
    }
}
