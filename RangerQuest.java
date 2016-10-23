
public class RangerQuest extends Quest{

	private static final int MAX_WORKCRED_MULTIPLIER = 10;
	private static final double RESCUE_HIKERS_CHANCE = 0.1;
	private static final double RESCUE_HIKERS_MAX_WORKCRED_BONUS = 0.8;
	private static final double MEDICINAL_HERBS_CHANCE = 0.075;
	private static final int MEDICINAL_HERB_MAX_HEAL = 20;
	private static final double BEAR_CHANCE = 0.05;
	private static final int BEAR_MAX_DAMAGE = 30;
	
	public RangerQuest(){
		super();
	}
	
	public void generateRandomEvents(int skillLevel){
		resetQuest();
		int multiplier = Math.round((1.0F*timeToComplete)/MIN_TASK_TIME);
		infoString = "Performing Ranger Quest! \n";
		workCredGain = random.nextInt(skillLevel*MAX_WORKCRED_MULTIPLIER*multiplier);
		foundHiker(multiplier);
		foundMedicinalHerbs(multiplier);
		foundBear(multiplier);
	}

	private void foundBear(int multiplier){
		if (random.nextDouble() <= multiplier*BEAR_CHANCE){
			int damageTaken = random.nextInt(BEAR_MAX_DAMAGE);
			healthCost = damageTaken;
			infoString += "Found a bear! Lost " + damageTaken + " health in the fight!\n"; 
		}
	}
	
	private void foundMedicinalHerbs(int multiplier){
		if (random.nextDouble() <= multiplier*MEDICINAL_HERBS_CHANCE){
			int healthHealed = random.nextInt(MEDICINAL_HERB_MAX_HEAL);
			healthGain = healthHealed;
			infoString += "Found some medicinal herbs! Recovered " + healthHealed + " health!\n";
		}
	}
	
	private void foundHiker(int multiplier){
		if (random.nextDouble() <= multiplier*RESCUE_HIKERS_CHANCE){
			int extraWorkCred = random.nextInt((int)(workCredGain*RESCUE_HIKERS_MAX_WORKCRED_BONUS));
			workCredGain += extraWorkCred;
			infoString += "Found and rescued a hiker! Bonus of " + extraWorkCred + " workCred!";
		}
	}
	
	public boolean canPerformQuest(int currentWorkCred){
		return true;
	}
}
