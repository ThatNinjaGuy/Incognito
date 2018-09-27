package com.randomDataGeneration;

import java.util.Random;

public class PriceGenerator {

    public double[] nextPriceList(double basePrice, double volatility, int numberOfData) {

        
        double maxPrice = (1.00 + (volatility) / (100d)) * basePrice;
        double minPrice = (1.00 - (volatility) / (100d)) * basePrice;
        //boolean bullish = false;
        
        Random r = new Random();
        double[] priceList = new double[numberOfData];
        

        for (int i = 0; i < numberOfData; i++) {
            double variationPercent = (r.nextGaussian());
            if (variationPercent > 2d) {
                variationPercent = 2d;
            }
            if (variationPercent < -2d) {
                variationPercent = -2d;
            }
           
            double temp = (1.00 + (variationPercent) / (100d)) * basePrice;
            if (temp > maxPrice || temp < minPrice) {
                variationPercent = (-1 * variationPercent);
            }
            temp = (1.00 + (variationPercent) / (100d)) * basePrice;
            basePrice = temp;
            priceList[i] = basePrice;

        }
        return priceList;
    }
}
