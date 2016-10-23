public class Item {

	private boolean unlocked;
	private long streetCredCost;
	private long workCredCost;
	private int rangerSkillGain;
	private int fishingSkillGain;
	private int healthGain;
	private int tickTestGain;
	private int infectionGain;

	private String name;
	private String infoString;

	public Item(String name, String infoString, boolean unlocked,
			long streetCredCost, int workCredCost, int rangerSkillGain,
			int fishingSkillGain, int healthGain, int tickTestGain,
			int infectionGain) {

		this.name = name;
		this.infoString = infoString;
		this.streetCredCost = streetCredCost;
		this.unlocked = unlocked;
		this.streetCredCost = streetCredCost;
		this.workCredCost = workCredCost;
		this.rangerSkillGain = rangerSkillGain;
		this.fishingSkillGain = fishingSkillGain;
		this.healthGain = healthGain;
		this.tickTestGain = tickTestGain;
		this.infectionGain = infectionGain;

	}

	public long getStreetCredCost() {
		return streetCredCost;
	}

	public long getWorkCredCost() {
		return workCredCost;
	}

	public int getRangerSkillGain() {
		return rangerSkillGain;
	}
	public int getInfectionGain() {
		return infectionGain;
	}

	public int getHealthGain() {
		return healthGain;
	}

	public int getTickTestGain() {
		return tickTestGain;
	}

	public int getFishingSkillGain() {
		return fishingSkillGain;
	}

	public String getInfoString() {
		return infoString;
	}

	public String getName() {
		return name;
	}

	public boolean isUnlocked() {
		return unlocked;
	}

}
