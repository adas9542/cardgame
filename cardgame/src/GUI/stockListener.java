package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import code.Card;
import code.HomeCellGolf;
import code.StockPileGolf;
import code.TableauPileGolf;

public class stockListener implements MouseListener
{
	private StockPileGolf stockPile;
	private JFrame frame;
	private JLabel label;
	private GolfGUI golfGUI;
	private HomeCellGolf homeCell;
	private TableauPileGolf tableauPile;
	private static int x;
	//private boolean tableauBoolean;
	
	public stockListener(StockPileGolf stockPile,JFrame frame,JLabel label,GolfGUI golfGUI,HomeCellGolf homeCell,TableauPileGolf tableauPile)
	{
		this.homeCell=homeCell;
		this.label=label;
		this.stockPile=stockPile;
		this.frame=frame;
		this.tableauPile=tableauPile;
		this.golfGUI=golfGUI;
		//this.tableauBoolean=tableauBoolean;
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
			GolfGUI.unselect(GolfGUI.recentModifiedLabel);
			GolfGUI.tableauBoolean = !GolfGUI.tableauBoolean;
		}
		
		else if(stockPile.if_removeTopCard() && !golfGUI.tableauBoolean)
		{	
			//stockPile.setTopCard();
			Card card=stockPile.getTopCard();
			//System.out.println(card.getRank());
			//System.out.println("stock size"+stockPile.getStockArrSize());
			//System.out.println(homeCell.if_addTop(homeCell.getTopCard(), card));
			
			if(homeCell.if_addTop(homeCell.getTopCard(), card))
			{
				stockPile.removeCard_decreaseCounter();
				homeCell.addTopCard_increaseCardCounter(card);
				//System.out.println("homeCell size"+homeCell.getSize());
				JLabel label1=homeCell.getTopCard().getJLabel();
				label1.addMouseListener(new homeListener(golfGUI.getPanel(),golfGUI,frame,homeCell,tableauPile,label1));
				label1.setLocation(700,400);
				//System.out.println(homeCell.getTopCard().getRank());
				golfGUI.getPanel().remove(golfGUI.getCurrentHomeLabel());
				golfGUI.setCurrentHomeLabel(label1);
				golfGUI.getPanel().add(label1);
				
				frame.doLayout();
				frame.repaint();
				
				//
//				label.removeMouseListener(l);
//				label.addMouseListener(new homeListener());
			}
			
			
			//golfGUI.update();
		}
		else if(stockPile.getStockArrSize()==0)
		{
			//JOptionPane.showMessageDialog(frame, "Hey there is no more card in stock pile.");
			//System.out.println(stockPile.getStockArrSize());
			golfGUI.getPanel().remove(label);
			//System.out.println(stockPile.getStockArrSize());
			frame.doLayout();
			frame.repaint();
			//System.out.println(stockPile.getStockArrSize());
			//golfGUI.update();
			//System.out.println(stockPile.getStockArrSize());
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		
	}
}
