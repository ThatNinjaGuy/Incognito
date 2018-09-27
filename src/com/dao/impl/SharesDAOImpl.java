package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Shares;
import com.connections.MyConnection;
import com.dao.SharesDAO;

public class SharesDAOImpl implements SharesDAO{

	@Override
	public int addShare(Shares Share) {
		// TODO Auto-generated method stub
		
	int rowsAdded = 0;
		String AddShare = "insert into Shares values(?,?,?,?)";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(AddShare);
			ps.setString(1, Share.getISIN());
			ps.setString(2, Share.getCompany_Name());
			ps.setInt(3, Share.getNumber_of_Shares());
			ps.setDouble(4, Share.getPrice());
			rowsAdded = ps.executeUpdate();
			//System.out.println(Share.getISIN()+Share.getCompany_Name()+Share.getNumber_of_Shares()+Share.getPrice());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsAdded;
	}

	@Override
	public boolean updateShare(String ISIN, Shares Share) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		String updateShare = "update Shares set number_of_share = ? where isin = ?";
		try(Connection con = MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(updateShare);
			ps.setInt(1, Share.getNumber_of_Shares());
			ps.setString(2, ISIN);
			int rows = ps.executeUpdate();
			isUpdated = rows>0?true:false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isUpdated;
	}

	@Override
	public int deleteShare(String ISIN) {
		// TODO Auto-generated method stub
		
		int rowsDeleted = 0;
		String deleteShare = "delete from Shares where ISIN = ?";
		try(Connection con = MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(deleteShare);
			ps.setString(1, ISIN);
			rowsDeleted = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
	}

	@Override
	public Shares findShareByISIN(String ISIN) {
		// TODO Auto-generated method stub
		Shares share = null;
		String findByISIN = "select * from Shares where ISIN = ?";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(findByISIN);
			ps.setString(1, ISIN);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				String isin = set.getString(1);
				String compName = set.getString(2);
				int sharesCount = set.getInt(3);
				double Price=set.getDouble(4);
				share = new Shares(isin,compName,sharesCount,Price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return share;
	}

	@Override
	public List<Shares> findAllShares() {
		// TODO Auto-generated method stub
List<Shares> shares = new ArrayList<>();
		
		String findAllShares = "select * from Shares";
		try(Connection con = MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(findAllShares);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				String isin = set.getString(1);
				String compName = set.getString(2);
				int sharesCount = set.getInt(3);
				double price=set.getDouble(4);
				Shares share = new Shares(isin,compName,sharesCount,price);
				shares.add(share);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return shares;
	}

	@Override
	public double FindSharePriceByShareName(Shares share) {
		String findShare="select price from Shares where Company_Name=?";
		double price=0;
		try(Connection con=MyConnection.openConnection())
		{
			PreparedStatement ps=con.prepareStatement(findShare);
			ResultSet set=ps.executeQuery();
			ps.setString(1,share.getCompany_Name());
			price=set.getDouble(4);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return price;
		
	}

}
