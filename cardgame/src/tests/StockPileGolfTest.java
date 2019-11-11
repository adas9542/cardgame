package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.Card;
import code.Deck;
import code.StockPileGolf;
import code.TableauPileGolf;

public class StockPileGolfTest {

	@Test
	public void hold17CardsTest() 
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		StockPileGolf stock=new StockPileGolf(stockPile);
		
		boolean TorF=stock.hold17Cards();
		assertTrue(TorF);
	}
	
	
	
	@Test
	public void if_addCardTest()
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		StockPileGolf stock=new StockPileGolf(stockPile);
		
		String fileName1="/Cards/2s.gif";
		Card card=new Card(2,"Spade",fileName1);
		boolean TorF=stock.if_addCard(card);
		
		assertFalse(TorF);
		
	}
	
	
	
	@Test
	public void if_removeTopCardTest()
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		StockPileGolf stock=new StockPileGolf(stockPile);
		
		//ArrayList<Card> currentStockPile=stock.getStockPile();
		boolean TorF=stock.if_removeTopCard();
		assertTrue(TorF);
	}
	
	
	
	@Test
	public void if_removeTopCardTest2()
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		StockPileGolf stock=new StockPileGolf(stockPile);
		//ArrayList<Card> currentStockPile=stock.getStockPile();
		for(int i=0;i<17;i++)
		{
			stock.getStockPile().remove(0);
		}
		boolean TorF=stock.if_removeTopCard();
		assertFalse(TorF);
	}
	
	
	
	@Test
	public void removeCard_decreaseCounterTest()
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		StockPileGolf stock=new StockPileGolf(stockPile);
		
		Card secondTop=stock.getStockPile().get(stock.getStockPile().size()-2);
		
		stock.removeCard_decreaseCounter();
		
		assertEquals(16,stock.getCardCounter());
		
		boolean TorF=false;
		
		Card newTop=stock.getStockPile().get(stock.getStockPile().size()-1);
		if(newTop==secondTop)
		{
			TorF=true;
		}
		assertEquals(true,TorF);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
