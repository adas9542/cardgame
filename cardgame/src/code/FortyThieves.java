package code;

import java.util.ArrayList;

public class FortyThieves 
{
	private ArrayList<Card> cards;					//to hold 96 cards after removed Aces
	private ArrayList<ArrayList<Card>> homePiles;	//to hold 8 home piles
	private ArrayList<ArrayList<Card>> allPiles;	//to hold all tableaus cards
	private ArrayList<Card> Aces;					//to hold 8 Aces;
	private ArrayList<Card> stockArr;				//store stock cards
	
	private FortyThievesTableau fortyTableau;		//tableau object
	private FortyThievesHomeCell fortyHomeCell;		//home cell pile object
	private FortyThievesStockPile fortyStock;		//stock pile object
	private FortyThievesWaste fortyWaste;			//waste pile object
	
	/**
	 * constructor
	 */
	public FortyThieves()
	{
		Deck deck=new Deck("a");		//"a" is meaningless, just for going to that forty thieves constructor in Deck class
		this.cards=deck.cards;			//96 cards after shuffle(after removed 8 Aces)
		this.Aces=deck.getAces();		//store 8 Aces
		
		fortyTableau=new FortyThievesTableau(cards);//pass 96 cards into Tableau class
		fortyTableau.create_tableau(13, 3);         //create 13 tableau piles with each has 3 cards
		allPiles=fortyTableau.getAllPiles();		//store all tableaus cards
		fortyTableau.setTopCard();					//store top card information
		fortyTableau.setStockPile();				//set rest of the cards into stock pile
		
		stockArr=fortyTableau.getStockPile();		//store rest of the 57 cards
		
		fortyHomeCell=new FortyThievesHomeCell(Aces);//pass 8 Aces into Homecell class
		fortyHomeCell.setTopCard();					 //set Home cell piles top cards(8 Aces)
		
		fortyStock=new FortyThievesStockPile(stockArr);
		
		fortyWaste=new FortyThievesWaste(stockArr);
	}
	
	//card getter
	public ArrayList<Card> getCards()
	{
		return this.cards;
	}
	
	//8 Aces getter
	public ArrayList<Card> getAces()
	{
		return this.Aces;
	}
	
	//tableau pile object getter
	public FortyThievesTableau getTableauPile()
	{
		return this.fortyTableau;
	}
	
	//stock pile object getter
	public FortyThievesStockPile getStockPile()
	{
		return this.fortyStock;
	}

	//home pile object getter
	public FortyThievesHomeCell getHomePile()
	{
		return this.fortyHomeCell;
	}
	
	//waste pile object getter
	public FortyThievesWaste getWastePile()
	{
		return this.fortyWaste;
	}
	
	
	
}
