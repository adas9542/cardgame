package code;

import java.util.ArrayList;

public class FortyThievesHomeCell 
{
	private ArrayList<Card> Aces;						//to store 8 Aces
	private ArrayList<ArrayList<Card>> homePile;		//all home piles
	private ArrayList<Card> topCard;					//store 8 top cards
	private Card toReplace;								//medium 
	private int cardCounter;							//holds numeber of cards in all home piles;
	
	/**
	 * constructor
	 * @param aces - 8 aces
	 */
	public FortyThievesHomeCell(ArrayList<Card> aces)
	{
		this.topCard=new ArrayList<Card>();
		this.homePile=new ArrayList<ArrayList<Card>>();
		this.Aces=aces;
		this.cardCounter=8;
		setAces();
		
	}
	
	
	
	
	
	/**
	 * 
	 * @param card_to_remove - card trying to be removed
	 * @return - always return false since we cannot remove from home cell pile
	 */
	public boolean if_removeTop(Card card_to_remove)
	{
		boolean TorF=false;
		//I dot't care what happen here since it is going to return false anyways^^^^^^
		return TorF;
	}
	
	/**
	 * 
	 * @param top
	 * @param add
	 * @return
	 */
	public boolean if_addTop(Card top, Card add)
	{
		boolean TorF=false;
		if(top.getSuite().equals(add.getSuite()))//check rank and suit
		{
			if((add.getRank()-top.getRank()==1)||(add.getRank()-top.getRank()==-12))//-12 is for adding two on top of ace
			{
				TorF=true;
			}
		}
		return TorF;
	}
	
	/**
	 * 
	 * @param index - index of home pile
	 * @param add	- card trying to be added
	 */
	public void addTopCard_increaseCardCounter(int index,Card add)
	{
		homePile.get(index).add(add);//add card to that pile
		toReplace=homePile.get(index).get(homePile.get(index).size()-1);
		topCard.set(index, toReplace);//reassigning top card to the next card in pile
		cardCounter+=1;
	}
	
	//initial set up for home piles
	public void setAces()
	{
		for(int i=0;i<Aces.size();i++)
		{	
			ArrayList<Card> pile = new ArrayList<Card>(); 
			pile.add(Aces.get(i));
			homePile.add(pile);
		}
	}
	
	//setter to set top cards
	public void setTopCard()
	{
		for(int i=0;i<homePile.size();i++)//distributing the aces into the 8 homecell piles
		{
			topCard.add(homePile.get(i).get(homePile.get(i).size()-1));
		}
	}
	
	public ArrayList<Card> getTopCard()
	{
		return this.topCard;
	}
	
	//getter for home pile
	public ArrayList<ArrayList<Card>> getHomePile()
	{
		return this.homePile;
	}
	
	public int getCardCounter()
	{
		return this.cardCounter;
	}
	
	
}
