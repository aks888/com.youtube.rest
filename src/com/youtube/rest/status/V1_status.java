package com.youtube.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.*;
import com.youtube.rest.dao.*;


@Path("/v1/status")
public class V1_status {

	private static final String apiVersion = "00.02.00";
	
	/**
	* This method sits at the root of the api. It will return the name
	* of this api.
	*
	* @return String - Title of the api
	*/
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
	return "<p>Java Web Service</p>";
	}
	
	/**
	* This method will return the version number of the api
	* Note: this is nested one down from the root. You will need to add version
	* into the URL path.
	*
	* Example:
	* http://localhost:7001/com.youtube.rest/api/v1/status/version
	*
	* @return String - version number of the api
	*/
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
	return "<p>Version:</p>" + apiVersion;
	}
	
	/**
	 * This method will connect to the oracle database and return the date/time stamp.
	 * It will then return the date/time to the user in String format
	 * 
	 * This was explained in Part 3 of the Java Rest Tutorial Series on YouTube
	 * 
	 * Pre-episode 6, updated because Oracle308tube.java no longer accessible.
	 * 
	 * @return String -  returns the database date/time stamp
	 * @throws Exception
	 * 
	 * 
	 */
	
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception {
		
		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;
		
		try {
			
			conn = Oracleaks888.Oracleaks308Conn().getConnection();
			query = conn.prepareStatement("select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') DATETIME " +
			                    "from sys.dual");
			ResultSet rs = query.executeQuery();
			
			while (rs.next())
			{				
				myString = rs.getString("DATETIME");
			}
			
			query.close();
			returnString = "<p>Database Status<p> " +
			               "<p>Database Date/Time return: " + myString + "<p>";
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
		
			if (conn!= null) conn.close();
		}
		
		return returnString; 
	}
	
/*	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception {
		
		String myString = null;
		String returnString = null;
		JSONArray json = new JSONArray();
		
		try {
			
			Schema308tube dao = new Schema308tube();
			
			json = dao.queryCheckDbConnection();
			myString = json.toString();
			
			returnString = "<p>Database Status</p> " +
				"<p>Database Date/Time return: " + myString + "</p>";
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnString; 
	}*/
}
