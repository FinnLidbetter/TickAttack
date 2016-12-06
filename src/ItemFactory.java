/**
 * ItemFactory class has methods for initialising each of the items
 * @author Finn Lidbetter, Michael Bradet-Legris
 * @version 1.0, 16/10/31
 */
public class ItemFactory {

  private static int ANTIBIOTICS_STREETCRED_COST = 10000;
  private static int ANTIBIOTICS_WORKCRED_COST = 0;
  private static int ANTIBIOTICS_HEALTH_GAIN = 10;

  private static int TICKTEST_STREETCRED_COST = 100;
  private static int TICKTEST_WORKCRED_COST = 0;
  private static int TICKTEST_HEALTH_GAIN = 0;

  private static int CHEAPMEDS_STREETCRED_COST = 1000;
  private static int CHEAPMEDS_WORKCRED_COST = 0;
  private static int CHEAPMEDS_HEALTH_GAIN = 10;

  private static int TREATMENT_PLAN_STREETCRED_COST = 100000;
  private static int TREATMENT_PLAN_WORKCRED_COST = 10000;
  private static int TREATMENT_PLAN_HEALTH_GAIN = 100;

  private static int TICKLEGS_STREETCRED_COST = 500;
  private static int TICKLEGS_WORKCRED_COST = 0;

  private static int EYEOFNEWT_STREETCRED_COST = 0;
  private static int EYEOFNEWT_WORKCRED_COST = 500;

  private static int POTIONBOOK_STREETCRED_COST = 1000;
  private static int POTIONBOOK_WORKCRED_COST = 1000;
  private static String POTION_RECIPES = "Potion Recipe Book:\n\tFishing Potion:\n\t\t2 Eyes of Newt\n\t\t4 Cheap Meds\n\tRanger Potion:\n\t\t3 Tick Legs\n\t\t1 Antibiotics\n\tFusion Potion\n\t\t1 Fishing Potion\n\t\t1 Ranger Potion";

  private static int FISHINGPOTION_STREETCRED_COST = 0;
  private static int FISHINGPOTION_WORKCRED_COST = 0;
  private static int FISHINGPOTION_FISHING_SKILL_GAIN = 1;

  private static int RANGERPOTION_STREETCRED_COST = 0;
  private static int RANGERPOTION_WORKCRED_COST = 0;
  private static int RANGERPOTION_RANGER_SKILL_GAIN = 1;

  private static int FUSIONPOTION_STREETCRED_COST = 0;
  private static int FUSIONPOTION_WORKCRED_COST = 0;
  private static int FUSIONPOTION_FISHING_SKILL_GAIN = 1;
  private static int FUSIONPOTION_RANGER_SKILL_GAIN = 1;
  private static int FUSIONPOTION_HEALTH_GAIN = 10;



  /**
   * Initialises a FishingRod Enum type as an Item object
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @param rod - The FishingRod to initialise as an item
   * @return the fishing rod as an item
   */
  public static Item createFishingRod(boolean unlocked, FishingRod rod) {
    Item fishingRodItem = new Item(rod.getName(),rod.getInfo(), "", "", unlocked,
      rod.getStreetCredCost(), 0,0,rod.getFishingSkillGain(),0);
    return fishingRodItem;
  }

  /**
   * Initializes a RangerGear Enum type as an Item object
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @param gear - The RangerGear to initialize as an item
   * @return the RangerGear as an item
   */
  public static Item createRangerGear(boolean unlocked, RangerGear gear) {
    Item rangerGearItem = new Item(gear.getName(), gear.getInfo(), "", "", unlocked,
      gear.getStreetCredCost(), 0, gear.getRangerSkillGain(),0,0);
    return rangerGearItem;
  }

  /**
   * Initialises the Antibiotics Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the Antibiotics as an item
   */
  public static Item createAntibiotics(boolean unlocked) {
    Item antibiotics = new Item("Antibiotics", "Treats the symptoms of Lyme Disease, but cannot fully cure it.", "Antibiotics used, you are fighting off Lyme disease", "You do not have any Lyme disease to treat",
    unlocked, ANTIBIOTICS_STREETCRED_COST, ANTIBIOTICS_WORKCRED_COST, 0, 0, ANTIBIOTICS_HEALTH_GAIN);
    return antibiotics;
  }

  /**
   * Initialises the Tick Test Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the Tick Test as an item
   */
  public static Item createTickTest(boolean unlocked) {
    Item tickTest = new Item("Tick Test", "This tick test can help me do my tick searches!", "", "", unlocked,
    TICKTEST_STREETCRED_COST, TICKTEST_WORKCRED_COST, 0, 0, TICKTEST_HEALTH_GAIN);
    return tickTest;
  }

  /**
   * Initialises the CheapMeds Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the CheapMeds as an item
   */
  public static Item createCheapMeds(boolean unlocked) {
    Item cheapMeds = new Item("Cheap Meds", "Helps you feel better by restoring health.", "Cheap meds consumed +10 health", "You are already at maximum health", unlocked,
    CHEAPMEDS_STREETCRED_COST, CHEAPMEDS_WORKCRED_COST, 0, 0, CHEAPMEDS_HEALTH_GAIN);
    return cheapMeds;
  }

  /**
   * Initialises the IntensiveTreatmentPlan Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the IntensiveTreatmentPlan as an item
   */
  public static Item createIntensiveTreatmentPlan(boolean unlocked) {
    Item treatmentPlan = new Item("Intensive Treatment Plan", "This health care option will fully treat Lyme Disease", "", "The Intensive Treatment Plan cannot be bought if you don't have Lyme Disease", unlocked,
    TREATMENT_PLAN_STREETCRED_COST, TREATMENT_PLAN_WORKCRED_COST, 0, 0, TREATMENT_PLAN_HEALTH_GAIN);
    return treatmentPlan;
  }

