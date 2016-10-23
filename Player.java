
public class Player {

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
  private InfectionStage infectionStage;
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
  
}
