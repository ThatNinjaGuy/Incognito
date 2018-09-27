package com.dao.impl;

import java.util.ArrayList;

import com.dao.RandomOrderDAO;
import com.pojo.Order;
import com.pojo.ProprietaryTraders;
import com.randomDataGeneration.RandomOrder;

public class RandomOrderDAOImpl implements RandomOrderDAO {

	@Override
	public int addOrderBatch(ArrayList<RandomOrder> randomOrderList) {
		// TODO Auto-generated method stub
		int count =0;
		String timeStamp = null;
		for(int i =0; i<randomOrderList.size(); i++) {
			timeStamp = Integer.toString(count);
			RandomOrder randomOrder = randomOrderList.get(i);
			Order order = new Order();
			order.setBuySell(randomOrder.getBuySell());
			order.setCustomerId("1");
//			AKSHAT CODE
			
//			order.setCustomerTrade("YES");
//			order.setisin(randomOrder.getiSIN());
			
//			NEWLY ADDED CODE
			order.setFirmClient("C");
			order.setIsin(randomOrder.getiSIN());
			
			order.setScenario(null);
			order.setShareName(randomOrder.getShareName());
			order.setSharePrice(randomOrder.getSharePrice());
			order.setShareQuantity(5);
			order.setTimeStamp(timeStamp);
			order.setTotalPrice(randomOrder.getSharePrice()*5);
			order.setTradeId(count);
			order.setTradePlaced(false);
			order.setTraderId(timeStamp);
			OrderDAOImpl orderImpl = new OrderDAOImpl();
			orderImpl.addOrder(order);
			count++;

		}

		return count;
	}

}
