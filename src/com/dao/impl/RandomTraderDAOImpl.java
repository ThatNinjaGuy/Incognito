package com.dao.impl;

import com.dao.RandomTraderDAO;
import com.pojo.Client;
import com.pojo.ProprietaryTraders;

public class RandomTraderDAOImpl implements RandomTraderDAO {

	@Override
	public int addTraderBatch(ProprietaryTraders[] randomTraderList) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 0; i<randomTraderList.length; i++) {
			ProprietaryTraders trader = randomTraderList[i];
			ProprietaryTraderDAOImpl traderImpl = new ProprietaryTraderDAOImpl();
			traderImpl.addProprietaryTrader(trader);
			count++;
		}
		return count;
	}

}
