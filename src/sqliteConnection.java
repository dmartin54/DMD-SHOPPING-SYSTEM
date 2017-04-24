import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	
	//create global variable 
	Connection conn=null;
	
	//this method will return connection
	public static Connection dbConnector(){
		
		try{
			//define class for connection 
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\techs\\Desktop\\ECLIPSE\\SE PROJECT\\DMDdata.sqlite\\");
			//JOptionPane.showMessageDialog(null, "Successfully Connected to DMD database!");	
			
			return connection;
		}catch(Exception e)
		{
		JOptionPane.showMessageDialog(null, e);	
		return null;
		}
		
	}
}
