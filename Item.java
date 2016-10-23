
public class Item {

	private long streetCredCost;
	private long workCredCost;
	private int rangerSkillGain;
	private int fishingSkillGain;
	private int healthGain;
	private int tickTestGain;
	private int infectionGain;
	private boolean unlocked;
	private String infoString;
	
	public long getStreetCredCost() {
		return streetCredCost;
	}
	public void setStreetCredCost(long streetCredCost) {
		this.streetCredCost = streetCredCost;
	}
	public long getWorkCredCost() {
		return workCredCost;
	}
	public void setWorkCredCost(long workCredCost) {
		this.workCredCost = workCredCost;
	}
	public int getRangerSkillGain() {
		return rangerSkillGain;
	}
	public void setRangerSkillGain(int rangerSkillGain) {
		this.rangerSkillGain = rangerSkillGain;
	}
	public int getInfectionGain() {
		return infectionGain;
	}
	public void setInfectionGain(int infectionGain) {
		this.infectionGain = infectionGain;
	}
	public int getHealthGain() {
		return healthGain;
	}
	public void setHealthGain(int healthGain) {
		this.healthGain = healthGain;
	}
	public int getTickTestGain() {
		return tickTestGain;
	}
	public void setTickTestGain(int tickTestGain) {
		this.tickTestGain = tickTestGain;
	}
	public int getFishingSkillGain() {
		return fishingSkillGain;
	}
	public void setFishingSkillGain(int fishingSkillGain) {
		this.fishingSkillGain = fishingSkillGain;
	}
	public boolean isUnlocked() {
		return unlocked;
	}
	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}
	public String getInfoString() {
		return infoString;
	}
	public void setInfoString(String infoString) {
		this.infoString = infoString;
	}
	
}
