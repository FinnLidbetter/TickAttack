/**
 * Specific type of quest pertaining to a dialog/story-advancement type of quest.
 * @author Patrick Coyle
 *
 */


public class SurfInternetQuest extends Quest {

	protected static final int MAX_WORKCRED_MULTIPLIER = 10;
	

	/**
	 * Constructor. Generates a quest with the given skill level.
	 */

	public SurfInternetQuest(int skillLevel){
		super(skillLevel);
		infoString = "Performing Surf Internet Quest! \n";
		this.timeToComplete = 75;
	}
	
	public void startDialog(Controller cont){
		this.questName = "Surf Internet";
		this.cont = cont;
		readFile();
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
		workCredGain = 20;
		streetCredGain = 50;
	}
}
