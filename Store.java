import java.util.ArrayList;

/**
 * Store class gives a way to keep track of a set of items available for purchase
 * @author Finn Lidbetter, Michael Bradet-Legris
 * @version 1.0, 16/10/31
 */
public class Store {
  private String storeName;
  private ArrayList<Item> availableItems;
  private int streetCredAccessCost;
  private int workCredAccessCost;
  private String infoString;

  /**
   * Conctructor for a store
   */
  public Store(String name, String infoString, ArrayList<Item> initialItems, int streetCredCost, int workCredCost) {
    storeName = name;
    this.infoString = infoString;
    availableItems = initialItems;
    streetCredAccessCost = streetCredCost;
    workCredAccessCost = workCredCost;
    infoString = "";
  }

  /**
   * Adds an item to the item list
   * @param toAdd - an item to be added to this Store's item list
   */
  public void addItem(Item toAdd) {
    if (!availableItems.contains(toAdd))
      availableItems.add(toAdd);
  }

  /**
   * Gets the name of the store
   * @return the name of the store
   */
  public String getStoreName() {
    return storeName;
  }

  /**
   * Gets the list of items available at this store
   * @return the list of items that can be bought at this store
   */
  public ArrayList<Item> getAvailableItems() {
    return availableItems;
  }

  /**
   * Gets the StreetCred cost for accessing this store
   * @return the StreetCred cost to access this store
   */
  public int getStreetCredAccessCost() {
    return streetCredAccessCost;
  }

  /**
   * Gets the WorkCred cost for accessing this store
   * @return the WorkCred cost to access this store
   */
  public int getWorkCredAccessCost() {
    return workCredAccessCost;
  }

  /**
   * Gets the info string for this store
   * @return the info string for this store
   */
  public String getInfoString() {
    return infoString;
  }

  /**
   * Gets a string representation of all of the items in the store
   * @return a string representation of all of the items in the store
   */
  public String getStoreContents() {
    String storeRepresentation = getInfoString();
    storeRepresentation += "\n";
    for (Item i:getAvailableItems()) {
      String itemString = ""+i.getID();
      itemString += ": " + i.getName();
      itemString += ", ";
      itemString += "StreetCred cost: " + i.getStreetCredCost();
      itemString += ", ";
      itemString += "WorkCred cost: " + i.getWorkCredCost();
      itemString += "\n\t"+i.getInfoString();
      storeRepresentation += itemString;
      storeRepresentation += "\n";
    }
    return storeRepresentation;
  }

  /**
   * Initialises the IDs of the items in the store
   */
  public void setItemIDs() {
    int idCounter = 0;
    ArrayList<Item> items = getAvailableItems();
    for (int i=0; i<items.size(); i++) {
      items.get(i).setID(idCounter);
      idCounter++;
    }
  }
}
