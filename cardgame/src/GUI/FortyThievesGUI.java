package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import code.Card;
import code.FortyThieves;
import code.FortyThievesHomeCell;
import code.FortyThievesStockPile;
import code.FortyThievesTableau;
import code.FortyThievesWaste;

public class FortyThievesGUI 
{
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5,Color.GREEN);
    
    private FortyThieves fortyThieves;
    private FortyThievesTableau tableau;
    private FortyThievesHomeCell home;
    private FortyThievesStockPile stock;
    private FortyThievesWaste waste;
    
    public static JLabel recentModifiedLabel;
	public static Card recentModifiedCard;
	public static int recentModifiedindex;
    
	private JFrame frame;
	private GUI gui;
	private JPanel panel;
	private JLabel wastePileLabel;
	
	public static boolean tableauBoolean;
	public static boolean wasteBoolean;
	
	
	
	public FortyThievesGUI(FortyThieves fortyThieves,FortyThievesTableau tableau,FortyThievesHomeCell home,FortyThievesStockPile stock,FortyThievesWaste waste)
	{
		this.frame=new JFrame();
		this.gui=new GUI(this.frame);
		this.panel=new JPanel();
		
		this.fortyThieves=fortyThieves;
		this.tableau=tableau;
		this.home=home;
		this.stock=stock;
		this.waste=waste;
		
		this.tableauBoolean=false;
		this.wasteBoolean=false;
		update();
		
	}
	
	public static void select(JLabel label) 
	{
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
	
	 public void setTableauLabel(int index,int x)
	 { 
		
		int y=125;
		JLabel label;
		
		for(int i=tableau.getAllPiles().get(index).size()-1;i>=0;i--)
		{
			label=new JLabel();
			Card card=tableau.getAllPiles().get(index).get(i);
			y-=20;
			label=tableau.getAllPiles().get(index).get(i).getJLabel();
			label.setLocation(x, y);
			label.addMouseListener(new FortyTableauListener(tableauBoolean,this,label,card,tableau,index,frame,x,y,waste));
			panel.add(label);
		}
	 }
	 
	 public void setNewTableauLabel(int index,int x,int  y,Card card)
	 {
		 JLabel label=new JLabel();
		 label=card.getJLabel();//tableau.getAllPiles().get(index).get(tableau.getAllPiles().get(index).size()-1).getJLabel();
		 label.setLocation(x, y+100);
		 label.addMouseListener(new FortyTableauListener(tableauBoolean,this,label,card,tableau,index,frame,x,y,waste));
		 panel.add(label);
	 }
	
//	 public void redisplayTableau(int index,int x)
//	 {
//		 for(int i=tableau.getAllPiles().get(index).size()-1;i>=0;i--)
//		 {
//			 int size=tableau.getAllPiles().get(index).size();
//			 int y=(size-3)*20+225;
//			 tableau.getAllPiles().get(index).get(size-1).getJLabel().setLocation(x, y);
//		 }
//	 }
	 public void setEasterEgg()
	 {
		 JLabel label=setJLabel("/Cards/button.png"); 
		 label.setLocation(0, 890);
		 label.addMouseListener(new FortyEasterEggListener(this));
		 panel.add(label);
	 }
	
	 public void setHomeLabel(int index,int x)
	 {
		 int y=700;
		 JLabel label=new JLabel();
		 Card card=home.getHomePile().get(index).get(0);
		 label=home.getHomePile().get(index).get(0).getJLabel();
		 label.setLocation(x,y);
		 label.addMouseListener(new FortyHomeListener(this,index,frame,home,tableau,waste,label,panel));
		 panel.add(label);
	 }
	
	 public JLabel getStockLabel()
	{
		JLabel label=setJLabel("/Cards/gold.gif");
		label.setLocation(1350, 700);
		label.addMouseListener(new FortyStockListener(stock,frame,label,this,home,tableau,waste));
		return label;
	}
	
	public JLabel getWasteLabel()
	{
		JLabel label=setJLabel("/Cards/green.gif");
		wastePileLabel=label;
		//Card card=waste.getWasteArr().get(waste.getWasteArr().size()-1);
		label.setLocation(1500, 700);
		//label.addMouseListener(new FortyWasteListener(wasteBoolean,waste/*»¹Ã»Ð´Íê*/));
		return label;
	}
	 
	public boolean isFromStock(Card check)
	{
		boolean TorF=false;
		ArrayList<Card> stockArr=waste.getStockArr();
		for(int i=0;i<stockArr.size();i++)
		{
			if(check==stockArr.get(i))
			{
				TorF=true;
			}
		}
		return TorF;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public void update()
	 {
		tableau.setTopCard();
		
		
		panel.setLayout(null);
		setTableauLabel(0,50);
		setTableauLabel(1,175);
		setTableauLabel(2,300);
		setTableauLabel(3,425);
		setTableauLabel(4,550);
		setTableauLabel(5,675);
		setTableauLabel(6,800);
		setTableauLabel(7,925);
		setTableauLabel(8,1050);
		setTableauLabel(9,1175);
		setTableauLabel(10,1300);
		setTableauLabel(11,1425);
		setTableauLabel(12,1550);
		
		setHomeLabel(0,150);
		setHomeLabel(1,300);
		setHomeLabel(2,450);
		setHomeLabel(3,600);
		setHomeLabel(4,750);
		setHomeLabel(5,900);
		setHomeLabel(6,1050);
		setHomeLabel(7,1200);
		
		setEasterEgg();
		
		panel.add(getStockLabel());
		panel.add(getWasteLabel());
//			
//			
//			if(homeCell.getSize()==0)
//			{
//				panel.add(getHomeLabel());
//			}
		frame.add(gui.getMenuPanel(),BorderLayout.NORTH);
		frame.add(panel);
		
			
		frame.setSize(1700, 1000);
		frame.setLocation(150, 50);
		frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	 }
	
	 public void setTableauBoolean(boolean TorF)
	 {
		this.tableauBoolean=TorF;
	 }
	 
	 public void setWasteBoolean(boolean TorF)
	 {
		this.wasteBoolean=TorF;
	 }
	 
	 public JPanel getPanel()
	 {
		 return this.panel;
	 }
	 
	 public JLabel getCurrentWasteLabel()
	{
		return this.wastePileLabel;
	}
	public void setCurrentWasteLabel(JLabel label)
	{
		this.wastePileLabel=label;
	}
}
