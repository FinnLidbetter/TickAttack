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

  public static Item createFishingRod(boolean unlocked, FishingRod rod) {
    Item fishingRodItem = new Item(rod.getName(),rod.getInfo(), unlocked,
      rod.getStreetCredCost(), 0,0,rod.getFishingSkillGain(),0);
    return fishingRodItem;
  }

  public static Item createRangerGear(boolean unlocked, RangerGear gear) {
    Item rangerGearItem = new Item(gear.getName(), gear.getInfo(), unlocked,
      gear.getStreetCredCost(), 0, gear.getRangerSkillGain(),0,0);
    return rangerGearItem;
  }

  public static Item createAntibiotics(boolean unlocked) {
    Item antibiotics = new Item("Antibiotics", "Treats early stages of Lyme disease",
    unlocked, ANTIBIOTICS_STREETCRED_COST, ANTIBIOTICS_WORKCRED_COST, 0, 0, ANTIBIOTICS_HEALTH_GAIN);
    return antibiotics;
  }
  public static Item createTickTest(boolean unlocked) {
    Item tickTest = new Item("Tick Test", "This tick test can help me do my tick searches!", unlocked,
    TICKTEST_STREETCRED_COST, TICKTEST_WORKCRED_COST, 0, 0, TICKTEST_HEALTH_GAIN);
    return tickTest;
  }

  public static Item createCheapMeds(boolean unlocked) {
    Item cheapMeds = new Item("Cheap Meds", "Helps you feel better by restoring health", unlocked,
    CHEAPMEDS_STREETCRED_COST, CHEAPMEDS_WORKCRED_COST, 0, 0, CHEAPMEDS_HEALTH_GAIN);
    return cheapMeds;
  }

  public static Item createIntensiveTreatmentPlan(boolean unlocked) {
    Item treatmentPlan = new Item("Intensive Treatment Plan", "This health care option will treat Lyme Disease", unlocked,
    TREATMENT_PLAN_STREETCRED_COST, TREATMENT_PLAN_WORKCRED_COST, 0, 0, TREATMENT_PLAN_HEALTH_GAIN);
    return treatmentPlan;
  }

  public static Item createOldRod(boolean unlocked) {
    Item oldRod = createFishingRod(unlocked, FishingRod.OLD_ROD);
    return oldRod;
  }

  public static Item createGoodRod(boolean unlocked) {
    Item goodRod = createFishingRod(unlocked, FishingRod.GOOD_ROD);
    return goodRod;
  }


  public static Item createSuperRod(boolean unlocked) {
    Item superRod = createFishingRod(unlocked, FishingRod.SUPER_ROD);
    return superRod;
  }

  public static Item createGreatRod(boolean unlocked) {
    Item greatRod = createFishingRod(unlocked, FishingRod.GREAT_ROD);
    return greatRod;
  }

  public static Item createHyperRod(boolean unlocked) {
    Item hyperRod = createFishingRod(unlocked, FishingRod.HYPER_ROD);
    return hyperRod;
  }

  public static Item createMasterRod(boolean unlocked) {
    Item masterRod = createFishingRod(unlocked, FishingRod.MASTER_ROD);
    return masterRod;
  }

  public static Item createBasicGear(boolean unlocked) {
    Item basicGear = createRangerGear(unlocked, RangerGear.BASIC_GEAR);
    return basicGear;
  }

  public static Item createDecentGear(boolean unlocked) {
    Item decentGear = createRangerGear(unlocked, RangerGear.DECENT_GEAR);
    return decentGear;
  }

  public static Item createExcellentGear(boolean unlocked) {
    Item excellentGear = createRangerGear(unlocked, RangerGear.EXCELLENT_GEAR);
    return excellentGear;
  }

  public static Item createPhenomenalGear(boolean unlocked) {
    Item phenomenalGear = createRangerGear(unlocked, RangerGear.PHENOMENAL_GEAR);
    return phenomenalGear;
  }

  public static Item createMasterGear(boolean unlocked) {
    Item masterGear = createRangerGear(unlocked, RangerGear.MASTER_GEAR);
    return masterGear;
  }

}
