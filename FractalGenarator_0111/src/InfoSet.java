import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Components.Const;
import Components.Informations;
import File.Information;

/** 
 * @author Frédéric Vitzikam
 * @author Hamza Chouh
 * @version 1.0
 * Panneau d'affichage d'informations représentant une information prise dans la classe Informations.
 */

public class InfoSet extends JPanel{
	/**
	 * Valeur de l'index où se situe l'information dans la classe Informations.
	 */
	private int valueIndex;
	/**
	 * Nom associé à l'information.
	 */
	JLabel nameLabel;
	/**
	 * Information à afficher.
	 */
	JTextField infoText;
	
	/**
	 * Constructeur de la classe Infoset.
	 * @param index Valeur d'index.
	 */
	public InfoSet(int index)
	{
		//Construction
		super();
		valueIndex = index;
		
		//Contenu et organisation du panneau
		this.setLayout(new FlowLayout());
		this.setMinimumSize(new Dimension(Const.nameLabelWidth+Const.infoTextWidth,Const.nameLabelHeight+Const.infoTextHeight));
		nameLabel = new JLabel(info().getName()+ " : ");
		infoText = new JTextField(info().getString());
		nameLabel.setPreferredSize(new Dimension(Const.nameLabelWidth, Const.nameLabelHeight));
		infoText.setPreferredSize(new Dimension(Const.infoTextWidth, Const.infoTextHeight));
		
		//Gestion des modifications
		infoText.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {
				if(!arg0.isActionKey() && arg0.getKeyCode() != arg0.VK_LEFT && arg0.getKeyCode() != arg0.VK_RIGHT && arg0.getKeyCode() != arg0.VK_KP_LEFT && arg0.getKeyCode() != arg0.VK_RIGHT && !arg0.isShiftDown())
					clean();
			}
			public void keyReleased(KeyEvent arg0) {
				if(!arg0.isActionKey() && arg0.getKeyCode() != arg0.VK_LEFT && arg0.getKeyCode() != arg0.VK_RIGHT && arg0.getKeyCode() != arg0.VK_KP_LEFT && arg0.getKeyCode() != arg0.VK_RIGHT && !arg0.isShiftDown())
					clean();
			}
			public void keyTyped(KeyEvent arg0) {
				if(!arg0.isActionKey() && arg0.getKeyCode() != arg0.VK_LEFT && arg0.getKeyCode() != arg0.VK_RIGHT && arg0.getKeyCode() != arg0.VK_KP_LEFT && arg0.getKeyCode() != arg0.VK_RIGHT && !arg0.isShiftDown())
					clean();				
			}
		    });
		
		nameLabel.setVisible(true);
		infoText.setVisible(true);
		
		//Ajout du label et du champ modifiable au panneau
		this.add(nameLabel);
		this.add(infoText);
	}
	
	/**
	 * Méthode retournant l'information associée à l'InfoSet considéré
	 * @return Information associée.
	 */
	public Information info()
	{
		return Informations.get(valueIndex);
	}
	
	/**
	 * Méthode permettant la gestion en direct des modifications apportées au champ de texte.
	 */
	public void clean()
	{
		String tmp = info().getString();
		try
		{
			info().setStrInfo(infoText.getText());
			info().generateInfo();
		}
		catch(Exception e)
		{
			infoText.setText(tmp);
		}	
	}
	
	/**
	 * Méthode permettant l'actualisation de l'InfoSet considéré.
	 */
	public void update()
	{
		info().generateString();
		infoText.setText(info().getString());
		nameLabel.setText(info().getName());
	}
}