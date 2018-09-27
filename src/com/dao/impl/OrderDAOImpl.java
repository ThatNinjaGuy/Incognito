package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connections.MyConnection;
import com.dao.OrderDAO;
import com.pojo.Order;


public class OrderDAOImpl implements OrderDAO {

	@Override
	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		List<Order> Orders = new ArrayList<>();
		String FIND_ALL_ORDERS = "SELECT * FROM ORDERS";
		
		try(Connection con = MyConnection.openConnection()) {
			PreparedStatement ps = con.prepareStatement(FIND_ALL_ORDERS);
			
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				int tradeId = set.getInt(1);
				String customerId = set.getString(2);
				String shareName = set.getString(3);
				String isin = set.getString(4);
				String buySell = set.getString(5);
				double price = set.getDouble(6);
				String shareType = set.getString(7);
				double quantity = set.getDouble(8);
				double totalPrice = set.getDouble(9);
				String traderId = set.getString(10);
				boolean tradePlaced = set.getBoolean(11);
				String timeStamp = set.getString(12);
				String scenario = set.getString(13);
				String firmClient = set.getString(14);
				
				Order Order = new Order(tradeId,customerId,shareName,isin,buySell,price,shareType,quantity,totalPrice,traderId,tradePlaced,timeStamp,scenario,firmClient);
				Orders.add(Order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Orders;
	}

	@Override
	public List<Order> findAllByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		
		List<Order> Orders = new ArrayList<>();
		String FIND_BY_TRADEID = "SELECT * FROM ORDERS WHERE CUSTOMERID = ?";
		
		try(Connection con = MyConnection.openConnection()) {
			PreparedStatement ps = con.prepareStatement(FIND_BY_TRADEID);
			ps.setString(1, customerId);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				int TradeId = set.getInt(1);
				String CustomerId = set.getString(2);
				String shareName = set.getString(3);
				String isin = set.getString(4);
				String buySell = set.getString(5);
				double price = set.getDouble(6);
				String shareType = set.getString(7);
				double quantity = set.getDouble(8);
				double totalPrice = set.getDouble(9);
				String traderId = set.getString(10);
				boolean tradePlaced = set.getBoolean(11);
				String timeStamp = set.getString(12);
				String scenario = set.getString(13);
				String firmClient = set.getString(14);
				
				Order Order = new Order(TradeId,CustomerId,shareName,isin,buySell,price,shareType,quantity,totalPrice,traderId,tradePlaced,timeStamp,scenario,firmClient);
				Orders.add(Order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Orders;
	}

	@Override
	public List<Order> findFirmOrders() {
		// TODO Auto-generated method stub
		List<Order> Orders = new ArrayList<>();
		String FIND_FIRM_ORDERS = "SELECT * FROM ORDERS WHERE FIRMCLIENT = 'F'";
		
		try(Connection con = MyConnection.openConnection()) {
			PreparedStatement ps = con.prepareStatement(FIND_FIRM_ORDERS);
			
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				int tradeId = set.getInt(1);
				String customerId = set.getString(2);
				String shareName = set.getString(3);
				String isin = set.getString(4);
				String buySell = set.getString(5);
				double price = set.getDouble(6);
				String shareType = set.getString(7);
				double quantity = set.getDouble(8);
				double totalPrice = set.getDouble(9);
				String traderId = set.getString(10);
				boolean tradePlaced = set.getBoolean(11);
				String timeStamp = set.getString(12);
				String scenario = set.getString(13);
				String firmClient = set.getString(14);
				Order Order = new Order(tradeId,customerId,shareName,isin,buySell,price,shareType,quantity,totalPrice,traderId,tradePlaced,timeStamp,scenario,firmClient);
				Orders.add(Order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Orders;
	}

	@Override
	public List<Order> findClientOrders() {
		// TODO Auto-generated method stub
		List<Order> Orders = new ArrayList<>();
		String FIND_CLIENT_ORDERS = "SELECT * FROM ORDERS WHERE FIRMCLIENT = 'C' ";
		
		try(Connection con = MyConnection.openConnection()) {
			PreparedStatement ps = con.prepareStatement(FIND_CLIENT_ORDERS);
			
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				int tradeId = set.getInt(1);
				String customerId = set.getString(2);
				String shareName = set.getString(3);
				String isin = set.getString(4);
				String buySell = set.getString(5);
				double price = set.getDouble(6);
				String shareType = set.getString(7);
				double quantity = set.getDouble(8);
				double totalPrice = set.getDouble(9);
				String traderId = set.getString(10);
				boolean tradePlaced = set.getBoolean(11);
				String timeStamp = set.getString(12);
				String scenario = set.getString(13);
				String firmClient = set.getString(14);
				Order Order = new Order(tradeId,customerId,shareName,isin,buySell,price,shareType,quantity,totalPrice,traderId,tradePlaced,timeStamp,scenario,firmClient);
				Orders.add(Order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Orders;
	}

	@Override
	public List<Order> findAllBuyOrders() {
		// TODO Auto-generated method stub
		List<Order> Orders = new ArrayList<>();
		String FIND_BUY_ORDERS = "SELECT * FROM ORDERS WHERE BUYSELL = 'B' ";
		
		try(Connection con = MyConnection.openConnection()) {
			PreparedStatement ps = con.prepareStatement(FIND_BUY_ORDERS);
			
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				int tradeId = set.getInt(1);
				String customerId = set.getString(2);
				String shareName = set.getString(3);
				String isin = set.getString(4);
				String buySell = set.getString(5);
				double price = set.getDouble(6);
				String shareType = set.getString(7);
				double quantity = set.getDouble(8);
				double totalPrice = set.getDouble(9);
				String traderId = set.getString(10);
				boolean tradePlaced = set.getBoolean(11);
				String timeStamp = set.getString(12);
				String scenario = set.getString(13);
				String firmClient = set.getString(14);
				Order Order = new Order(tradeId,customerId,shareName,isin,buySell,price,shareType,quantity,totalPrice,traderId,tradePlaced,timeStamp,scenario,firmClient);
				Orders.add(Order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Orders;
	}

	@Override
	public List<Order> findAllSellOrders() {
		// TODO Auto-generated method stub
		List<Order> Orders = new ArrayList<>();
		String FIND_BUY_ORDERS = "SELECT * FROM ORDERS WHERE BUYSELL = 'S' ";
		
		try(Connection con = MyConnection.openConnection()) {
			PreparedStatement ps = con.prepareStatement(FIND_BUY_ORDERS);
			
			ResultSet set = ps.executeQuery();
			while(set.next()) {
			int tradeId = set.getInt(1);
			String customerId = set.getString(2);
			String shareName = set.getString(3);
			String isin = set.getString(4);
			String buySell = set.getString(5);
			double price = set.getDouble(6);
			String shareType = set.getString(7);
			double quantity = set.getDouble(8);
			double totalPrice = set.getDouble(9);
			String traderId = set.getString(10);
			boolean tradePlaced = set.getBoolean(11);
			String timeStamp = set.getString(12);
			String scenario = set.getString(13);
			String firmClient = set.getString(14);
				
				Order Order = new Order(tradeId,customerId,shareName,isin,buySell,price,shareType,quantity,totalPrice,traderId,tradePlaced,timeStamp,scenario,firmClient);
				Orders.add(Order);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Orders;
	}
	
	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;
		String addOrder = "inset into orders values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(addOrder);
			ps.setInt(1, order.getTradeId());
			ps.setString(2, order.getCustomerId());
			ps.setString(3, order.getShareName());
			ps.setString(4, order.getIsin());
			ps.setString(5, order.getBuySell());
			ps.setDouble(6, order.getSharePrice());
			ps.setString(7, order.getShareType());
			ps.setDouble(8, order.getShareQuantity());
			ps.setDouble(9, order.getTotalPrice());
			ps.setString(10, order.getTraderId());
			ps.setBoolean(11, order.isTradePlaced());
			ps.setString(12, order.getTimeStamp());
			ps.setString(13, order.getScenario());
			ps.setString(14, order.getFirmClient());
			rowsAdded = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsAdded;
		
	}


}
