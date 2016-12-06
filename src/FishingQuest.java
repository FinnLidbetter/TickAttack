/**
 * Specific type of quest pertaining to fishing.
 * @author Finn Lidbetter, Michael Bradet-Legris
 *
 */
public class FishingQuest extends Quest {

	protected static final int WORKCRED_COST = 20;

	protected static final double FISH_CHANCE = 0.7;
	protected static final double FISH_IS_BIG_CHANCE = 0.3;
	protected static final double NESSY_CHANCE = 0.03;
	protected static final long REGULAR_FISH_MAX_STREETCRED_MULTIPLIER = 100;
	protected static final long BIG_FISH_MAX_STREETCRED_MULTIPLIER = 500;
	protected static final long NESSY_MAX_STREETCRED_MULTIPLIER = 10000;

	/**
	 * Constructor. Generates a quest with the given skill level.
	 */
	public FishingQuest(int skillLevel) {
		super(skillLevel);
		infoString += "Took some time off to go fishing! (-" + WORKCRED_COST
				+ " workCred)\n";
		workCredCost = WORKCRED_COST;
	}

	public void generateRandomEvents() {
		resetQuest();
		int multiplier = Math.round((1.0F * timeToComplete) / MIN_TASK_TIME);
		fish(skillLevel, multiplier);
		nessy(skillLevel, multiplier);
	}

	/**
	 * Gives additional payoffs to the player depending on how many fish are
	 * caught. Number of fish caught is partially random, but increases if the
	 * multiplier increases. Payoffs are partially random, but increase if more
	 * fish are caught and if the player has a higher skill level.
	 *
	 * @param skillLevel
	 *            player's skill level.
	 * @param multiplier
	 *            increases chance of catching fish.
	 */
	protected void fish(int skillLevel, int multiplier) {
		int numRegFishes = 0;
		int numBigFishes = 0;
		int chancesLeft = multiplier;
		while (chancesLeft > 0) {
			if (random.nextDouble() <= FISH_CHANCE) {
				if (random.nextDouble() <= FISH_IS_BIG_CHANCE)
					numBigFishes++;
				else
					numRegFishes++;
			} else
				chancesLeft--;
		}
		if (numRegFishes == 0 && numBigFishes == 0) {
			infoString += "Oh no! Looks like today was bad for fishing! \n";
			return;
		}
		infoString += "Pulled some nice fish! " + numRegFishes
				+ " regular fish and " + numBigFishes + " big fish!\n";

		if (numRegFishes > 0)
			streetCredGain += Math.abs(random.nextLong()) % (numRegFishes * REGULAR_FISH_MAX_STREETCRED_MULTIPLIER * skillLevel);
		if (numBigFishes > 0)
			streetCredGain += Math.abs(random.nextLong()) % (numBigFishes * BIG_FISH_MAX_STREETCRED_MULTIPLIER * skillLevel);

		infoString += "Got meself a hefty " + streetCredGain
				+ " streetCred by selling 'em!\n";
	}

	/**
	 * Gives additional payoffs to the player depending on if he catches the
	 * Loch Ness Monster.  The payoff is partially random but also increases with
	 * the user's skillLevel.  The chance to catch Nessy is random, but increases
	 * with the multiplier.
	 *
	 * @param skillLevel
	 *            player's skill level.
	 * @param multiplier
	 *            increases chance of catching Nessy.
	 */
	protected boolean nessy(int skillLevel, int multiplier) {
		int chances = multiplier;
		while (chances > 0){
			if (random.nextDouble() <= NESSY_CHANCE) {
				long bonus = Math.abs(random.nextLong())
						% (skillLevel * NESSY_MAX_STREETCRED_MULTIPLIER);
				infoString += "Woah! Looks like I pulled Nessy! Bonus of " + bonus
					+ " streetCred!\n";
				streetCredGain += bonus;
				return true;
			}
			else
				chances--;
		}
		return false;
	}

	public boolean canPerformQuest(int currentWorkCred) {
		if (currentWorkCred < WORKCRED_COST)
			return false;
		return true;
	}
}
