package com.randomDataGeneration;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javafx.util.Pair;

public class RandomScenarioOrder {
	public ArrayList<RandomOrder> generateRandomScenarioOrder(String shareName, double basePrice) {
		Random r = new Random();
		//RandomOrder[] randomScenarios = new RandomOrder[n];
		int scenarioNumber = r.nextInt(2)+1;
		ArrayList<RandomOrder> randomOrders = new ArrayList<>();
		switch (scenarioNumber) {
        case 1:  randomOrders.add(new RandomOrder("BUY", basePrice, "1", "FIRM", "FB"));
        		randomOrders.add(new RandomOrder("BUY", 1.01*basePrice, "1", "CLIENT", "FB"));
        		randomOrders.add(new RandomOrder("SELL", 1.02*basePrice, "1", "FIRM", "FB"));
                 break;
        case 2:  randomOrders.add(new RandomOrder("SELL", basePrice, "1", "FIRM", "FB"));
				randomOrders.add(new RandomOrder("SELL", 0.99*basePrice, "1", "CLIENT", "FB"));
                 break;
//        case 3:  monthString = "March";
//                 break;
//        case 4:  monthString = "April";
//                 break;
//        case 5:  monthString = "May";
//                 break;
//        case 6:  monthString = "June";
//                 break;
//        case 7:  monthString = "July";
//                 break;
//        case 8:  monthString = "August";
//                 break;
//        case 9:  monthString = "September";
//                 break;
//        case 10: monthString = "October";
//                 break;
//        case 11: monthString = "November";
//                 break;
//        case 12: monthString = "December";
//                 break;
    }
		
		return randomOrders;
	}
	
	
}
