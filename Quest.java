import java.util.Random;

/**
 * Contains all methods any quest should contain, except the
 * generateRandomEvents() method, which is quest specific.
 * @author mbl80_000
 *
 */
public abstract class Quest implements QuestProperties, Task{

	public static final int TASK_TIME_RANGE = 100;
	public static final double TICK_CHANCE = 0.3;

	protected static Random random = new Random();

	protected String questName;
	protected String infoString;

	protected long streetCredGain;
	protected int workCredCost;
	protected int workCredGain;
	protected int healthCost;
	protected int healthGain;
	protected int timeToComplete;
	private boolean hasTick;

	/**
	 * Resets the payoffs and the length of time the quest takes to
	 * complete.  Allows reseting and reusing a quest instead of
	 * creating new objects.
	 */
	protected void resetQuest(){
		streetCredGain = 0L;
		workCredGain = 0;
		workCredCost = 0;
		healthCost = 0;
		healthGain = 0;
		timeToComplete = MIN_TASK_TIME + random.nextInt(TASK_TIME_RANGE);
		infoString = "";
		if (random.nextDouble() <= TICK_CHANCE)
			hasTick = true;
	}

	/**
	 * Constructor.
	 */
	public Quest(int skillLevel) {
		resetQuest();
		generateRandomEvents(skillLevel);
	}

	public String getInfoString() {
		return infoString;
	}

	public long getStreetCredGain() {
		return streetCredGain;
	}

	public int getWorkCredCost() {
		return workCredCost;
	}

	public int getWorkCredGain() {
		return workCredGain;
	}

	public int getHealthCost() {
		return healthCost;
	}

	public int getHealthGain() {
		return healthGain;
	}

	public int getTimeToComplete() {
		return timeToComplete;
	}

	public boolean hasTick() {
		return hasTick;
	}
}
