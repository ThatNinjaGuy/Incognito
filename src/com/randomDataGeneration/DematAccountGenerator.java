package com.randomDataGeneration;

public class DematAccountGenerator {
	public static int dematOne = 1;
	public static int dematTwo = 1;
	
	public String nextDematAccount() {
      String dematAccOne = Integer.toString(dematOne);
      String dematAccTwo = Integer.toString(dematTwo);
      String zeroOne = new String(new char[8-dematAccOne.length()]).replace("\0", "0");
      String zeroTwo = new String(new char[8-dematAccTwo.length()]).replace("\0", "0");
      String dematAcc = dematAccOne+zeroOne+zeroTwo+dematAccTwo;
      if(dematTwo == 10000000) {
    	  dematTwo =0;
    	  dematOne++;
      }
      dematTwo++;
      return dematAcc;
	}
}
