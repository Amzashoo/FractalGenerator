import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;

import Components.Coord;

import File.ConfigFile;
import File.mCoord;
import Components.Const;
import Components.Informations;
import Components.Utils;

/** 
 * @author Frédéric Vitzikam
 * @author Hamza Chouh
 * @version 1.0
 * Classe implémentant la barre de menu de la fenêtre principale.
 */
public class Menu extends JMenuBar {
	/**
	 * Menu.
	 */
	private JMenu file, info;
	/**
	 * Éléments de menu.
	 */
	private JMenuItem load, save, soft, us;
	/**
	 * Fenêtre à laquelle appartient cette barre de menu. 
	 */
	private Window window;
	
	/**
	 * Constructeur du menu.
	 * @param window Fenêtre dans laquelle la barre de menu sera placé.
	 */
	public Menu(Window window)
	{
		this.window = window;
		window.setJMenuBar(this);
		file = new JMenu("Fichier");
		add(file);
		
		save = new JMenuItem("Sauver les paramètres");
		save.addActionListener(new Save(window));
		file.add(save);
		
		load = new JMenuItem("Charger les paramètres");
		load.addActionListener(new Load(window));
		file.add(load);
	}
}

/**
 * Gestion de l'action à effectuer lors de l'appel de l'option de sauvegarde.
 */
class Save implements ActionListener
{
	private Window window;	
	final JFileChooser fc = new JFileChooser(".");

	public Save(Window w)
	{
		window = w;		
		fc.setFileFilter(new OurFileFilter()); //Choix du filtre de fichiers.
		fc.setAcceptAllFileFilterUsed(false);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("Sauvegarde demandée.");
		
		int returnVal = fc.showDialog(window, "Enregistrer"); //Affichage de la boîte de dialogue de navigation.
		
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
	            File file = fc.getSelectedFile(); //Obtention du fichier sélectionné dans la boîte de dialogue.
	            String name = file.getName(); //Nom du fichier.
	            
	            int fin = name.lastIndexOf('.'); //Si une extension a été spécifiée, on retire la partie qui suit le point dans le nom de fichier
	            if(fin == -1)
	            	fin = name.length();
	            name = name.substring(0,fin);
	            
	            name = name+".cfg"; //On spécifie l'extension du fichier
	            System.out.println("Dans le fichier : "+ name);
	            ConfigFile cfg = new ConfigFile(name);
	            
	            window.setConfigFile(cfg); //Spéficiation du fichier de configuration courant pour la fenêtre.
	            window.save(); //Sauvgarde des informations.
	    } 
		else 
		{
			System.out.println("Opération annulée par l'utilisateur.");
	    }

	}	
}

/**
 * Gestion de l'action à effectuer lors de l'appel de l'option de chargement de fichier.
 */
class Load implements ActionListener
{
	private Window window;
	
	final JFileChooser fc = new JFileChooser(".");

	public Load(Window w)
	{
		window = w;
		fc.setFileFilter(new OurFileFilter()); //Choix du filtre de fichiers.
		fc.setAcceptAllFileFilterUsed(false);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("Chargment demandé.");
		int returnVal = fc.showDialog(window, "Charger"); //Affichage de la boîte de dialogue de navigation.
		
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
            File file = fc.getSelectedFile(); //Obtention du fichier sélectionné dans la boîte de dialogue.
            window.setConfigPath(file.getName()); //Spécification du chemin du fichier à charger.
            window.refresh(); //Actualisation.
        } 
		else 
		{
			System.out.println("Open command cancelled by user.");
	    }

	}	
}

class OurFileFilter extends FileFilter {
	 
    //Filtre permettant de rejeter les fichiers dont l'extension n'est pas celle que l'on souhaite. 
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
 
        String extension = Utils.getExtension(f);
        if (extension != null) 
        {
            return extension.equals(Const.fileExtension);
        }
 
        return false;
    }
 
    //Description du fichier.
    public String getDescription() {
        return "Fichiers de type "+ Const.fileExtension;
    }
}
