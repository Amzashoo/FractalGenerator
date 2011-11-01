package File;
/** 
 * @author Frédéric Vitzikam
 * @author Hamza Chouh
 * @version 1.0
 * Classe abstraite représentant des informations stockables dans un fichier.
 */
public abstract class Information {
  /**
   * Information stockée sous forme de chaîne de caractères.
   */
  protected String strInfo;
  /**
   * Nom associé à l'information tel qu'il apparaît dans le fichier de configuration.
   */
  private String name;

  /** 
   * Constructeur générique
   */
  public Information()
  {
  }
  
  /**
   * Stocke l'information stockée sous forme de chaîne de caractères dans le paramètre strInfo.
   */
  public abstract void generateString();

  /**
   * Renvoie l'information stockée sous forme de chaîne de caractères.
   * @return Information stockée sous forme de chaîne de caractères.
   */
  public String getString() 
  {
	  generateString();
	  return strInfo;
  }
  
  /**
   * Récupère l'information à partir de strInfo.
   */
  public abstract void generateInfo();
  
  /**
   * Renvoie le nom associé à l'information.
   * @return Nom de l'information.
   */
  public String getName() 
  {
	  return name;
  }  
  
  /**
   * Fixe le nom associé à l'information.
   * param Nom de l'information.
   */
  public void setName(String name) 
  {
	  this.name = name;
  } 
  
  /**
   * Fixe l'information en chaîne de caractères.
   * param Chaîne de caractères.
   */
  public void setStrInfo(String name) 
  {
	  this.strInfo = name;
  } 
  
  /**
   * Renvoie le type de données.
   * @return Type de données.
   */
  public abstract String type();
  
}