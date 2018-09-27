package com.dao;

import java.util.List;

import com.pojo.ProprietaryTraders;

public interface ProprietaryTraderDAO {
	int addProprietaryTrader(ProprietaryTraders proprietaryTrader);
    int DeleteProprietaryTrader(String traderID);
    ProprietaryTraders FindTraderByID(String traderID);
    List<ProprietaryTraders> FindAllTraders();
    boolean UpdateTraderPassword(String traderID,String password,ProprietaryTraders proprietaryTrader);
    boolean UpdateTraderID(String traderID,String password,ProprietaryTraders proprietaryTrader);
}
