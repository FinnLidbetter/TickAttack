import java.util.Collection;
import java.util.Random;

public class TickSearch implements Task{
	
	private static Random random;

	private int timeToComplete;
	private static final double BASE_REMOVE_TICK_CHANCE = 0.3;
	private static final double TICK_TEST_EXTRA_REMOVAL_CHANCE = 0.4;
	
	public TickSearch(){
		timeToComplete = MIN_TASK_TIME;
	}
	
	public int getTimeToComplete() {
		return timeToComplete;
	}

	public void attemptRemovingTicks(Collection<Tick> ticks, boolean usingTickTest){
		for (Tick tick: ticks){
			double removalChance = tick.engorgedSize() + BASE_REMOVE_TICK_CHANCE;
			if (usingTickTest){
				tick.makeVisible();
				removalChance += TICK_TEST_EXTRA_REMOVAL_CHANCE;
			}
			if (random.nextDouble() <= removalChance)
				ticks.remove(tick);
		}
	}
}
