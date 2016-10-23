public class FishingQuest extends Quest {

	private static final int WORKCRED_COST = 15;

	private static final double FISH_CHANCE = 0.9;
	private static final double BIG_FISH_CHANCE = 0.3;
	private static final double NESSY_CHANCE = 0.1;
	private static final int REGULAR_FISH_MAX_STREETCRED_MULTIPLIER = 100;
	private static final int BIG_FISH_MAX_STREETCRED_MULTIPLIER = 500;
	private static final int NESSY_MAX_STREETCRED_MULTIPLIER = 10000;

	public FishingQuest(){
		super();
	}
	
	public void generateRandomEvents(int skillLevel) {
		resetQuest();
		timeToComplete = MIN_QUEST_TIME + random.nextInt(QUEST_TIME_RANGE);
		infoString += "Took some time off to go fishing! (-" + WORKCRED_COST + " workCred)\n";
		workCredCost = 15;
		fish(skillLevel);
		nessy(skillLevel);
	}

	public void fish(int skillLevel) {
		int numRegFishes = 0;
		int numBigFishes = 0;
		while (random.nextDouble() <= FISH_CHANCE) {
			if (random.nextDouble() <= BIG_FISH_CHANCE)
				numBigFishes++;
			else
				numRegFishes++;
		}
		if (numRegFishes == 0 && numBigFishes == 0) {
			infoString += "Oh no! Looks like today was bad for fishing! \n";
			return;
		}
		infoString += "Pulled some nice fish! " + numRegFishes
				+ " regular fish and " + numBigFishes + "big fish!\n";
		
		streetCredGain +=  random.nextInt(numRegFishes*REGULAR_FISH_MAX_STREETCRED_MULTIPLIER*skillLevel);
		streetCredGain +=  random.nextInt(numBigFishes*BIG_FISH_MAX_STREETCRED_MULTIPLIER*skillLevel);
		
		infoString += "Got meself a hefty " + streetCredGain + " streetCred by selling 'em!\n";
	}
	
	public void nessy(int skillLevel){
		if (random.nextDouble() <= NESSY_CHANCE){
			int bonus = random.nextInt(skillLevel*NESSY_MAX_STREETCRED_MULTIPLIER);
			infoString += "Woah! Looks like I pulled Nessy! Bonus of " + bonus + " streetCred!\n";
			streetCredGain += bonus;
		}
	}
	
	public boolean canPerformQuest(int currentWorkCred){
		if (currentWorkCred < WORKCRED_COST)
			return false;
		return true;
	}
}
