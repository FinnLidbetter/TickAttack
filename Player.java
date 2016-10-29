import java.util.ArrayList;

public class Player {

  public static final double INFECTIONSTAGE_INCREMENT = 0.002;
  public static final int INITIAL_HEALTH = 100;
  public static final double INITIAL_STREET_CRED_GAIN_RATE = 1.0;

  private long streetCred;
  private int workCred;
  private double health;
  private int numKnownTicks;
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
  private Task currentTask;
  private int timeToCompleteTask;
  private Store currentStore;


  public Player() {
    streetCred = 0;
    workCred = 0;
    health = INITIAL_HEALTH;
    fishingSkill = 1;
    rangerSkill = 1;

    numTickTests = 0;
    numAntibiotics = 0;
    numCheapMeds = 0;

    numKnownTicks = 0;
    infectionStage = 0;
    streetCredGainRate = INITIAL_STREET_CRED_GAIN_RATE;

    infoString = ""; // Insert appropriate info string here

    isAlive = true;
    currentTask = null;
    timeToCompleteTask = 0;
    currentStore = null;
    ticks = new ArrayList<Tick>();
  }

  public void infect() {
    if (infectionStage==0) {
      infectionStage = INFECTIONSTAGE_INCREMENT;
    }
  }

  public long getStreetCred() {
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
  public boolean useTickTest(){
	  if (numTickTests == 0)
		  return false;
	  numTickTests--;
	  return true;
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

  public void addTick(){
	  ticks.add(new Tick());
  }

  public int getNumKnownTicks() {
    return numKnownTicks;
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

  public boolean consumeCheapMeds() {
    if (health==100 || numCheapMeds==0)
      return false;
    adjustHealth(10);
    numCheapMeds--;
    return true;
  }

  public void incrementPerSecondStreetCred() {
    streetCred += (int)Math.round(streetCredGainRate);
  }

  public void updateStreetCred(long streetCredChange) {
    streetCred += streetCredChange;
  }

  public void updateWorkCred(int workCredChange) {
    workCred += workCredChange;
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

  public Task getCurrentTask() {
  	return currentTask;
  }

  public void setCurrentTask(Task currentTask) {
  	this.currentTask = currentTask;
    this.timeToCompleteTask = currentTask.getTimeToComplete();
  }

  public int getTimeToCompleteTask() {
  	return timeToCompleteTask;
  }

  public void setTimeToCompleteTask(int timeToCompleteTask) {
  	this.timeToCompleteTask = timeToCompleteTask;
  }

  public Task decrementTimeToCompleteTask(){
	  if (currentTask != null){
		  if (--timeToCompleteTask == 0){
			  Task completedTask = currentTask;
			  currentTask = null;
			  return completedTask;
      }
	  }
	  return null;
  }

  public Store getCurrentStore() {
    return currentStore;
  }


  public void goToStore(Store destinationStore) {
    currentStore = destinationStore;
  }

  public void leaveStore() {
    currentStore = null;
  }

  public boolean useAntibiotics() {
    if (numAntibiotics>0 && infectionStage!=0) {
      infectionStage -= 0.1;
      if (infectionStage<=0) {
        infectionStage = INFECTIONSTAGE_INCREMENT;
      }
      return true;
    }
    return false;
  }

  public boolean useIntensiveTreatment() {
    if (infectionStage!=0) {
      health = 100;
      infectionStage = 0;
      return true;
    }
    return false;
  }
}
