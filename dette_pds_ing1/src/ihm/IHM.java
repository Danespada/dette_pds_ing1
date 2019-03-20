package ihm;
import javax.swing.*;

import client.Client;
import dao.MagasinDAO;
import magasin.Magasin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.util.ArrayList;

public class IHM extends JFrame {
  
  private OutputStreamWriter w;
  
  public IHM(OutputStreamWriter c) {
  super();  
  Window();
  this.w = c;
  }
  
  
  private void Window() {
    this.setSize(400,200);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    JPanel panel = new JPanel();
    this.setContentPane(panel);
    
    JLabel label = new JLabel("Liste des magasins");
    this.getContentPane().add(label, BorderLayout.NORTH);
    JComboBox ListeMagasins = new JComboBox();
    this.getContentPane().add(ListeMagasins, BorderLayout.CENTER);
    JComboBox ListeDates = new JComboBox();
    this.getContentPane().add(ListeDates, BorderLayout.CENTER);
    JButton button = new JButton("Voir facture");
    button.addActionListener((ActionListener)new ActionListener() {

      public void actionPerformed(ActionEvent e)
      {
        // TODO Auto-generated method stub
        startRedevance(w, 1, null);
      }
   
    });
    this.getContentPane().add(button, BorderLayout.SOUTH);
    
    this.setVisible(true);
  }
  
  private void Combobox() {
    
  }
  
  public void setListeMagasin(ArrayList<Magasin> list) {
  }
  
  
  public boolean startRedevance(OutputStreamWriter writer,int magasin,Date date) {
    try
    {
      System.out.println("push");
      writer.write("redevance\n");
      writer.flush();
      writer.write("1\n");
      writer.flush();
      writer.write("01012019\n");
      writer.flush();
      
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return false;
  }
  
}
