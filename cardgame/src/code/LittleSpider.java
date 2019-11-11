package code;
import java.util.ArrayList;

//class to connect everything
public class LittleSpider {
	
	private ArrayList<ArrayList<Card>> allPiles;
	private TableauPile tableau;
	
	public HomeCellSpider homeCellSpider;
	private ArrayList<ArrayList<Card>> homePiles;
	public static int x = 2; //x starts at 2
	public ArrayList<Card> cardz; //pileof cards
	//public Deck spiderDeck; //entire deck
	public ArrayList<TableauPile> tableauPiles; //arraylist of arraylist of cards
	
	public LittleSpider() { //implements shuffeled deck 
		Deck deck=new Deck(1);
		this.cardz=deck.cards;//52 cards after shuffle
		this.homePiles=new ArrayList<ArrayList<Card>>();
	    //Creating homecell piles
		
		
		Card ad=deck.getAd();
		Card ah=deck.getAh();
		Card kc=deck.getKc();
		Card ks=deck.getKs();
		
		ArrayList<Card> h1=new ArrayList<Card>();
		ArrayList<Card> h2=new ArrayList<Card>();
		ArrayList<Card> h3=new ArrayList<Card>();
		ArrayList<Card> h4=new ArrayList<Card>();
		
		h1.add(ad);
		h2.add(ah);
		h3.add(kc);
		h4.add(ks);
		
		
		
		homePiles.add(h1);
		homePiles.add(h2);
		homePiles.add(h3);
		homePiles.add(h4);
		
		
		HomeCellSpider homeCellSpider=new HomeCellSpider(homePiles);
		
		
		//removing the cards added to homecell
		cardz.remove(ad);//placement of Ace diamonds
		cardz.remove(ah);//placement of Ace hearts
		cardz.remove(kc);//placement of king club
		cardz.remove(ks);//placement of king spade
		
		System.out.println(cardz.size());
		tableau=new TableauPile(cardz);
		tableau.create_tableau(8,6);
		this.allPiles=tableau.getAllPiles();//return all piles
		tableau.setTopCard();
//		t = new TableauPile();
//		tableau = t.allPiles;
//		t.create_tableau(tableau,8,6);
		

		
		//Creating tableau pile
		
//		tableauPiles = new ArrayList<TableauPile>();
//		create_tableau(8,6);
	
	}
	public ArrayList<ArrayList<Card>> getHomePiles()
	{
		return this.homePiles;
	}
	
	
	public TableauPile getTableauPile()
	{
		return this.tableau;
	}
	
	public HomeCellSpider getHomeCell1()
	{
		return this.homeCellSpider;
	}
	
	
	public ArrayList<Card> getCards()
	{
		return this.cardz;
	}
	
	
	
	//create tableau pile
//	public void create_tableau(int numpiles, int numcards) 
//	{
//		while(numpiles >0){
//	}
//			ArrayList<Card> pile = new ArrayList<Card>(); 
//			
//			for(int i = 0; i < numcards; i++){
//				pile.add(cardz.get(0));
//				cardz.remove(0);   // remove 1st from 52 card,remove 2nd from 51 card, remove 3rd from 50 cards,and so on
//			}						
//			tableauPiles.add(new TableauPile(pile));		
//			numpiles--;
//	}
//	
//	
//}
	public void create_tableau(int numpiles, int numcards)
	{	
		while(numpiles != 0 && numpiles >0) 
		{
			ArrayList<Card> pile = new ArrayList<Card>(); 
			
			for(int i = 0; i < numcards; i++) 
			{
				pile.add(cardz.get(0));
				cardz.remove(0);   // remove 1st from 52 card,remove 2nd from 51 card, remove 3rd from 50 cards,and so on
			}						
			allPiles.add(pile);		
			numpiles--;
		}
		
	}
	
	
	
}