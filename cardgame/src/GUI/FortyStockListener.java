package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import code.Card;
import code.FortyThievesHomeCell;
import code.FortyThievesStockPile;
import code.FortyThievesTableau;
import code.FortyThievesWaste;

public class FortyStockListener  implements MouseListener
{
	private FortyThievesStockPile stock;
	private FortyThievesTableau tableau;
	private FortyThievesHomeCell home;
	private FortyThievesWaste waste;
	
	private FortyThievesGUI fortyGUI;
	
	private JFrame frame;
	private JLabel label;
	
	public FortyStockListener(FortyThievesStockPile stock,JFrame frame,JLabel label,FortyThievesGUI fortyGUI,FortyThievesHomeCell home,FortyThievesTableau tableau,FortyThievesWaste waste)
	{
		this.home=home;
		this.stock=stock;
		this.tableau=tableau;
		this.waste=waste;
		
		this.label=label;
		this.frame=frame;
		
		this.fortyGUI=fortyGUI;
		
		
		
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
		if(FortyThievesGUI.tableauBoolean)
		{
			FortyThievesGUI.unselect(FortyThievesGUI.recentModifiedLabel);
			FortyThievesGUI.tableauBoolean = !FortyThievesGUI.tableauBoolean;
			JOptionPane.showMessageDialog(frame, "Invalid move");
		}
		
		else if(stock.if_removeTopCard() && !fortyGUI.tableauBoolean)
		{	
			Card card=stock.getTopCard();
			
			if(waste.if_addTop(card))
			{
				stock.removeCard_decreaseCounter();
				waste.addTopCard(card);

				JLabel label1=waste.getTopCard().getJLabel();
				label1.addMouseListener(new FortyWasteListener(card,waste,fortyGUI.wasteBoolean,label1,fortyGUI,frame/*»¹Ã»Ð´Íê*/));
				//label1.addMouseListener(new homeListener(golfGUI.getPanel(),golfGUI,frame,homeCell,tableauPile,label1));
				label1.setLocation(1500,700);

				fortyGUI.getPanel().remove(fortyGUI.getCurrentWasteLabel());
				fortyGUI.setCurrentWasteLabel(label1);
				fortyGUI.getPanel().add(label1);
				
				frame.doLayout();
				frame.repaint();
				
			}
			
		}
		else if(stock.getStockArrSize()==0)
		{

			fortyGUI.getPanel().remove(label);

			frame.doLayout();
			frame.repaint();

		}
		
		
		
		
		
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