  /**
   * Initialises the OldRod Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the OldRod as an item
   */
  public static Item createOldRod(boolean unlocked) {
    Item oldRod = createFishingRod(unlocked, FishingRod.OLD_ROD);
    return oldRod;
  }

  /**
   * Initialises the GoodRod Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the GoodRod as an item
   */
  public static Item createGoodRod(boolean unlocked) {
    Item goodRod = createFishingRod(unlocked, FishingRod.GOOD_ROD);
    return goodRod;
  }


  /**
   * Initialises the SuperRod Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the SuperRod as an item
   */
  public static Item createSuperRod(boolean unlocked) {
    Item superRod = createFishingRod(unlocked, FishingRod.SUPER_ROD);
    return superRod;
  }

  /**
   * Initialises the GreatRod Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the GreatRod as an item
   */
  public static Item createGreatRod(boolean unlocked) {
    Item greatRod = createFishingRod(unlocked, FishingRod.GREAT_ROD);
    return greatRod;
  }

  /**
   * Initialises the HyperRod Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the HyperRod as an item
   */
  public static Item createHyperRod(boolean unlocked) {
    Item hyperRod = createFishingRod(unlocked, FishingRod.HYPER_ROD);
    return hyperRod;
  }

  /**
   * Initialises the MasterRod Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the MasterRod as an item
   */
  public static Item createMasterRod(boolean unlocked) {
    Item masterRod = createFishingRod(unlocked, FishingRod.MASTER_ROD);
    return masterRod;
  }

  /**
   * Initialises the BasicGear Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the BasicGear as an item
   */
  public static Item createBasicGear(boolean unlocked) {
    Item basicGear = createRangerGear(unlocked, RangerGear.BASIC_GEAR);
    return basicGear;
  }

  /**
   * Initialises the DecentGear Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the DecentGear as an item
   */
  public static Item createDecentGear(boolean unlocked) {
    Item decentGear = createRangerGear(unlocked, RangerGear.DECENT_GEAR);
    return decentGear;
  }

  /**
   * Initialises the ExcellentGear Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the ExcellentGear as an item
   */
  public static Item createExcellentGear(boolean unlocked) {
    Item excellentGear = createRangerGear(unlocked, RangerGear.EXCELLENT_GEAR);
    return excellentGear;
  }

  /**
   * Initialises the PhenomenalGear Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the PhenomenalGear as an item
   */
  public static Item createPhenomenalGear(boolean unlocked) {
    Item phenomenalGear = createRangerGear(unlocked, RangerGear.PHENOMENAL_GEAR);
    return phenomenalGear;
  }

  /**
   * Initialises the MasterGear Item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the MasterGear as an item
   */
  public static Item createMasterGear(boolean unlocked) {
    Item masterGear = createRangerGear(unlocked, RangerGear.MASTER_GEAR);
    return masterGear;
  }

  /**
   * Initialises TickLegs as an item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the TickLegs Item
   */
  public static Item createTickLegs(boolean unlocked) {
    Item tickLegs = new Item("Tick Legs", "This could be useful in brewing potions", "You eat the Tick Legs. No effect but a bad taste.", "", unlocked, TICKLEGS_STREETCRED_COST,
    TICKLEGS_WORKCRED_COST, 0, 0, 0);
    return tickLegs;
  }

  /**
   * Initialises an Eye of Newt as an item
   * @param unlocked - boolean value indicating whether this item is available for purchase or not
   * @return the Eye of Newt Item
   */
  public static Item createEyeOfNewt(boolean unlocked) {
    Item eyeOfNewt = new Item("Eye of Newt", "This could be useful in brewing potions", "You eat the Eye of Newt. No effect but a bad taste.", "", unlocked, EYEOFNEWT_STREETCRED_COST,
    EYEOFNEWT_WORKCRED_COST, 0, 0, 0);
    return eyeOfNewt;
  }

  public static Item createPotionBook(boolean unlocked) {
    Item potionBook = new Item("Book of Potions", "This might tell me the secrets of brewing potions!", POTION_RECIPES, "", unlocked, POTIONBOOK_STREETCRED_COST,
    POTIONBOOK_WORKCRED_COST, 0, 0, 0);
    return potionBook;
  }

  public static Item createFishingPotion(boolean unlocked){
	  Item fishingPotion = new Item("Fishing Potion", "This Fishing Potion will help me with fishing!", "Fishing skill boosted!", "", unlocked,
			  FISHINGPOTION_STREETCRED_COST, FISHINGPOTION_WORKCRED_COST, 0, FISHINGPOTION_FISHING_SKILL_GAIN, 0);
	  return fishingPotion;
  }

  public static Item createRangerPotion(boolean unlocked){
	  Item rangerPotion = new Item("Ranger Potion", "This Ranger Potion will help me with my park ranger duties!", "Ranger skill boosted!", "", unlocked,
			  RANGERPOTION_STREETCRED_COST, RANGERPOTION_WORKCRED_COST, RANGERPOTION_RANGER_SKILL_GAIN, 0, 0);
	  return rangerPotion;
  }

  public static Item createFusionPotion(boolean unlocked){
	  Item fusionPotion = new Item("Fusion Potion", "This Fusion Potion must be good for me!", "Fishing Skill, Ranger Skill, and health boosted!", "", unlocked,
			  FUSIONPOTION_STREETCRED_COST, FUSIONPOTION_WORKCRED_COST, FUSIONPOTION_RANGER_SKILL_GAIN, FUSIONPOTION_FISHING_SKILL_GAIN,
        FUSIONPOTION_HEALTH_GAIN);
	  return fusionPotion;
  }

}
