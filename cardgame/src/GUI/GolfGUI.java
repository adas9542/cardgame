package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.Border;

import code.Card;
import code.Golf;
import code.HomeCellGolf;
import code.StockPileGolf;
import code.TableauPileGolf;

public class GolfGUI 
{
	private JPanel panel;
	private Golf golf;
//	private ArrayList<Card> stockArr;
//	private ArrayList<ArrayList<Card>> allPiles;
//	private ArrayList<Card> homePile;
	public static boolean tableauBoolean;
	private Card topCard;
	private JFrame frame;
	private TableauPileGolf tableauPile;
	private HomeCellGolf homeCell;
	private StockPileGolf stockPile;
	public static JLabel recentModifiedLabel;
	public static Card recentModifiedCard;
	public static int recentModifiedindex;
	private JLabel homePileLabel;
	//private stockListener a;
	private GUI gui;
	
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5,Color.GREEN);
	
	public GolfGUI(Golf golf,TableauPileGolf tableauPile,HomeCellGolf homeCell,StockPileGolf stockPile)
	{
		//this.frame=frame;
		//frame.setVisible(false);
		//frame.dispose();
		this.frame=new JFrame();
		this.gui=new GUI(this.frame);
		this.tableauPile=tableauPile;
		this.homeCell=homeCell;
		this.stockPile=stockPile;
		this.golf=golf;
		this.tableauBoolean=false;
//		this.allPiles=golf.getTableauPile().getAllPiles();
//		this.stockArr=golf.getStockPile().getStockPile();
//		this.homePile=golf.getHomePile().getHomePile();
		this.topCard=null;
		this.panel=new JPanel();
		update();
		
	}
	
	public void setTableauLabel(int index,int x)
	{
		
		int y=125;
		JLabel label;
		for(int i=tableauPile.getAllPiles().get(index).size()-1;i>=0;i--)
		{
			label=new JLabel();
			Card card=tableauPile.getAllPiles().get(index).get(i);
			y-=20;
			label=tableauPile.getAllPiles().get(index).get(i).getJLabel();
			label.setLocation(x, y);
			label.addMouseListener(new AnswerListener(tableauBoolean,this,label,card,tableauPile,index,frame));
			panel.add(label);
		}
	}
