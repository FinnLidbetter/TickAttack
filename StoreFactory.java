import java.util.ArrayList;
public class StoreFactory {
  public static Store buildLocalStore() {
    ArrayList<Item> storeItems = new ArrayList<Item>();
    Item cheapMeds = new Item("Cheap meds", "Helps you feel better by restoring health", true, 100, 0, 0, 0, 10, 0, 0);
    Item tickTests = new Item("Tick Test", "This tick test can help me do my tick searches!", true, 100, 0, 0, 0, 0, 1, 0);
    Item goodRod = new Item("Good rod", "This fishing rod looks good.", true, 500, 0, 0, 5, 0, 0, 0);
    Item superRod = new Item("Super rod", "This fishing rod is even better than a good rod!", false, 5000, 0, 0, 10, 0, 0, 0);
    Item basicGear = new Item("Basic gear", "This gear will really help me with my park ranger duties!", true, 20000, 0, 5, 0, 0, 0, 0);
    Item decentGear = new Item("Decent gear", "This gear will really help me with my park ranger duties!", false, 80000, 0, 5, 0, 0, 0, 0);

    storeItems.add(cheapMeds);
    storeItems.add(tickTests);
    storeItems.add(goodRod);
    storeItems.add(superRod);
    storeItems.add(basicGear);
    storeItems.add(decentGear);
    return new Store("Local Store", storeItems, 0, 0);
  }

  public static Store buildAcrossBorderStore() {
    ArrayList<Item> storeItems = new ArrayList<Item>();
    Item antibiotics = new Item("Antibiotics", "Treats early stages of Lyme disease", true, 10000, 0, 0, 0, 10, 0, -1);
    Item tickTests = new Item("Tick Test", "This tick test can help me do my tick searches!", true, 100, 0, 0, 0, 0, 1, 0);
    Item greatRod = new Item("Great rod", "This fishing rod is even better than a super rod!", true, 20000, 0, 0, 5, 0, 0, 0);
    Item hyperRod = new Item("Hyper rod", "This fishing rod is even better than a great rod!", false, 80000, 0, 0, 10, 0, 0, 0);
    Item masterRod = new Item("Master rod", "This fishing rod is even better than a hyper rod!", false, 200000, 0, 0, 15, 0, 0, 0);
    Item excellentGear = new Item("Excellent gear", "This gear will really help me with my park ranger duties!", false, 20000, 0, 5, 0, 0, 0, 0);
    Item phenomenalGear = new Item("Phenomenal gear", "This gear will really help me with my park ranger duties!", false, 80000, 0, 5, 0, 0, 0, 0);
    Item masterGear = new Item("Master gear", "This gear will really help me with my park ranger duties!", false, 200000, 0, 5, 0, 0, 0, 0);
    Item treatmentPlan = new Item("Intensive Treatment", "This intensive treatment plan will put you out of work for a while, but will treat middle and early stages of Lyme disease.", true, 100000, 5000, 0, 0, 0, 0, -2);

    storeItems.add(antibiotics);
    storeItems.add(tickTests);
    storeItems.add(greatRod);
    storeItems.add(hyperRod);
    storeItems.add(masterRod);
    storeItems.add(excellentGear);
    storeItems.add(phenomenalGear);
    storeItems.add(masterGear);
    return new Store("Across-Border Store", storeItems, 0, 100);
  }
}
