import java.util.ArrayList;

/**
 * StoreFactory class has methods for initialising the Stores with their Items
 * @author Finn Lidbetter, Michael Bradet-Legris
 * @version 1.0, 16/10/31
 */

public class StoreFactory {
  private static int LOCAL_STORE_STREETCRED_COST = 0;
  private static int LOCAL_STORE_WORKCRED_COST = 0;

  private static int ACROSS_BORDER_STORE_STREETCRED_COST = 0;
  private static int ACROSS_BORDER_STORE_WORKCRED_COST = 100;

  private static int WITCH_HUT_STREETCRED_COST = 1000;
  private static int WITCH_HUT_WORKCRED_COST = 1000;

  /**
   * Creates the Local Store
   * @return the initialised Local Store
   */
  public static Store createLocalStore() {
    ArrayList<Item> storeItems = new ArrayList<Item>();
    storeItems.add(ItemFactory.createCheapMeds(true));
    storeItems.add(ItemFactory.createTickTest(true));
    storeItems.add(ItemFactory.createOldRod(true));
    storeItems.add(ItemFactory.createGoodRod(true));
    storeItems.add(ItemFactory.createSuperRod(true));
    storeItems.add(ItemFactory.createBasicGear(true));
    storeItems.add(ItemFactory.createDecentGear(true));
    Store bobs =  new Store("Local Store", "Welcome to Bob's Local Outdoors Store.\nPurchase items by entering a digit [0-9] matching the item you wish to purchase.", storeItems,
    LOCAL_STORE_STREETCRED_COST, LOCAL_STORE_WORKCRED_COST);
    bobs.setItemIDs();
    return bobs;
  }

  /**
   * Creates the across border store
   * @return the initialised across border store
   */
  public static Store createAcrossBorderStore() {
    ArrayList<Item> storeItems = new ArrayList<Item>();
    storeItems.add(ItemFactory.createAntibiotics(true));
    storeItems.add(ItemFactory.createTickTest(true));
    storeItems.add(ItemFactory.createGreatRod(true));
    storeItems.add(ItemFactory.createHyperRod(true));
    storeItems.add(ItemFactory.createMasterRod(true));
    storeItems.add(ItemFactory.createExcellentGear(true));
    storeItems.add(ItemFactory.createPhenomenalGear(true));
    storeItems.add(ItemFactory.createMasterGear(true));
    storeItems.add(ItemFactory.createIntensiveTreatmentPlan(true));
    Store joes = new Store("Across-Border Store","Welcome to Joe's Giant Outdoors Emporium.\nPurchase items by entering a digit [0-9] matching the item you wish to purchase." , storeItems,
    ACROSS_BORDER_STORE_STREETCRED_COST, ACROSS_BORDER_STORE_WORKCRED_COST);
    joes.setItemIDs();
    return joes;
  }

  /**
   * Method to create the Witch's Hut
   * @return the initialised Witch's Hut
   */
  public static Store createWitchHut() {
    ArrayList<Item> storeItems = new ArrayList<Item>();
    storeItems.add(ItemFactory.createPotionBook(true));
    storeItems.add(ItemFactory.createTickLegs(true));
    storeItems.add(ItemFactory.createEyeOfNewt(true));
    Store witchHut = new Store("The Witch's Hut","Welcome to my Hut.\nPurchase items by entering a digit [0-9] if you dare", storeItems,
    WITCH_HUT_STREETCRED_COST, WITCH_HUT_WORKCRED_COST);
    witchHut.setItemIDs();
    return witchHut;
  }
}
