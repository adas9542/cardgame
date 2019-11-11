package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import code.Card;
import code.HomeCellGolf;
import code.TableauPileGolf;

public class homeListener implements MouseListener
{
	private JPanel panel;
	private GolfGUI golfGUI;
	private JFrame frame;
	private HomeCellGolf homeCell;
	private TableauPileGolf tableauPile;
	private JLabel label;
	private JLabel recentModifiedLabel;
	public homeListener(JPanel panel,GolfGUI golfGUI,JFrame frame,HomeCellGolf homeCell,TableauPileGolf tableauPile,JLabel label)
	{
		this.panel=panel;
		this.frame=frame;
		this.golfGUI=golfGUI;
		this.homeCell=homeCell;
		this.tableauPile=tableauPile;
		this.label = label;
		this.recentModifiedLabel = GolfGUI.recentModifiedLabel;
	}
	
	public homeListener()
	{
		
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
		
		if(GolfGUI.tableauBoolean)
		{
//			if(tableauPile.if_removeTop(GolfGUI.recentModifiedindex, GolfGUI.recentModifiedCard))
//			{
			Card card=GolfGUI.recentModifiedCard;
			int index=GolfGUI.recentModifiedindex;
			//JLabel label=card.getJLabel();
			//System.out.println(homeCell.if_addTop(homeCell.getTopCard(),card));
				if(homeCell.if_addTop(homeCell.getTopCard(),card))
				{
					homeCell.addTopCard_increaseCardCounter(card);
					tableauPile.removeCard_decreaseCardCounter(index);
					label.setIcon(GolfGUI.recentModifiedLabel.getIcon());
					golfGUI.getPanel().remove(GolfGUI.recentModifiedLabel);
					
					golfGUI.setTableauBoolean(false);
					//GolfGUI.recentModifiedLabel = null;
					//label.setLocation(700, 400);
					//golfGUI.update();
					frame.doLayout();
					frame.repaint();
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(frame, "Invalid Selection");
					golfGUI.setTableauBoolean(false);
					GolfGUI.unselect(golfGUI.recentModifiedLabel);
				}
				//GolfGUI.unselect(GolfGUI.recentModifiedLabel);
				//GolfGUI.tableauBoolean = !GolfGUI.tableauBoolean;
//			}
		}
		else if(!GolfGUI.tableauBoolean)
		{
			JOptionPane.showMessageDialog(frame, "Invalid Selection");
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		
	}
}
