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

public class FortyWasteTest 
{
	@Test
	public void hold0CardTest()
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
		
		assertEquals(0,fortyWaste.getCardCounter());
	}
	
	@Test
	public void if_addToppTest()
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
		
		boolean TorF=fortyWaste.if_addTopp();
		assertFalse(TorF);
	}
	
	@Test
	public void if_removeTopCarddTest()
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
		
		boolean TorF=fortyWaste.if_removeTopCardd();
		assertTrue(TorF);
		
	}
	
	@Test
	public void removeTopCardTest()
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
		Card addWaste1=fortyStock.getStockPile().get(fortyStock.getStockPile().size()-1);
		Card addWaste2=fortyStock.getStockPile().get(fortyStock.getStockPile().size()-2);
		
		fortyStock.removeCard_decreaseCounter();
		fortyStock.removeCard_decreaseCounter();
		
		fortyWaste.addTopCard(addWaste1);
		fortyWaste.addTopCard(addWaste2);
		
		fortyWaste.removeTopCard();
		
		assertEquals(1,fortyWaste.getCardCounter());
		
		Card wasteTop=fortyWaste.getTopCard();
		assertEquals(wasteTop,addWaste1);
	}
	
	
	
}
