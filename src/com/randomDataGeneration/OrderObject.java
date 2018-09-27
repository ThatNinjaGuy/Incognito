/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.randomDataGeneration;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author aaksh
 */
public class OrderObject {
    public ArrayList<RandomOrder> generateOrderBatch(int numberOfOrder, double basePrice, double volatility) {
    	RandomOrder[] randomOrders = new RandomOrder[numberOfOrder];
    	PriceGenerator pricegen = new PriceGenerator();
    	double[] priceList = pricegen.nextPriceList(basePrice, volatility, numberOfOrder);
    	Random rn = new Random();
    	int numberOfScenarios = rn.nextInt(5)+1;
//    	RandomScenarioOrder randomScene = new RandomScenarioOrder();
    	String firmClient = "FIRM";
    	String buySell = "BUY";
    	for(int i = 0; i<numberOfOrder; i++) {
    		if(Math.random()<0.9) firmClient = "FIRM";
    		else firmClient ="CLIENT";
    		if(rn.nextBoolean() == true) buySell = "BUY";
    		else buySell ="SELL";
    		randomOrders[i] = new RandomOrder(buySell, priceList[i], "1", firmClient, "FB");
    	}
    	ArrayList<RandomOrder> randomOrderObjects = new ArrayList<>();
    	int tradeListCount = 0;
    	int scenarioListCount =0;
    	RandomScenarioOrder scenario = new RandomScenarioOrder();
    	while(tradeListCount <numberOfOrder && scenarioListCount < numberOfScenarios ) {
    		ArrayList<RandomOrder> currentScenario = scenario.generateRandomScenarioOrder("FB", basePrice);
    		scenarioListCount++;
    		int currentScenarioCount = 0;
    		while(currentScenarioCount < currentScenario.size() && tradeListCount < numberOfOrder) {
    			if(Math.random()<0.9) {
    				randomOrderObjects.add(randomOrders[tradeListCount]);
    				tradeListCount++;
    			}else {
    				randomOrderObjects.add(currentScenario.get(currentScenarioCount));
    				currentScenarioCount++;
    			}
    		}
    		while(currentScenarioCount < currentScenario.size()) {
    			randomOrderObjects.add(currentScenario.get(currentScenarioCount));
				currentScenarioCount++;
    		}
    	}
    	while(tradeListCount < numberOfOrder) {
    		randomOrderObjects.add(randomOrders[tradeListCount]);
			tradeListCount++;
    	}
    	while(scenarioListCount < numberOfScenarios) {
    		ArrayList<RandomOrder> currentScenario = scenario.generateRandomScenarioOrder("FB", basePrice);
    		scenarioListCount++;
    		randomOrderObjects.addAll(currentScenario);
    	}
    	
    	return randomOrderObjects;
    }
}
