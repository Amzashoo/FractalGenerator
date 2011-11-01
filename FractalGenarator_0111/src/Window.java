import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;

import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Components.Const;
import Components.Informations;
import File.*;

/** 
 * @author Frédéric Vitzikam
 * @author Hamza Chouh
 * @version 1.0
 * Classe implémentant la fenêtre du générateur de fractales.
 */
public class Window extends JFrame {

	/**
	 * Représentation du fichier de configuration associé.
	 */
	private ConfigFile cfg;
	/**
	 * Ensemble des afficheurs à mettre à jour lors du chargement d'un fichier de configuration.
	 */
	private Vector<InfoSet> infoDisplayers;
	/**
	 * Conteneur principal de la fenêtre.
	 */
	private Container contain;
	/**
	 * Panneau inférieur de la fenêtre.
	 */
	private JPanel infPanel;
	/**
	 * Écran d'affichage de la figure fractale.
	 */
	private JPanel screen;
	
	/**
	 * Constructeur de la fenêtre principale.
	 */
	public Window()
	{
		super();
		infoDisplayers = new Vector<InfoSet>();
		cfg = new ConfigFile();
		
		//Initialisation des paramètres de configuration
		mDouble xPos = new mDouble(2.0);
		xPos.setName("Position X");
		Informations.vec.add(xPos);
		
		mDouble yPos = new mDouble(5.0);
		yPos.setName("Position Y");
		Informations.vec.add(yPos);
		
		mDouble zPos = new mDouble(6.0);
		zPos.setName("Position Z");
		Informations.vec.add(zPos);

		//Paramétrage de la fenêtre
		setTitle(Const.title); //Titre de la fenêtre
		this.setSize(Const.windows_x,Const.screensize_y+Informations.vec.size()*(Const.nameLabelHeight+10)+100); //Dimensions de la fenêtre
		setLocationRelativeTo(null); //Positionnement centré
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Définition de l'opération de fermeture
		
		//Placement du contenu
		contain = new JPanel(new GridBagLayout());
		this.setContentPane(contain);
		contain.setBackground(new Color(180,180,180));
		build(); //Construction du panneau princpal.
	}

	/**
	 * Méthode permettant la construction du panneau principal.
	 */
	private void build()
	{
		GridBagConstraints C = new GridBagConstraints(); //On utilise un gestionnaire de placement de type 'grille'
		C.gridx = 0; //Position, taille, et propriétés de redimensionnement du bloc d'affichage de la fractale
		C.gridy = 0;
		C.gridwidth = 3;
		C.gridheight = 1;
		C.weightx = 10;
		C.weighty = 10;
		C.insets = new Insets(10,10,10,10); //Marges
		C.fill = GridBagConstraints.NONE;  

		screen = new JPanel(); //Création et spécification du bloc d'affichage de la fractale
		screen.setBackground(Color.black);
		screen.setMinimumSize(new Dimension(Const.screensize_x,Const.screensize_y));
		screen.setMaximumSize(new Dimension(Const.screensize_x,Const.screensize_y));
		screen.setPreferredSize(new Dimension(Const.screensize_x,Const.screensize_y));
		//TODO : Génération de l'écran
		contain.add(screen,C); //Ajout de l'écra au conteneur principal
		
		C.fill = GridBagConstraints.HORIZONTAL; //Position, taille et propriétés de redimensionnement du panneau inférieur
		C.insets = new Insets(0,0,0,0);
		C.gridx = 0;
		C.gridy = 1;
		C.gridwidth = 3;
		C.gridheight = 1;
		C.weightx = 0;
		C.weighty = 100;
		C.anchor = GridBagConstraints.NORTH;
		
		infPanel = new JPanel(); //Création du panneau inférieur
		buildInfPanel(infPanel); //Spécification et remplissage du panneau inférieur
		contain.add(infPanel,C); //Ajout du panneau inférieur au bloc principal
		
		Menu m = new Menu(this);
	}
	
