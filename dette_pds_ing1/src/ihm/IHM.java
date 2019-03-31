package ihm;
import javax.swing.*;

import client.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.toedter.calendar.JDateChooser;
import dao.MagasinDAO;
import magasin.Magasin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.util.ArrayList;

public class IHM extends JFrame {
  
  private OutputStreamWriter w;
  private BufferedReader r;
  private ArrayList<Magasin> listeMag;
  
  public IHM(OutputStreamWriter c, BufferedReader r) {
  super();
    this.w = c;
    this.r = r;
    Window();
  }
  
  
  private void Window() {
    this.setSize(400,200);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    JPanel panel = new JPanel();
    this.setContentPane(panel);

    //recuperation des magasins
    listeMag = new ArrayList<Magasin>();
    try {
      System.out.println("send getmag");

      w.write("getMagasins\n");
      w.flush();
      String magasins = this.r.readLine();
      System.out.println("read mag");
      System.out.println(magasins);
      final Gson gson = new GsonBuilder().setPrettyPrinting().create();
      //recuperation de la liste

      listeMag = gson.fromJson(magasins,new TypeToken<ArrayList<Magasin>>(){}.getType());
    }catch(IOException e){
      e.printStackTrace();
    }finally {
      JLabel label = new JLabel("Liste des magasins");
      this.getContentPane().add(label, BorderLayout.NORTH);
      final JComboBox ListeMagasins = new JComboBox(listeMag.toArray());
      this.getContentPane().add(ListeMagasins, BorderLayout.CENTER);
      final JDateChooser ListeDates = new JDateChooser();
      this.getContentPane().add(ListeDates, BorderLayout.CENTER);
      JButton button = new JButton("Voir facture");
      button.addActionListener((ActionListener) new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          // TODO Auto-generated method stub
          Magasin selected = listeMag.get(ListeMagasins.getSelectedIndex());
          startRedevance(w, selected.getIdMagasin(), ListeDates.getDate().toString());
        }

      });
      this.getContentPane().add(button, BorderLayout.SOUTH);

      this.setVisible(true);
    }
  }
  
  private void Combobox() {
    
  }
  
  public void setListeMagasin(ArrayList<Magasin> list) {
  }
  
  
  public boolean startRedevance(OutputStreamWriter writer,int magasin,String date) {
    try
    {
      System.out.println("push");
      writer.write("redevance\n");
      writer.flush();
      writer.write(magasin+"\n");
      writer.flush();
      writer.write(date+"\n");
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
