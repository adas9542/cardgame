package code;

import java.util.ArrayList;

public class FortyThievesTableau 
{
	private ArrayList<ArrayList<Card>> allPiles;//holds 13 ArrayList of Card,each has 3cards
	private ArrayList<Card> stockPile;          //to store rest of the 57 cards
	private ArrayList<Card> cards;				//to hold 96 cards
	private ArrayList<Card> topCard;			//will be top card of specific tableau pile
	
	private int cardCounter;   					//to count total number of cards in tableau piles
	private Card toReplace;						//medium for top card
	
	/**
	 * constructor: to initialize
	 * @param cards - holds 96 cards in random order
 	 */
	public FortyThievesTableau(ArrayList<Card> cards)
	{
		this.topCard=new ArrayList<Card>();					//initialize topCard
		this.cardCounter=57;								//initially 57 cards
		this.cards=cards;									//store parameter cards into cards
		this.stockPile=new ArrayList<Card>();				//initialize stockPile
		this.allPiles=new ArrayList<ArrayList<Card>>();		//initialize allPiles
	}
	
	/**
	 * to create 13 tableau piles with each pile has 3 cards initially
	 * 
	 * @param numpiles - 13 piles
	 * @param numcards - 3 cards (each tableau pile)
	 */
	public void create_tableau(int numpiles, int numcards)
	{	
		while(numpiles != 0 && numpiles >0) 
		{
			ArrayList<Card> pile = new ArrayList<Card>(); 
			
			for(int i = 0; i < numcards; i++) 
			{
				pile.add(cards.get(0));
				cards.remove(0);   // remove 1st from 52 card,remove 2nd from 51 card, remove 3rd from 50 cards,and so on
			}						
			allPiles.add(pile);		
			numpiles--;
		}
	}
	
	/**
	 * 
	 * @param index - index of the top card that is trying to be removed in 13 tableau piles(index from 0 to 12)
	 * @param topx - the top card of that index position in *allPiles(arrayList<ArrayList<Card>>)
	 * @return - return if the assuming top card is the top card, if yes, return true, false otherwise
	 */
	public boolean if_removeTop(int index, Card topx) 
    {
    	if(allPiles.get(index).size()>0)
    	{
	    	if(index <= 12 && index >= 0)// make sure index is not out of bounds 
	    	{
		    	if((allPiles.get(index).get(allPiles.get(index).size()-1)) == topx) //check to see if top is really the top card of the homecellpile
		    	{
		    		//allPiles.get(index).remove(allPiles.get(index).size()-1);//if so remove it and decrease the overall cardCounter
		    		//cardCounter--;
		    		//topCard = allPiles.get(index).get(allPiles.get(index).size()-1) ;//reassigning top card to the next card in pile
		        	return true;
		    	}
	    	}
    	}
    	return false;
    }
	
	/**
	 * 
	 * @param index - the index in allPile where the top card being moved belongs to
	 */
	public void removeCard_decreaseCardCounter(int index)//index of pile
	{
		
		allPiles.get(index).remove(allPiles.get(index).size()-1);//if so remove it and decrease the overall cardCounter
		
		cardCounter=cardCounter-1;
		
		if(allPiles.get(index).size()==0)
			topCard.set(index, null);
		
		if(allPiles.get(index).size()>0)
			toReplace=allPiles.get(index).get(allPiles.get(index).size()-1);
			topCard.set(index, toReplace);//reassigning top card to the next card in pile because next card is now the new top card
	}
	
	/**
	 * 
	 * @param index - index of the tableau pile that is trying to add the card
	 * @param add - card being added to allPiles in index of (index)
	 * @return - true if possible to add, false otherwise
	 */
	public boolean if_AddingTableau(int index,Card add)
	{
		boolean TorF=false;
		if(allPiles.get(index).size()==0)//If the tablueau pile is empty u can add any card legally
		{
			TorF=true;
		}
		
		else if(allPiles.get(index).size()>0)
		{
			if((allPiles.get(index).get(allPiles.get(index).size()-1)).getSuite().equals(add.getSuite()))
			{
				if(allPiles.get(index).get(allPiles.get(index).size()-1).getRank()-add.getRank()==1)
				{
					TorF=true;
				}
			}


		}
		return TorF;
	}
	
	/**
	 * 
	 * @param index - index of the tableau pile that is trying to add the card
	 * @param add - card being added to allPiles in index of (index)
	 */
	public void addCard(int index, Card add)// card aparm new top card 
	{
		allPiles.get(index).add(add);//add card to pile
		toReplace=allPiles.get(index).get(allPiles.get(index).size()-1);
		topCard.set(index, toReplace);//reassigning top card to the next card in pile
		cardCounter+=1;
	}
	
	
	
	
	
	
	
	//set stockPile
	public void setStockPile()
	{
		for(int i=0;i<cards.size();i++)
		{
			stockPile.add(cards.get(i));
		}
	}
		
	//get stockPile
	public ArrayList<Card> getStockPile()
	{
		return this.stockPile;
	}
	
	//get top card
	public ArrayList<Card> getTopCard()
	{
		return this.topCard;
	}
	
	//set top card
	public void setTopCard()
	{
		for(int i=0;i<allPiles.size();i++)
		{
			topCard.add(allPiles.get(i).get(allPiles.get(i).size()-1));
		}
	}
	
	//get allPiles
	public ArrayList<ArrayList<Card>> getAllPiles()
	{
		return this.allPiles;
	}
	
	//for return 96-39=57 cards purpose
	public ArrayList<Card> getCards()
	{
		return this.cards;
	}
		
	public int getCardCounter()
	{
		return this.cardCounter;
	}
		
		
		
}
