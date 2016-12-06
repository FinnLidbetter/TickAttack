/**
 * Task for brewing a potion
 * @author Finn Lidbetter, Patrick Coyle
 * @version 1.0, 16/12/06
 */
public class BrewPotion implements Task {

  Item brewedPotion;
  String infoString;

  /**
   * Constructor for the BrewPotion task
   */
  public BrewPotion(String potionName) {
    switch(potionName) {
      case "Fishing Potion":
        brewedPotion = ItemFactory.createFishingPotion(true);
        break;
      case "Ranger Potion":
        brewedPotion = ItemFactory.createRangerPotion(true);
        break;
      case "Fusion Potion":
        brewedPotion = ItemFactory.createFusionPotion(true);
        break;
      default:
        brewedPotion = null;
        break;
    }
    infoString = "Brewing a potion";
  }

  public Item getBrewedPotion() {
    return brewedPotion;
  }

  public String getInfoString() {
    return infoString;
  }

  public int getTimeToComplete() {
    return MIN_TASK_TIME;
  }

  /**
   * Update the info string to indicate that the potion has been brewed
   */
  public void setFinishedBrew() {
    infoString = "You successfully brewed a " + brewedPotion.getName()+"!";
  }
}
