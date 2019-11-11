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

public class FortyTableauTest 
{
	
	@Test
	public void hold3CardsTest()
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
		for(int i=0;i<fortyTableau.getAllPiles().size();i++)
		{
			if(fortyTableau.getAllPiles().get(i).size()!=3)
				TorF=false;
		}
		assertTrue(TorF);
	}
	
	@Test
	public void if_AddingTableauTest1()
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
		String suite=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-1).getSuite();
		int rank=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-1).getRank();
		System.out.println(rank);
		Card s=null;
		
		if(rank==2)
		{
			s=new Card(14,suite);
			boolean TorF=fortyTableau.if_AddingTableau(0, s);
			assertFalse(TorF);
		}
		else if(rank==14)
		{
			s=null;
			boolean TorF=fortyTableau.if_AddingTableau(0, s);
			assertTrue(TorF);
		}
		else
		{
			s=new Card(rank-1,suite);
			boolean TorF=fortyTableau.if_AddingTableau(0, s);
			assertTrue(TorF);
		}
		
		
	}
	
	@Test
	public void if_AddingTableauTest2()
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
		String suite=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-1).getSuite();
		int rank=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-1).getRank()-1;
		
		Card s=null;
		
		if(rank==1)
		{
			s=new Card(5,suite);
		}
		else if(rank==13)
		{
			s=null;
		}
		else
		{
			s=new Card(rank+2,suite);
		}
		boolean TorF=fortyTableau.if_AddingTableau(0, s);
		assertFalse(TorF);
		
	}
	
	@Test
	public void if_removeTopTest1()
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
		//String suite=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-1).getSuite();
		//int rank=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-1).getRank();
		Card s=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-1);
		boolean TorF=fortyTableau.if_removeTop(0, s);
		assertTrue(TorF);
	}
	
	@Test
	public void if_removeTopTest2()
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
		
		Card s=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-2);
		boolean TorF=fortyTableau.if_removeTop(0, s);
		assertFalse(TorF);
	}
	
	
	@Test
	public void addCardTest()
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
		
		String suite=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-1).getSuite();
		int rank=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-1).getRank();
		System.out.println(rank);
		Card s=null;
		boolean TorF=false;
		if(rank==2)
		{
			s=new Card(14,suite);
			TorF=fortyTableau.if_AddingTableau(0, s);
		}
		else if(rank==14)
		{
			s=null;
		}
		else
		{
			s=new Card(rank-1,suite);
			TorF=fortyTableau.if_AddingTableau(0, s);
		}
		
		if(TorF)
		{
			fortyTableau.addCard(0, s);
			assertEquals(58,fortyTableau.getCardCounter());
			
			Card top=fortyTableau.getTopCard().get(0);
			assertEquals(s,top);
		}
		
	
	}
	
	@Test
	public void removeCard_decreaseCardCounterTest()
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
		Card s=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-1);
		boolean TorF=fortyTableau.if_removeTop(0, s);
		Card toReplace=null;
		if(TorF)
		{
			toReplace=fortyTableau.getAllPiles().get(0).get(fortyTableau.getAllPiles().get(0).size()-2);
			fortyTableau.removeCard_decreaseCardCounter(0);
		}
		
		assertEquals(56,fortyTableau.getCardCounter());
		assertEquals(fortyTableau.getTopCard().get(0),toReplace);
		
	}
	
}
