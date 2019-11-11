package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import code.Golf;

public class Main 
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
				{
				@Override
				public void run() 
				{
					runGUI();
				}
				});	
	}
	
	public static void runGUI()
	{
		JFrame frame=new JFrame("Solitaire Games");
		
//		Golf golf=new Golf();
//		GolfGUI golfGUI=new GolfGUI(golf);
		GUI gui=new GUI(frame);
		
		
		
		//frame.getContentPane().add(gui.getMenuPanel(),BorderLayout.NORTH);
		frame.add(gui.getMenuPanel());
		
		frame.setSize(960, 600);
		frame.setLocation(480, 243);
		//frame.pack();
		//frame.setSize(2000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
		
	}	
	
	
	
}