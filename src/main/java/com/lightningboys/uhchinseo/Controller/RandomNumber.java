package com.lightningboys.uhchinseo.Controller;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomNumber {

    public List<Integer> randomNumber(){
        Random rd = new Random();
        List<Integer> randomNumber = new ArrayList<>();
        for(int i=0; i<10; i++){
            randomNumber.add((rd.nextInt(31)+1));
        }
        return randomNumber;
    }
}
