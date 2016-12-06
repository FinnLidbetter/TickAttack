public class BrewPotion implements Task {

  Item brewedPotion;
  String infoString;

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

  public void setFinishedBrew() {
    infoString = "You successfully brewed a " + brewedPotion.getName()+"!";
  }

  public int getTimeToComplete() {
    return MIN_TASK_TIME;
  }
}