//	public void setTableauLabel1()
//	{
//		int index=0;
//		int y=125;
//		JLabel label=new JLabel();
//		for(int i=tableauPile.getAllPiles().get(index).size()-1;i>=0;i--)
//		{
//			Card card=tableauPile.getAllPiles().get(index).get(i);
//			y-=20;
//			label=tableauPile.getAllPiles().get(index).get(i).getJLabel();
//			label.setLocation(50, y);
//			label.addMouseListener(new AnswerListener(tableauBoolean,this,label,card,tableauPile,index));
//			panel.add(label);
//		}
//	}
//	
//	public void setTableauLabel2()
//	{
//		int index=1;
//		int y=125;
//		JLabel label=new JLabel();
//		for(int i=tableauPile.getAllPiles().get(1).size()-1;i>=0;i--)
//		{
//			y-=20;
//			label=tableauPile.getAllPiles().get(1).get(i).getJLabel();
//			label.setLocation(175, y);
//			label.addMouseListener(new AnswerListener(tableauBoolean,this,label));
//			panel.add(label);
//		}
//	}
//	
//	public void setTableauLabel3()
//	{
//		int index=2;
//		int y=125;
//		JLabel label=new JLabel();
//		for(int i=tableauPile.getAllPiles().get(2).size()-1;i>=0;i--)
//		{
//			y-=20;
//			label=tableauPile.getAllPiles().get(2).get(i).getJLabel();
//			label.setLocation(300, y);
//			label.addMouseListener(new AnswerListener(tableauBoolean,this,label));
//			panel.add(label);
//		}
//	}
//	
//	public void setTableauLabel4()
//	{
//		int index=3;
//		int y=125;
//		JLabel label=new JLabel();
//		for(int i=tableauPile.getAllPiles().get(3).size()-1;i>=0;i--)
//		{
//			y-=20;
//			label=tableauPile.getAllPiles().get(3).get(i).getJLabel();
//			label.setLocation(425, y);
//			label.addMouseListener(new AnswerListener(tableauBoolean,this,label));
//			panel.add(label);
//		}
//	}
//	
//	public void setTableauLabel5()
//	{
//		int index=4;
//		int y=125;
//		JLabel label=new JLabel();
//		for(int i=tableauPile.getAllPiles().get(4).size()-1;i>=0;i--)
//		{
//			y-=20;
//			label=tableauPile.getAllPiles().get(4).get(i).getJLabel();
//			label.setLocation(550, y);
//			label.addMouseListener(new AnswerListener(tableauBoolean,this,label));
//			panel.add(label);
//		}
//	}
//	
//	public void setTableauLabel6()
//	{
//		int index=5;
//		int y=125;
//		JLabel label=new JLabel();
//		for(int i=tableauPile.getAllPiles().get(5).size()-1;i>=0;i--)
//		{
//			y-=20;
//			label=tableauPile.getAllPiles().get(5).get(i).getJLabel();
//			label.setLocation(675, y);
//			label.addMouseListener(new AnswerListener(tableauBoolean,this,label));
//			panel.add(label);
//		}
//	}
//	
//	public void setTableauLabel7()
//	{
//		int index=6;
//		int y=125;
//		JLabel label=new JLabel();
//		for(int i=tableauPile.getAllPiles().get(6).size()-1;i>=0;i--)
//		{
//			y-=20;
//			label=tableauPile.getAllPiles().get(6).get(i).getJLabel();
//			label.setLocation(800, y);
//			label.addMouseListener(new AnswerListener(tableauBoolean,this,label));
//			panel.add(label);
//		}
//	}
//	
	public JLabel getStockLabel()
	{
		JLabel label=setJLabel("/Cards/gold.gif");
		label.setLocation(400, 400);
		label.addMouseListener(new stockListener(stockPile,frame,label,this,homeCell,tableauPile));
		return label;
	}
	
	public JLabel getHomeLabel()
	{
		JLabel label=setJLabel("/Cards/green.gif");
		homePileLabel=label;
		label.setLocation(700, 400);
		label.addMouseListener(new homeListener(panel,this,frame,homeCell,tableauPile,label));
		return label;
	}
	
	public JLabel getCurrentHomeLabel()
	{
		return this.homePileLabel;
	}
	public void setCurrentHomeLabel(JLabel label)
	{
		this.homePileLabel=label;
	}
	
	public void setTableauBoolean(boolean TorF)
	{
		this.tableauBoolean=TorF;
	}
	
	public Card saveCard(int index)
	{
		return this.topCard;
	}
	
	public static void select(JLabel label) 
	{
		//System.out.println('0');
	      label.setBorder(SELECTED_BORDER);
	      label.repaint();
	}

	 public static void unselect(JLabel label) 
	 {
	      label.setBorder(UNSELECTED_BORDER);
	      label.repaint();
	 }
	 
	 public JLabel setJLabel(String fileName)
		{
		 	JLabel label=new JLabel();
			java.net.URL imgURL = this.getClass().getResource(fileName);
		    if (imgURL == null) 
		    {
		      throw new IllegalArgumentException("Couldn't find file: "+fileName );
		    }
		    ImageIcon cardImage = new ImageIcon(imgURL);    
		    label.setIcon(cardImage);
		    Dimension d = new Dimension(cardImage.getIconWidth() + 10, cardImage.getIconHeight() + 10);
		    label.setSize(d);
		    label.setPreferredSize(d);
		    label.setMaximumSize(d);
		    label.setMinimumSize(d);
		    return label;
		}
	 
	 public JPanel getPanel()
	 {
		 return this.panel;
	 }
	
	public void update()
	{
		tableauPile.setTopCard();
		
		//System.out.println(tableauPile.getAllPiles().get(0).size());
		//System.out.println(tableauPile.getAllPiles().get(0).get(tableauPile.getAllPiles().get(0).size()-1).getRank());
		
		
		//frame.setVisible(false);
		//frame.dispose();

		panel.setLayout(null);
		setTableauLabel(0,50);
		setTableauLabel(1,175);
		setTableauLabel(2,300);
		setTableauLabel(3,425);
		setTableauLabel(4,550);
		setTableauLabel(5,675);
		setTableauLabel(6,800);
//		if(stockPile.getStockArrSize()>0)
//		{
			panel.add(getStockLabel());
		
		
		if(homeCell.getSize()==0)
		{
			panel.add(getHomeLabel());
		}
		frame.add(gui.getMenuPanel(),BorderLayout.NORTH);
		frame.add(panel);
		

		
		//frame.pack();
		frame.setSize(960, 600);
		frame.setLocation(480, 243);
		//frame.setSize(2000, 1000);
		frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
}
