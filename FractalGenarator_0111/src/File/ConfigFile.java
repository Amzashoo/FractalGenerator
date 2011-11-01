package File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import Components.Informations;

/** 
 * @author Frédéric Vitzikam
 * @author Hamza Chouh
 * @version 1.0
 * Classe permettant de représenter un fichier de configuration.
 */
public class ConfigFile {
  /**
   * Ensemble des informations stockées dans le fichier.
   */
	private Informations infos;
  /**
   * Chemin d'accès au fichier écrit en mémoire.
   */
  private String path;

  /**
   * Constructeur de la classe ConfigFile.
   * @param path Chemin relatif d'accès au fichier de configuration.
   */
  public ConfigFile(String path) 
  {
	  this.path = path;
  }
  
  public ConfigFile() 
  {
	  path = "";
  }

/**
   * Permet d'obtenir l'information stockée.
   * @param Information à ajouter dans le fichier.
   */
  public void addInformation(Information info) {
	  infos.vec.add(info);
  }

  /**
   * Permet d'obtenir l'information stockée.
   * @param Indice de l'information à obtenir.
   */
  public Information getInformation(int num) {
	  return infos.vec.elementAt(num);
  }
  
  /**
   * Permet d'obtenir toute l'information stockée.
   */
  public Informations getInformations() {
	  return infos;
  }

 /**
  * Permet de stocker un objet de type Information donné à un emplacement donné de l'ensemble des informations du fichier.
  * @param num Indice de l'information à fixer.
  * @param info Contenu de type Information à placer à l'indice num.
  */
  public void setInformation(int num, Information info) {
	  infos.vec.set(num, info);
  }

  /**
   * Permet de stocker un ensemble d'Informations donné.
   * @param info Contenu de type Vector<Information>.
   */
   public void setInformations(Vector<Information> info) {
 	  infos.vec = info;
   }

  /**
   * Permet de changer le chemin du fichier.
   * @param path Chemin relatif du fichier.
   */
  public void setPath(String path) {
	  this.path = path;
  }

  /**
   * Permet d'obtenir le chemin du fichier.
   * @return Chemin du fichier.
   */
  public String getPath() {
	  return path;
  }
  
  /**
   * Permet de sauvegarder le fichier. 
   */
  public void saveFile()
  {
	  PrintWriter writer;
		try
		{
			writer = new PrintWriter(new FileWriter(path));
			Information info;
			//Écrire le contenu d'un début de fichier de config dans Const.java
			for(int i = 0; i<infos.vec.size(); i++)
			{
				info = infos.vec.elementAt(i);
				writer.write(info.type()+"@"+info.getName()+"\n");
				writer.write("	"+infos.vec.elementAt(i).getString()+"\n");
			}
			writer.close();
			//CONFIRMATION ?
		} 
		catch (IOException e) {
			System.out.println("Problème d'I/O.");	
		}
  }
  
  /**
   * Permet de générer le contenu d'une information à partir des deux lignes la concernant extraites du fichier de configuration.
   * @param nameLine Ligne contenant le nom et le type de l'information. 
   * @param infoLine Ligne contenant l'information elle-même.
   */
  public void readInfo(String nameLine, String infoLine)
  { 
	  	String type = "";
	  	String name = "";
	  	String info = infoLine;
		int i = 0;
		while(nameLine.charAt(i) != '@') //Le caractère '@' marque la fin de la partie "Type".
		{
			type = type + String.valueOf(nameLine.charAt(i));
			i++;
		}
		i++;
		name = nameLine.substring(i, nameLine.length());
		System.out.println("Élément : " + name + " --- " + type);
		System.out.println(type.equals("Double"));
		Information item;
		if(type.equals("Boolean"))
		{
			item = new mBoolean();
			item.setStrInfo(info);
			item.generateInfo();
		}
		else
			if(type.equals("Double"))
		{
			item = new mDouble();
			item.setStrInfo(info);
			item.generateInfo();
		}
		else 
			if(type.equals("Coord"))
		{
			item = new mCoord();
			item.setStrInfo(infoLine);			
			item.generateInfo();
		}
		else
			item = new mBoolean(true); //Cas par défaut qui n'arrive jamais car un fichier de configuration contient toujours les types d'information.
			
		item.setName(name);
		System.out.println("Lecture de l'élément : " + item.getName() + " - " + item.getString());
		infos.vec.add(item);
  }
  
  /**
   * Permet de remplir l'objet ConfigFile à partir du fichier de configuration spécifié dans path.
   */
  public void readFile()
  {
	  Informations.reset();
	  BufferedReader reader;
		try
		{
			String tmp = "init";
			String tmp1 = "init";
			System.out.println(path);
			reader = new BufferedReader(new FileReader(path));
			while(tmp != null && tmp1 != null)
			{
				tmp = reader.readLine();
				tmp1 = reader.readLine();
				if(tmp != null && tmp1 != null)
					readInfo(tmp,tmp1);
			}
		}
		catch (IOException a) 
		{
			System.out.println("Problème d'IO");
		}
  }
}