package com.randomDataGeneration;

import com.pojo.Client;

public class ClientObject {
	
	public Client[] generateClientObject(int n) {
		Client[] clientArray = new Client[n];
		String[] names = new String[n];
		RandomNames rn = new RandomNames();
		names = rn.generateRandomNames(n);
		IDGenerator idgen = new IDGenerator();
		DematAccountGenerator demat = new DematAccountGenerator();
		for(int i = 0; i<n; i++) {
			Client c = new Client();
			c.setClientName(names[i]);
			String id =idgen.generateIDFromName(names[i]);
			c.setClientId(id);
			c.setClientPassword(id);
			c.setDematAccountNumber(demat.nextDematAccount());
			clientArray[i] = c;
		}
		return clientArray;
	}
	

}
