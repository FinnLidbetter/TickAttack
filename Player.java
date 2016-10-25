import java.util.ArrayList;

public class Player {
  
  public static final double INFECTIONSTAGE_INCREMENT = 0.002;
  private int streetCred;
  private int workCred;
  private double health;
  private int fishingSkill;
  private int rangerSkill;
  private int numTickTests;
  private int numAntibiotics;
  private int numCheapMeds;
  private double streetCredGainRate; // streetCred gained per second
  private ArrayList<Tick> ticks;
  private double infectionStage;
  private String infoString;
  private boolean isAlive;
  
  public Player() {
    streetCred = 0;
    workCred = 0;
    health = 100;
    fishingSkill = 0;
    rangerSkill = 0;
    
    numTickTests = 0;
    numAntibiotics = 0;
    numCheapMeds = 0;
    infectionStage = 0;
    streetCredGainRate = 1.0;
    
    infoString = ""; // Insert appropriate info string here
    
    isAlive = true;
  }
  
  public int getStreetCred() {
    return streetCred;
  }
  public int getWorkCred() {
    return workCred;
  }
  public double getHealth() {
    return health;
  }
  public int getFishingSkill() {
    return fishingSkill;
  }
  public int getRangerSkill() {
    return rangerSkill;
  }
  public int getNumTickTests() {
    return numTickTests;
  }
  public int getNumAntibiotics() {
    return numAntibiotics;
  }
  public int getNumCheapMeds() {
    return numCheapMeds;
  }
  public double getStreetCredGainRate() {
    return streetCredGainRate;
  }

  public double getInfectionStage() {
    return infectionStage;
  }
  public String getInfoString() {
    return infoString;
  }
  public void setInfoString(String newInfoString) {
    infoString = newInfoString; 
  }
  
  public void incrementInfectionStage() {
    if (infectionStage != 0)
    	infectionStage += INFECTIONSTAGE_INCREMENT;
  }
  
  public void updateInfectionStage(double amount){
	  infectionStage += amount;
	  if (infectionStage < 0)
		  infectionStage = 0;
  }
  
  public ArrayList<Tick> getTicks() {
    return ticks;
  }
  
  public void incrementRangerSkill(int rangerSkillIncrease) {
    rangerSkill += rangerSkillIncrease;
  }
  
  public void incrementFishingSkill(int fishingSkillIncrease) {
    fishingSkill += fishingSkillIncrease; 
  }
  
  public void incrementNumAntibiotics(int numExtraAntibiotics) {
    numAntibiotics += numExtraAntibiotics;
  }
  
  public void consumeAntibiotics() {
    numAntibiotics--; 
  }
  
  public void incrementNumCheapMeds(int numExtraCheapMeds) {
    numCheapMeds += numExtraCheapMeds;
  }
  
  public void consumeCheapMeds() {
    numCheapMeds--; 
  }
  
  public void incrementPerSecondStreetCred() {
    streetCred += (int)Math.round(streetCredGainRate);
  }
  
  public void incrementWorkCred(int workCredGained) {
    workCred += workCredGained; 
  }
  
  public void spendStreetCred(int streetCredSpent) {
    streetCred -= streetCredSpent;
  }
  
  public void spendWorkCred(int workCredSpent) {
    workCred -= workCredSpent; 
  }
  
  public void multiplyStreetCredGainRate(double multiplier) {
    streetCredGainRate *= multiplier; 
  }
  
  public void adjustHealth(int healthChange) {
    health += healthChange; 
    if (health > 100)
    	health = 100;
    if (health <= 0)
    	isAlive = false;
  }
  
  public void incrementPerSecondHealth(){
	health -= infectionStage;
	if (health <= 0)
      isAlive = false;
  }

  public boolean isAlive() {
	return isAlive;
  }

  public void setAlive(boolean isAlive) {
	this.isAlive = isAlive;
  }
}
