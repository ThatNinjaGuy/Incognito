package com.dao.impl;

import java.util.ArrayList;

import com.dao.RandomClientDAO;
import com.pojo.Client;

public class RandomClientDAOImpl implements RandomClientDAO {

	@Override
	public int addClientBatch(Client[] randomClientList) {
		// TODO Auto-generated method stub
		
		int count = 0;
		for(int i = 0; i<randomClientList.length; i++) {
			Client client = randomClientList[i];
			ClientDAOImpl clientImpl = new ClientDAOImpl();
			clientImpl.addClient(client);
			count++;
		}
		return count;
	}

}
