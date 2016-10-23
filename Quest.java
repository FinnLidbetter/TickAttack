import java.util.Random;

public abstract class Quest implements QuestProperties{

	public static final int MIN_QUEST_TIME = 20;
	public static final int QUEST_TIME_RANGE = 100;
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
		streetCredGain = 0;
		workCredGain = 0;
		healthCost = 0;
		healthGain = 0;
		timeToComplete = MIN_QUEST_TIME;
		infoString = "";
		if (random.nextDouble() <= TICK_CHANCE)
			hasTick = true;
	}
	public Quest(){
		resetQuest();
		generateRandomEvents(1);
	}
	public String getQuestName() {
		return questName;
	}
	public void setQuestName(String questName) {
		this.questName = questName;
	}
	public String getInfoString() {
		return infoString;
	}
	public void setInfoString(String infoString) {
		this.infoString = infoString;
	}
	public long getStreetCredGain() {
		return streetCredGain;
	}
	public void setStreetCredGain(long streetCredGain) {
		this.streetCredGain = streetCredGain;
	}
	public int getWorkCredCost() {
		return workCredCost;
	}
	public void setWorkCredCost(int workCredCost) {
		this.workCredCost = workCredCost;
	}
	public int getWorkCredGain() {
		return workCredGain;
	}
	public void setWorkCredGain(int workCredGain) {
		this.workCredGain = workCredGain;
	}
	public int getHealthCost() {
		return healthCost;
	}
	public void setHealthCost(int healthCost) {
		this.healthCost = healthCost;
	}
	public int getHealthGain() {
		return healthGain;
	}
	public void setHealthGain(int healthGain) {
		this.healthGain = healthGain;
	}
	public int getTimeToComplete() {
		return timeToComplete;
	}
	public void setTimeToComplete(int timeToComplete) {
		this.timeToComplete = timeToComplete;
	}
	public boolean hasTick() {
		return hasTick;
	}
}
