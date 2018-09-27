package com.pojo;

public class Shares {

		private String ISIN;
		private String Company_Name;
		private int Number_of_Shares;
        private double price;
		
		public Shares() {
			String ISIN = "INE009A01021";
			String Company_Name = "Reliance";
			int Number_of_Shares = 10000;
            double price=100;
		}
		
		public Shares(String iSIN, String company_Name, int number_of_Shares, double Price) {
			ISIN = iSIN;
			Company_Name = company_Name;
			Number_of_Shares = number_of_Shares;
            price=Price;
		}

		public String getISIN() {
			return ISIN;
		}
                
		public double getPrice() {
			return price;
		}
                
		public void setPrice(double Price){
			price=Price;
		}

		public void setISIN(String iSIN) {
			ISIN = iSIN;
		}

		public String getCompany_Name() {
			return Company_Name;
		}

		public void setCompany_Name(String company_Name) {
			Company_Name = company_Name;
		}

		public int getNumber_of_Shares() {
			return Number_of_Shares;
		}

		public void setNumber_of_Shares(int number_of_Shares) {
			Number_of_Shares = number_of_Shares;
		}

		@Override
		public String toString() {
			return "Shares [ISIN=" + ISIN + ", Company_Name=" + Company_Name + ", Number_of_Shares=" + Number_of_Shares
					+ "]";
		}
}
