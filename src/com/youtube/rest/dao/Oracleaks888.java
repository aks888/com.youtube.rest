package com.youtube.rest.dao;

import javax.naming.*;
import javax.sql.*;

public class Oracleaks888 {

	private static DataSource Oracleaks888 = null;
	private static Context context = null;
	
	public static DataSource Oracleaks308Conn() throws Exception {
		
		if (Oracleaks888 != null)
		{
			return Oracleaks888;
		}
		
		try
		{
			if (context == null)
			{
				context = new InitialContext();
			}
			
			Oracleaks888 = (DataSource) context.lookup("aks888Oracle");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return Oracleaks888;
	}
}
