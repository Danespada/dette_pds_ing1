package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import magasin.ChiffredAffaire;
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
                ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT nommagasin, idMagasin FROM magasin Where magasin='"+ nom);
                while(result.next()) {
                    Magasin mag = new Magasin(result.getString("nommagasin"),result.getInt("idMagasin"),new ChiffredAffaire(new Date(2019,5,10),0));
                    return mag;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }

    public ArrayList<Magasin> findList()
    {
      ArrayList<Magasin> list = new ArrayList<>();
      try {
        ResultSet result = this.connect
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT nommagasin,idMagasin FROM magasin");
        while (result.next()) {
            Magasin mag = new Magasin(result.getString("nommagasin"),result.getInt("idMagasin"),new ChiffredAffaire(new Date(2019,5,10),0));
            list.add(mag);
        }
        return list;
    } catch (SQLException e) {
        e.printStackTrace();
    }
      return null;
    }
    public int getSurfaceFromidMagasin(int id) {
        try {
            ResultSet result = this.connect
                    .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT SuperficieEmplacement FROM emplacement e JOIN emplacementMagasin em ON em.idEmplacement = e.idEmplacement" +
                            " Where em.idMagasin ="+id);
            while (result.next()) {
                return result.getInt("SuperficieEmplacement");
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    //return false if exception or shop not found
    public boolean getPrivilegeFromidMagasin(int id) {
        try {
            ResultSet result = this.connect
                    .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT Categorie FROM emplacement e JOIN emplacementMagasin em ON em.idEmplacement = e.idEmplacement" +
                            " Where em.idMagasin ="+id);
            while (result.next()) {
                return (result.getInt("Categorie")==1) ? true : false;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Magasin find()
    {
      // TODO Auto-generated method stub
      return null;
    }


}
