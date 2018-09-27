/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

/**
 *
 * @author Ashish
 */
import java.util.Date;

public class Order {

    private int tradeId;
	private String customerId;
    private String shareName;
    private String isin;
    private String buySell;
    private double sharePrice;
    private String shareType;
    private double shareQuantity;
    private double totalPrice;
    private String traderId;
    private boolean tradePlaced;
    private String timeStamp;
    private String scenario;
    private String firmClient;

    public Order() {
        super();
    }

    public Order(int tradeId, String customerId, String shareName, String isin, String buySell, double sharePrice, String shareType,
    		double shareQuantity, double totalPrice, String traderId, boolean tradePlaced, String timeStamp, String scenario, String firmClient) {
        this.tradeId = tradeId;
    	this.customerId = customerId;
        this.shareName = shareName;
        this.isin = isin;
        this.buySell = buySell;
        this.sharePrice = sharePrice;
        this.shareType = shareType;
        this.shareQuantity = shareQuantity;
        this.totalPrice = totalPrice;
        this.traderId = traderId;
        this.tradePlaced = tradePlaced;
        this.timeStamp = timeStamp;
        this.scenario = scenario;
        this.firmClient = firmClient;
    }

    public Order(int tradeId, String customerId, String shareName, String isin, String buySell, double sharePrice, String shareType, double shareQuantity, double totalPrice, String traderId, boolean tradePlaced, String firmClient) {
        this.tradeId = tradeId;
        this.customerId = customerId;
        this.shareName = shareName;
        this.isin = isin;
        this.buySell = buySell;
        this.sharePrice = sharePrice;
        this.shareType = shareType;
        this.shareQuantity = shareQuantity;
        this.totalPrice = totalPrice;
        this.traderId = traderId;
        this.tradePlaced = tradePlaced;
        this.firmClient = firmClient;
        
        this.scenario = "No Scenario";
        this.timeStamp = null;
    }
    
    public Order(int tradeId, String customerId, String shareName, String isin, String buySell, double sharePrice, String shareType, double shareQuantity, String traderId,String firmClient) {
        this.tradeId = tradeId;
        this.customerId = customerId;
        this.shareName = shareName;
        this.isin = isin;
        this.buySell = buySell;
        this.sharePrice = sharePrice;
        this.shareType = shareType;
        this.shareQuantity = shareQuantity;
        this.totalPrice = sharePrice*shareQuantity;
        this.traderId = traderId;
        this.tradePlaced = true;
        this.firmClient = firmClient;
        
        this.scenario = "No Scenario";
        this.timeStamp = null;
    }
    

    public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getShareType() {
		return shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getFirmClient() {
		return firmClient;
	}

	public void setFirmClient(String firmClient) {
		this.firmClient = firmClient;
	}

	public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
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

    public double getShareQuantity() {
        return shareQuantity;
    }

    public void setShareQuantity(double shareQuantity) {
        this.shareQuantity = shareQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTraderId() {
        return traderId;
    }

    public void setTraderId(String traderId) {
        this.traderId = traderId;
    }

    public boolean isTradePlaced() {
        return tradePlaced;
    }

    public void setTradePlaced(boolean tradePlaced) {
        this.tradePlaced = tradePlaced;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	@Override
	public String toString() {
		return "Order [tradeId=" + tradeId + ", customerId=" + customerId + ", shareName=" + shareName + ", isin="
				+ isin + ", buySell=" + buySell + ", sharePrice=" + sharePrice + ", shareQuantity=" + shareQuantity
				+ ", totalPrice=" + totalPrice + ", traderId=" + traderId + ", tradePlaced=" + tradePlaced
				+ ", timeStamp=" + timeStamp + ", scenario=" + scenario + ", customerTrade=" + firmClient + "]";
	}
	
	public String toString1() {
        return "tradeId=" + tradeId + ", customerId=" + customerId + ", shareName=" + shareName +  ", buySell=" + buySell + ", sharePrice=" + sharePrice + ", shareType=" + shareType + ", shareQuantity=" + shareQuantity + ", firmClient=" + firmClient + '}';
    }

}
