package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FortyEasterEggListener implements MouseListener
{
	//private JFrame frame;
	private FortyThievesGUI fortyGUI;
	
	public FortyEasterEggListener(FortyThievesGUI fortyGUI)
	{
		//this.frame=frame;
		this.fortyGUI=fortyGUI;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		JFrame frame=new JFrame("Easter Egg!!!");
		JLabel label=fortyGUI.setJLabel("/Cards/hey.png"); 
		JPanel panel=new JPanel();
		panel.add(label);
		
		frame.add(panel);
		frame.pack();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
