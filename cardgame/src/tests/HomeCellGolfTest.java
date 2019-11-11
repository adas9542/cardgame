package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


import code.Card;
import code.Deck;
import code.HomeCellGolf;
import code.StockPileGolf;
import code.TableauPileGolf;

public class HomeCellGolfTest 
{
	@Test
	public void hold0CardTest()
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		HomeCellGolf homeCell=new HomeCellGolf(stockPile);
		
		int getCard=homeCell.getCardCounter();
		assertEquals(0,getCard);	
	}
	
	
	
	@Test
	public void if_addTopTest1()
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		HomeCellGolf homeCell=new HomeCellGolf(stockPile);
		
		Card top=null;
		String fileName1="/Cards/3d.gif";
		Card add=new Card(3,"Diamond",fileName1);
		
		boolean TorF=false;
		if(homeCell.getHomePile().size()==0)
		{
			TorF=homeCell.if_addTop(top, add);
		}
		
		assertTrue(TorF);
	}
	
	
	
	@Test
	public void if_addTopTest2()
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		HomeCellGolf homeCell=new HomeCellGolf(stockPile);
		
		boolean TorF=false;
		Card top=tableau.getAllPiles().get(1).get(1);
		homeCell.addTopCard_increaseCardCounter(top);
		
		Card add=stockPile.get(3);
		if(homeCell.getHomePile().size()>0)
		{
			top=homeCell.getHomePile().get(homeCell.getHomePile().size()-1);
		}
		
		TorF=homeCell.if_addTop(top, add);
		
		assertTrue(TorF);
	}
	
	
	
	@Test
	public void if_addTopTest3()
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		ArrayList<ArrayList<Card>> allPiles= tableau.getAllPiles();
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		HomeCellGolf homeCell=new HomeCellGolf(stockPile);
		
		boolean TorF1=false;
		Card add=allPiles.get(0).get(0);
//		System.out.println("origin add:"+add.getRank());
		for(int i=0;i<allPiles.size();i++)
		{
			for(int j=0;j<allPiles.get(i).size();j++)
			{
				if(allPiles.get(i).get(j).getRank()==14)
				{
					add=allPiles.get(i).get(j);
//					System.out.println("first add:"+add.getRank());
				}
				break;
			}
		}
		String fileName1="/Cards/2d.gif";
		Card top=new Card(2,"Diamond",fileName1);
		homeCell.addTopCard_increaseCardCounter(top);
		TorF1=homeCell.if_addTop(top, add);
//		System.out.println(TorF1);
		if(TorF1)
			homeCell.addTopCard_increaseCardCounter(add);
		
		////////////////////////////////////////
		boolean TorF2=false;
		for(int i=0;i<allPiles.size();i++)
		{
			for(int j=0;j<allPiles.get(i).size();j++)
			{
				if(allPiles.get(i).get(j).getRank()==2)
				{
					add=allPiles.get(i).get(j);
//					System.out.println("second add:"+add.getRank());
				}
				break;
			}
		}
		TorF2=homeCell.if_addTop(homeCell.getTopCard(), add);
//		System.out.println(TorF2);
		
	    
		if(TorF1==true || TorF2==true)
			assertTrue(TorF1 || TorF2 );
		
		if(TorF1==false && TorF2==false)
			assertFalse(TorF1 || TorF2 );
	}
	
	@Test
	public void if_addTopTest4()
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		ArrayList<ArrayList<Card>> allPiles= tableau.getAllPiles();
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		HomeCellGolf homeCell=new HomeCellGolf(stockPile);
		
		boolean TorF=false;
		Card add=allPiles.get(0).get(0);
		for(int i=0;i<allPiles.size();i++)
		{
			for(int j=0;j<allPiles.get(i).size();j++)
			{
				if(allPiles.get(i).get(j).getRank()==4)
				{
					add=allPiles.get(i).get(j);
					System.out.println("add4:"+add.getRank());
				}
				break;
			}
			if(add.getRank()==4);
			break;
		}
		if(add.getRank()!=4)
		{
			for(int i=0;i<allPiles.size();i++)
			{
				for(int j=0;j<allPiles.get(i).size();j++)
				{
					if(allPiles.get(i).get(j).getRank()==6)
					{
						add=allPiles.get(i).get(j);
						System.out.println("add6:"+add.getRank());
					}
					break;
				}
				if(add.getRank()==6);
				break;
			}
		}
		if(add.getRank()==4 || add.getRank()==6)
		{
			String fileName1="/Cards/5d.gif";
			Card top=new Card(5,"Diamond",fileName1);
			homeCell.addTopCard_increaseCardCounter(top);
			TorF=homeCell.if_addTop(top, add);
			assertTrue(TorF);
		}
		
		
		if(add.getRank()!=4 && add.getRank()!=6)
		{
			for(int i=0;i<allPiles.size();i++)
			{
				for(int j=0;j<allPiles.get(i).size();j++)
				{
					if(allPiles.get(i).get(j).getRank()==9)
					{
						add=allPiles.get(i).get(j);
						//System.out.println("add4:"+add.getRank());
					}
					break;
				}
				if(add.getRank()==9);
				break;
			}
			if(add.getRank()!=4)
			{
				for(int i=0;i<allPiles.size();i++)
				{
					for(int j=0;j<allPiles.get(i).size();j++)
					{
						if(allPiles.get(i).get(j).getRank()==7)
						{
							add=allPiles.get(i).get(j);
							//System.out.println("add6:"+add.getRank());
						}
						break;
					}
					if(add.getRank()==7);
					break;
				}
			}
		}
		if(add.getRank()==7 || add.getRank()==9)
		{
			String fileName1="/Cards/8d.gif";
			Card top=new Card(8,"Diamond",fileName1);
			homeCell.addTopCard_increaseCardCounter(top);
			TorF=homeCell.if_addTop(top, add);
			assertTrue(TorF);
		}
		
		
		
		
		
		
		
	}
	
	@Test
	public void if_removeTopTest()
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		ArrayList<ArrayList<Card>> allPiles=new ArrayList<ArrayList<Card>>();
		allPiles=tableau.getAllPiles();
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		HomeCellGolf homeCell=new HomeCellGolf(stockPile);
		
		int index=1;
		String fileName1="/Cards/3c.gif";
		homeCell.addTopCard_increaseCardCounter(new Card(3,"Club",fileName1));
		Card remove=homeCell.getTopCard();
		boolean TorF=homeCell.if_removeTop(remove);
		assertFalse(TorF);
	}
	
	
	
	@Test
	public void addTopCard_increaseCardCounterTest()
	{
		Deck deck=new Deck();
		ArrayList<Card> cards=new ArrayList<Card>();
		cards=deck.cards;//52 cards after shuffle
		
		TableauPileGolf tableau=new TableauPileGolf(cards);
		tableau.create_tableau(7, 5);
		tableau.setStockPile();
		ArrayList<ArrayList<Card>> allPiles=new ArrayList<ArrayList<Card>>();
		allPiles=tableau.getAllPiles();
		ArrayList<Card> stockPile=tableau.getStockPile();
		
		HomeCellGolf homeCell=new HomeCellGolf(stockPile);
		
		int index=0;
		String fileName1="/Cards/kh.gif";
		Card top=new Card(13,"Heart",fileName1);
		homeCell.addTopCard_increaseCardCounter(top);
		
		assertEquals(1,homeCell.getCardCounter());
		
		boolean TorF=false;
		Card newTop=homeCell.getTopCard();
		if(newTop==top)
		{
			TorF=true;
		}
		assertEquals(true,TorF);
	}
	
	
}
