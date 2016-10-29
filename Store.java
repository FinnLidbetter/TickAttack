import java.util.ArrayList;

public class Store {
  private String storeName;
  private ArrayList<Item> availableItems;
  private int streetCredAccessCost;
  private int workCredAccessCost;
  private String infoString;

  public Store(String name, String infoString, ArrayList<Item> initialItems, int streetCredCost, int workCredCost) {
    storeName = name;
    this.infoString = infoString;
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

  public void setItemIDs() {
    int idCounter = 0;
    ArrayList<Item> items = getAvailableItems();
    for (int i=0; i<items.size(); i++) {
      items.get(i).setID(idCounter);
      idCounter++;
    }
  }
}
