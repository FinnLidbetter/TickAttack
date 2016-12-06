import java.util.ArrayList;

/**
 * Player class stores all of the information for the player in the game
 * @author Finn Lidbetter, Michael Bradet-Legris
 * @version 1.0, 16/10/31
 */
public class Player {

  public static final double INFECTIONSTAGE_INCREMENT = 0.0005;
  public static final int INITIAL_HEALTH = 100;
  public static final double INITIAL_STREET_CRED_GAIN_RATE = 1.0;

  private long streetCred;
  private int workCred;
  private double health;
  private FishingSkill fishingSkill;
  private RangerSkill rangerSkill;
  ArrayList<Item> inventory;
  private double streetCredGainRate; // streetCred gained per second
  private ArrayList<Tick> ticks;
  private double infectionStage;
  private String infoString;
  private Task currentTask;
  private int timeToCompleteTask;
  private Store currentStore;
  private RangerGear bestGear;

  /**
   * Constructor for the player
   */
  public Player() {
    streetCred = 0;
    workCred = 0;
    health = INITIAL_HEALTH;
    fishingSkill = new BaseFishingSkill();
    rangerSkill = new BaseRangerSkill();

    infectionStage = 0;
    streetCredGainRate = INITIAL_STREET_CRED_GAIN_RATE;

    infoString = "";

    currentTask = null;
    timeToCompleteTask = 0;
    currentStore = null;
    ticks = new ArrayList<Tick>();
    inventory = new ArrayList<Item>();
  }



