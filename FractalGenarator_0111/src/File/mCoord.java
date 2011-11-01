package File;
import Components.Coord;

/**
 * 
 * @author Frédéric Vitzikam
 * @author Hamza Chouh
 * @version 1.0
 * Classe Boolean représentant un triplet de coordonnées pour la génération de fichiers de configuration.
 */

public class mCoord extends Information {
  /**
   * Information stock�e, ici sous forme d'un triplet de coordonnées.
   */
  private Coord info;
  
  /**
   * Permet de changer l'information stockée.
   * @param x Nouvelle valeur à enregistrer.
   */
  public void setInfo(Coord c) {
	  info = c;
  }

  /**
   * Permet d'obtenir l'information stockée.
   * @return Valeur stockée en mémoire.
   */
  public Coord getInfo() {
	  return info;
  }

  /**
   * Transforme l'information stockée sous forme de chaîne de caractères dans le paramètre strInfo.
   */
  public void generateString() 
  {
	  strInfo = String.valueOf(info.get_x())+","+String.valueOf(info.get_y())+","+String.valueOf(info.get_z());
  }

  /**
   * Constructeur générique
   */
  public mCoord() 
  {
	  info = new Coord();
  }
  
  /**
   * Constructeur prenant en argument un objet de type Coord.
   * @param c Coord à stocker dans le paramètre info.
   */
  public mCoord(Coord c)
  {
	  info = c;
  }
  
  /**
   * Constructeur prenant en argument trois coordonnées à stocker en information.
   * @param x Abscisse à stocker.
   * @param y Ordonnée à stocker.
   * @param z Côte à stocker.
   */
  public mCoord(double x, double y, double z)
  {
	  info = new Coord(x,y,z);
  }
  
  /**
   * Fonction renvoyant le type de l'objet Information courant, ici Coord. 
   */
  public String type()
  {
	  return "Coord";
  }
  
  /**
   * Permet de générer l'information à stocker dans l'attribut info à partir de celle stockée dans strInfo.
   */
  public void generateInfo() 
  {
	  String tmp;
	  int i = 0;
	  while(strInfo.charAt(i) != ',')
		  i++;
	  tmp = strInfo.substring(0, i);
	  info.set_x(Double.parseDouble(tmp));
	  i++;
	  
	  int j = i;
	  while(strInfo.charAt(j) != ',')
		  j++;
	  tmp = strInfo.substring(i, j);
	  info.set_y(Double.parseDouble(tmp));
	  j++;
	  
	  tmp = strInfo.substring(j, strInfo.length());
	  info.set_z(Double.parseDouble(tmp));
  }
}
