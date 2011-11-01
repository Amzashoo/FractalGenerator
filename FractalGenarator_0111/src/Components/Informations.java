package Components;
import java.util.Vector;
import File.Information;
/** 
 * @author Frédéric Vitzikam
 * @author Hamza Chouh
 * @version 1.0
 * Classe stockant les informations communes à l'ensemble des classes du générateur de fractales.
 */
public class Informations {
	/**
	 * Informations stockées.
	 */
	public static Vector<Information> vec = new Vector<Information>();
	
	/**
	 * Constructeur.
	 */
	public Informations()
	{
	}
	
	 /**
	  * Méthode permettant d'obtenir la i-ème information stockée.
	  * @param i Indice de l'information à obtenir.
	  * @return Information souhaitée.
	  */
	public static Information get(int i)
	{
		return vec.elementAt(i);
	}
	
	/**
	 * Méthode permettant la remise à zéro des informations.
	 */
	public static void reset()
	{
		vec = new Vector<Information>();
	}
}

//Revoir l'indexation : hachage ?