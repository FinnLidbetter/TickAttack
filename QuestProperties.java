/**
 * Properties a Quest must contain pertaining to costs and payoffs.
 * @author Finn Lidbetter, Michael Bradet-Legris
 *
 */
public interface QuestProperties {

	/**
	 * Some sort of function that randomizes properties of the quest, generally
	 * the payoffs, in accordance with the user's skillLevel.
	 *
	 * @param skillLevel
	 *            Some sort of parameter which should increase the payoffs to
	 *            some extent if it is higher.
	 */
	public void generateRandomEvents();

	/**
	 * Returns true if player has enough workCred to perform this quest.
	 *
	 * @param currentWorkCred
	 *            is the player's current workCred.
	 * @return true if the quest can be performed.
	 */
	boolean canPerformQuest(int currentWorkCred);

	/**
	 * ASCII representation of this quest.
	 *
	 * @return
	 */
	public String getInfoString();

	/**
	 * StreetCred gained by performing this quest.
	 *
	 * @return
	 */
	public long getStreetCredGain();

	/**
	 * WorkCred cost to perform this quest.
	 *
	 * @return
	 */
	public int getWorkCredCost();

	/**
	 * WorkCred gained by performing this quest.
	 *
	 * @return
	 */
	public int getWorkCredGain();

	/**
	 * Health lost by performing this quest.
	 *
	 * @return
	 */
	public int getHealthCost();

	/**
	 * Health gained by performing this quest.
	 *
	 * @return
	 */
	public int getHealthGain();

	/**
	 * Indicates if the user gets a ticked latched on to him by doing this
	 * quest.
	 *
	 * @return True if the quest has a tick.
	 */
	public boolean hasTick();
}
