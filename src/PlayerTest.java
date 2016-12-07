import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Patrick Coyle & Finn Lidbetter
 *
 */

public class PlayerTest {
	Player p1;
	Item meds;
	Item antiBio;
	Item eyeOfNewt;
	Item potionBook;
	Item eyeOfNewt2;
	Item tickLegs;
	Item tickTest;
	Item rangerPotion;
	Item fishingPotion;
	Item fusionPotion;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Player();
		meds = ItemFactory.createCheapMeds(true);
		antiBio = ItemFactory.createAntibiotics(true);
		eyeOfNewt = ItemFactory.createEyeOfNewt(true);
		potionBook = ItemFactory.createPotionBook(true);
		eyeOfNewt2 = ItemFactory.createEyeOfNewt(true);
		tickLegs = ItemFactory.createTickLegs(true);
		tickTest = ItemFactory.createTickTest(true);
		rangerPotion = ItemFactory.createRangerPotion(true);
		fishingPotion = ItemFactory.createFishingPotion(true);
		fusionPotion = ItemFactory.createFusionPotion(true);
	}
	@Test
	public void addRemoveItemTest(){
		//add test
		p1.addItem(eyeOfNewt);
		p1.addItem(eyeOfNewt2);
		p1.addItem(potionBook);
		assertEquals(p1.inventory.get(0), eyeOfNewt);
		assertEquals(p1.inventory.get(1), eyeOfNewt2);
		assertEquals(p1.inventory.get(2), potionBook);
		//remove test
		p1.removeItem("Eye of Newt", 1);
		assertEquals(p1.inventory.size(), 2);
		p1.removeItem("Book of Potions", 1);
		assertEquals(p1.inventory.size(), 1);
		p1.addItem(eyeOfNewt);
		p1.removeItem("Eye of Newt", 2);
		assertEquals(p1.inventory.size(), 0);
	}
	
	@Test
	public void useItemTest() {
		//med HP test
		p1.adjustHealth(-50);
		p1.addItem(meds);
		p1.useItem("Cheap Meds");
		assertEquals(p1.getHealth(), 60, 0);
		//Antibiotics test
		p1.updateInfectionStage(1.0);
		p1.addItem(antiBio);
		p1.useItem("Antibiotics");
		assertEquals(p1.getInfectionStage(), 0.9, 0);
		//PotionBook
		p1.addItem(potionBook);
		//assertEquals(p1.useItem("Book of Potions"), true);
		//Test potions
		p1.addItem(fusionPotion);
		p1.addItem(rangerPotion);
		p1.addItem(fishingPotion);
		p1.useItem("Fishing Potion");
		p1.useItem("Ranger Potion");
		p1.useItem("Fusion Potion");
		assertEquals(p1.getFishingSkill(), 3);
		assertEquals(p1.getRangerSkill(), 3);
		assertEquals(p1.getHealth(), 80, 0);
		
		//Test using item you don't have
		assertEquals(p1.useItem("Eye of Newt"), false);
		//Test item with no effect
		p1.addItem(eyeOfNewt);
		assertEquals(p1.useItem("Eye of Newt"), true);
	}
	
	@Test
	public void testGetItemNum(){
		p1.addItem(eyeOfNewt);
		p1.addItem(eyeOfNewt2);
		p1.addItem(eyeOfNewt);
		p1.addItem(potionBook);
		assertEquals(p1.getItemNum("Eye of Newt"), 3);
		assertEquals(p1.getItemNum("Book of Potions"), 1);
		assertEquals(p1.getItemNum("Ranger Potion"), 0);
		p1.removeItem("Eye of Newt", 1);
		assertEquals(p1.getItemNum("Eye of Newt"), 2);
	}
	
	@Test
	public void testHasAllItems(){
		assertEquals(p1.hasAllItems(new String[] {}, new int[] {}), true);
		p1.addItem(eyeOfNewt);
		p1.addItem(eyeOfNewt2);
		p1.addItem(potionBook);
		p1.addItem(tickLegs);
		p1.addItem(tickLegs);
		p1.addItem(tickLegs);
		assertEquals(p1.hasAllItems(new String[] {"Eye of Newt", "Book of Potions", "Tick Legs"}, new int[] {2, 1, 3}), true);
		assertEquals(p1.hasAllItems(new String[] {"Ranger Potion"}, new int[] {2}), false);
		assertEquals(p1.hasAllItems(new String[] {"Ranger Potion"}, new int[] {0}), true);
		//Love potion does not exist!
		assertEquals(p1.hasAllItems(new String[] {"Love Potion"}, new int[] {0}), true);
		assertEquals(p1.hasAllItems(new String[] {"Love Potion"}, new int[] {1}), false);
	}
	
	@Test
	public void testGetItem(){
		p1.addItem(eyeOfNewt);
		assertFalse(p1.getItem("Eye of Newt").equals(eyeOfNewt2));
		assertTrue(p1.getItem("Eye of Newt").equals(eyeOfNewt));
		assertEquals(p1.getItem("Tick Legs"), null);
		//Love potion doesn't exist
		assertEquals(p1.getItem("Love Potion"), null);
	}

}
