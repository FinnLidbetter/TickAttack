import java.util.ArrayList;
import java.util.Random;

/**
 * Task for performing a tick search.
 *
 */
public class TickSearch implements Task{
	
	private static Random random = new Random();

	private int timeToComplete;
	protected static final double BASE_REMOVE_TICK_CHANCE = 0.3;
	protected static final double TICK_TEST_EXTRA_REMOVAL_CHANCE = 0.4;
	
	/**
	 * Constructor.
	 */
	public TickSearch(){
		timeToComplete = MIN_TASK_TIME;
	}
	
	public int getTimeToComplete() {
		return timeToComplete;
	}

	/**
	 * Attempts removing all the ticks in the ticks Collection.  If usingTickTest
	 * is true, sets all ticks to Visisble and the probability of removing them increases.
	 * @param ticks
	 * @param usingTickTest
	 */
	public void attemptRemovingTicks(ArrayList<Tick> ticks, boolean usingTickTest){
		Tick tick;
		for (int i = 0; i < ticks.size(); i++){
			tick = ticks.get(i);
			double removalChance = tick.engorgedSize() + BASE_REMOVE_TICK_CHANCE;
			if (usingTickTest){
				tick.makeVisible();
				removalChance += TICK_TEST_EXTRA_REMOVAL_CHANCE;
			}
			if (random.nextDouble() <= removalChance){
				ticks.remove(i);
				i--;
			}
		}
	}
}
