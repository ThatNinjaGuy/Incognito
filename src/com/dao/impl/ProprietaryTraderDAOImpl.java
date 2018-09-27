package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connections.MyConnection;
import com.dao.ProprietaryTraderDAO;
import com.pojo.ProprietaryTraders;

public class ProprietaryTraderDAOImpl implements ProprietaryTraderDAO {

	@Override
	public int addProprietaryTrader(ProprietaryTraders proprietaryTrader) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;
		String addProprietaryTrader = "insert into Firm values(?,?,?,?)";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(addProprietaryTrader);
			ps.setString(1, proprietaryTrader.getTraderName());
			ps.setString(2, proprietaryTrader.getTraderId());
			ps.setString(3, proprietaryTrader.getTraderPassword());
			ps.setString(4, proprietaryTrader.getTraderDematAccountNumber());
			rowsAdded = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowsAdded;
	}

	@Override
	public int DeleteProprietaryTrader(String traderID) {
		// TODO Auto-generated method stub
		int rowsDeleted = 0;
		String deleteProprietaryTrader= "delete from Firm where traderid = ?";
		try(Connection con = MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(deleteProprietaryTrader);
			ps.setString(1, traderID);
			rowsDeleted = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return rowsDeleted;
	}

	@Override
	public ProprietaryTraders FindTraderByID(String traderID) {
		// TODO Auto-generated method stub
		ProprietaryTraders trader=null;
		String findBytraderId = "select * from Firm where traderid = ?";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(findBytraderId);
			ps.setString(1, traderID);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				String traderid = set.getString(1);
				String tradername = set.getString(2);
				String password=set.getString(3);
				String demat=set.getString(4);
				trader = new ProprietaryTraders(traderid,tradername,password,demat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trader;
	}

	@Override
	public List<ProprietaryTraders> FindAllTraders() {
		// TODO Auto-generated method stub
		List<ProprietaryTraders> traders = new ArrayList<>();

		String findAllTraders = "select * from Firm";
		try(Connection con = MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(findAllTraders);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				String traderid = set.getString(1);
				String tradername = set.getString(2);
				String password=set.getString(3);
				String demat=set.getString(4);
				ProprietaryTraders trader = new ProprietaryTraders(traderid,tradername,password,demat);
				traders.add(trader);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return traders;
	}

	@Override
	public boolean UpdateTraderPassword(String traderID, String password, ProprietaryTraders proprietaryTrader) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		String updatePassword = "update Firm set password = ? where traderid = ?";
		try(Connection con = MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(updatePassword);
			ps.setString(1, proprietaryTrader.getTraderPassword());
			int rows = ps.executeUpdate();
			isUpdated = rows>0?true:false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isUpdated;
	}

	@Override
	public boolean UpdateTraderID(String traderID, String password, ProprietaryTraders proprietaryTrader) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		String updateID = "update Firm set traderid = ? where traderid = ? and password=?";
		try(Connection con = MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(updateID);
			ps.setString(1, proprietaryTrader.getTraderId());
                            
			int rows = ps.executeUpdate();
			isUpdated = rows>0?true:false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isUpdated;
	}

}
