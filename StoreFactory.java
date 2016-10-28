import java.util.ArrayList;
public class StoreFactory {
  private static int LOCAL_STORE_STREETCRED_COST = 0;
  private static int LOCAL_STORE_WORKCRED_COST = 0;

  private static int ACROSS_BORDER_STORE_STREETCRED_COST = 0;
  private static int ACROSS_BORDER_STORE_WORKCRED_COST = 100;

  public static Store createLocalStore() {
    ArrayList<Item> storeItems = new ArrayList<Item>();
    storeItems.add(ItemFactory.createCheapMeds());
    storeItems.add(ItemFactory.createTickTest());
    storeItems.add(ItemFactory.createOldRod());
    storeItems.add(ItemFactory.createGoodRod());
    storeItems.add(ItemFactory.createSuperRod());
    storeItems.add(ItemFactory.createBasicGear());
    storeItems.add(ItemFactory.createDecentGear());
    return new Store("Local Store", storeItems,
    LOCAL_STORE_STREETCRED_COST, LOCAL_STORE_WORKCRED_COST);
  }

  public static Store createAcrossBorderStore() {
    ArrayList<Item> storeItems = new ArrayList<Item>();
    storeItems.add(ItemFactory.createAntibiotics());
    storeItems.add(ItemFactory.createTickTest());
    storeItems.add(ItemFactory.createGreatRod());
    storeItems.add(ItemFactory.createHyperRod());
    storeItems.add(ItemFactory.createMasterRod());
    storeItems.add(ItemFactory.createExcellentGear());
    storeItems.add(ItemFactory.createPhenomenalGear());
    storeItems.add(ItemFactory.createMasterGear());
    return new Store("Across-Border Store", storeItems,
    ACROSS_BORDER_STORE_STREETCRED_COST, ACROSS_BORDER_STORE_WORKCRED_COST);
  }
}
