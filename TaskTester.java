import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TaskTester {
	
	double avgMultiplier;
	@Before
	public void setUp() throws Exception {
		avgMultiplier = 0;
		for (int i = Task.MIN_TASK_TIME; i <= Quest.TASK_TIME_RANGE+Task.MIN_TASK_TIME; i++){
			avgMultiplier += Math.round(i*1.0/Quest.MIN_TASK_TIME);
		}
		avgMultiplier /= (Quest.TASK_TIME_RANGE +1.0);
	}
	@Test
	public void testTimeRandomizes() {
		double time = 0;
		for (int i = 0; i < 1000; i++){
			Task quest = new RangerQuest();
			Task quest2 = new FishingQuest();
			time += quest.getTimeToComplete();
			time += quest2.getTimeToComplete();
		}
		time /= 2000.0;
		double avgTime = Task.MIN_TASK_TIME + (Quest.TASK_TIME_RANGE)/2.0;
		assertTrue(time < avgTime*1.1);
		assertTrue(time > avgTime*0.9);
	}
	
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
		
		for (Tick tick : ticks)
			assertTrue(tick.isVisible());
	}
	
	@Test
	public void testEngorgedTickSearch(){
		ArrayList<Tick> ticks = new ArrayList<Tick>();
		for (int i = 0; i< 3000; i++){
			Tick tick = new Tick();
			for (int j = 0; j < 200; j++)
				tick.suckBlood();
			ticks.add(tick);
		}
		TickSearch tickSearch = new TickSearch();
		tickSearch.attemptRemovingTicks(ticks, false);
		double predictedTicks = 3000*(1-TickSearch.BASE_REMOVE_TICK_CHANCE-Tick.GROWTH_RATE*200);
		assertTrue(ticks.size() > predictedTicks*0.9);
		assertTrue(ticks.size() < predictedTicks*1.1);
	}
	
	@Test
	public void testNessy(){
		FishingQuest f = new FishingQuest();
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
	
	@Test
	public void testFish(){
		FishingQuest f = new FishingQuest();
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
	
	@Test
	public void testFoundBear(){
		RangerQuest quest = new RangerQuest();
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
	
	@Test
	public void testFoundMedicinalHerb(){
		RangerQuest quest = new RangerQuest();
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
}
