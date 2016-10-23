import java.util.ArrayList;

public class Store {
  private String storeName;
  private ArrayList<Item> availableItems;
  private int streetCredAccessCost;
  private int workCredAccessCost;
  private String infoString;
  
  public Store(String name, ArrayList<Item> initialItems, int streetCredCost, int workCredCost) {
    storeName = name;
    availableItems = initialItems;
    streetCredAccessCost = streetCredCost;
    workCredAccessCost = workCredCost;
    infoString = ""; // INSERT APPROPRIATE INFO STRING HERE
  }
  
  public void addItem(Item toAdd) {
    if (!availableItems.contains(toAdd))
      availableItems.add(toAdd);
  }

  public String getStoreName() {
    return storeName;
  }

  public ArrayList<Item> getAvailableItems() {
    return availableItems;
  }

  public int getStreetCredAccessCost() {
    return streetCredAccessCost;
  }

  public int getWorkCredAccessCost() {
    return workCredAccessCost;
  }

  public String getInfoString() {
    return infoString;
  }
  
  public void setInfoString(String newInfoString) {
    infoString = newInfoString;
  }
}
