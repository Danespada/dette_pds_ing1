package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import magasin.Magasin;


public class MagasinDAO extends Dao<Magasin>{
    
    private Connection con;
    
    
    public MagasinDAO(Connection conn) {
        super(conn);
        this.con=conn;
    }
    
    public Connection getConnection(){
        return this.con;
    }

    @Override
    public boolean create(Magasin obj) {
           try{
                this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO magasin(nommagasin) values (\'"+obj.getNom()+"\')");
                return true;
            } catch (SQLException e) {
               System.out.println("Erreur lors de l'insertion");
            }
            return false;
    }

    @Override
    public boolean delete(Magasin obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Magasin obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Magasin find(String nom) {
          try{
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT nommagasin FROM magasin Where magasin='"+ nom);
                while(result.next()) {
                    Magasin mag = new Magasin(result.getString("nom"));
                    return mag;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }

    @Override
    public Magasin find()
    {
      try {
        ResultSet result = this.connect
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT nommagasin FROM magasin");
        while (result.next()) {
            Magasin mag = new Magasin(result.getString("nom"));
            return mag;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
      return null;
    }


}
