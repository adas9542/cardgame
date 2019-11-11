package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.Card;
import code.Deck;
import code.TableauPileGolf;

public class TableauPileGolfTest {

		@Test
		public void hold5CardsTest() 
		{
			Deck deck=new Deck();
			ArrayList<Card> cards=new ArrayList<Card>();
			cards=deck.cards;//52 cards after shuffle
			
			TableauPileGolf tableau=new TableauPileGolf(cards);
			tableau.create_tableau(7, 5);
//			boolean TorF=tableau.hold5Cards();
//			assertTrue(TorF); 
			boolean TorF=true;
			for(int i=0;i<tableau.getAllPiles().size();i++)
			{
				if(tableau.getAllPiles().get(i).size()!=5)
					TorF=false;
			}
			assertTrue(TorF);
		}
		
		
		
		@Test
		public void if_AddingTableauTest()
		{
			Deck deck=new Deck();
			ArrayList<Card> cards=new ArrayList<Card>();
			cards=deck.cards;//52 cards after shuffle
			
			TableauPileGolf tableau=new TableauPileGolf(cards);
			tableau.create_tableau(7, 5);
			ArrayList<ArrayList<Card>> allPiles=new ArrayList<ArrayList<Card>>();
			allPiles=tableau.getAllPiles();
			
			int index=1;
			Card add=allPiles.get(index).get(3);
			boolean TorF=tableau.if_AddingTableau(index, add);
			assertFalse(TorF);
		}
		
		
		
		@Test
		public void if_removeTopTest()
		{
			Deck deck=new Deck();
			ArrayList<Card> cards=new ArrayList<Card>();
			cards=deck.cards;//52 cards after shuffle
			
			TableauPileGolf tableau=new TableauPileGolf(cards);
			tableau.create_tableau(7, 5);
			ArrayList<ArrayList<Card>> allPiles=new ArrayList<ArrayList<Card>>();
			allPiles=tableau.getAllPiles();
			
			int index=3;
			Card topx=allPiles.get(index).get(allPiles.get(index).size()-1);
			boolean TorF=tableau.if_removeTop(index, topx);
			assertTrue(TorF);
			
		}
		
		
		
		@Test
		public void if_removeTopTest2()
		{
			Deck deck=new Deck();
			ArrayList<Card> cards=new ArrayList<Card>();
			cards=deck.cards;//52 cards after shuffle
			
			TableauPileGolf tableau=new TableauPileGolf(cards);
			tableau.create_tableau(7, 5);
			ArrayList<ArrayList<Card>> allPiles=new ArrayList<ArrayList<Card>>();
			allPiles=tableau.getAllPiles();
			
			int index=0;
			for(int i=0;i<5;i++)
			{
				allPiles.get(index).remove(allPiles.get(index).get(0));
			}
			
			Card topx=null;
			if(allPiles.get(index).size()!=0)
				allPiles.get(index).get(allPiles.get(index).size()-1);
			
			boolean TorF=tableau.if_removeTop(index, topx);
			assertFalse(TorF);
			
		}
		
		
		@Test
		public void removeCard_decreaseCardCounterTest()
		{
			Deck deck=new Deck();
			ArrayList<Card> cards=new ArrayList<Card>();
			cards=deck.cards;//52 cards after shuffle
			
			TableauPileGolf tableau=new TableauPileGolf(cards);
			tableau.create_tableau(7, 5);
			ArrayList<ArrayList<Card>> allPiles=new ArrayList<ArrayList<Card>>();
			allPiles=tableau.getAllPiles();//7 piles, 5 cards in each pile
			
			System.out.println(allPiles.size());
			//ArrayList<Card> topCard=new ArrayList<Card>();
			tableau.setTopCard();
			//System.out.println(topCard.size());
			
			int index=0;
			Card secondTop=allPiles.get(index).get(allPiles.get(index).size()-2);
			tableau.removeCard_decreaseCardCounter(index);
			//System.out.println(tableau.getTopCard().size());
			
			assertEquals(34,tableau.getCardCounter());
			
			boolean TorF=false;
			Card newTop=tableau.getTopCard().get(index);//allPiles.get(index).get(allPiles.get(index).size()-1);
			if(newTop==secondTop)
			{
				TorF=true;
			}
			assertEquals(true,TorF);
			
		}

}
