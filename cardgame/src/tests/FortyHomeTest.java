package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import code.Card;
import code.Deck;
import code.FortyThievesHomeCell;
import code.FortyThievesStockPile;
import code.FortyThievesTableau;
import code.FortyThievesWaste;

public class FortyHomeTest 
{

	@Test
	public  void hold1CardTest()
	{
		Deck deck=new Deck("a");
		ArrayList<Card> cards=deck.cards;
		ArrayList<Card> Aces=deck.getAces();
		
		FortyThievesTableau fortyTableau=new FortyThievesTableau(cards);
		fortyTableau.create_tableau(13, 3);
		ArrayList<ArrayList<Card>> allPiles=fortyTableau.getAllPiles();
		fortyTableau.setTopCard();
		fortyTableau.setStockPile();
		
		ArrayList<Card> stockArr=fortyTableau.getStockPile();
		FortyThievesHomeCell fortyHomeCell=new FortyThievesHomeCell(Aces);
		fortyHomeCell.setTopCard();
		
		FortyThievesStockPile fortyStock=new FortyThievesStockPile(stockArr);
		FortyThievesWaste fortyWaste=new FortyThievesWaste(stockArr);
		/////////////////////above codes are set ups
		boolean TorF=true;
		for(int i=0;i<fortyHomeCell.getHomePile().size();i++)
		{
			if(fortyHomeCell.getHomePile().get(i).size()!=1)
				TorF=false;
		}
		assertTrue(TorF);
	}
	
	@Test
	public void if_addTopTest1()
	{
		Deck deck=new Deck("a");
		ArrayList<Card> cards=deck.cards;
		ArrayList<Card> Aces=deck.getAces();
		
		FortyThievesTableau fortyTableau=new FortyThievesTableau(cards);
		fortyTableau.create_tableau(13, 3);
		ArrayList<ArrayList<Card>> allPiles=fortyTableau.getAllPiles();
		fortyTableau.setTopCard();
		fortyTableau.setStockPile();
		
		ArrayList<Card> stockArr=fortyTableau.getStockPile();
		FortyThievesHomeCell fortyHomeCell=new FortyThievesHomeCell(Aces);
		fortyHomeCell.setTopCard();
		
		FortyThievesStockPile fortyStock=new FortyThievesStockPile(stockArr);
		FortyThievesWaste fortyWaste=new FortyThievesWaste(stockArr);
		/////////////////////above codes are set ups
		Card top=fortyHomeCell.getHomePile().get(0).get(fortyHomeCell.getHomePile().get(0).size()-1);
		String suite=top.getSuite();
		
		Card add=new Card(2,suite);
		boolean TorF=fortyHomeCell.if_addTop(top, add);
		assertTrue(TorF);
	}
	
	@Test
	public void if_addTopTest2()
	{
		Deck deck=new Deck("a");
		ArrayList<Card> cards=deck.cards;
		ArrayList<Card> Aces=deck.getAces();
		
		FortyThievesTableau fortyTableau=new FortyThievesTableau(cards);
		fortyTableau.create_tableau(13, 3);
		ArrayList<ArrayList<Card>> allPiles=fortyTableau.getAllPiles();
		fortyTableau.setTopCard();
		fortyTableau.setStockPile();
		
		ArrayList<Card> stockArr=fortyTableau.getStockPile();
		FortyThievesHomeCell fortyHomeCell=new FortyThievesHomeCell(Aces);
		fortyHomeCell.setTopCard();
		
		FortyThievesStockPile fortyStock=new FortyThievesStockPile(stockArr);
		FortyThievesWaste fortyWaste=new FortyThievesWaste(stockArr);
		/////////////////////above codes are set ups
		Card top=fortyHomeCell.getHomePile().get(0).get(fortyHomeCell.getHomePile().get(0).size()-1);
		String suite=top.getSuite();
		
		Card add=new Card(3,suite);
		boolean TorF=fortyHomeCell.if_addTop(top, add);
		assertFalse(TorF);
	}
	
	@Test
	public void if_removeTopTest()
	{
		Deck deck=new Deck("a");
		ArrayList<Card> cards=deck.cards;
		ArrayList<Card> Aces=deck.getAces();
		
		FortyThievesTableau fortyTableau=new FortyThievesTableau(cards);
		fortyTableau.create_tableau(13, 3);
		ArrayList<ArrayList<Card>> allPiles=fortyTableau.getAllPiles();
		fortyTableau.setTopCard();
		fortyTableau.setStockPile();
		
		ArrayList<Card> stockArr=fortyTableau.getStockPile();
		FortyThievesHomeCell fortyHomeCell=new FortyThievesHomeCell(Aces);
		fortyHomeCell.setTopCard();
		
		FortyThievesStockPile fortyStock=new FortyThievesStockPile(stockArr);
		FortyThievesWaste fortyWaste=new FortyThievesWaste(stockArr);
		/////////////////////above codes are set ups
		
		Card top=fortyHomeCell.getHomePile().get(0).get(fortyHomeCell.getHomePile().get(0).size()-1);
		boolean TorF=fortyHomeCell.if_removeTop(top);
		assertFalse(TorF);
	}
	
	@Test
	public void addTopCard_increaseCardCounterTest()
	{
		Deck deck=new Deck("a");
		ArrayList<Card> cards=deck.cards;
		ArrayList<Card> Aces=deck.getAces();
		
		FortyThievesTableau fortyTableau=new FortyThievesTableau(cards);
		fortyTableau.create_tableau(13, 3);
		ArrayList<ArrayList<Card>> allPiles=fortyTableau.getAllPiles();
		fortyTableau.setTopCard();
		fortyTableau.setStockPile();
		
		ArrayList<Card> stockArr=fortyTableau.getStockPile();
		FortyThievesHomeCell fortyHomeCell=new FortyThievesHomeCell(Aces);
		fortyHomeCell.setTopCard();
		
		FortyThievesStockPile fortyStock=new FortyThievesStockPile(stockArr);
		FortyThievesWaste fortyWaste=new FortyThievesWaste(stockArr);
		/////////////////////above codes are set ups
		
		Card top=fortyHomeCell.getHomePile().get(0).get(fortyHomeCell.getHomePile().get(0).size()-1);
		String suite=top.getSuite();
		
		Card add=new Card(2,suite);
		boolean TorF=fortyHomeCell.if_addTop(top, add);
		if(TorF)
		{
			fortyHomeCell.addTopCard_increaseCardCounter(0, add);
		}
		assertEquals(fortyHomeCell.getTopCard().get(0),add);
		assertEquals(9,fortyHomeCell.getCardCounter());
		
		
	}
}
