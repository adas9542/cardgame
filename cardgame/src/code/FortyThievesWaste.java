package code;

import java.util.ArrayList;

public class FortyThievesWaste 
{
	private ArrayList<Card> wasteArr;//initial waste pile is empty
	private Card topCard;			 //holds waste pile top card
	private ArrayList<Card> stockArr;//holds cards from stock pile
	private int CardCounter;
	
	/**
	 * constructor
	 * @param stockArr - cards from stock pile
	 */
	public FortyThievesWaste(ArrayList<Card> stockArr)
	{
		this.CardCounter=0;
		this.stockArr=stockArr;
		this.wasteArr=new ArrayList<Card>();//just iniatlizing new pile
		this.topCard=null;
		
	}
	
	/**
	 * 
	 * @return - true if able to remove top card, false otherwise
	 */
	public boolean if_removeTopCard()
	{
		boolean TorF=false;
		if(wasteArr.size()>0)
		{
			TorF=true;
		}
		
		return TorF;
	}
	
	/**
	 * 
	 * @return -always true
	 */
	public boolean if_removeTopCardd()//just just this not top one 
	{
		return true;
	}
	
	//remove waste top card and set new top card
	public void removeTopCard()
	{
		if(wasteArr.size()==1)
		{
			topCard=null;
			wasteArr.remove(wasteArr.size()-1);
		}
		else 
		{
			topCard=wasteArr.get(wasteArr.size()-2);
			wasteArr.remove(wasteArr.size()-1);
		}
		CardCounter-=1;
	}
	
	//check if able to add 
	public boolean if_addTop(Card add)
	{
		for(int i=0;i<stockArr.size();i++)
		{
			if(add.getRank()==stockArr.get(i).getRank() && add.getSuite().equals(stockArr.get(i).getSuite()))
			{
				return true;
			}
		}
		return false;
	}
	
	//always false
	public boolean if_addTopp()
	{
		return false;
	}
	
	//adds the card as new top card
	public void addTopCard(Card add)
	{
		wasteArr.add(add);
		topCard=wasteArr.get(wasteArr.size()-1);
		CardCounter+=1;
	
	}
	
	public int getCardCounter()
	{
		return this.CardCounter;
	}
	
	//getter for top card
	public Card getTopCard()
	{
		return this.topCard;
	}
	
	//getter for stock pile
	public ArrayList<Card> getStockArr()
	{
		return this.stockArr;
	}
	
	//getter for waste pile
	public ArrayList<Card> getWasteArr()
	{
		return this.wasteArr;
	}
	
	//check if it is the top card
	public boolean isTopCard(Card card)
	{
		if(wasteArr.get(wasteArr.size()-1)==card)
		{
			return true;
		}
		else
			return false;
	}
	
}
