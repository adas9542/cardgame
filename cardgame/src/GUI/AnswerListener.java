package GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import code.Card;
import code.TableauPileGolf;


public class AnswerListener implements MouseListener
{
	private static boolean tableauBoolean;
	private GolfGUI golfGUI;
	private JLabel label;
	private Card card;
	private TableauPileGolf tableauPile;
	private int index;
	private JFrame frame;
	public AnswerListener(boolean tableauBoolean,GolfGUI golfGUI,JLabel label,Card card,TableauPileGolf tableauPile,int index,JFrame frame)
	{
		AnswerListener.tableauBoolean=tableauBoolean;
		this.frame=frame;
		this.golfGUI=golfGUI;
		this.label = label;
		this.card=card;
		this.tableauPile=tableauPile;
		this.index=index;
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
				
	}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(tableauPile.if_removeTop(index, card))//check if selected card is top card
		{
			tableauBoolean=!GolfGUI.tableauBoolean;
			if(tableauBoolean==true)
			{
				GolfGUI.select(label);
			}
			else
			{
				GolfGUI.unselect(label);
				GolfGUI.unselect(GolfGUI.recentModifiedLabel);
				if(GolfGUI.recentModifiedCard!=card)
				{
					JOptionPane.showMessageDialog(frame, "Invalid move");
				}
			}
			
			golfGUI.setTableauBoolean(tableauBoolean);
			
		}
		GolfGUI.recentModifiedLabel=label;
		GolfGUI.recentModifiedCard=card;
		GolfGUI.recentModifiedindex=index;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		
	}
}
