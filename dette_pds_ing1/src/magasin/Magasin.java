package magasin;

public class Magasin{
  
  private int idMag;
  private String nomMag;
  
  public Magasin(int idMag, String nom, ChiffredAffaire ca) {
    
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
    return idMag;
  }


  public void setIdMagasin(int idMagasin)
  {
    this.idMag = idMagasin;
  }
  
  
}
