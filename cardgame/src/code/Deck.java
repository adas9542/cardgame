package code;
import java.util.ArrayList;
import java.util.Collections;

//create 52 cards, and shuffle
public class Deck {
	
	public ArrayList<Card> cards; //arraylist of cards
	protected static int x = 2; //holds an int starting at 2
	private Card ad;
	private Card ah;
	private Card kc;
	private Card ks;
	
	private ArrayList<Card> Aces;
	
	public Deck() { //defaultconstructor creates a shufffeled deck
		cards= new ArrayList<Card>();
		constructDeck();
		deckShuffle();
	}
	
	public Deck(int x) {//Deck constructor SPECIFICALLY for spider; 
		cards= new ArrayList<Card>();
		constructDeckForSpider();//creates 52 cards and then removes the 4 homecell starting cards
		multiDeckShuffle(x);//needed to create same method over but this time taking in a @param to allow us to use spiderDeck constructor
	}
	
	//for forty thieves
	public Deck(String a)
	{
		cards= new ArrayList<Card>();
		Aces= new ArrayList<Card>();
		constructDeckForFortyThieves();
		deckShuffle();
		takeAwayAces();
	}
	
	//to take away Aces(for forty thieves)
	public void takeAwayAces()
	{
		for(int i=0;i<cards.size();i++)
		{
			if(cards.get(i).getRank()==14)
			{
				Aces.add(cards.get(i));
				cards.remove(i);
				i--;
			}
		}
	}
	
	//General Deck construction
	public ArrayList<Card> constructDeck() {
		String[] suites = {"Diamond","Club","Heart","Spade"};// This should create the deck
		for(int i=0;i<suites.length;i++) {
			for(int r =2; r<=14; r++) {//we start with 2, construct all suites of 2 and then r will increment and construct all suites of the next card 
				String rank="";
				if(r==11)
					rank="j";
				if(r==12)
					rank="q";
				if(r==13)
					rank="k";
				if(r==14)
					rank="a";
				if(r>=2 && r<=10)
					rank=""+r;
				String fileName="/Cards/"+rank+suites[i].substring(0, 1).toLowerCase()+".gif";
				cards.add(new Card(r, suites[i],fileName));
			}
		}return cards;
	}
	
	// Specifically for Little Spider; 48 cards; removed homecell starting cards
	public ArrayList<Card> constructDeckForSpider() {
		String[] suites = {"Diamond","Club","Heart","Spade"};// This should create the deck
		
		for(int i=0;i<suites.length;i++) {
			for(int r =2; r<=14; r++) {//we start with 2, construct all suites of 2 and then r will increment and construct all suites of the next card 
				String rank="null";
				
				if(r==11)
					rank="j";
				if(r==12)
					rank="q";
				if(r==13 && !suites[i].equals("Club") && !suites[i].equals("Spade"))
					rank="k";
				if(r==14 && !suites[i].equals("Diamond") && !suites[i].equals("Heart"))
					rank="a";
				if(r>=2 && r<=10)
					rank=""+r;
				if(!rank.equals("null")) 
				{
					String fileName="/Cards/"+rank+suites[i].substring(0, 1).toLowerCase()+".gif";
					cards.add(new Card(r, suites[i],fileName));		
				}
				
				if(suites[i].equals("Diamond") && r==14)
				{
					rank="a";
					String fileName="/Cards/"+rank+suites[i].substring(0, 1).toLowerCase()+".gif";
					ad=new Card(r, suites[i],fileName);
					cards.add(ad);
				}
				if(suites[i].equals("Heart") && r==14)
				{
					rank="a";
					String fileName="/Cards/"+rank+suites[i].substring(0, 1).toLowerCase()+".gif";
					ah=new Card(r, suites[i],fileName);
					cards.add(ah);
				}
				if(suites[i].equals("Club") && r==13)
				{
					rank="k";
					String fileName="/Cards/"+rank+suites[i].substring(0, 1).toLowerCase()+".gif";
					kc=new Card(r, suites[i],fileName);
					cards.add(kc);
				}
				if(suites[i].equals("Spade") && r==13)
				{
					rank="k";
					String fileName="/Cards/"+rank+suites[i].substring(0, 1).toLowerCase()+".gif";
					ks=new Card(r, suites[i],fileName);
					cards.add(ks);
				}
			}
			
		}
		
		
//		String fileName1="/Cards/ad.gif";
//		Card cell1 = new Card(14, "Diamond",fileName1);
//		String fileName2="/Cards/ah.gif";
//		Card cell2 = new Card(14, "Heart",fileName2);
//		String fileName3="/Cards/kc.gif";
//		Card cell3 = new Card(13, "Club",fileName3);
//		String fileName4="/Cards/ks.gif";
//		Card cell4 = new Card(13, "Spade",fileName4);
//		cards.remove(cell1);
//		cards.remove(cell2);
//		cards.remove(cell3);
//		cards.remove(cell4);
		return cards;
	}
	
	//construct deck for forty thieves
	public ArrayList<Card> constructDeckForFortyThieves() 
	{
		String[] suites = {"Diamond","Club","Heart","Spade"};// This should create the deck
		for(int i=0;i<suites.length;i++) 
		{
			for(int r =2; r<=14; r++) {//we start with 2, construct all suites of 2 and then r will increment and construct all suites of the next card 
				String rank="";
				if(r==11)
					rank="j";
				if(r==12)
					rank="q";
				if(r==13)
					rank="k";
				if(r==14)
					rank="a";
				if(r>=2 && r<=10)
					rank=""+r;
				String fileName="/Cards/"+rank+suites[i].substring(0, 1).toLowerCase()+".gif";
				cards.add(new Card(r, suites[i],fileName));
			}
		}
		for(int i=0;i<suites.length;i++) 
		{
			for(int r =2; r<=14; r++) {//we start with 2, construct all suites of 2 and then r will increment and construct all suites of the next card 
				String rank="";
				if(r==11)
					rank="j";
				if(r==12)
					rank="q";
				if(r==13)
					rank="k";
				if(r==14)
					rank="a";
				if(r>=2 && r<=10)
					rank=""+r;
				String fileName="/Cards/"+rank+suites[i].substring(0, 1).toLowerCase()+".gif";
				cards.add(new Card(r, suites[i],fileName));
			}
		}
		
		return cards;
	}
	
	
	
	public Card getAd()
	{
		return this.ad;
	}
	public Card getAh()
	{
		return this.ah;
	}
	public Card getKc()
	{
		return this.kc;
	}
	public Card getKs()
	{
		return this.ks;
	}
	//shuffles deck
	public void deckShuffle() {
		Collections.shuffle(cards);//generates the deck of cards in random order
	}
	
	//shuffles deck multiple times
	public void multiDeckShuffle(int x) {
		for(int i= 0; i<= x; i++) {
			Collections.shuffle(cards);//generates the deck of cards in random order
		}
	}
	
   
	//getter method for deck 
	public ArrayList<Card> getDeck() {
		return cards;
	}
	
	
	//removes card dealt from main deck.
	public Card deal() {
		Card dealt = cards.get(cards.size()-1);
		cards.remove(cards.size()-1);
		return dealt;
	}
	
	//getter to get 8 Aces
	public ArrayList<Card> getAces()
	{
		return this.Aces;
	}

	
}
