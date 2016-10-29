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

  private static int OLD_ROD_STREETCRED_COST = 100;
  private static int OLD_ROD_WORKCRED_COST = 0;
  private static int OLD_ROD_FISHING_SKILL_GAIN = 1;

  private static int GOOD_ROD_STREETCRED_COST = 500;
  private static int GOOD_ROD_WORKCRED_COST = 0;
  private static int GOOD_ROD_FISHING_SKILL_GAIN = 2;

  private static int SUPER_ROD_STREETCRED_COST = 5000;
  private static int SUPER_ROD_WORKCRED_COST = 0;
  private static int SUPER_ROD_FISHING_SKILL_GAIN = 3;

  private static int GREAT_ROD_STREETCRED_COST = 50000;
  private static int GREAT_ROD_WORKCRED_COST = 0;
  private static int GREAT_ROD_FISHING_SKILL_GAIN = 4;

  private static int HYPER_ROD_STREETCRED_COST = 500000;
  private static int HYPER_ROD_WORKCRED_COST = 0;
  private static int HYPER_ROD_FISHING_SKILL_GAIN = 5;

  private static int MASTER_ROD_STREETCRED_COST = 5000000;
  private static int MASTER_ROD_WORKCRED_COST = 0;
  private static int MASTER_ROD_FISHING_SKILL_GAIN = 6;

  private static int BASIC_GEAR_STREETCRED_COST = 500;
  private static int BASIC_GEAR_WORKCRED_COST = 0;
  private static int BASIC_GEAR_RANGER_SKILL_GAIN = 1;

  private static int DECENT_GEAR_STREETCRED_COST = 5000;
  private static int DECENT_GEAR_WORKCRED_COST = 0;
  private static int DECENT_GEAR_RANGER_SKILL_GAIN = 2;

  private static int EXCELLENT_GEAR_STREETCRED_COST = 50000;
  private static int EXCELLENT_GEAR_WORKCRED_COST = 0;
  private static int EXCELLENT_GEAR_RANGER_SKILL_GAIN = 3;

  private static int PHENOMENAL_GEAR_STREETCRED_COST = 500000;
  private static int PHENOMENAL_GEAR_WORKCRED_COST = 0;
  private static int PHENOMENAL_GEAR_RANGER_SKILL_GAIN = 4;

  private static int MASTER_GEAR_STREETCRED_COST = 5000000;
  private static int MASTER_GEAR_WORKCRED_COST = 0;
  private static int MASTER_GEAR_RANGER_SKILL_GAIN = 5;

  public static Item createAntibiotics(boolean unlocked) {
    Item antibiotics = new Item("Antibiotics", "Treats early stages of Lyme disease",
    true, ANTIBIOTICS_STREETCRED_COST, ANTIBIOTICS_WORKCRED_COST, 0, 0, ANTIBIOTICS_HEALTH_GAIN);
    return antibiotics;
  }
  public static Item createTickTest(boolean unlocked) {
    Item tickTest = new Item("Tick Test", "This tick test can help me do my tick searches!", true,
    TICKTEST_STREETCRED_COST, TICKTEST_WORKCRED_COST, 0, 0, TICKTEST_HEALTH_GAIN);
    return tickTest;
  }

  public static Item createCheapMeds(boolean unlocked) {
    Item cheapMeds = new Item("Cheap meds", "Helps you feel better by restoring health", true,
    CHEAPMEDS_STREETCRED_COST, CHEAPMEDS_WORKCRED_COST, 0, 0, CHEAPMEDS_HEALTH_GAIN);
    return cheapMeds;
  }

  public static Item createOldRod(boolean unlocked) {
    Item oldRod = new Item("Old rod", "This fishing rod looks a little tired.", true,
    OLD_ROD_STREETCRED_COST, OLD_ROD_WORKCRED_COST, 0, OLD_ROD_FISHING_SKILL_GAIN, 0);
    return oldRod;
  }

  public static Item createGoodRod(boolean unlocked) {
    Item goodRod = new Item("Good rod", "This fishing rod looks ok.", true,
    GOOD_ROD_STREETCRED_COST, GOOD_ROD_WORKCRED_COST, 0, GOOD_ROD_FISHING_SKILL_GAIN, 0);
    return goodRod;
  }

  public static Item createSuperRod(boolean unlocked) {
    Item superRod = new Item("Super rod", "This fishing rod is even better than a good rod!", true,
    SUPER_ROD_STREETCRED_COST, SUPER_ROD_WORKCRED_COST, 0, SUPER_ROD_FISHING_SKILL_GAIN, 0);
    return superRod;
  }

  public static Item createGreatRod(boolean unlocked) {
    Item greatRod = new Item("Great rod", "This fishing rod is even better than a super rod!", true,
    GREAT_ROD_STREETCRED_COST, GREAT_ROD_WORKCRED_COST, 0, GREAT_ROD_FISHING_SKILL_GAIN, 0);
    return greatRod;
  }

  public static Item createHyperRod(boolean unlocked) {
    Item hyperRod = new Item("Hyper rod", "This fishing rod is even better than a great rod!", true,
    HYPER_ROD_STREETCRED_COST, HYPER_ROD_WORKCRED_COST, 0, HYPER_ROD_FISHING_SKILL_GAIN, 0);
    return hyperRod;
  }

  public static Item createMasterRod(boolean unlocked) {
    Item masterRod = new Item("Master rod", "This fishing rod is even better than a hyper rod!", true,
    MASTER_ROD_STREETCRED_COST, MASTER_ROD_WORKCRED_COST, 0, MASTER_ROD_FISHING_SKILL_GAIN, 0);
    return masterRod;
  }

  public static Item createBasicGear(boolean unlocked) {
    Item basicGear = new Item("Basic gear", "This gear will really help me with my park ranger duties!", true,
    BASIC_GEAR_STREETCRED_COST, BASIC_GEAR_WORKCRED_COST, BASIC_GEAR_RANGER_SKILL_GAIN, 0, 0);
    return basicGear;
  }

  public static Item createDecentGear(boolean unlocked) {
    Item decentGear = new Item("Decent gear", "This gear will really help me with my park ranger duties!", true,
    DECENT_GEAR_STREETCRED_COST, DECENT_GEAR_WORKCRED_COST, DECENT_GEAR_RANGER_SKILL_GAIN, 0, 0);
    return decentGear;
  }

  public static Item createExcellentGear(boolean unlocked) {
    Item excellentGear = new Item("Excellent gear", "This gear will really help me with my park ranger duties!", true,
    EXCELLENT_GEAR_STREETCRED_COST, EXCELLENT_GEAR_WORKCRED_COST, EXCELLENT_GEAR_RANGER_SKILL_GAIN, 0, 0);
    return excellentGear;
  }

  public static Item createPhenomenalGear(boolean unlocked) {
    Item phenomenalGear = new Item("Phenomenal gear", "This gear will really help me with my park ranger duties!", true,
    PHENOMENAL_GEAR_STREETCRED_COST, PHENOMENAL_GEAR_WORKCRED_COST, PHENOMENAL_GEAR_RANGER_SKILL_GAIN, 0, 0);
    return phenomenalGear;
  }

  public static Item createMasterGear(boolean unlocked) {
    Item masterGear = new Item("Master gear", "This gear will really help me with my park ranger duties!", true,
    MASTER_GEAR_STREETCRED_COST, MASTER_GEAR_WORKCRED_COST, MASTER_GEAR_RANGER_SKILL_GAIN, 0, 0);
    return masterGear;
  }
}
