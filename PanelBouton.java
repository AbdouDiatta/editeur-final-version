package editeur;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;

public class PanelBouton extends JPanel{
  protected Livre livre1;

  public PanelBouton(Livre liv){
    this.livre1 = liv;
    this.crerBouton();
  }
  public void crerBouton(){
      for(int i =0; i < livre1.getListeParagraphe().size(); i++){
        JButton jbutton = new JButton("");
        this.add(jbutton,BorderLayout.EAST);
      }
  }
}
