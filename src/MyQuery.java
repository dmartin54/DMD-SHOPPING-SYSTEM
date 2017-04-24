import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.Query;

/**
 *
 * @author DMD coders
 */
public class MyQuery {
    
   public Connection getConnection() throws SQLException{
        Connection connection = null;
        connection = sqliteConnection.dbConnector();
        return connection ;
    }
    
    public ArrayList<Product2> BindTable(){
        
   ArrayList<Product2> list = new ArrayList<Product2>();
   Connection connection = null;
try {
	connection = getConnection();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   Statement st;
   ResultSet rs;
   
   
   try {
   st = connection.createStatement();
   rs = st.executeQuery("SELECT `ProductID`, `Seller`, `Product_Name`, `Department`, `Price`, `Units`, `Image` FROM `Product_Info2`");
   
   Product2 p;
   while(rs.next()){
   p = new Product2(
   rs.getInt("ProductID"),
   rs.getString("Seller"),
   rs.getString("Product_Name"),
   rs.getString("Department"),
   rs.getDouble("Price"),
   rs.getInt("Units"),
   rs.getBytes("Image")
   
   );
   list.add(p);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return list;
   }
}

