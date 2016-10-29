
/**
 * Represents and item that can modify properties of a player.
 *
 */
public class Item {

	private boolean unlocked;
	private long streetCredCost;
	private long workCredCost;
	private int rangerSkillGain;
	private int fishingSkillGain;
	private int healthGain;

	private String name;
	private String infoString;
	private int id;
	/**
	 * Constructor.
	 * @param name name of item.
	 * @param infoString how the item should be displayed.
	 * @param unlocked if the item is available for purchase.
	 * @param streetCredCost cost of the item in streetCred.
	 * @param workCredCost cost of the item in workCred.
	 * @param rangerSkillGain how much this item increases the player's rangerSkill by.
	 * @param fishingSkillGain how much this item increases the player's fishingSkill by.
	 * @param healthGain how the health the player gains by using this item.
	 */
	public Item(String name, String infoString, boolean unlocked,
			long streetCredCost, int workCredCost, int rangerSkillGain,
			int fishingSkillGain, int healthGain) {

		this.name = name;
		this.infoString = infoString;
		this.streetCredCost = streetCredCost;
		this.unlocked = unlocked;
		this.streetCredCost = streetCredCost;
		this.workCredCost = workCredCost;
		this.rangerSkillGain = rangerSkillGain;
		this.fishingSkillGain = fishingSkillGain;
		this.healthGain = healthGain;
	}

	/**
	 * The cost of this item in streetCred.
	 * @return the value.
	 */
	public long getStreetCredCost() {
		return streetCredCost;
	}

	/**
	 * The cost of this item in workCred.
	 * @return the value.
	 */
	public long getWorkCredCost() {
		return workCredCost;
	}

	/**
	 * How much this item increases the player's rangerSkill by.
	 * @return the value.
	 */
	public int getRangerSkillGain() {
		return rangerSkillGain;
	}

	/**
	 * How much the user's health is modified by this item.
	 * @return the value.
	 */
	public int getHealthGain() {
		return healthGain;
	}

	/**
	 * How much this item increases the player's fishingSkill by.
	 * @return the value.
	 */
	public int getFishingSkillGain() {
		return fishingSkillGain;
	}

	/**
	 * The ASCII representation of this item.
	 * @return the String.
	 */
	public String getInfoString() {
		return infoString;
	}

	/**
	 * The item's name.
	 * @return the item's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * If this item can be purchased or not.
	 * @return true if the item can be purchased, false otherwise.
	 */
	public boolean isUnlocked() {
		return unlocked;
	}

	public int getID() {
		return id;
	}

	public void setID(int newID) {
		id = newID;
	}
}
