package File;

/**
 * 
 * @author Frédéric Vitzikam
 * @author Hamza Chouh
 * @version 1.0
 * Classe Boolean représentant un flottant pour la génération de fichiers de configuration.
 */

public class mDouble extends Information {
  /**
   * Information stock�e, ici sous forme d'un double.
   */
  private double info;
  
  /**
   * Permet de changer l'information stockée.
   * @param x Nouvelle valeur à enregistrer.
   */
  public void setInfo(double x) {
	  info = x;
  }

  /**
   * Permet d'obtenir l'information stockée.
   * @return Valeur stockée en mémoire.
   */
  public double getInfo() {
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
   * Constructeur générique.
   */
  public mDouble() 
  {
  }
  
  /**
   * Constructeur prenant en argument le Double à stocker dans l'objet mDouble construit.
   * @param a Double à stocker.
   */
  public mDouble(double a)
  {
	  info = a;
  }
  /**
   * Fonction renvoyant le type de l'objet Information courant, ici Double. 
   */
  public String type()
  {
	  return "Double";
  }
  
  /**
   * Permet de générer l'information à stocker dans l'attribut info à partir de celle stockée dans strInfo.
   */
  public void generateInfo() 
  {
	  info = Double.valueOf(strInfo);
  }
}
