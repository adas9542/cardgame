package code;

import java.util.ArrayList;

public class FortyThievesStockPile 
{
	private Card topCard; // will be the top card of the stock pile
	private ArrayList<Card> stockArr; // stock pile
	private int cardCounter;// count on the number of cards in stock pile
	
	/**
	 * constructor
	 * @param stockArr - 57 cards that are in stock pile
	 */
	public FortyThievesStockPile(ArrayList<Card> stockArr)//param is the remainder of the deck after tablueau and homecell piles are set up
	{
		this.stockArr=stockArr;
		this.cardCounter=57;
		setTopCard();
	}
	
	//should always return false since we cannot add any card to the stock pile after game started
	public boolean if_addCard(Card add)
	{
		boolean TorF=false;
		//cannot add card to stock pile at anytime
		return TorF;
	}
	
	//check if able to remove from stock pile
	public boolean if_removeTopCard()
	{
		boolean TorF=false;
		if(stockArr.size()>0)//as long as size is greater than 0, u can remove a card from it
		{
			TorF=true;
		}
		
		return TorF;
	}
	
	//remove stock top card, and decrease card counter, and set new top card
	public void removeCard_decreaseCounter()
	{
		if(stockArr.size()==1)
		{
			topCard=null;
			stockArr.remove(stockArr.size()-1);
			cardCounter--;
		}
		else 
		{
			topCard=stockArr.get(stockArr.size()-2);//setting second top card in pile as new top card
			stockArr.remove(stockArr.size()-1);//removing original top card
			cardCounter--;
		}
	}
	
	//get stockArr
	public ArrayList<Card> getStockPile()
	{
		return this.stockArr;
	}
	
	//get cardCounter
	public int getCardCounter()
	{
		return this.cardCounter;
	}
	
	//setter for top cards
	public void setTopCard()
	{
		//System.out.println(stockArr.size());
		topCard=stockArr.get(stockArr.size()-1);
	}
	
	//getter for top cards
	public Card getTopCard()
	{
		return this.topCard;
	}
	
	//getter for stock pile size
	public int getStockArrSize()
	{
		return this.stockArr.size();
	}
	
}
