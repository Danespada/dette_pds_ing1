package dao;

import java.sql.Connection;

import magasin.Emplacement;
import magasin.Magasin;

public abstract class Dao<T> {

protected Connection connect = null;
    
    public Dao(Connection conn){
        this.connect= conn;
    }
    
    public abstract boolean create(T obj);

  
    public abstract boolean delete(T obj);

    
    public abstract boolean update(T obj);

    
    public abstract T find();
    
    public Magasin find(String nom) {
        return null;
    }
    
    
    public Emplacement find(boolean categorie) {
      return null;
  }
    
}
