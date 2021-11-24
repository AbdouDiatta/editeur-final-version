package editeur;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.io.File;
import javax.swing.JFileChooser;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class MonInterface extends JFrame implements ActionListener{
  protected JPanel monPanelBas;
  protected Livre livre = new Livre();
  protected SaisirText monPanelText = new SaisirText(this.livre);
  protected PanelBouton panelBout = new PanelBouton(this.livre);
  //protected ParagrapheView courantVue;
  private JButton bouton2;
  protected JButton bouton1;
  private JButton bouton3;
  protected Menu menu;
  protected ArrayList<String> nouvParagra;
  protected ArrayList<JButton> choix;
  protected Paragraphe courant;
  protected Paragraphe precedent;


//CONSTRUCTEUR

  public MonInterface(){
    //this.courant = new Paragraphe("blabla", "Ou voulez vous aller", false, false);
    //courant.add(new Reponse("Allez au paragraphe 2", livre.getListeParagraphe().get(0)));
    //courant.add(new Reponse("Allez au paragraphe 3", livre.getListeParagraphe().get(1)));
    //courant.add(new Reponse("Allez au paragraphe 4", livre.getListeParagraphe().get(2)));
    //precedent = null;
    //courantVue = new ParagrapheView(this, courant, precedent);

    //PARAMETRES DE LA FENETRE
    Container cp=this.getContentPane();
    this.nouvParagra = new ArrayList<String>();
    this.menu = new Menu(this);

    this.setSize(600,600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Editeur Livre");
    this.setLayout(new BorderLayout());

    //cp.add(courantVue, BorderLayout.NORTH);

    //CREATION PANEL1
    this.monPanelBas = new JPanel();
    this.monPanelBas.setPreferredSize(new Dimension(50,60));
    this.monPanelBas.setBackground(Color.YELLOW);
    monPanelBas.setLayout(new GridLayout(1,3));
    bouton1 =new JButton("+");
    bouton2 = new JButton("Bouton2");
    monPanelBas.add(bouton1);
    monPanelBas.add(bouton2);
    bouton3 =new JButton("Bouton3");
    monPanelBas.add(bouton3);
    this.setJMenuBar(menu);
    this.getContentPane().add(this.panelBout, BorderLayout.EAST);
    //monPanelBas.add(choix);
    cp.add(this.monPanelBas,BorderLayout.SOUTH);
    // //CREATION MON JPanel2
    //
    // //CREATION PANEL3
    //this.courant = new Paragraphe("blabla", "Ou voulez vous alle2", false, false);
    //this.monPanelText.setPreferredSize(new Dimension(500,500));
    cp.add(this.monPanelText,BorderLayout.CENTER);
    bouton2.addActionListener(this);
    bouton1.addActionListener(this);
    bouton3.addActionListener(this);

    pack();
    this.setVisible(true);


 }
  public void setText(String s){


  }
  public JButton getBouton1(){
    return this.bouton1;
  }
//ASSOCIATION EVENEMENT AUX BOUTON ET AUX ITEMMENU
    @Override
    public void actionPerformed(ActionEvent e)
    {
      Object obj = e.getSource();
      if (obj == bouton2)
      {
        this.monPanelText.afficheParagraphe(livre.getListeParagraphe().get(0));
        this.monPanelText.setnpage(0);
      }
      if (obj == bouton3)
      {
        this.monPanelText.afficheParagraphe(livre.getListeParagraphe().get(2));
        this.monPanelText.setnpage(2);
      }
      /*if (obj == courantVue.getChoix()){
        //this.courantVue.txt.setText(livre.getListeParagraphe().get(1).getText());
        this.courant = courantVue.courant.getReponses().get(2).getSuivant();
        this.courantVue.txt.setText(this.courant.getText());*/


      //}
      if (obj == menu.getBouton1())
      {
      Paragraphe  para = new Paragraphe("");
      this.monPanelText.afficheParagraphe(para);
      }
      if (obj == bouton1)
      {
        this.livre.addParagraphe(new Paragraphe());
        this.panelBout.crerBouton();
        JButton jbutton = new JButton();
        this.panelBout.add(jbutton);
      }
//ASSOCIATION EVENEMENT AUX ITEMMENU
      if (obj == menu.getMenuPara())
      {
      Paragraphe  para = new Paragraphe("");
      this.monPanelText.afficheParagraphe(para);
      }
      if (obj ==menu.getMenuEnregistre()){
          JFileChooser dialogue = new JFileChooser(new File(".txt"));
        	PrintWriter sortie;
        	File fichier;

        	if (dialogue.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
        	    fichier = dialogue.getSelectedFile();
              livre.save(fichier.getPath());
        	}
      }
      if (obj ==menu.getMenuCharge()){
        JFileChooser dialogue = new JFileChooser(new File(".txt"));
        PrintWriter sortie;
        File fichier;
        if (dialogue.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
            fichier = dialogue.getSelectedFile();
            livre = new Livre();
            livre.load(fichier.getPath());
        }
      }
      if (obj == menu.getBouton1())
      {
      Paragraphe  para = new Paragraphe("");
      this.monPanelText.afficheParagraphe(para);
      }
    /*  if (obj ==menu.getMenuSuprim()){
            this.livre.getListeParagraphe().remove
           this.courantVue.txt.remove(courantVue.txt);
           this.courantVue.txt.revalidate();
           monPanelText.repaint();
     }*/

      }
}
