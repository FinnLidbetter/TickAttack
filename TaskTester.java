import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
/**
 * Test suite to test every class that implements the Task interface.  Note
 * that since in general Tasks have randomized completion times and the payoffs 
 * are proportional to the completion time, every test case is a probabilistic 
 * test.  Thus, if one test fails but passes multiple times afterwards when the
 * test suite is ran again, the functionality probably still works. 
 *
 */
public class TaskTester {
	
	/**
	 * Checks if removing ticks are removed with the correct chance
	 * when performing a tick search.
	 */
	@Test
	public void testTickSearch(){
		ArrayList<Tick> ticks = new ArrayList<Tick>();
		for (int i = 0; i < 3000; i++)
			ticks.add(new Tick());
		TickSearch tickSearch = new TickSearch();
		tickSearch.attemptRemovingTicks(ticks, false);

		double predictedTicks = 3000*(1-TickSearch.BASE_REMOVE_TICK_CHANCE);
		assertTrue(ticks.size() > predictedTicks*0.9);
		assertTrue(ticks.size() < predictedTicks*1.1);
	}

	/**
	 * Checks that using a tick test with a tick search correctly
	 * increases the chances of ticks being removed.
	 */
	@Test
	public void testTickSearchWithTickTest(){
		ArrayList<Tick> ticks = new ArrayList<Tick>();
		for (int i = 0; i < 3000; i++)
			ticks.add(new Tick());
		TickSearch tickSearch = new TickSearch();
		tickSearch.attemptRemovingTicks(ticks, true);

		double predictedTicks = 3000*(1-TickSearch.BASE_REMOVE_TICK_CHANCE-TickSearch.TICK_TEST_EXTRA_REMOVAL_CHANCE);
		assertTrue(ticks.size() > predictedTicks*0.9);
		assertTrue(ticks.size() < predictedTicks*1.1);
	}

	/**
	 * Checks that "more engorged" ticks are removed with a higher probability
	 * than than ticks that are not engorged. 
	 */
	@Test
	public void testEngorgedTickSearch(){
		ArrayList<Tick> ticks = new ArrayList<Tick>();
		for (int i = 0; i< 10000; i++){
			Tick tick = new Tick();
			for (int j = 0; j < 200; j++)
				tick.suckBlood();
			ticks.add(tick);
		}
		TickSearch tickSearch = new TickSearch();
		tickSearch.attemptRemovingTicks(ticks, false);
		double predictedTicks = 10000*(1-TickSearch.BASE_REMOVE_TICK_CHANCE-Tick.GROWTH_RATE*200);
		assertTrue(ticks.size() > predictedTicks*0.9);
		assertTrue(ticks.size() < predictedTicks*1.1);
	}

	/**
	 * Checks that the time to complete a quest (fishing or ranger) correctly
	 * randomizes within a certain range.
	 */
	@Test
	public void testTimeRandomizes() {
		double time = 0;
		for (int i = 0; i < 1000; i++){
			Task quest = new RangerQuest(1);
			Task quest2 = new FishingQuest(1);
			time += quest.getTimeToComplete();
			time += quest2.getTimeToComplete();
		}
		time /= 2000.0;
		double avgTime = Task.MIN_TASK_TIME + (Quest.TASK_TIME_RANGE)/2.0;
		assertTrue(time < avgTime*1.1);
		assertTrue(time > avgTime*0.9);
	}

	/**
	 * Checks that increasing the multiplier for the method nessy() has the
	 * desired effect.
	 */
	@Test
	public void testNessyMultiplier(){
		FishingQuest f = new FishingQuest(1);
		long payoff1 = 0;
		long payoff2 = 0;
		for (int i = 0; i < 100000;i++){
			f.resetQuest();
			if (f.nessy(1,1)){
				payoff1 += f.getStreetCredGain();
			}
			f.resetQuest();
			if (f.nessy(1,2)){
				payoff2 += f.getStreetCredGain();
			}
		}
		assertTrue(2*payoff1 < 1.1*payoff2);
		assertTrue(2*payoff1 > 0.9*payoff2);
	}
	
	/**
	 * Checks that increasing the skillLevel for the method nessy() has the
	 * desired effect.
	 */
	@Test
	public void testNessySkillLevel(){
		FishingQuest f = new FishingQuest(1);
		long payoff1 = 0;
		long payoff2 = 0;
		for (int i = 0; i < 100000;i++){
			f.resetQuest();
			if (f.nessy(1,1)){
				payoff1 += f.getStreetCredGain();
			}
			f.resetQuest();
			if (f.nessy(2,1)){
				payoff2 += f.getStreetCredGain();
			}
		}
		assertTrue(2*payoff1 < 1.1*payoff2);
		assertTrue(2*payoff1 > 0.9*payoff2);
	}

	/**
	 * Checks that increasing the multiplier for the method fish() has the
	 * desired effect.
	 */
	@Test
	public void testFishMultiplier(){
		FishingQuest f = new FishingQuest(1);
		long streetCredMultiplier2 = 0;
		long streetCredMultiplier4 = 0;
		for (int i = 0; i < 100000; i++){
			f.resetQuest();
			f.fish(1,2);
			streetCredMultiplier2 += f.getStreetCredGain();
			f.resetQuest();
			f.fish(1, 4);
			streetCredMultiplier4 += f.getStreetCredGain();
		}
		assertTrue(2*streetCredMultiplier2 < 1.1*streetCredMultiplier4);
		assertTrue(2*streetCredMultiplier2 > 0.9*streetCredMultiplier4);
	}
	
