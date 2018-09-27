
package com.randomDataGeneration;

import com.pojo.Client;
import com.pojo.ProprietaryTraders;

public class TraderObject {
	
	public ProprietaryTraders[] generateTraderObject(int n) {
		ProprietaryTraders[] traderArray = new ProprietaryTraders[n];
		String[] names = new String[n];
		RandomNames rn = new RandomNames();
		names = rn.generateRandomNames(n);
		IDGenerator idgen = new IDGenerator();
		DematAccountGenerator demat = new DematAccountGenerator();
		for(int i = 0; i<n; i++) {
			ProprietaryTraders t = new ProprietaryTraders();
			t.setTraderName(names[i]);
			String id = idgen.generateIDFromName(names[i]);
			t.setTraderId(id);
			t.setTraderPassword(id);
			t.setTraderDematAccountNumber(demat.nextDematAccount());
			traderArray[i] = t;
		}
		return traderArray;
	}
	

}