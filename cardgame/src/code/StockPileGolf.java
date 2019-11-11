package code;
import java.util.ArrayList;

// set up rules for Golf stock pile
public class StockPileGolf
{	
	private Card topCard; // will be the top card of the stock pile
	private ArrayList<Card> stockArr; // stock pile
	private int cardCounter;// count on the number of cards in stock pile
	
	/**
	 * constructor
	 * @param stockArr - from Golf class, already has the 17 cards.
	 */
	public StockPileGolf(ArrayList<Card> stockArr)
	{
		//this.topCard=null;
		this.stockArr=stockArr;
		//System.out.println(stockArr.size());
		this.cardCounter=17;
		setTopCard();
	}
	
	// check if stock initially holds 17 cards
	public boolean hold17Cards()
	{
		if(stockArr.size()==17)
			return true;
		else
			return false;
	}
	
	//should always return false since we cannot add any card to the stock pile after game started
	public boolean if_addCard(Card add)
	{
		boolean TorF=false;
		//cannot add card to stock pile at anytime
		return TorF;
	}
	
	//check if leagal to remove top card in stock pile
	public boolean if_removeTopCard()
	{
		boolean TorF=false;
		if(stockArr.size()>0)
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
			topCard=stockArr.get(stockArr.size()-2);
			stockArr.remove(stockArr.size()-1);
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
	
	public void setTopCard()
	{
		//System.out.println(stockArr.size());
		topCard=stockArr.get(stockArr.size()-1);
	}
	
	public Card getTopCard()
	{
		return this.topCard;
	}
	
	public int getStockArrSize()
	{
		return this.stockArr.size();
	}
	
	
}
