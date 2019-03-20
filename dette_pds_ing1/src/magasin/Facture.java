package magasin;

import java.sql.Date;

public class Facture {


  private int idFacture;
  private Date date;
  private float loyer;
  
  private double tauxPrivilege = 1.2;
  // taux sur les emplacements privilégiés = +20% au loyer théorique
  
  private double tauxSurVente = 0.1;
  // taux sur les ventes effectuées par un magasin = 10% des ventes
  
  
  
public Facture() {
    
  }
  
  Magasin mag = new Magasin();
  Emplacement emp = new Emplacement();
  ChiffredAffaire ca = new ChiffredAffaire();
  EmplacementMagasin empMag = new EmplacementMagasin(mag, emp);
 
  
  public float calculRedevance(EmplacementMagasin empMag) {
    float redevance;
    redevance = emp.getLoyerTheorique();
    if(emp.isCategorie()==true && ca.getMontant()> 2 * emp.getLoyerTheorique()) {
      redevance = (float)(redevance*tauxPrivilege);
      redevance = redevance + ca.getMontant() * (float)tauxSurVente;
    }else if(emp.isCategorie()==false && ca.getMontant()>2 * emp.getLoyerTheorique()){
     redevance = redevance + ca.getMontant() * (float)tauxSurVente;
    }
    return redevance;
  }
  
  public int getIdFacture()
  {
    return idFacture;
  }


  public void setIdFacture(int idFacture)
  {
    this.idFacture = idFacture;
  }


  public Date getDate()
  {
    return date;
  }


  public void setDate(Date date)
  {
    this.date = date;
  }


  public float getLoyer()
  {
    return loyer;
  }


  public void setLoyer(float loyer)
  {
    this.loyer = loyer;
  }


  public double getTauxPrivilege()
  {
    return tauxPrivilege;
  }


  public void setTauxPrivilege(double tauxPrivilege)
  {
    this.tauxPrivilege = tauxPrivilege;
  }


  public double getTauxSurVente()
  {
    return tauxSurVente;
  }


  public void setTauxSurVente(double tauxSurVente)
  {
    this.tauxSurVente = tauxSurVente;
  }


  public Magasin getMag()
  {
    return mag;
  }


  public void setMag(Magasin mag)
  {
    this.mag = mag;
  }


  public Emplacement getEmp()
  {
    return emp;
  }


  public void setEmp(Emplacement emp)
  {
    this.emp = emp;
  }


  public ChiffredAffaire getCa()
  {
    return ca;
  }


  public void setCa(ChiffredAffaire ca)
  {
    this.ca = ca;
  }


  public EmplacementMagasin getEmpMag()
  {
    return empMag;
  }


  public void setEmpMag(EmplacementMagasin empMag)
  {
    this.empMag = empMag;
  }
}
