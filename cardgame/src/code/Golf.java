package code;
import java.util.ArrayList;

//main class for Golf to connect everything to get them working
public class Golf 
{
	private ArrayList<Card> cards;//to hold 52 cards in random order ------------Card class(rank,suit)
	private ArrayList<Card> stockArr;//to hold 17 cards
	private ArrayList<ArrayList<Card>> allPiles;//holding 7 Piles, and each pile has 5 cards
	private ArrayList<Card> homePile;//homecell pile 
	private TableauPileGolf tableauPile;
	private StockPileGolf stockPile;
	private HomeCellGolf homeCell;
	
	//constructor, actually sets up for the game, but have not yet connect everything in game rule.
	public Golf()
	{
		Deck deck=new Deck();
		this.cards=deck.cards;//52 cards after shuffle
		
		
		tableauPile=new TableauPileGolf(cards);
		tableauPile.create_tableau(7, 5);//create Golf tableau with 7 piles and each pile has 5 cards initially
		this.allPiles=tableauPile.getAllPiles();//return all piles
		tableauPile.setTopCard();
		
		tableauPile.setStockPile();//set rest of the 17 cards into stock pile
		this.stockArr=tableauPile.getStockPile();//store rest of the 17 cards
		
		//System.out.println("Golf "+stockArr.size());
		stockPile=new StockPileGolf(stockArr);
		
		homeCell=new HomeCellGolf(stockArr);
		
		this.homePile=new ArrayList<Card>();
		homePile=homeCell.getHomePile();
		
	}
	public ArrayList<Card> getCards()
	{
		return this.cards;
	}
	public ArrayList<ArrayList<Card>> getAllPiles()
	{
		return this.allPiles;
	}
	
	public TableauPileGolf getTableauPile()
	{
		return this.tableauPile;
	}
	
	public StockPileGolf getStockPile()
	{
		return this.stockPile;
	}

	public HomeCellGolf getHomePile()
	{
		return this.homeCell;
	}

}
