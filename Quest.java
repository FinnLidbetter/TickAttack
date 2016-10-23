import java.util.Random;

public abstract class Quest implements QuestProperties, Task{

	public static final int TASK_TIME_RANGE = 100;
	public static final double TICK_CHANCE = 0.3;
	
	protected static Random random;
	
	protected String questName;
	protected String infoString;
	
	protected long streetCredGain;
	protected int workCredCost;
	protected int workCredGain;
	protected int healthCost;
	protected int healthGain;
	protected int timeToComplete;
	private boolean hasTick;
	
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
	public Quest(){
		resetQuest();
		generateRandomEvents(1);
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
