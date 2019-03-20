package magasin;

public class Emplacement{
  
  private int id;
  private boolean categorie;
  private int superficieEmplacement;
  private float loyerTheorique;
  
  //loyerTheorique = 160*superficieEmplacement --> 160€/m2
  
  public Emplacement(int id,boolean categorie, int superficieEmplacement, float loyerTheorique)
  {
    super();
    this.setCategorie(categorie);
    this.setSuperficieEmplacement(superficieEmplacement);
    this.setLoyerTheorique(loyerTheorique);
  }
  
  public Emplacement() {
    
  }

  public int getSuperficieEmplacement()
  {
    return superficieEmplacement;
  }


  public void setSuperficieEmplacement(int superficieEmplacement)
  {
    this.superficieEmplacement = superficieEmplacement;
  }


  public float getLoyerTheorique()
  {
    return loyerTheorique;
  }


  public void setLoyerTheorique(float loyerTheorique)
  {
    this.loyerTheorique = loyerTheorique;
  }


  public boolean isCategorie()
  {
    return categorie;
  }


  public void setCategorie(boolean categorie)
  {
    this.categorie = categorie;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }
  
  
 
}
