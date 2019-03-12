package ihm;
import javax.swing.*;
import java.awt.*;

public class IHM extends JFrame {
  
  public IHM() {
  super();  
  Window();
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
    this.getContentPane().add(button, BorderLayout.SOUTH);
    
    this.setVisible(true);
  }
}
