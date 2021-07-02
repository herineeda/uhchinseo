package com.lightningboys.uhchinseo.Controller;

import com.lightningboys.uhchinseo.Domain.User;
import com.lightningboys.uhchinseo.Repository.UserRepository;
import com.lightningboys.uhchinseo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/")
    public String main(Model model){
        Optional<User> user = userService.findByNickName("피넛버터젤리빈");
        model.addAttribute("nickName",user.get().getNickname());
        model.addAttribute("user", user.get());
        return "index";
    }

    @ResponseBody
    @PostMapping("user")
    public Long createUser(@RequestParam("nickName")String nickName){

        java.util.Date time = new java.util.Date(System.currentTimeMillis());
        User user = new User();
        user.setCreatetime(time);
        user.setNickname(nickName);
        user.setScore(0);
        userService.save(user);
        Optional<User> users = userService.findByNickName(nickName);
        Long id = user.getId();

        return id;
    }


    @ResponseBody
    @GetMapping("findNickName")
    public String findByNickname(@RequestParam("nickName")String nickName){
        String isNickname = "";
        if(userService.findByNickName(nickName)==null) isNickname = "Y";
        else isNickname = "N";

        return isNickname;
    }
}
