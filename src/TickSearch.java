import java.util.ArrayList;
import java.util.Random;

/**
 * Task for performing a tick search.
 * @author Finn Lidbetter, Michael Bradet-Legris
 */
public class TickSearch implements Task{

	private static Random random = new Random();

	private String infoString;
	private int timeToComplete;
	private boolean usingTickTest;
	protected static final double BASE_REMOVE_TICK_CHANCE = 0.5;
	protected static final double TICK_TEST_EXTRA_REMOVAL_CHANCE = 0.4;


	/**
	 * Constructor.
	 */
	public TickSearch(){
		timeToComplete = MIN_TASK_TIME;
		if (usingTickTest)
			infoString = "Performing an improved tick search";
		else {
			infoString = "Performing a tick search";
		}
	}

	public int getTimeToComplete() {
		return timeToComplete;
	}

	/**
	 * Attempts removing all the ticks in the ticks Collection.  If usingTickTest
	 * is true, sets all ticks to Visible and the probability of removing them increases.
	 * @param ticks
	 * @param usingTickTest
	 */
	public void attemptRemovingTicks(ArrayList<Tick> ticks, boolean usingTickTest){
		Tick tick;
		int removedTicks = 0;
		for (int i = 0; i < ticks.size(); i++){
			tick = ticks.get(i);
			double removalChance = tick.engorgedSize() + BASE_REMOVE_TICK_CHANCE;
			if (usingTickTest){
				removalChance += TICK_TEST_EXTRA_REMOVAL_CHANCE;
			}
			if (random.nextDouble() <= removalChance){
				removedTicks++;
				ticks.remove(i);
				i--;
			}
		}
		if (removedTicks == 1)
			this.infoString = "Found 1 tick!";
		else
			this.infoString = "Found " + removedTicks + " ticks!";
	}

	@Override
	public String getInfoString() {
		return infoString;
	}
}
