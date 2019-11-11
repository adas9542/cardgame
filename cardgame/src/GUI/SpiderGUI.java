package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.Card;
import code.HomeCellSpider;
import code.LittleSpider;
import code.TableauPile;

public class SpiderGUI 
{
	private LittleSpider littleSpider;
	private TableauPile tableauPileSpider;
	private HomeCellSpider homeCellSpider;
	
	private JFrame frame;
	private JPanel panel;
	
	private GUI gui;
	
	public SpiderGUI(LittleSpider littleSpider,TableauPile tableauPileSpider,HomeCellSpider homeCellSpider)
	{
		this.littleSpider=littleSpider;
		this.tableauPileSpider=tableauPileSpider;
		this.homeCellSpider=homeCellSpider;
		
		this.frame=new JFrame();
		this.panel=new JPanel();
		this.gui=new GUI(this.frame);
		
		update();
	}
	
	public void setTableauLabel(int index,int x)
	{
		
		int y=125;
		JLabel label;
		for(int i=tableauPileSpider.getAllPiles().get(index).size()-1;i>=0;i--)
		{
			label=new JLabel();
			Card card=tableauPileSpider.getAllPiles().get(index).get(i);
			y-=20;
			label=tableauPileSpider.getAllPiles().get(index).get(i).getJLabel();
			label.setLocation(x, y);
			//label.addMouseListener(new AnswerListener(tableauBoolean,this,label,card,tableauPile,index,frame));
			panel.add(label);
		}
	}
	
//	public JLabel setJLabel(String fileName)
//	{
//	 	JLabel label=new JLabel();
//		java.net.URL imgURL = this.getClass().getResource(fileName);
//	    if (imgURL == null) 
//	    {
//	      throw new IllegalArgumentException("Couldn't find file: "+fileName );
//	    }
//	    ImageIcon cardImage = new ImageIcon(imgURL);    
//	    label.setIcon(cardImage);
//	    Dimension d = new Dimension(cardImage.getIconWidth() + 10, cardImage.getIconHeight() + 10);
//	    label.setSize(d);
//	    label.setPreferredSize(d);
//	    label.setMaximumSize(d);
//	    label.setMinimumSize(d);
//	    return label;
//	}
//	
//	public JLabel getHomeLabel()
//	{
//		JLabel label=setJLabel("/Cards/green.gif");
//		homePileLabel=label;
//		label.setLocation(700, 400);
//		label.addMouseListener(new homeListener(panel,this,frame,homeCell,tableauPile,label));
//		return label;
//	}
	public void setHomeLabel(int index,int x)
	{
		
		int y=525;
		JLabel label;
		for(int i=tableauPileSpider.getAllPiles().get(index).size()-1;i>=0;i--)
		{
			label=new JLabel();
			Card card=tableauPileSpider.getAllPiles().get(index).get(i);
			y-=20;
			label=tableauPileSpider.getAllPiles().get(index).get(i).getJLabel();
			label.setLocation(x, y);
			//label.addMouseListener(new AnswerListener(tableauBoolean,this,label,card,tableauPile,index,frame));
			panel.add(label);
		}
	}
	
	public void update()
	{
		tableauPileSpider.setTopCard();
		homeCellSpider.setTopCard();
		
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
		setTableauLabel(6,800);
		
		setHomeLabel(1,1);
		
		
		
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
