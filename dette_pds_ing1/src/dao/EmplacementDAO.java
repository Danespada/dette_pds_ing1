package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import magasin.Emplacement;

public class EmplacementDAO extends Dao<Emplacement>{
    
      private Connection con;
      
      
      public EmplacementDAO(Connection conn) {
          super(conn);
          this.con=conn;
      }
      
      public Connection getConnection(){
          return this.con;
      }

      @Override
      public boolean create(Emplacement obj) {
             try{
                  this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Emplacement(Categorie) values (\'"+obj.isCategorie()+"\')");
                  return true;
              } catch (SQLException e) {
                 System.out.println("Erreur lors de l'insertion");
              }
              return false;
      }

      @Override
      public boolean delete(Emplacement obj) {
          // TODO Auto-generated method stub
          return false;
      }

      @Override
      public boolean update(Emplacement obj) {
          // TODO Auto-generated method stub
          return false;
      }

      public Emplacement find(int empNumber) {
            try{
                  ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT Categorie FROM Emplacement Where Emplacement='"+ empNumber);
                  while(result.next()) {
                      Emplacement emp = new Emplacement(empNumber,result.getBoolean(0), 0, 0);
                      return emp;
                  }
              } catch (SQLException e) {
                  e.printStackTrace();
              }
              return null;
      }

      public ArrayList<Emplacement> findList()
      {
        ArrayList<Emplacement> list = new ArrayList<>();
        try {
          ResultSet result = this.connect
                  .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                  .executeQuery("SELECT id,Categorie FROM Emplacement");
          while (result.next()) {
            Emplacement emp = new Emplacement(result.getInt(0), result.getBoolean(1), 0, 0);
              list.add(emp);
          }
          return list;
      } catch (SQLException e) {
          e.printStackTrace();
      }
        return null;
      }

      @Override
      public Emplacement find()
      {
        // TODO Auto-generated method stub
        return null;
      }


  }


