package magasin;

import java.sql.Date;

public class ChiffredAffaire{
  
  private Date date;
  private float montant;
  
  public ChiffredAffaire() {
    
  }

  public ChiffredAffaire(Date date, float montant){
    
    super();
    this.setDate(date);
    this.setMontant(montant);
  }

  public float getMontant()
  {
    return montant;
  }

  public void setMontant(float montant)
  {
    this.montant = montant;
  }

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }
  
}
