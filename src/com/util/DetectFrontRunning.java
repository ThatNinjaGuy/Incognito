/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;


import com.pojo.Order;
import java.util.ArrayList;
import java.util.List;
import com.global.OrderVariables;
import java.util.Date;

/**
 *
 * @author Grad57
 */
public class DetectFrontRunning  {

    public final double basePrice = 10000000;

    OrderVariables obj = new OrderVariables();

    public List<Order[]> detectingFrontRunning(List<Order> orderBook) {

        int totalOrders = orderBook.size();

        List<Order[]> possibleFrontRunning = new ArrayList<>();

//        pattern.add(e)
        Order past, present, future;
        int i;

        for (i = 0; i < totalOrders - 2; i++) {

            past = orderBook.get(i);

            if (past.getFirmClient().equals("F") && past.getScenario().equals("No Scenario")) {

//              The time at which the trade has been placed
//                long time1;
//                time1 = past.getTimeStamp().getTime();

                String t1, t2, t3;

//              Here t1,t2 are the trade IDS  
                t1 = past.getTraderId();

                for (int j = i + 1; j < totalOrders - 1; j++) {
                    present = orderBook.get(j);
                    if (/*(present.getTimeStamp().getTime() - time1) < obj.timeDiff &&*/ present.getScenario().equals("No Scenario")) {
                        if (present.getFirmClient().equals("C")) {
                            for (int k = j + 1; k < totalOrders; k++) {
                                future = orderBook.get(k);
                                if (/*(future.getTimeStamp().getTime() - present.getTimeStamp().getTime()) < obj.timeDiff &&*/ future.getScenario().equals("No Scenario")) {
                                    if (future.getFirmClient().equals("F")) {
                                        boolean b1, b2, b3;
//                  Here b1,b2,b3 are to denote whether the trade has taken place or not
                                        b1 = past.isTradePlaced();
                                        b2 = present.isTradePlaced();
                                        b3 = future.isTradePlaced();

//                      Here tP is the base amount of shares to check for front running.
                                        double tP = obj.shareLimit;

//                      Here bs1,bs2 is a String denoting the various types of 
                                        String bs1, bs2, bs3;
                                        bs1 = past.getBuySell();
                                        bs2 = present.getBuySell();
                                        bs3 = future.getBuySell();

                                        if (bs1.equals("B") && bs2.equals("B") && bs3.equals("S") && past.getShareQuantity() >= tP && future.getShareQuantity() >= tP && b1 && b2 &&
                                                future.getScenario().equals("No Scenario")&& past.getScenario().equals("No Scenario") && present.getScenario().equals("No Scenario")) {

                                            String shareType1 = past.getShareType();
                                            String shareType2 = present.getShareType();
                                            String shareType3 = future.getShareType();
                                            if ((shareType1.equals("Equity") && shareType2.equals("Equity") && shareType3.equals("Equity")) ||
                                                    (shareType1.equals("Futures") && shareType2.equals("Equity") && shareType3.equals("Futures")) ||
                                                    (shareType1.equals("Equity") && shareType2.equals("Futures") && shareType3.equals("Equity"))||
                                                    (shareType1.equals("Futures") && shareType2.equals("Futures") && shareType3.equals("Futures")) ||
                                                    (shareType1.equals("Futures") && shareType2.equals("CallOption") && shareType3.equals("Futures")) ||
                                                    (shareType1.equals("Equity") && shareType2.equals("CallOption") && shareType3.equals("Equity"))||
                                                    (shareType1.equals("CallOption") && shareType2.equals("Equity") && shareType3.equals("CallOption"))||
                                                    (shareType1.equals("CallOption") && shareType2.equals("Futures") && shareType3.equals("CallOption"))||
                                                    (shareType1.equals("CallOption") && shareType2.equals("CallOption") && shareType3.equals("CallOption"))
                                                    ) {
                                                Order[] tempBatch = new Order[3];
                                                past.setScenario("3");
                                                present.setScenario("3");
                                                future.setScenario("3");
                                                tempBatch[0] = past;
                                                tempBatch[1] = present;
                                                tempBatch[2] = future;

                                                possibleFrontRunning.add(tempBatch);

                                            }

                                        }

                                        
                                        if (bs1.equals("S") && bs2.equals("S") && bs3.equals("B") && past.getShareQuantity() >= tP && future.getShareQuantity() >= tP && b1 && b2 &&
                                                 future.getScenario().equals("No Scenario")&& past.getScenario().equals("No Scenario") && present.getScenario().equals("No Scenario")) {

                                            String shareType1 = past.getShareType();
                                            String shareType2 = present.getShareType();
                                            String shareType3 = future.getShareType();
                                            if ((shareType1.equals("Equity") && shareType2.equals("Equity") && shareType3.equals("Equity")) ||
                                                    (shareType1.equals("Futures") && shareType2.equals("Equity") && shareType3.equals("Futures")) ||
                                                    (shareType1.equals("Equity") && shareType2.equals("Futures") && shareType3.equals("Equity"))||
                                                    (shareType1.equals("Futures") && shareType2.equals("Futures") && shareType3.equals("Futures")) ||
                                                    (shareType1.equals("Futures") && shareType2.equals("CallOption") && shareType3.equals("Futures"))) {
                                                Order[] tempBatch = new Order[3];
                                                past.setScenario("3");
                                                present.setScenario("3");
                                                future.setScenario("3");
                                                tempBatch[0] = past;
                                                tempBatch[1] = present;
                                                tempBatch[2] = future;

                                                possibleFrontRunning.add(tempBatch);

                                            }

                                        }
                                        if (bs1.equals("B") && bs2.equals("S") && bs3.equals("S") && past.getShareQuantity() >= tP && future.getShareQuantity() >= tP && b1 && b2 &&
                                                 future.getScenario().equals("No Scenario")&& past.getScenario().equals("No Scenario") && present.getScenario().equals("No Scenario")) {

                                            String shareType1 = past.getShareType();
                                            String shareType2 = present.getShareType();
                                            String shareType3 = future.getShareType();
                                            if ( (shareType1.equals("PutOption")) && shareType2.equals("Equity") && (shareType3.equals("PutOption"))||
                                                 (shareType1.equals("PutOption")) && shareType2.equals("Futures") && (shareType3.equals("PutOption"))
                                                ) {
                                                Order[] tempBatch = new Order[3];
                                                past.setScenario("3");
                                                present.setScenario("3");
                                                future.setScenario("3");
                                                tempBatch[0] = past;
                                                tempBatch[1] = present;
                                                tempBatch[2] = future;

                                                possibleFrontRunning.add(tempBatch);

                                            }

                                        }

                                        if (bs1.equals("S") && bs2.equals("B") && bs3.equals("B") && past.getShareQuantity() >= tP && future.getShareQuantity() >= tP && b1 && b2 &&  
                                                future.getScenario().equals("No Scenario")&& past.getScenario().equals("No Scenario") && present.getScenario().equals("No Scenario")) {

                                            String shareType1 = past.getShareType();
                                            String shareType2 = present.getShareType();
                                            String shareType3 = future.getShareType();
                                            if ((shareType1.equals("Futures")) && shareType2.equals("PutOption") && (shareType3.equals("Futures"))||
                                                    (shareType1.equals("Equity")) && shareType2.equals("PutOption") && (shareType3.equals("Equity"))) {
                                                Order[] tempBatch = new Order[3];
                                                past.setScenario("3");
                                                present.setScenario("3");
                                                future.setScenario("3");
                                                tempBatch[0] = past;
                                                tempBatch[1] = present;
                                                tempBatch[2] = future;

                                                possibleFrontRunning.add(tempBatch);

                                            }

                                        }

                                    }

                                }
                            }
                        }
                    }
                }

            }
        }
        return possibleFrontRunning;
    }

    
}
