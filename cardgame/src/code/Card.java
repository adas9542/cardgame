package code;

import java.awt.Dimension;

import javax.swing.*;

//create an card class since each of our 52 cards is a Card object
public class Card {
	
	protected String Suites; //card suites
	protected int Rank; //card numbers, J =11, Q= 12, K = 13, A = 14
	private JLabel label;
	
	public Card(int number, String suite, String fileName) {
		Rank = number;////card numbers are only from 2-10, 11-14 is from jack,queen,king,ace
		Suites = suite;
		label=new JLabel();
		setJLabel(fileName);
	}
	
	public Card(int number,String suite)
	{
		Rank = number;////card numbers are only from 2-10, 11-14 is from jack,queen,king,ace
		Suites = suite;
	}
	
    //Getters returns suites
	public String getSuite() {
		return Suites;
	}

	public int getRank() { //returns rank number
		return Rank;
	}

	public JLabel getJLabel()
	{
		return label;
	}
	
	public void setJLabel(String fileName)
	{
		java.net.URL imgURL = this.getClass().getResource(fileName);
	    if (imgURL == null) {
	      throw new IllegalArgumentException("Couldn't find file: "+fileName );
	    }
	    ImageIcon cardImage = new ImageIcon(imgURL);    
	    label.setIcon(cardImage);
	    Dimension d = new Dimension(cardImage.getIconWidth() + 10, cardImage.getIconHeight() + 10);
	    label.setSize(d);
	    label.setPreferredSize(d);
	    label.setMaximumSize(d);
	    label.setMinimumSize(d);
	}
}









