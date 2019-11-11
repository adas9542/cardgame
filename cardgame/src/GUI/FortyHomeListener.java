package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import code.Card;
import code.FortyThievesHomeCell;
import code.FortyThievesStockPile;
import code.FortyThievesTableau;
import code.FortyThievesWaste;

public class FortyHomeListener  implements MouseListener
{
	private FortyThievesGUI fortyGUI;
	private FortyThievesHomeCell home;
	private FortyThievesStockPile stock;
	private FortyThievesTableau tableau;
	private FortyThievesWaste waste;
	
	private int index;
	
	private JFrame frame;
	private JLabel label;
	private JLabel recentModifiedLabel;
	
	
	public FortyHomeListener(FortyThievesGUI fortyGUI,int index,JFrame frame,FortyThievesHomeCell home,FortyThievesTableau tableau,FortyThievesWaste waste,JLabel label,JPanel panel)
	{
		this.fortyGUI=fortyGUI;
		this.home=home;
		this.stock=stock;
		this.tableau=tableau;
		this.waste=waste;
		
		this.index=index;
		
		this.frame=frame;
		this.label=label;
		this.recentModifiedLabel = FortyThievesGUI.recentModifiedLabel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(FortyThievesGUI.wasteBoolean)
		{
			//int indexTb=FortyThievesGUI.recentModifiedindex;
			Card card=FortyThievesGUI.recentModifiedCard;
			if(home.if_addTop(home.getHomePile().get(index).get(home.getHomePile().get(index).size()-1),card))
			{
				FortyThievesGUI.unselect(FortyThievesGUI.recentModifiedLabel);
				home.addTopCard_increaseCardCounter(index,card);
				
				//JLabel label1=card.getJLabel();
				//tableau.removeCard_decreaseCardCounter(indexTb);
				label.setIcon(FortyThievesGUI.recentModifiedLabel.getIcon());
				fortyGUI.getPanel().remove(FortyThievesGUI.recentModifiedLabel);
				waste.removeTopCard();
				fortyGUI.setCurrentWasteLabel(waste.getTopCard().getJLabel());
				fortyGUI.getPanel().add(waste.getTopCard().getJLabel());
				//fortyGUI.getPanel().remove(FortyThievesGUI.recentModifiedLabel);
				

				frame.doLayout();
				frame.repaint();
				
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "Invalid Selection");
				fortyGUI.setWasteBoolean(false);
				fortyGUI.unselect(FortyThievesGUI.recentModifiedLabel);
			}
		}
		
		else if(FortyThievesGUI.tableauBoolean)
		{
			Card card=FortyThievesGUI.recentModifiedCard;
			int indexTb=FortyThievesGUI.recentModifiedindex;

				if(home.if_addTop(home.getHomePile().get(index).get(home.getHomePile().get(index).size()-1),card))
				{
					home.addTopCard_increaseCardCounter(index,card);
					tableau.removeCard_decreaseCardCounter(indexTb);
					label.setIcon(FortyThievesGUI.recentModifiedLabel.getIcon());
					fortyGUI.getPanel().remove(FortyThievesGUI.recentModifiedLabel);
					
					fortyGUI.setTableauBoolean(false);

					frame.doLayout();
					frame.repaint();
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(frame, "Invalid Selection");
					fortyGUI.setTableauBoolean(false);
					FortyThievesGUI.unselect(fortyGUI.recentModifiedLabel);
				}

		}
		else if(!FortyThievesGUI.tableauBoolean)
		{
			JOptionPane.showMessageDialog(frame, "Invalid Selection");
		}
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
