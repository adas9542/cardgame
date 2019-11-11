package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import code.Card;
import code.FortyThievesWaste;

public class FortyWasteListener  implements MouseListener
{
	private FortyThievesWaste waste;
	private FortyThievesGUI fortyGUI;
	
	private Card card;
	
	private JLabel label;
	private JFrame frame;
	
	private static boolean wasteBoolean;

	public FortyWasteListener(Card card,FortyThievesWaste waste,boolean wasteBoolean,JLabel label,FortyThievesGUI fortyGUI,JFrame frame)
	{
		FortyWasteListener.wasteBoolean=wasteBoolean;
		
		this.label=label;
		this.frame=frame;
		
		this.card=card;
		
		this.waste=waste;
		this.fortyGUI=fortyGUI;
		
		//this.wasteBoolean=wasteBoolean;
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
		//System.out.println(1);
		if(FortyThievesGUI.tableauBoolean)
		{
			FortyThievesGUI.unselect(FortyThievesGUI.recentModifiedLabel);
			FortyThievesGUI.tableauBoolean = !FortyThievesGUI.tableauBoolean;
			JOptionPane.showMessageDialog(frame, "Invalid move");
		}
		
		else if(waste.isTopCard(card))
		{
			//System.out.println(1);
			wasteBoolean=!FortyThievesGUI.wasteBoolean;
			if(wasteBoolean==true)
			{
				//System.out.println(2);
				FortyThievesGUI.select(label);
			}
			
			else
			{
				//System.out.println(3);
				FortyThievesGUI.unselect(label);
				//FortyThievesGUI.unselect(FortyThievesGUI.recentModifiedLabel);
			}
			fortyGUI.setWasteBoolean(wasteBoolean);
			
		}
		
		FortyThievesGUI.recentModifiedLabel=label;
		FortyThievesGUI.recentModifiedCard=card;
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
