public class RangerQuest extends Quest {

	private static final int MAX_WORKCRED_MULTIPLIER = 10;
	private static final double RESCUE_HIKERS_CHANCE = 0.1;
	private static final double RESCUE_HIKERS_MAX_WORKCRED_BONUS = 0.8;
	private static final double MEDICINAL_HERBS_CHANCE = 0.075;
	private static final int MEDICINAL_HERB_MAX_HEAL = 20;
	private static final double BEAR_CHANCE = 0.05;
	private static final int BEAR_MAX_DAMAGE = 30;

	/**
	 * Constructor. Generates a quest with assumed skill level of 1.
	 */
	public RangerQuest(){
		super();
	}

	public void generateRandomEvents(int skillLevel) {
		resetQuest();
		int multiplier = Math.round((1.0F * timeToComplete) / MIN_TASK_TIME);
		infoString = "Performing Ranger Quest! \n";
		workCredGain = random.nextInt(skillLevel * MAX_WORKCRED_MULTIPLIER
				* multiplier) + 1;
		foundHiker(multiplier);
		foundMedicinalHerbs(multiplier);
		foundBear(multiplier);
	}

	/**
	 * Has a chance of finding a bear. The chance of finding a bear increases
	 * with the multiplier, and the damage taken is between 0 and
	 * BEAR_MAX_DAMAGE.
	 * 
	 * @param multiplier
	 *            increases chances of event happening.
	 */
	protected void foundBear(int multiplier) {
		if (random.nextDouble() <= 1 - Math.pow(1-BEAR_CHANCE, multiplier)) {
			int damageTaken = random.nextInt(BEAR_MAX_DAMAGE);
			healthCost = damageTaken;
			infoString += "Found a bear! Lost " + damageTaken
					+ " health in the fight!\n";
		}
	}

	/**
	 * Has a chance of finding medicinal herbs. The chance of finding them
	 * increases with the multiplier, and the health healed is between 0 and
	 * MEDICINAL_HERBS_MAX_HEAL.
	 * 
	 * @param multiplier
	 *            increases chances of event happening.
	 */
	protected void foundMedicinalHerbs(int multiplier) {
		if (random.nextDouble() <= 1 - Math.pow(1-MEDICINAL_HERBS_CHANCE, multiplier)) {
			int healthHealed = random.nextInt(MEDICINAL_HERB_MAX_HEAL);
			healthGain = healthHealed;
			infoString += "Found some medicinal herbs! Recovered "
					+ healthHealed + " health!\n";
		}
	}

	/**
	 * Has a chance of finding (and rescuing) an Hiker. The chance of finding a
	 * hiker increases with the multiplier. The user's payoff for this quest is
	 * increased by a percentage between 0 and RESCUE_HIKERS_MAX_WORKCRED_BONUS
	 * if a hiker is rescued.
	 * 
	 * @param multiplier
	 */
	protected void foundHiker(int multiplier) {
		if (random.nextDouble() <= 1 - Math.pow(1-RESCUE_HIKERS_CHANCE, multiplier)) {
			int extraWorkCred = random
					.nextInt((int)Math.max(1,(Math.round(workCredGain * RESCUE_HIKERS_MAX_WORKCRED_BONUS))));
			workCredGain += extraWorkCred;
			infoString += "Found and rescued a hiker! Bonus of "
					+ extraWorkCred + " workCred!";
		}
	}

	public boolean canPerformQuest(int currentWorkCred) {
		return true;
	}
}
