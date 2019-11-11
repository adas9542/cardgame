package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import code.Card;
import code.FortyThievesTableau;
import code.FortyThievesWaste;
import code.TableauPileGolf;

public class FortyTableauListener  implements MouseListener
{
	private static boolean tableauBoolean;
	private FortyThievesGUI fortyGUI;
	private JLabel label;
	private Card card;
	private FortyThievesTableau tableauPile;
	private int index;
	private JFrame frame;
	
	private int x;
	private int y;
	
	private FortyThievesWaste waste;
	
	public FortyTableauListener(boolean tableauBoolean,FortyThievesGUI fortyGUI,JLabel label,Card card,FortyThievesTableau tableauPile,int index,JFrame frame,int x,int y,FortyThievesWaste waste)
	{
		FortyTableauListener.tableauBoolean=tableauBoolean;
		this.frame=frame;
		this.fortyGUI=fortyGUI;
		this.label = label;
		this.card=card;
		this.tableauPile=tableauPile;
		this.index=index;
		this.x=x;
		this.y=y;
		this.waste=waste;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		//System.out.println(tableauPile.getAllPiles().get(index).get(tableauPile.getAllPiles().get(index).size()-1).getRank());
		if(tableauPile.if_removeTop(index, card))//check if selected card is top card
		{
			if(fortyGUI.wasteBoolean)
			{
				if(tableauPile.if_AddingTableau(index, FortyThievesGUI.recentModifiedCard))
				{
				Card s=FortyThievesGUI.recentModifiedCard;
				tableauPile.addCard(index, FortyThievesGUI.recentModifiedCard);
				
				//fortyGUI.unselect(FortyThievesGUI.recentModifiedLabel);
				
				fortyGUI.setNewTableauLabel(index, x, y, s);
				waste.removeTopCard();
				
				fortyGUI.setCurrentWasteLabel(waste.getTopCard().getJLabel());
				fortyGUI.getPanel().add(waste.getTopCard().getJLabel());
				
				frame.doLayout();
				frame.repaint();
				
				//fortyGUI.setWasteBoolean(false);
				
				}
				else
					JOptionPane.showMessageDialog(frame, "Invalid move");
			}
			//System.out.println(333);
			//System.out.println(tableauPile.getAllPiles().get(index).get(tableauPile.getAllPiles().get(index).size()-1));
			if(!fortyGUI.wasteBoolean)
			{
				tableauBoolean=!FortyThievesGUI.tableauBoolean;
			}
			
			if(tableauBoolean==true)
			{
				FortyThievesGUI.select(label);
				
				
			}
			else 
			{
				FortyThievesGUI.unselect(label);
				FortyThievesGUI.unselect(FortyThievesGUI.recentModifiedLabel);
				if(FortyThievesGUI.recentModifiedCard!=card)
				{
					//JOptionPane.showMessageDialog(frame, "Invalid move");
					if(tableauPile.if_AddingTableau(index, FortyThievesGUI.recentModifiedCard))
					{
						Card s=FortyThievesGUI.recentModifiedCard;
						tableauPile.addCard(index, FortyThievesGUI.recentModifiedCard);
						fortyGUI.setTableauBoolean(tableauBoolean);
						fortyGUI.setNewTableauLabel(index, x, y, s);
						//fortyGUI.redisplayTableau(index, x);
						//fortyGUI.setNewTableauLabel(FortyThievesGUI.recentModifiedindex, x, y, s);
//						label=s.getJLabel();
//						label.setLocation(x, y+20);
//						label.addMouseListener(new FortyTableauListener(tableauBoolean,this,label,card,tableau,index,frame,x,y));
						
						tableauPile.removeCard_decreaseCardCounter(FortyThievesGUI.recentModifiedindex);
						
						//FortyThievesGUI.recentModifiedLabel.setLocation(0, 0);
						//fortyGUI.getPanel().remove(FortyThievesGUI.recentModifiedCard.getJLabel());
						//label.setLocation(50,50);
						//fortyGUI.update();
						//fortyGUI.setTableauBoolean(false);
						
						frame.doLayout();
						frame.repaint();
						//System.out.println(1);
					}
					else if(!fortyGUI.wasteBoolean)
					{
						JOptionPane.showMessageDialog(frame, "Invalid move");
						fortyGUI.setWasteBoolean(false);
					}
				}
			}
			fortyGUI.setWasteBoolean(false);
			fortyGUI.setTableauBoolean(tableauBoolean);
			
		}
		FortyThievesGUI.recentModifiedLabel=label;
		FortyThievesGUI.recentModifiedCard=card;
		FortyThievesGUI.recentModifiedindex=index;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	
}
