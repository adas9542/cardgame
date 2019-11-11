package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.Card;
import code.Deck;
import code.FortyThievesHomeCell;
import code.FortyThievesStockPile;
import code.FortyThievesTableau;
import code.FortyThievesWaste;

public class FortyStockTest 
{
	@Test
	public void hold57CardsTest()
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
		assertEquals(57,fortyStock.getStockArrSize());
	}
	
	@Test
	public void if_addCardTest()
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
		Card s=new Card(3,"Diamond");
		boolean TorF=fortyStock.if_addCard(s);
		assertFalse(TorF);
	}
	
	@Test
	public void if_removeTopCardTest1()
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
		
		boolean TorF=fortyStock.if_removeTopCard();
		assertTrue(TorF);
		
		
	}
	
	@Test
	public void if_removeTopCardTest2()
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
		
		for(int i=0;i<57;i++)
		{
			fortyStock.removeCard_decreaseCounter();
		}
		//System.out.println(fortyStock.getStockArrSize());
		boolean TorF=fortyStock.if_removeTopCard();
		assertFalse(TorF);
		
	}

	@Test
	public void removeCard_decreaseCounterTest()
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
		Card s=fortyStock.getStockPile().get(fortyStock.getStockPile().size()-2);
		Card oldTop=fortyStock.getStockPile().get(fortyStock.getStockPile().size()-1);
		fortyStock.removeCard_decreaseCounter();
		Card newTop=fortyStock.getTopCard();
		assertEquals(newTop,s);
		//
		fortyWaste.addTopCard(oldTop);
		Card b=fortyWaste.getTopCard();
		assertEquals(oldTop,b);
		
	}
	
	
}
