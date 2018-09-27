/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.impl;
import com.pojo.Client;
import com.connections.MyConnection;
import com.dao.ClientDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PUNGRAD035
 */
public class ClientDAOImpl implements ClientDAO{
    
    @Override
    public int addClient(Client Client)
    {
    int rowsAdded = 0;
		String addClient = "insert into Client values(?,?,?,?)";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(addClient);
			ps.setString(1, Client.getClientName());
			ps.setString(2, Client.getClientId());
			ps.setString(3, Client.getClientPassword());
                        ps.setString(4, Client.getDematAccountNumber());
			rowsAdded = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsAdded;    
    }
    
    @Override
    public int DeleteClient(String Client_ID) {
		// TODO Auto-generated method stub
		
		int rowsDeleted = 0;
		String deleteClient = "delete from Client where clientId = ?";
		try(Connection con = MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(deleteClient);
			ps.setString(1, Client_ID);
			rowsDeleted = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
	}
    
    @Override
    public boolean UpdateClientPassword(String Client_ID,String Password,Client client)
    {
        
        boolean isUpdated = false;
		String updatePassword = "update Client set clientPassword = ? where clientId = ?";
		try(Connection con = MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(updatePassword);
			ps.setString(1, client.getClientPassword());
			int rows = ps.executeUpdate();
			isUpdated = rows>0?true:false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isUpdated;
    }
    
    @Override
    public boolean UpdateClientID(String Client_ID,String Password,Client client)
    {
        boolean isUpdated = false;
		String updateShare = "update Client set clientId = ? where clientId = ? and clientPassword=?";
		try(Connection con = MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(updateShare);
			ps.setString(1, client.getClientId());
                            
			int rows = ps.executeUpdate();
			isUpdated = rows>0?true:false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isUpdated;
    }
    
    @Override
    public Client FindClientByID(String Client_ID) {
		// TODO Auto-generated method stub
		Client client=null;
		String findByClientId = "select * from client where clientId = ?";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(findByClientId);
			ps.setString(1, Client_ID);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				String clientid = set.getString(1);
				String clientname = set.getString(2);
                                String clientpassword=set.getString(3);
				String demat=set.getString(4);
				client = new Client(clientid,clientname,clientpassword,demat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}
    
    @Override
	public List<Client> FindAllClients() {
		// TODO Auto-generated method stub
List<Client> client = new ArrayList<>();
		
		String findAllClients = "select * from client";
		try(Connection con = MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(findAllClients);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				String clientid = set.getString(1);
				String clientname = set.getString(2);
                                String clientpassword=set.getString(3);
				String demat=set.getString(4);
				Client clients = new Client(clientid,clientname,clientpassword,demat);
				client.add(clients);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return client;
	}
}