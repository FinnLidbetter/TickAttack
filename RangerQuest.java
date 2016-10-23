
public class RangerQuest extends Quest{

	private static final int MAX_WORKCRED_MULTIPLIER = 10;
	private static final double RESCUE_HIKERS_CHANCE = 0.4;
	private static final double RESCUE_HIKERS_MAX_WORKCRED_BONUS = 0.8;
	private static final double MEDICINAL_HERBS_CHANCE = 0.3;
	private static final int MEDICINAL_HERB_MAX_HEAL = 20;
	private static final double BEAR_CHANCE = 0.2;
	private static final int BEAR_MAX_DAMAGE = 30;
	
	public RangerQuest(){
		super();
	}
	public void generateRandomEvents(int skillLevel){
		resetQuest();
		timeToComplete = MIN_QUEST_TIME + random.nextInt(QUEST_TIME_RANGE);
		infoString = "Performing Ranger Quest! \n";
		workCredGain = random.nextInt(skillLevel*MAX_WORKCRED_MULTIPLIER);
		foundHiker();
		foundMedicinalHerbs();
		foundBear();
	}

	private void foundBear(){
		if (random.nextDouble() <= BEAR_CHANCE){
			int damageTaken = random.nextInt(BEAR_MAX_DAMAGE);
			healthCost = damageTaken;
			infoString += "Found a bear! Lost " + damageTaken + " health in the fight!\n"; 
		}
	}
	
	private void foundMedicinalHerbs(){
		if (random.nextDouble() <= MEDICINAL_HERBS_CHANCE){
			int healthHealed = random.nextInt(MEDICINAL_HERB_MAX_HEAL);
			healthGain = healthHealed;
			infoString += "Found some medicinal herbs! Recovered " + healthHealed + " health!\n";
		}
	}
	
	private void foundHiker(){
		if (random.nextDouble() <= RESCUE_HIKERS_CHANCE){
			int extraWorkCred = random.nextInt((int)(workCredGain*RESCUE_HIKERS_MAX_WORKCRED_BONUS));
			workCredGain += extraWorkCred;
			infoString += "Found and rescued a hiker! Bonus of " + extraWorkCred + " workCred!";
		}
	}
	
	public boolean canPerformQuest(int currentWorkCred){
		return true;
	}
}
