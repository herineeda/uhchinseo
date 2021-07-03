package com.lightningboys.uhchinseo;

import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Service.AzGameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class UhchinseoApplicationTests {

	@Autowired
	AzGameService azGameService;

	@Test
	void contextLoads() {
		Random rd = new Random();
		List<Integer> randomNumber = new ArrayList<>();
		for(int i=0; i<10; i++){
			randomNumber.add((rd.nextInt(31)+1));
		}
		for(int i=0; i<10; i++){
			System.out.println(randomNumber.get(i));
		}
		List<AZGame> azGameList = azGameService.findRandomQ(randomNumber.get(0));

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(AZGame azGame : azGameList){
			System.out.println("===========================");
			System.out.println(azGame.getCategory() +" " + azGame.getId());
		}
	}

}
