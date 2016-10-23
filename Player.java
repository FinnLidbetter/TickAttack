
public class Player {

  public static final int HEALTHY = 0;
  public static final int FIRST_STAGE_INFECTION = 1;
  public static final int SECOND_STAGE_INFECTION = 2;
  public static final int THIRD_STAGE_INFECTION = 3;
  
  private int streetCred;
  private int workCred;
  private int health;
  private int fishingSkillLevel;
  private int rangerSkillLevel;
  private int numTickTests;
  private int numAnitbiotics;
  private int numCheapMeds;
  private double streetCredGainRate; // streetCred gained per second
  private int numTicks;
  private int infectionStage;
  private String infoString;
  
  public Player() {
    streetCred = 0;
    workCred = 0;
    fishingSkillLevel = 0;
    rangerSkillLevel = 0;
    numTickTests = 0;
    infectionStage = InfectionStage.HEALTHY;
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
  public int getFishingSkillLevel() {
    return fishingSkillLevel;
  }
  public int getRangerSkillLevel() {
    return rangerSkillLevel;
  }
  public int getNumTickTests() {
    return numTickTests;
  }
  public int getNumAnitbiotics() {
    return numAnitbiotics;
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
  public InfectionStage getInfectionStage() {
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
