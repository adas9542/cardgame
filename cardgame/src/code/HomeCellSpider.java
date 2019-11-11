package code;
import java.util.ArrayList;

public class HomeCellSpider extends Deck{
	
	public ArrayList<ArrayList<Card>> allHomepiles;
	public ArrayList<Card> topCard;
	
	public ArrayList<Card> piles;
	public ArrayList<Card> cards;
	public Card top;
	public static int cardCounter = 0;
	public int cardNumber;
	
	public HomeCellSpider(ArrayList<ArrayList<Card>> first) {//Ace of Diamonds,Ace of Hearts,King of Clubs,King of Spades 
		
//		piles= new ArrayList<Card>();
//		piles.add(first);//all homecell piles start with one card
		cardCounter++;
		cardNumber = cardCounter;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	
	//checks to see if two cards are one rank apart or not
	public boolean legalOrNot(int x,int y) {
		if((x == 14 && y ==2) || (x== 2 && y == 14)) {
			return true;
		}else if((x-y) == 1 || (x-y) == -1 ) {
			return true;
		}else {
			return false;
		}
	}

	public void setTopCard()
	{
		for(int i=0;i<allHomepiles.size();i++)
		{
			topCard.add( allHomepiles.get(i). get(allHomepiles.get(i).size()-1) );
		}
	}
	
	public ArrayList<Card> getTopCard() {
		return topCard;
	}
	
	
	
//	public boolean to_homecell(int fromhom, int totab) {
//    	
//		
//		
//    	boolean retVal = false; 
//    	
//    	ArrayList<Card> frompile = allPiles.get(fromhom);
//    	ArrayList<Card> topile = allPiles.get(totab);
//    	
//    	Card x = getTopCard();
//    	
//    	Card y = topile.get(topile.size() -1);
//    	
//    	if(x.getSuite() == y.getSuite()) {
//    		if((x.getSuite().equals("Diamond") || x.getSuite().equals("Heart")) && legalOrNotforred(x,y)) {
//    			retVal = true;
//    		}
//    		else if((x.getSuite().equals("Club") || x.getSuite().equals("Spade")) &&  legalOrNotforblack(x,y)){
//    			retVal = true;
//    		}
//
//    	}
////    	else {
////    		return a pop up window
////    	}
//    	
//    	return retVal;
//    }
	
    //checks to see if all requirements to add cards to the homecellpiles are met
	public boolean addCard(HomeCellSpider x, Card top, Card added, int index_of_homecell_pile_of_top) {//Heart/diamond go up & club/spade go down 
		allHomepiles.get(index_of_homecell_pile_of_top).indexOf(top);
		
		
		piles = x.piles;//setting piles == piles of the homecell x
		if( ((top.getSuite() == "Diamond") && (added.getSuite() == "Diamond")) || ((top.getSuite() == "Heart") && (added.getSuite() == "Heart")) ) {
			if( (top.getRank()-added.getRank() == -1) || (top.getRank() == 14 && added.getRank() == 2) ) {
				piles.add(added);
				cardCounter++;//increases total cardNumber
				return true;
				}
			}
		if( ((top.getSuite() == "Club") && (added.getSuite() == "Club")) || ((top.getSuite() == "Spade") && (added.getSuite() == "Spade")) ) {
			if( (top.getRank()-added.getRank() == 1) || (top.getRank() == 2 && added.getRank() == 14) ) {
				piles.add(added);
				cardCounter++;//increases total cardNumber
				return true;
				}
			}
			return false;
	}
	
	//removes top card of the homecellpile inputted
    public boolean removeCard(HomeCellSpider x, Card top) {
    	piles= x.piles;
    	if(piles.get(piles.size()-1) == top) {//check to see if top is really the top card of the homecellpile
    		piles.remove(piles.size()-1);//if so remove it and decrease the overall cardCounter
        	cardCounter--;
        	return true;
    	}else {
    		return false; // only top card can be removed
    	}
    }
	
}