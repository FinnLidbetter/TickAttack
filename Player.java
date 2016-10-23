
public class Player {

  public static final int HEALTHY = 0;
  public static final int FIRST_STAGE_INFECTION = 1;
  public static final int SECOND_STAGE_INFECTION = 2;
  public static final int THIRD_STAGE_INFECTION = 3;
  
  private int streetCred;
  private int workCred;
  private int health;
  private int fishingSkill;
  private int rangerSkill;
  private int numTickTests;
  private int numAntibiotics;
  private int numCheapMeds;
  private double streetCredGainRate; // streetCred gained per second
  private int numTicks;
  private int infectionStage;
  private String infoString;
  
  public Player() {
    streetCred = 0;
    workCred = 0;
    health = 100;
    fishingSkill = 0;
    rangerSkill = 0;
    
    numTickTests = 0;
    numAntibiotics = 0;
    numCheapMeds = 0;
    numTicks = 0;
    
    infectionStage = HEALTHY;
    streetCredGainRate = 1.0;
    
    infoString = ""; // Insert appropriate info string here
  }
  
  public int getStreetCred() {
    return streetCred;
  }
  public int getWorkCred() {
    return workCred;
  }
  public int getHealth() {
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
  public int getNumTicks() {
    return numTicks;
  }
  public int getInfectionStage() {
    return infectionStage;
  }
  public String getInfoString() {
    return infoString;
  }
  public void setInfoString(String newInfoString) {
    infoString = newInfoString; 
  }
  public void incrementInfectionStage() {
    if (infectionStage!=THIRD_STAGE_INFECTION)
      infectionStage++;
  }
  
  public void incrementNumTicks() {
    numTicks++;
  }
  public void decrementNumTicks(int numTicksRemoved) {
    numTicks -= numTicksRemoved;
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
  }
}