	/**
	 * Checks that increasing the skillLevel for the method fish() has the
	 * desired effect.
	 */
	@Test
	public void testFishSkillLevel(){
		FishingQuest f = new FishingQuest(1);
		long streetCredMultiplier2 = 0;
		long streetCredMultiplier4 = 0;
		for (int i = 0; i < 100000; i++){
			f.resetQuest();
			f.fish(2,1);
			streetCredMultiplier2 += f.getStreetCredGain();
			f.resetQuest();
			f.fish(4,1);
			streetCredMultiplier4 += f.getStreetCredGain();
		}
		assertTrue(2*streetCredMultiplier2 < 1.1*streetCredMultiplier4);
		assertTrue(2*streetCredMultiplier2 > 0.9*streetCredMultiplier4);
	}

	/**
	 * Checks that increasing the multiplier for the method foundBear()
	 * has the desired effect.
	 */
	@Test
	public void testFoundBearMultiplier(){
		RangerQuest quest = new RangerQuest(1);
		int healthLostMultiplier2 = 0;
		int healthLostMultiplier4 = 0;
		for (int i = 0; i < 100000; i++){
			quest.resetQuest();
			quest.foundBear(2);
			healthLostMultiplier2 += quest.getHealthCost();
			quest.resetQuest();
			quest.foundBear(4);
			healthLostMultiplier4 += quest.getHealthCost();
		}
		assertTrue(2*healthLostMultiplier2 < 1.1*healthLostMultiplier4);
		assertTrue(2*healthLostMultiplier2 > 0.9*healthLostMultiplier4);
	}

	/**
	 * Checks that increasing the multiplier for the method foundMedicinalHerbs()
	 * has the desired effect.
	 */
	@Test
	public void testFoundMedicinalHerbMultiplier(){
		RangerQuest quest = new RangerQuest(1);
		int healthGainMultiplier2 = 0;
		int healthGainMultiplier4 = 0;
		for (int i = 0; i < 100000; i++){
			quest.resetQuest();
			quest.foundMedicinalHerbs(2);
			healthGainMultiplier2 += quest.getHealthGain();
			quest.resetQuest();
			quest.foundMedicinalHerbs(4);
			healthGainMultiplier4 += quest.getHealthGain();
		}
		assertTrue(2*healthGainMultiplier2 < 1.1*healthGainMultiplier4);
		assertTrue(2*healthGainMultiplier2 > 0.9*healthGainMultiplier4);
	}
	
	/**
	 * Checks that increasing the multiplier for the method foundHiker()
	 * has the desired effect.
	 */
	@Test
	public void testFoundHikerMultiplier(){
		RangerQuest quest = new RangerQuest(1);
		int workCredBonusMultiplier2 = 0;
		int workCredBonusMultiplier4 = 0;
		int regWorkCred = 0;
		for (int i = 0; i < 100000; i++){
			quest.resetQuest();
			quest.generateRandomEvents();
			regWorkCred += quest.getWorkCredGain();
			quest.foundHiker(2);
			workCredBonusMultiplier2 += quest.getWorkCredGain();
			quest.resetQuest();
			quest.generateRandomEvents();
			quest.foundHiker(4);
			workCredBonusMultiplier4 += quest.getWorkCredGain();
		}
		assertTrue(2.0*(workCredBonusMultiplier2 - regWorkCred) < 1.1*(workCredBonusMultiplier4 - regWorkCred));
		assertTrue(2.0*(workCredBonusMultiplier2 - regWorkCred) > 0.9*(workCredBonusMultiplier4 - regWorkCred));
	}
	
	/**
	 * Checks that generateRandomEvents() method works properly for the 
	 * RangerQuest class.  Note that this method calls methods that were
	 * previously tested above.
	 */
	@Test
	public void testRangerGenerateRandomEvents(){
		RangerQuest quest1 = new RangerQuest(3);
		RangerQuest quest2 = new RangerQuest(6);
		int workCred1 = 0;
		int workCred2 = 0;
		int healthGain1 = 0;
		int healthGain2 = 0;
		int healthCost1 = 0;
		int healthCost2 = 0;
		
		for(int i = 0; i < 10000; i++){
			quest1.resetQuest();
			quest1.generateRandomEvents();
			workCred1 += quest1.getWorkCredGain();
			healthGain1 += quest1.getHealthGain();
			healthCost1 += quest1.getHealthCost();
			quest2.resetQuest();
			quest2.generateRandomEvents();
			workCred2 += quest2.getWorkCredGain();
			healthGain2 += quest2.getHealthGain();
			healthCost2 += quest2.getHealthCost();
		}
		
		assertTrue(2.0*workCred1 > 0.9*workCred2);
		assertTrue(2.0*workCred1 < 1.1*workCred2);
		//SkillLevel has no effect on chance of finding bears/medicinal herbs or their benefits.
		assertTrue(healthGain1 > 0.9*healthGain2);
		assertTrue(healthGain1 < 1.1*healthGain2);
		assertTrue(healthCost1 > 0.9*healthCost2);
		assertTrue(healthCost1 > 0.9*healthCost2);
	}
	
	/**
	 * Checks that generateRandomEvents() method works properly for the 
	 * FishingQuest class.  Note that this method calls methods that were
	 * previously tested above.
	 */
	@Test public void testFishingQuest(){
		FishingQuest quest1 = new FishingQuest(3);
		FishingQuest quest2 = new FishingQuest(6);
		long streetCredGain1 = 0;
		long streetCredGain2 = 0;
		
		for (int i = 0; i < 10000; i++){
			quest1.resetQuest();
			quest1.generateRandomEvents();
			streetCredGain1 += quest1.getStreetCredGain();
			quest2.resetQuest();
			quest2.generateRandomEvents();
			streetCredGain2 += quest2.getStreetCredGain();
		}
		
		assertTrue(2.0*streetCredGain1 > 0.9*streetCredGain2);
		assertTrue(2.0*streetCredGain1 < 1.1*streetCredGain2);
	}
}
