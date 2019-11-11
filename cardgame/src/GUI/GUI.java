package GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

import code.FortyThieves;
import code.FortyThievesHomeCell;
import code.FortyThievesStockPile;
import code.FortyThievesTableau;
import code.FortyThievesWaste;
import code.Golf;
import code.HomeCellGolf;
import code.HomeCellSpider;
import code.LittleSpider;
import code.StockPileGolf;
import code.TableauPile;
import code.TableauPileGolf;



public class GUI 
{
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenuItem menuItem3;
	private JMenuItem menuItem4;
	private JFrame frame;
	//private GolfGUI golfGUI;
	
	public GUI(JFrame frame)
	{
		//this.golfGUI=golfGUI;
		this.frame=frame;
		this.menuBar=new JMenuBar();
		this.menu=new JMenu("New Game");
		this.menuItem1=new JMenuItem("Golf");
		this.menuItem2=new JMenuItem("Little Spider");
		this.menuItem3=new JMenuItem("Forty Thieves");
		this.menuItem4=new JMenuItem("Exit");
		
		
	}
	
	public JPanel getMenuPanel()
	{
		JPanel menuPanel=new JPanel();
		
		menu.add(menuItem1);//Golf
		menuItem1.addMouseListener(new MouseListener() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) 
			{
				frame.setVisible(false);
				frame.dispose();
				restartGolf();
			}
			
		});
		menu.add(menuItem2);//Little Spider
		menuItem2.addMouseListener(new MouseListener() 
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) 
			{
				frame.setVisible(false);
				frame.dispose();
				restartLittleSpider();
			}
			
		});
		menu.add(menuItem3);//Forty Thieves
		menuItem3.addMouseListener(new MouseListener() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) 
			{
				frame.setVisible(false);
				frame.dispose();
				restartFortyThieves();
			}
			
		});
		menu.add(menuItem4);//Exit
		menuItem4.addMouseListener(new MouseListener() 
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) 
			{
				System.exit(0);
			}
			
		});
		
		menuBar.add(menu);
		
		menuPanel.add(menuBar);
		return menuPanel;
	}
	
	
	public void restartLittleSpider()
	{
		frame=new JFrame("Little Spider");
		LittleSpider littleSpider=new LittleSpider();
		TableauPile tableauPileSpider=littleSpider.getTableauPile();
		HomeCellSpider homeCellSpider=littleSpider.getHomeCell1();
		
		SpiderGUI spiderGUI=new SpiderGUI(littleSpider,tableauPileSpider,homeCellSpider);
	}
	
	
	public void restartGolf()
	{
		JFrame newFrame=new JFrame("Golf Game");
		
		Golf golf=new Golf();
		TableauPileGolf tableauPile=golf.getTableauPile();
		HomeCellGolf homeCell=golf.getHomePile();
		StockPileGolf stockPile=golf.getStockPile();
		
		GolfGUI golfGUI=new GolfGUI(golf,tableauPile,homeCell,stockPile);
		//frame.setVisible(false);
		//frame.dispose();
	}
	
	public void restartFortyThieves()
	{
		JFrame newFrame=new JFrame("Forty Thieves");
		
		FortyThieves forty=new FortyThieves();
		
		FortyThievesTableau tableau=forty.getTableauPile();
		FortyThievesHomeCell home=forty.getHomePile();
		FortyThievesStockPile stock=forty.getStockPile();
		FortyThievesWaste waste=forty.getWastePile();
		
		FortyThievesGUI fortyThievesGUI=new FortyThievesGUI(forty,tableau,home,stock,waste);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
