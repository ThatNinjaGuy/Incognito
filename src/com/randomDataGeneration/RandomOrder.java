/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.randomDataGeneration;

import java.util.Date;

/**
 *
 * @author aaksh
 */
public class RandomOrder {
    private String buySell, iSIN, firmClient, shareName;
    private Date timeStamp;
    double sharePrice;
    
	public RandomOrder(String buySell, double sharePrice, String iSIN, String firmClient, String shareName) {
		this.buySell = buySell;
		this.sharePrice = sharePrice;
		this.iSIN = iSIN;
		this.firmClient = firmClient;
		this.shareName = shareName;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public String getiSIN() {
		return iSIN;
	}

	public void setiSIN(String iSIN) {
		this.iSIN = iSIN;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getFirmClient() {
		return firmClient;
	}

	public void setFirmClient(String firmClient) {
		this.firmClient = firmClient;
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}
	
	
    
    
}
