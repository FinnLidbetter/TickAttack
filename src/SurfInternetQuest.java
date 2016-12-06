/**
 * Specific type of quest pertaining to a dialog/story-advancement type of quest.
 * @author Patrick Coyle
 *
 */


public class SurfInternetQuest extends Quest {
	

	/**
	 * Constructor. Generates a quest with the given skill level.
	 */

	public SurfInternetQuest(int skillLevel){
		super(skillLevel);
		infoString = "Performing Surf Internet Quest! \n";
		this.timeToComplete = 75;
		//required for the dialog quest to work.
		this.questName = "Surf Internet";
	}
		
	public boolean canPerformQuest(int currentWorkCred) {
		return true;
	}

	// A bit strange, but since this quest has no random events, but I must implement this, so it only has
	// resetQuest, as in every other quest
	@Override
	public void generateRandomEvents() {
		resetQuest();
		hasTick = false;
		workCredGain = 1000;
		streetCredGain = 1000;
	}
}
