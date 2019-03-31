package magasin;

public class Magasin{
  
  private int idMag;
  private String nomMag;
  
  public Magasin(String nom,int idMag, ChiffredAffaire ca) {
    this.idMag = idMag;
    this.nomMag = nom;
  }
  
  
  public Magasin(String nom){
    this.nomMag = nom;
  }
 
  public Magasin() {
    
  }
  
  public String getNom()
  {
    return nomMag;
  }
  public void setNom(String nom)
  {
    this.nomMag = nom;
  }


  public int getIdMagasin()
  {
    return this.idMag;
  }
  public String toString(){return "" + this.nomMag+";"+this.idMag;}


  public void setIdMagasin(int idMagasin)
  {
    this.idMag = idMagasin;
  }
  
  
}
