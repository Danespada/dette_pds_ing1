package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

// jdbc:mysql://:localhost:8889/dette

public class Database {

  
  public static void mydb() throws Exception{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/dette", "root", "root");
    
    PreparedStatement statement = con.prepareStatement("select * from Redevance");
    
    ResultSet result = statement.executeQuery();
    
    while(result.next()) {
      System.out.println(result.getString(1)+ " "+ result.getString(2));

    }
}
  }

