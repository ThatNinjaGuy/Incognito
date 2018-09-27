package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connections.MyConnection;
import com.dao.LoginDao;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean checkLogin(String EmailId, String Password) {
		boolean success = false;
		String search = "select * from RegistrationTable where EmailId = ? and Password=?";
		try {
			PreparedStatement ps = MyConnection.openConnection().prepareStatement(search);
			ps.setString(1, EmailId);
			ps.setString(2, Password);
			ResultSet set  = ps.executeQuery();
			if(set.next())
				success=true;
			if(success)
				System.out.println("login entered");
			else
				System.out.println("login failure");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return success;
	}

}
