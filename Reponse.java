package editeur;

public class Reponse{
  private String texte;
  private Paragraphe suivant;


  public Reponse(String texte, Paragraphe suivant){
    this.texte = texte;
    this.suivant = suivant;
  }

  public String getTexte(){
    return texte;
  }

  public Paragraphe getSuivant(){
    return suivant;
  }
}
