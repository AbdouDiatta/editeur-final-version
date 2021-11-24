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
import java.awt.event.*;
import javax.swing.AbstractAction;

public class ParagrapheView extends JPanel{
  JTextField txt;
  JTextField question;
  protected JButton retour;
  protected ArrayList<JButton> choix;
  Paragraphe courant,parent;
  MonInterface _interface;
  public ParagrapheView(MonInterface i, Paragraphe courant,Paragraphe parent){
    this._interface = i;
   this.courant=courant;
   this.parent=parent;
   txt = new JTextField(courant.getText());
   question = new JTextField(courant.getQuestion());
   choix = new ArrayList<JButton>();
   for (Reponse r : courant.getReponses()){
     JButton b = new JButton(r.getTexte());
     choix.add(b);
   }
   this.setLayout(new BorderLayout());
   this.add(question,BorderLayout.NORTH);
   this.add(txt,BorderLayout.CENTER);
   JPanel buttons = new JPanel();
   this.setLayout(new GridLayout(1, choix.size()));
   this.add(buttons,BorderLayout.SOUTH);
   for(JButton b : choix){
     buttons.add(b);
   }

 }
    public ArrayList<JButton> getChoix(){
      return this.choix;
    }



//  public Action(String s){
    //super(s);

  //}
  //public void actionPerformed(ActionEvent e){
    //  System.exit(0);
  //}

}
