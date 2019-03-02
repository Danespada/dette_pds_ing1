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
    
    JPanel panel = new JPanel();
    this.setContentPane(panel);
    
    JButton button = new JButton("Voir");
    this.getContentPane().add(button);
    JTextField jtxtfld = new JTextField(50);
    this.getContentPane().add(jtxtfld);
    JLabel label = new JLabel("Exemple de label");
    this.getContentPane().add(label);
    this.setVisible(true);
  }
}