  /* Getters */
  public long getStreetCred() {
    return streetCred;
  }
  public int getWorkCred() {
    return workCred;
  }
  public double getHealth() {
    return health;
  }
  public FishingSkill getBaseFishingSkill() {
    return fishingSkill;
  }
  public int getFishingSkill() {
    return fishingSkill.getFishingSkill();
  }
  public RangerSkill getBaseRangerSkill() {
    return rangerSkill;
  }
  public int getRangerSkill() {
    return rangerSkill.getRangerSkill();
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
  public ArrayList<Tick> getTicks() {
    return ticks;
  }
  public FishingRod getBestRod() {
    return fishingSkill.getBestRod();
  }

  public RangerGear getBestGear() {
    return rangerSkill.getBestGear();
  }

  public Store getCurrentStore() {
    return currentStore;
  }

  public Task getCurrentTask() {
  	return currentTask;
  }

  public int getTimeToCompleteTask() {
  	return timeToCompleteTask;
  }
  /* End getters */

  /**
   * Sets the current task for the player
   * @param currentTask - the currentTask for the player
   */
  public void setCurrentTask(Task currentTask) {
  	this.currentTask = currentTask;
    this.timeToCompleteTask = currentTask.getTimeToComplete();
  }

  /**
   * Sets the time remaining to complete the current task
   * @param timeToCompleteTask - the time remaining to complete the task
   */
  public void setTimeToCompleteTask(int timeToCompleteTask) {
  	this.timeToCompleteTask = timeToCompleteTask;
  }
  /**
   * Sets the info string for the player
   * @param the new info string
   */
  public void setInfoString(String newInfoString) {
    infoString = newInfoString;
  }

  public void setFishingSkill(FishingSkill skill) {
    fishingSkill = skill;
  }

  public void setRangerSkill(RangerSkill skill) {
    rangerSkill = skill;
  }
  /* NEW METHODS HERE */
  /**
   * remove a number of a certain item from the player's inventory.
   * @param itemName The name of the item we want removed
   * @param num The amount of the item we want to remove.
   * @return
   */

  public void addItem(Item theItem){
	  inventory.add(theItem);
  }

  public boolean removeItem(String itemName, int num){
	  if(num <= 0){
		  return true;
	  }
	  ArrayList<Integer> listOfIndices = new ArrayList<Integer>();
	  for(int i = 0; i < inventory.size(); i++){
		  if(inventory.get(i).getName().equals(itemName)){
			  listOfIndices.add(i);
			  if(listOfIndices.size() == num){
				  for(int j = 0; j < listOfIndices.size(); j++){
					  inventory.remove(listOfIndices.get(j) - j);
				  }
				  return true;
			  }
		  }
	  }
	  return false;
  }


  public int getItemNum(String itemName){
	  int numItems = 0;
	  for(int i = 0; i < inventory.size(); i++){
		  if(inventory.get(i).getName().equals(itemName)){
			  numItems++;
		  }
	  }
	  return numItems;
  }

  public boolean hasAllItems(String[] itemNames, int[] itemCounts) {
    if (itemNames.length!= itemCounts.length)
      return false;
    for (int i=0; i<itemNames.length; i++) {
      if (getItemNum(itemNames[i])<itemCounts[i]) {
        return false;
      }
    }
    return true;
  }

  public boolean useItem(String itemName){
	  for(int i = 0; i < inventory.size(); i++){
		  if(inventory.get(i).getName().equals(itemName)){
			  Item theItem = inventory.get(i);
			  if(itemName.equals("Antibiotics")){
				  if(useAntibiotics()){
					  inventory.remove(itemName);
					  return true;
				  }
				  return false;
			  }
			  if(theItem.getFishingSkillGain() > 0){

			  }
			  if(theItem.getRangerSkillGain() > 0){

			  }
			  if(theItem.getHealthGain() > 0){
				  adjustHealth(theItem.getHealthGain());
				  return inventory.remove(theItem);
			  }

		  }
	  }
	  return false;
  }

  public Item getItem(String itemName){
	  for(int i = 0; i < inventory.size(); i++){
		  if(inventory.get(i).getName().equals(itemName)){
			  return inventory.get(i);
		  }
	  }
	  return null;
  }

  /* END NEW METHODS */

  public boolean useAntibiotics(){
	  if (infectionStage!=0) {
	        infectionStage -= 0.1;
	        if (infectionStage<=0) {
	          infectionStage = INFECTIONSTAGE_INCREMENT;
	        }
	        return true;
	  }
	  return false;
  }
  /**
   * Increments the development of Lyme Disease
   */
  public void incrementInfectionStage() {
    if (infectionStage != 0)
    	infectionStage += INFECTIONSTAGE_INCREMENT;
  }

  /**
   * Updates the infectionStage
   * @param amount - the amount to change the infectionStage by
   */
  public void updateInfectionStage(double amount){
	  infectionStage += amount;
	  if (infectionStage < 0)
		  infectionStage = INFECTIONSTAGE_INCREMENT;
  }
  /**
   * Gives the player Lyme Disease
   */
  public void infect() {
    if (infectionStage==0) {
      infectionStage = INFECTIONSTAGE_INCREMENT;
    }
  }

  /**
   * Adds a tick to the player's tick list
   */
  public void addTick(){
	  ticks.add(new Tick());
  }

  /**
   * Updates the fishing skill
   * @param fishingSkillIncrease - amount to increase fishing skill by
   */
  //public void incrementFishingSkill(int fishingSkillIncrease) {
    //fishingSkill += fishingSkillIncrease;
  //}


  /**
   * Increments the streetcred gain rate
   */
  public void incrementPerSecondStreetCred() {
    streetCred += (int)Math.round(streetCredGainRate);
  }


  /**
   * Updates the amount of street cred
   * @param streetCredChage - amount to increase streetCred by
   */
  public void updateStreetCred(long streetCredChange) {
    streetCred += streetCredChange;
  }

  /**
   * Updates the amount of work cred
   * @param workCredChage - amount to increase workCred by
   */
  public void updateWorkCred(long workCredChange) {
    workCred += workCredChange;
  }

  /**
   * Increases the street cred gain rate by a scalar factor
   * @param mutliplier - the scalar factor
   */
  public void multiplyStreetCredGainRate(double multiplier) {
    streetCredGainRate *= multiplier;
  }

  /**
   * Spends an amount of work cred
   * @param amount - amount of work cred to spend
   */
  public void spendWorkCred(long amount) {
    updateWorkCred(-1L*amount);
  }

  /**
   * Spends an amount of street cred
   * @param amount - amount of street cred to spend
   */
  public void spendStreetCred(long amount) {
    updateStreetCred(-1L*amount);
  }

  /**
   * Changes the player's health
   * @param healthChange - amount to change health by
   */
  public void adjustHealth(double healthChange) {
    health += healthChange;
    if (health > 100)
    	health = 100;
    if (health <= 0)
    	health = 0;
  }

  /**
   * Adjusts the player's per-second health according to the infection stage
   */
  public void incrementPerSecondHealth() {
  	adjustHealth(-1*infectionStage);
  }

  /**
   * Checks if the player is still alive
   * @return true if the player has positive health, false otherwise
   */
  public boolean isAlive() {
  	return health>0;
  }

  /**
   * Method to decrement the time needed to complete the task
   * @return null if the Task is still in progress, a completed task otherwise
   */
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

  /**
   * Sets the currentStore to the destinationStore
   * @param destinationStore - store to go to
   */
  public void goToStore(Store destinationStore) {
    currentStore = destinationStore;
  }

  /**
   * Sets the currentStore to null
   */
  public void leaveStore() {
    currentStore = null;
  }

  /**
   * Method to use the IntensiveTreatmentPlan
   * @return true if the IntensiveTreatmentPlan was used successfully, false otherwise
   */
  public boolean useIntensiveTreatment() {
    if (infectionStage!=0) {
      health = 100;
      infectionStage = 0;
      return true;
    }
    return false;
  }
}
