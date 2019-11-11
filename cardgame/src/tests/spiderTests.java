package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import code.Card;
import code.Deck;
import code.HomeCellSpider;
import code.LittleSpider;
import code.TableauPile;

public class spiderTests {
	
	
	//Deck set up
	@Test
	public void setUp() {
		Deck x = new Deck();
		x.constructDeck();
		assertEquals(52, x.getDeck().size());
	}
	/*HOMECELL JUNIT TESTS
	 * 
	 */
	@Test
	public void testHomecellHold1 () {// Homecell spider holds 1 card 
		String fileName1="/Cards/2c.gif";
		Card cell1 = new Card(2, "Club",fileName1);
		//HomeCellSpider hcs = new HomeCellSpider(cell1);
		//assertEquals(1, hcs.cardNumber);
	}
	
	@Test
	public void testLegaltrue () {//homecell spider
		String fileName1="/Cards/kc.gif";
		Card cell2 = new Card(13, "Club",fileName1);
		String fileName2="/Cards/as.gif";
		Card cell3 = new Card(14, "Spade",fileName2);
		//HomeCellSpider hcs1 = new HomeCellSpider(cell2);
		//assertEquals(true, hcs1.legalOrNot(cell2.getRank(),cell3.getRank()));
	}
	
	@Test
	public void testLegalFalse () {//homecell spider
		String fileName1="/Cards/kc.gif";
		Card cell2 = new Card(13, "Club",fileName1);
		String fileName2="/Cards/2s.gif";
		Card cell3 = new Card(2, "Spade",fileName2);
		//HomeCellSpider hcs2 = new HomeCellSpider(cell2);
		//assertEquals(false, hcs2.legalOrNot(cell2.getRank(),cell3.getRank()));
	}
	
	@Test
	public void testremoveCardtrue () {
		String fileName1="/Cards/kc.gif";
		Card cell4 = new Card(13, "Club",fileName1);
		//HomeCellSpider hcs3 = new HomeCellSpider(cell4);
		//assertEquals(true,hcs3.removeCard(hcs3,cell4) );
	}
	
	@Test
	public void testremoveCardfalse() {
		String fileName1="/Cards/kc.gif";
		Card cell5 = new Card(13, "Club",fileName1);
		String fileName2="/Cards/qc.gif";
		Card cell6 = new Card(12, "Club",fileName2);
		//HomeCellSpider hcs4 = new HomeCellSpider(cell5);
		//assertEquals(false, hcs4.removeCard(hcs4,cell6) );
	}
	
	@Test
	public void testAddCardTrue() {
		String fileName1="/Cards/kc.gif";
		Card x = new Card(13, "Club",fileName1);
		String fileName2="/Cards/qc.gif";
		Card y = new Card(12, "Club",fileName2);
		//HomeCellSpider a = new HomeCellSpider(x);
		//assertEquals( true, a.addCard(a,x,y) );
		//assertEquals(2, a.cardCounter);
	}
	
	
	@Test
	public void testAddCardFalse() {
		String fileName1="/Cards/kc.gif";
		Card x = new Card(13, "Club",fileName1);
		String fileName2="/Cards/qc.gif";
		Card y = new Card(12, "Club",fileName2);
//		HomeCellSpider a = new HomeCellSpider(y);
//		assertEquals( false, a.addCard(a,y,x) );
	}
	
	/*
	 * TABLEAU PILE TESTS
	 */
	@Test
	public void createPilesTest() {  
		LittleSpider game = new LittleSpider();
		assertEquals(8, game.tableauPiles.size()); 
		
	}
	
	@Test
	public void tableauRemoveCardTest() {  
		String fileName1="/Cards/kc.gif";
		Card xx = new Card(13, "Club",fileName1);
//		TableauPile x = new TableauPile(xx);
//		assertEquals(true, x.removeCard(x,xx)); 
		}
	
	
	@Test
	public void tableauAddCardTest() {  
		String fileName1="/Cards/5d.gif";
		Card yy = new Card(5, "Diamond",fileName1);//top card of tableauPile x
//		TableauPile x = new TableauPile(yy);
		String fileName2="/Cards/6d.gif";
		Card xx = new Card(6, "Diamond",fileName2);// card to be added
		
//		assertEquals(true, x.addCard(x,yy,xx)); 
		}   
	
	

	
}