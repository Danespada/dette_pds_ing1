package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

// jdbc:mysql://:localhost:8889/dette

public class Database {

  private ArrayList<Connection> pool1;
  private ArrayList<Connection> pool2;
  private int nbConnection = 0;
  
  public Database(int nbCo) throws ClassNotFoundException {
    this.setNbConnection(nbCo);
    this.setPool1(new ArrayList<>());
    this.setPool2(new ArrayList<>());
    connectAll();
}
  
  private void connectAll() throws ClassNotFoundException {
    try {
        for (int i = 0; i < this.nbConnection; i++) {
            this.getPool1().add(getConnection());
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public int getNbConnection() {
    return this.pool1.size();
}

public void setNbConnection(int nbConnection) {
    this.nbConnection = nbConnection;
}

public ArrayList<Connection> getPool1() {
  return pool1;
}

public void setPool1(ArrayList<Connection> pool1) {
  this.pool1 = pool1;
}

public ArrayList<Connection> getPool2() {
    return pool2;
}

public void setPool2(ArrayList<Connection> pool2) {
    this.pool2 = pool2;
}


  //public static void mydb() throws Exception{
    //Connexion BD
   // Class.forName("com.mysql.jdbc.Driver");
    /*Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/dette", "root", "root");
    PreparedStatement statement = con.prepareStatement("select * from Redevance");
    //Requêtes de toutes les valeurs de la table Redevance : les magasins + le montant qu'ils doivent
    ResultSet result = statement.executeQuery();
    
    while(result.next()) {
      System.out.println(result.getString(1)+ " "+ result.getString(2));
    }*/
  //}
  
  public static Connection getConnection() throws SQLException, ClassNotFoundException{
    Class.forName("com.mysql.jdbc.Driver");
    return DriverManager.getConnection("jdbc:mysql://localhost:8889/dette", "root", "root");
  }
  
  public Connection addConnection() {
    if (!getPool1().isEmpty()) {
        Connection co = getPool1().remove(getPool1().size() - 1);
        this.getPool2().add(co);
        return co;
    } else {
        return null;
    }
}
  
  public void close(Connection con) {
    if (con != null) {
        this.getPool1().add(con);
        boolean value = this.getPool2().remove(con);
        if (!value) {
            System.out.println("Pas de connexion");
        } else {
            System.out.println("Connexion interrompue, Nombre de connexions restantes "+this.getPool1().size());
            
        }
    }
}
  
}
