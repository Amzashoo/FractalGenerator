package File;

/**
 * 
 * @author Frédéric Vitzikam
 * @author Hamza Chouh
 * @version 1.0
 * Classe Boolean représentant un booléen pour la génération de fichiers de configuration.
 */

public class mBoolean extends Information {

  /**
   * Information stockée.
   */
  private boolean info;
	
  /**
   * Permet de changer l'information stockée.
   * @param x Nouvelle valeur à enregistrer.
   */
  public void setInfo(boolean x) 
  {
	  info = x;
  }

  /**
   * Permet d'obtenir l'information stockée.
   * @return 
   * @return Valeur stockée en mémoire.
   */
  public boolean getInfo()
  {
	  return info;
  }

  /**
   * Transforme l'information stockée sous forme de chaîne de caractères dans le paramètre strInfo.
   */
  public void generateString() 
  {
	  strInfo = String.valueOf(info);
  }

  /**
   * Constructeur générique
   */
  public mBoolean()
  {
  }
  
  /**
   * Constructeur prenant en argument une valeur de booléen.
   * @param a Valeur booléenne à stocker dans mBoolean contruit.
   */
  public mBoolean(boolean a)
  {
	  info = a;
  }
  
  /**
   * Fonction renvoyant le type de l'objet Information, ici Boolean.
   */
  public String type()
  {
	  return "Boolean";
  }

  /**
   * Fonction permettant de générer l'information info à partir de celle contenue dans la chaîne de caractères d'information. (Obsolète à priori)
   */
  public void generateInfo() 
  {
	  info = Boolean.parseBoolean(strInfo);
  }

}
