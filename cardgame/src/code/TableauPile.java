package code;
import java.util.ArrayList;

//set up tableau pile rules for little spider game
public class TableauPile {//extends Deck {
	
//	public ArrayList<ArrayList<Card>> allPiles; //ArrayList in an ArrayList
	private ArrayList<ArrayList<Card>> allPiles;
	private ArrayList<Card> topCard;
	public ArrayList<Card> cards; //pile of cards created
	

	
	//public Card top; //top card 
	public int cardCounter= 6; //initially 6 cards each pile for a total of 8 piles
	public int cardNumber; //stores value of cardcounter
	
	//constructor containinga pile of 1 card
//	public TableauPile() {
//		pile = new ArrayList<Card>();
//		//this.allPiles=new ArrayList<ArrayList<Card>>();
//		cardNumber= cardCounter;
//	}
	
	
	//constructor containing apile of cards
	public TableauPile(ArrayList<Card> cards)
	{
		
		cardNumber= cardCounter;
		this.cards=cards;
		//this.allPiles=new ArrayList<ArrayList<Card>>()
	}
	
	//CONSTRUCTOR USED ONLY TO CHECK ADD AND REMOVE METHODS
//	public TableauPile(Card first) {
//		pile= new ArrayList<Card>();
//		pile.add(first);
//	}
	
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
			System.out.println(pile.size());
			allPiles.add(pile);		
			numpiles--;
		}
	}
	
	public ArrayList<ArrayList<Card>> getAllPiles()
	{
		return this.allPiles;
	}

	public void setTopCard()
	{
		for(int i=0;i<allPiles.size();i++)
		{
			topCard.add(allPiles.get(i).get(allPiles.get(i).size()-1));
		}
	}
////	/* numpiles parameter determines the number of tableau piles(8)
////	 *  numcards parameter determines the number of cards in each pile(6)
//	/**
//	 * 
//	 * @param numpiles total number of piles in Golf Tableau
//	 * @param numcards number of cards in each Golf Tableau Pile initially
//	 */
//	public void create_tableau(ArrayList<ArrayList<Card>> x, int numpiles, int numcards)
//	{	
//		while(numpiles != 0 && numpiles >0) 
//		{
//			ArrayList<Card> pile = new ArrayList<Card>(); 
//			
//			for(int i = 0; i < numcards; i++) 
//			{
//				pile.add(cards.get(0));
//				cards.remove(0);   // remove 1st from 52 card,remove 2nd from 51 card, remove 3rd from 50 cards,and so on
//			}						
//			allPiles.add(pile);		
//			numpiles--;
//		}
//	}


	
//	public Card topCard(int index) {
//		return (allPiles.get(index).get(allPiles.get(index).size()-1));
//		
//	}
//	
	//checks to see if two cards are one rank apart or not little spider
		public boolean legalOrNotforred(Card x,Card y) {
			if((x.getRank() == 14 && y.getRank() ==2)) {
				return true;
			}else if( (x.getRank()-y.getRank()) == -1 ) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean legalOrNotforblack(Card x,Card y) {
			if((x.getRank()== 2 && y.getRank() == 14)) {
				return true;
			}else if((x.getRank()-y.getRank()) == 1 ) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean legalOrNot_foronetableau_toanother(Card x,Card y) 
		{
			if((Math.abs(x.getRank()-y.getRank()) == 1 ))
			{
				return true;
			}
			if((x.getRank()== 2 && y.getRank() == 14) || x.getRank()== 14 && y.getRank() == 2)
			{
				return true;
			}
			return false;
		}
		
		// adding card
//		public boolean addCard(TableauPile to, Card topMoving, Card last){
//			//pile = to.pile;// pile adding card
//			if( (last== pile.get(pile.size()-1)) ) {//if last is the last card in pile
//				if( legalOrNot(topMoving, last) ) {//check if they are one rank apart
//					pile.add(topMoving);
//					to.cardCounter++; //increases total cardNumber 
//					return true;
//					}
//			}
//			return false;
//			}
		
		//removes top card of the from a tableau pile //little spider
//	    public boolean removeCard(TableauPile x, Card top) {
//	    	pile=x.pile;
//	    	if( (top== pile.get(pile.size()-1)) ){
//	    		pile.remove(top);
//	    		x.cardCounter--;
//	    		return true;
//	    	}
//	    		return false;
//	    	}
	    
//	   public boolean addCard(int frompile, int topile, Card topMoving){
//	    	if(topCard(topile-1) == topMoving){
//	    		if(Math.abs( topMoving.getRank() -topCard(topile).getRank()) == 1 ) {
//	    			allPiles.get(frompile).remove( allPiles.get(frompile).get(allPiles.get(frompile).size()-1));
//	    			allPiles.get(topile).add(topMoving);
//	    		}
//	    		return true;
//	    		
//	    	}return false;
//	    } 
	    
//	    public ArrayList<ArrayList<Card>> getAllPiles(){
//	    	return this.allPiles;
//	    }
//	    public static void main(String[] args) { //tests code
//	    	
//	    	
//	    	Card last2 = new Card(12, "Diamond");
//	    	TableauPile to = new TableauPile(last2);
//	    	//ArrayList<Card> pile = new ArrayList<Card>();
//	    	//pile = to.pile;// pile adding card
//	    	
//	    	
//	    	Card topMoving = new Card(13, "Diamond");
//	        TableauPile initial = new TableauPile(topMoving);
	        //ArrayList<Card> pileLosing = new ArrayList<Card>();
	        //pileLosing = initial.pileLosing;// pile getting card removed
	    	
	    	
	    	
	    	
			
//			
//			System.out.println(to);
//			System.out.println(initial);
			
//			if( (topMoving == pileLosing.get(0)) && (last2== pile.get(0)) ) {
//				if( to.legalOrNot(topMoving, last2) ) {
//					pile.add(topMoving);
//					to.cardCounter++; //increases total cardNumber 
//					pileLosing.remove(topMoving);
//					initial.cardCounter--; //decreases total cardNumber of tableau pile that lost card
//					
//					}
//			}
			
	    
	    
}
