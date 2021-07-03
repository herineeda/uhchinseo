package com.lightningboys.uhchinseo.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MainController {


    @GetMapping("/")
    public String main(Model model){

        return "index";
    }

}
