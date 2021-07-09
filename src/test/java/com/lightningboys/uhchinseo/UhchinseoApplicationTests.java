package com.lightningboys.uhchinseo;

import com.lightningboys.uhchinseo.Domain.AZGame;
import com.lightningboys.uhchinseo.Service.AzGameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

@SpringBootTest
@Transactional
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

	@Test
	void contextLoadsds() {
		int prices[] = {13000,88000,10000};
		int discounts[] = {30,20};
		int answer = 0;
		Arrays.sort(prices);
		Arrays.sort(discounts);
		int j = prices.length -1 ;
		for (int i = discounts.length; i >= 0; i--, j--) {
			answer += prices[j] * discounts[i];
		}
		for (int i = j; i >= 0; i--) {
			answer += prices[i];
		}
		System.out.println(answer);
	}

	@Test
	void test(){
		azGameService.find();
	}
}
