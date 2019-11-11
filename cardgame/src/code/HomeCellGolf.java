package code;
import java.util.ArrayList;

//set up homecell rules for Golf game
public class HomeCellGolf
{
	private ArrayList<Card> homePile;//initial home cell pile is empty
	private ArrayList<Card> stockArr;//stock pile
	private Card topCard;//current top card in home cell pile
	private int cardCounter;//should be from 0 to 52
	
	/**
	 * constructor 
	 * @param stockArr - array with 17 cards that are from stock pile, used to check if card adding to it is from stock
	 */ 
	public HomeCellGolf(ArrayList<Card> stockArr)
	{
		this.stockArr=stockArr;
		this.homePile =new ArrayList<Card>();
		this.cardCounter=0;
		this.topCard=null;
		//this.topCard=null;
	}
	
	//check if home cell pile initially holds 0 card
//	public boolean hold0Card()
//	{
//		if(homePile.size()==0)
//			return true;
//		else 
//			return false;
//	}
	
	
	/**
	 * 
	 * @param top - current top card in the home cell pile
	 * @param add - card to be added to home cell pile as new top card
	 * @return return true if (add) can be added to home cell pile as new top card, false otherwise
	 */
	public boolean if_addTop(Card top, Card add) 
	{
		boolean x = false;
		
		//if home cell pile is empty, just add to it
		if(homePile.size()==0) 
		{
			//homePile.add(add);
			//topCard = add;
			//cardCounter++;
			return true; 
		}
		
		//check if the (add) is from the stock pile, if yes, just add to it
		if(homePile.size()>0)
		{
			for(int i=0;i<stockArr.size();i++)
			{
				if(add.getRank()==stockArr.get(i).getRank() && add.getSuite().equals(stockArr.get(i).getSuite()))
				{
					//homePile.add(add);
					//topCard=add;
					//cardCounter++;
					return true;
				}
			}
		}
		
		//check if the the (top) and (add) are ("Ace" and "2") or ("2" and "Ace"),if yes, add to home cell pile
		if((top.getRank() == 14 && add.getRank() ==2) || (top.getRank() == 2 && add.getRank()==14))
		{
			System.out.println("in");
			//homePile.add(add);
			//topCard = add;
			//cardCounter++;
			return true;
		}
		
		// check if (top) and (add) are 1 rank away from each other, regardless of the suit.
		if(Math.abs(add.getRank()-top.getRank())==1) 
		{
			//homePile.add(add);
			//topCard = add;
			//cardCounter++;
			return true;
		}
		
		return x;
	}
	
	//should always return false since the rule is that player cannot remove card that is already added to home cell pile
	public boolean if_removeTop(Card card_to_remove)
	{
		boolean TorF=false;
		//I dot't care what happen here since it is going to return false anyways^^^^^^
		return TorF;
	}
	
	//get cardCounter
	public int getCardCounter()
	{
		return this.cardCounter;
	}
	
	//add legal top card, and increase card counter, and set new top card as(add)
	public void addTopCard_increaseCardCounter(Card add)
	{
		homePile.add(add);
		cardCounter++;
		topCard=homePile.get(homePile.size()-1);
	
	}
	
	//get topCard
	public Card getTopCard()
	{
		return this.topCard;
	}
	
	//get homePile
	public ArrayList<Card> getHomePile()
	{
		return this.homePile;
	}
	
	public int getSize()
	{
		return homePile.size();
	}
	
	
	
	
	
}
