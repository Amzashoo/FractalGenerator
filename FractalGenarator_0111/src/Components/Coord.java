package Components;
/** 
 * @author Frédéric Vitzikam
 * @author Hamza Chouh
 * @version 1.0
 * Classe abstraite représentant un triplet de coordonnées.
 */
public class Coord
{
	private double x;
	private double y;
	private double z;

	/**
	 * Constructeur générique.
	 */
	public Coord()
	{
	}

	/**
	 * Constructeur prenant en argument les coordonnées à enregistrer.
	 * @param x Coordonnée x.
	 * @param y Coordonnée y.
	 * @param z Coordonnée z.
	 */	
	public Coord(double x, double y, double z)
	{
		set(x,y,z);
	}
	
	/**
	 * Constructeur permettant de copier un coordonnée C passée en argument.
	 * @param C Coordonnée à copier.
	 */
	public Coord(Coord C)
	{
		set(C);
	}
	
	/**
	 * Addition sur les coordonnées.
	 * @param A Première coordonnée.
	 * @param B Seconde coordonnée à additionner à la première.
	 * @return Somme des coordonnées A et B.
	 */
	public static Coord add(Coord A, Coord B)
	{
		return new Coord(A.get_x()+B.get_x(),A.get_y()+B.get_y(),A.get_z()+B.get_z());
	}
	
	/**
	 * Multiplication d'une coordonnée par un scalaire.
	 * @param a Scalaire.
	 * @param A Coordonnée à multiplier.
	 * @return Résultat du produit.
	 */
	public static Coord mult(double a, Coord A)
	{
		return new Coord(a*A.get_x(),a*A.get_y(),a*A.get_z());
	}
	
	/**
	 * Méthode permettant de fixer la coordonnée courante à partir d'une coordonnée passée en argument.
	 * @param C Coordonnée.
	 */
	public void set(Coord C)
	{
		set_x(C.get_x());
		set_y(C.get_y());
		set_z(C.get_z());
	}
	
	/**
	 * Méthode permettant de fixer la coordonnée courante à partir d'un triplet de double.
	 * @param x Coordonnée x.
	 * @param y Coordonnée y.
	 * @param z Coordonnée z.
	 */
	public void set(double x, double y, double z)
	{
		set_x(x);
		set_y(y);
		set_z(z);
	}
	
	/**
	 * Méthode permettant de fixer la valeur de la coordonnée x.
	 * @param x Nouvelle valeur de coordonnée x.
	 */
	public void set_x(double x)
	{
		this.x=x;	
	}
	
	/**
	 * Méthode permettant de fixer la valeur de la coordonnée y.
	 * @param y Nouvelle valeur de coordonnée y.
	 */
	public void set_y(double y)
	{
		this.y=y;	
	}
	
	/**
	 * Méthode renvoyant la valeur de la coordonnée x.
	 * @return Coordonnée x.
	 */
	public void set_z(double z)
	{
		this.z=z;	
	}
	
	/**
	 * Méthode renvoyant la valeur de la coordonnée x.
	 * @return Coordonnée x.
	 */
	public double get_x()
	{
		return x;
	}
	/**
	 * Méthode renvoyant la valeur de la coordonnée y.
	 * @return Coordonnée y.
	 */
	public double get_y()
	{
		return y;
	}	
	/**
	 * Méthode renvoyant la valeur de la coordonnée z.
	 * @return Coordonnée z.
	 */
	public double get_z()
	{
		return z;
	}
	/**
	 * Méthode renvoyant la valeur de la coordonnée x, y ou z en fonction de l'entier passé en argument.
	 * @param i Entier permettant de choisir la valeur de sortie.
	 * @return Coordonnée x si  i = 0, y si i = 1 et z si i = 2. 0 sinon.
	 */
	public double get(int i)
	{
		 switch (i) 
		 {
         case 0: return x;
         case 1: return y;
         case 2: return z;
         default:return 0;
		 }
     }

	/**
	 * Méthode permettant de fixer la valeur de x, y ou z en fonction de l'entier passé en argument.
	 * @param i Entier permettant de choisir la valeur modifiée.
	 * @param val Nouvelle valeur pour le paramètre choisi.
	 */
	public void set(int i, double val)
	{
		switch (i)
		{
		case 0: x = val; break;
		case 1: y = val; break;
		case 2: z = val; break;
		}	 
	}
	
	/**
	 * Méthode générant un affichage de la coordonnée courante.
	 */
	public void afficher()
	{
		System.out.println("| "+ get(0)+" |");
		System.out.println("| "+ get(1)+" |");
		System.out.println("| "+ get(2)+" |");
	}
	/**
	 * Méthode renvoyant la coordonnée opposée à la coordonnée courante.
	 * @return Coordonnée opposée.
	 */
	public Coord opp()
	{
		return new Coord(-x,-y,-z);
	}
	
}