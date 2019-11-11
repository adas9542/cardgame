package code;
import java.util.ArrayList;

//set up rule for tableau pile
public class TableauPileGolf
{
	private ArrayList<ArrayList<Card>> allPiles;//holds 7 ArrayList of Card,each has 5cards
	private ArrayList<Card> stockPile;          //store the rest 17 card
	private ArrayList<Card> cards;				//
	private ArrayList<Card> topCard;						//will be top card of specific tableau pile
	//private Card cardBeingMoved;
	private int cardCounter;   					//to count total number of cards in tableau piles
	private Card toReplace;
	
	/**
	 * constructor: to initialize
	 * @param cards - holds 52 cards in random order
 	 */
	public TableauPileGolf(ArrayList<Card> cards)
	{
		
		this.topCard=new ArrayList<Card>();
		this.cardCounter=35;//initially 35 cards
		this.cards=cards;
		this.stockPile=new ArrayList<Card>();
		this.allPiles=new ArrayList<ArrayList<Card>>();
		//setTopCard();
		//this.topCard=null;
		
	}
	
	/**
	 * 
	 * @param numpiles total number of piles in Golf Tableau
	 * @param numcards number of cards in each Golf Tableau Pile initially
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
	
	//check if each tableau pile holds exactly 5 cards initially
//	public boolean hold5Cards()
//	{
//		boolean TorF=true;
//		for(int i=0;i<allPiles.size();i++)
//		{
//			if(allPiles.get(i).size() != 5)
//			{
//				TorF =false;
//			}
//		}
//		return TorF;
//	}
	
	/**
	 * 
	 * @param index - index of the pile of the card being added
	 * @param add - Card being added
	 * @return should always return false
	 */
	public boolean if_AddingTableau(int index,Card add)
	{
		boolean TorF=false;
//		//check if a exist in allPiles,return False if yes.
//		for(int i=0;i<allPiles.size();i++)
//		{
//			for(int j=0;i<allPiles.get(i).size();j++)
//			{
//				if(a.get(aIndex).getRank()==allPiles.get(i).get(j).getRank())
//				{
//					if(a.get(aIndex).getSuite().equals(allPiles.get(i).get(j).getSuite()))
//						{
//						return TorF;
//						}
//				}
//			}
//		}
//		
//		////check if b exist in allPiles,return False if yes.
//		for(int i=0;i<allPiles.size();i++)
//		{
//			for(int j=0;i<allPiles.get(i).size();j++)
//			{
//				if(b.get(bIndex).getRank()==allPiles.get(i).get(j).getRank())
//				{
//					if(b.get(bIndex).getSuite().equals(allPiles.get(i).get(j).getSuite()))
//						{
//						return TorF;
//						}
//				}
//			}
//		}
//		
//		//check if a or b exist in stockPile,return False if yes.
//		for(int i=0;i<stockPile.size();i++)
//		{
//			
//				if(a.get(aIndex).getRank()==stockPile.get(i).getRank() || b.get(bIndex).getRank()==stockPile.get(i).getRank())
//				{
//					if(a.get(aIndex).getSuite().equals(stockPile.get(i).getSuite()) || b.get(bIndex).getSuite().equals(stockPile.get(i).getSuite()))
//						{
//						return TorF;
//						}
//				}
//		}
		return TorF;
		
	}
	
	/**
	 * 
	 * @param index - the index of the pile where topx belongs to (topx is the single card object 
	 * 				  in 7 of the single tableau pile)
	 * @param topx - assume the card pass into this method is top card
	 * @return true if able to remove
	 */
    public boolean if_removeTop(int index, Card topx) 
    {
    	if(allPiles.get(index).size()>0)
    	{
	    	if(index <= 6 && index >= 0) 
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
     *  to remove card and decrease card counter
     * @param index - same para as the index para in removeCard method
     */
	public void removeCard_decreaseCardCounter(int index)
	{
		//System.out.println(allPiles.get(index).size());
		//System.out.println(allPiles.get(index).get(allPiles.get(index).size()-1.));
		allPiles.get(index).remove(allPiles.get(index).size()-1);//if so remove it and decrease the overall cardCounter
		//System.out.println(index+" removed "+allPiles.get(index).get(allPiles.get(index).size()-1).getRank());
		cardCounter--;
		if(allPiles.get(index).size()==0)
			topCard.set(index, null);
		//System.out.println(topCard.size());
		if(allPiles.get(index).size()>0)
			toReplace=allPiles.get(index).get(allPiles.get(index).size()-1);
			topCard.set(index, toReplace);//reassigning top card to the next card in pile
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
	
	//get allPiles
	public ArrayList<ArrayList<Card>> getAllPiles()
	{
		return this.allPiles;
	}
	
	//get top card
	public ArrayList<Card> getTopCard()
	{
		return this.topCard;
	}
	
	public void setTopCard()
	{
		for(int i=0;i<allPiles.size();i++)
		{
			topCard.add(allPiles.get(i).get(allPiles.get(i).size()-1));
		}
	}
	
	//get cardCounter
	public int getCardCounter()
	{
		return this.cardCounter;
	}
	
	
	
	
}