	/**
	 * Méthode permettant de transformer un panneau en panneau d'informations.
	 * @param pane Panneau à transformer.
	 */
	private void makeInfoPanel(Container pane) 
	{
	    pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	 	pane.setLayout(new GridBagLayout());
	 	pane.setMinimumSize(new Dimension(Const.menu_x,Const.menu_y));
	 	pane.setPreferredSize(new Dimension(Const.menu_x,Const.menu_y));
	 	pane.setMaximumSize(new Dimension(Const.menu_x,Const.menu_y));


		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		//Panel d'informations
		c.gridx = 0;
		for(int i = 0; i < Informations.vec.size(); i++)
		{
			System.out.println("ICI");
			c.gridy = i;
			JPanel a = new InfoSet(i);
			infoDisplayers.add((InfoSet) a);
			pane.add(a,c);
		}
	}
	
	/**
	 * Méthode permettant de transformer un panneau en panneau de commande gauche.
	 * @param pane Panneau à transformer.
	 */
	private void makeLeftCmdPanel(Container pane) 
	{
	    //Boutons gauche
	}
	
	/**
	 * Méthode permettant de transformer un panneau en panneau de commande droit.
	 * @param pane Panneau à transformer.
	 */
	private void makeRightCmdPanel(Container pane) 
	{
	    //Boutons gauche
	}
	
	/**
	 * Méthode permettant de transformer un panneau en le panneau inférieur.
	 * @param pane Panneau à transformer.
	 */
	public void buildInfPanel(Container pane)
	{
		pane.setSize(new Dimension(Const.menu_x,Const.menu_y)); //Dimensions et organisation
		pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		//Panneau de commandes gauche
		c.gridx = 0;
		c.gridy = 0;
		JPanel leftCmdPanel = new JPanel();
		makeLeftCmdPanel(leftCmdPanel);
		pane.add(leftCmdPanel,c);
		
		//Panneau d'information
		c.gridx = 1;
		c.gridy = 0;
		JPanel infoPanel = new JPanel();
		makeInfoPanel(infoPanel);
		pane.add(infoPanel,c);
		
		//Panneau de commande droit
		c.gridx = 2;
		c.gridy = 0;
		JPanel rightCmdPanel = new JPanel();
		makeRightCmdPanel(rightCmdPanel);
		pane.add(rightCmdPanel,c);
	}

	/**
	 * Méthode permettant d'obtenir le fichier de configuration de la fenêtre considérée.
	 * @return Fichier de configuration.
	 */
	public ConfigFile getConfigFile()
	{
		return cfg;
	}	
	
	/**
	 * Méthode permettant de fixer le fichier de configuration de la fenêtre considérée.
	 * @param cfg Fichier de configuration.
	 */
	public void setConfigFile(ConfigFile cfg)
	{
		this.cfg = cfg;
	}
	
	/**
	 * Méthode permettant d'ordonner l'enregistrement de la configuration actuelle par le biais de l'objet ConfigFile associé.
	 */
	public void save()
	{
		cfg.setInformations(Informations.vec);
		cfg.saveFile();
	}
	
	/**
	 * Méthode permettant de rafraîchir l'affichage des informations.
	 */
	public void refresh()
	{
		for(int i = 0; i < infoDisplayers.size(); i++)
		{
			infoDisplayers.elementAt(i).update();
		}
	}
	
	/**
	 * Méthode permettant de changer le chemin d'accès au fichier de configuration de la fenêtre considérée.
	 * @param path Chemin d'accès.
	 */
	public void setConfigPath(String path)
	{
		cfg.setPath(path);
		cfg.readFile();
	}

	
	public void mouseClicked(MouseEvent arg0) 
	{
		
	}

	public void mouseEntered(MouseEvent arg0) 
	{
		
	}

	public void mouseExited(MouseEvent arg0) 
	{
		
	}

	public void mousePressed(MouseEvent arg0) 
	{
		
	}

	public void mouseReleased(MouseEvent arg0) 
	{
		
	}
}
