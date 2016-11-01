/**
 * Controller class communicates information between the Models and the View in
 * order to run the TickAttack game
 * @author Finn Lidbetter, Michael Bradet-Legris
 * @version 1.0, 16/10/31
 */
public class Controller extends AbstractController implements IController {

  Player gamePlayer;
  Store acrossBorderStore;
  Store localStore;

  /**
   * Constructor that initialises the controller for the TickAttack game
   */
  public Controller() {
    super();
    gamePlayer = new Player();
    localStore = StoreFactory.createLocalStore();
    acrossBorderStore = StoreFactory.createAcrossBorderStore();
  }

  /**
   * Resets the values in the player and the controller such that a new gamePlayer
   * can be started
   */
  public void resetController() {
    this.gamePlayer = new Player();
    this.localStore = StoreFactory.createLocalStore();
    this.acrossBorderStore = StoreFactory.createAcrossBorderStore();
  }

  /**
   * Method to process an object given by the view
   * @param o - The object that the controller must process
   */
  @Override
  public void process(Object o) {
    if (o instanceof String) {
      String command = (String) o;
      process(command);
    }
    else if (o instanceof Integer) {
      int command = (int) o;
      process(command);
    }
  }

  /**
   * Helper method to process all instructions given in the form of a String
   * @param instruction - The given instruction
   */
  private void process(String instruction) {
      switch (instruction) {
        case "Fishing Quest":
          FishingQuest fQuest = new FishingQuest(gamePlayer.getFishingSkill());
          attemptStartQuest(fQuest);
          break;
        case "Ranger Quest":
          RangerQuest rQuest = new RangerQuest(gamePlayer.getRangerSkill());
          attemptStartQuest(rQuest);
          break;
        case "Cheap Local Store":
          attemptGoToStore(localStore);
          break;
        case "Expensive Across Border Store":
          attemptGoToStore(acrossBorderStore);
          break;
        case "Cheap Meds":
          attemptUseCheapMeds();
          break;
        case "Antibiotics":
          attemptUseAntibiotics();
          break;
        case "Tick Search":
          attemptTickSearch();
          break;
      }
  }

  /**
   * Helper method to handle processing integer instructions for purchasing items
   * @param instruction - variable indicating which item to purchase
   */
  private void process(int instruction) {
    if (gamePlayer.getTimeToCompleteTask()!=0) {
      showViewsError("You are still performing a task");
    } else {
      // All int instuctions are for the purpose of buying an item
      Store currentStore = gamePlayer.getCurrentStore();
      Item desiredItem = findItemInStore(currentStore, instruction);
      if (desiredItem==null)
        return;
      String desiredItemName = desiredItem.getName();
      boolean itemAvailable = true;
      if (FishingRod.stringToRodMap.containsKey(desiredItemName)) {
        FishingRod desiredRod = FishingRod.stringToRodMap.get(desiredItemName);
        FishingRod bestRod = gamePlayer.getBestRod();
        itemAvailable = isSkillBoosterAvailable(desiredRod, bestRod);
      } else if (RangerGear.stringToGearMap.containsKey(desiredItemName)) {
        RangerGear desiredGear = RangerGear.stringToGearMap.get(desiredItemName);
        RangerGear bestGear = gamePlayer.getBestGear();
        itemAvailable = isSkillBoosterAvailable(desiredGear, bestGear);
      }
      if (!itemAvailable || !desiredItem.isUnlocked()) {
        showViewsError("Sorry, this item is not currently available for purchase");
        return;
      }
      attemptItemPurchase(desiredItem);
    }
  }

  /**
   * Helper method to start a quest
   * @param quest - The quest that we are attempting to start
   */
  private void attemptStartQuest(Quest quest) {
    if (gamePlayer.getTimeToCompleteTask()==0 && quest.canPerformQuest(gamePlayer.getWorkCred()))  {
      gamePlayer.spendWorkCred(quest.getWorkCredCost());
      gamePlayer.setCurrentTask(quest);
      update(gamePlayer.getCurrentTask().getInfoString());
    } else if (gamePlayer.getTimeToCompleteTask()!=0) {
      showViewsError("You are still performing a task");
    } else {
      showViewsError("Sorry, you do not have enough work cred to go on this quest");
    }
  }

  /**
   * Helper method to go to a store
   * @param store - The store that we are attempting to go to
   */
  private void attemptGoToStore(Store store) {
    if (gamePlayer.getTimeToCompleteTask()!=0) {
      showViewsError("You are still performing a task");
    } else if (gamePlayer.getStreetCred()<store.getStreetCredAccessCost()) {
      showViewsError("Sorry, you need to spend "+store.getStreetCredAccessCost()+" StreetCred to access this store.");
    } else if (gamePlayer.getWorkCred()<store.getWorkCredAccessCost()) {
      showViewsError("Sorry, you need to spend "+store.getWorkCredAccessCost()+" WorkCred to access this store.");
    } else {
      gamePlayer.goToStore(store);
      gamePlayer.spendStreetCred(store.getStreetCredAccessCost());
      gamePlayer.spendWorkCred(store.getWorkCredAccessCost());
      update(store.getStoreContents());
    }
  }

  /**
   * Helper method to attempt to use the Cheap Meds item
   */
  private void attemptUseCheapMeds() {
    boolean used = gamePlayer.useCheapMeds();
    if (used) {
      update("Cheap Meds consumed, +10 health");
    } else {
      if (gamePlayer.getNumCheapMeds()==0) {
        showViewsError("You don't have any Cheap Meds available to use");
      } else {
        showViewsError("You are already at maximum health");
      }
    }
  }

  /**
   * Helper method to attempt to use the Antibiotics item
   */
  private void attemptUseAntibiotics() {
    boolean used = gamePlayer.useAntibiotics();
    if (used) {
      update("Antibiotics used, you are fighting off Lyme disease");
    } else {
      if (gamePlayer.getNumAntibiotics()==0) {
        showViewsError("You don't have any Antibiotics available to use");
      } else {
        showViewsError("You do not have any Lyme disease to treat");
      }
    }
  }

  /**
   * Helper method to attempt to start a Tick Search
   */
  private void attemptTickSearch() {
    if (gamePlayer.getTimeToCompleteTask()==0) {
      TickSearch tSearch = new TickSearch();
      gamePlayer.setCurrentTask(tSearch);
      update(gamePlayer.getCurrentTask().getInfoString());
    } else {
      showViewsError("You are still performing a task");
    }
  }

  /**
   * Finds an item with specified itemID in the given Store
   * @param store - the store in which the item is being looked for
   * @param itemID - the ID of the item that is being looked for
   * @return the Item in the store matching the ID, or null if not found
   */
  private Item findItemInStore(Store store, int itemID) {
    for (Item item:store.getAvailableItems()) {
      if (item.getID()==itemID) {
        return item;
      }
    }
    return null;
  }

  /**
   * Checks if the Enum item can be purchased based on the items already owned
   * @param desiredItem - the item that we are trying to buy
   * @param currentBest - the best version of that item that is already owned
   * @return true if the item is available for purchase, false otherwise
   */
  private boolean isSkillBoosterAvailable(Enum desiredItem, Enum currentBest) {
    if (currentBest==null && desiredItem.ordinal()==0) {
      return true;
    } else if (currentBest==null) {
      return false;
    }
    // Check if the desiredItem is the next skill booster in the ordering
    if (currentBest.ordinal()+1==desiredItem.ordinal()) {
      return true;
    }
    return false;
  }

  /**
   * Helper method to attempt the purchase of an item
   * @param desiredItem - the Item that we are trying to purchase. This is assumed to be available for purchase
   */
  private void attemptItemPurchase(Item desiredItem) {
    long itemStreetCredCost = desiredItem.getStreetCredCost();
    long itemWorkCredCost = desiredItem.getWorkCredCost();
    if (gamePlayer.getStreetCred()<itemStreetCredCost) {
      showViewsError("You don't have enough StreetCred to purchase this item");
    } else if (gamePlayer.getWorkCred()<itemWorkCredCost) {
      showViewsError("You don't have enough WorkCred to purchase this item");
    } else { // All conditions met to allow purchase
      purchaseItem(desiredItem);
    }
  }

  /**
   * Helper method to apply the effects of buying an item
   * @param desiredItem - The item that will be purchased
   */
  private void purchaseItem(Item desiredItem) {
    String desiredItemName = desiredItem.getName();
    long itemStreetCredCost = desiredItem.getStreetCredCost();
    long itemWorkCredCost = desiredItem.getWorkCredCost();
    gamePlayer.spendStreetCred(itemStreetCredCost);
    gamePlayer.spendWorkCred(itemWorkCredCost);
    gamePlayer.incrementFishingSkill(desiredItem.getFishingSkillGain());
    gamePlayer.incrementRangerSkill(desiredItem.getRangerSkillGain());
    if (FishingRod.stringToRodMap.containsKey(desiredItemName))
      gamePlayer.setBestRod(FishingRod.stringToRodMap.get(desiredItemName));
    if (RangerGear.stringToGearMap.containsKey(desiredItemName))
      gamePlayer.setBestGear(RangerGear.stringToGearMap.get(desiredItemName));
    if (desiredItemName.equals("Cheap Meds"))
      gamePlayer.incrementNumCheapMeds(1);
    if (desiredItemName.equals("Tick Test"))
      gamePlayer.incrementNumTickTests(1);
    if (desiredItemName.equals("Antibiotics"))
      gamePlayer.incrementNumAntibiotics(1);
    if (desiredItemName.equals("Intensive Treatment Plan")) {
      if (!gamePlayer.useIntensiveTreatment()) {
        // If treatment plan cannot be used, refund spendings and show error
        gamePlayer.updateStreetCred(itemStreetCredCost);
        gamePlayer.updateWorkCred(itemWorkCredCost);
        showViewsError("The Intensive Treatment Plan cannot be bought if you don't have Lyme Disease");
      } else {
        // plan used successfully
      }
    }
  }

  /**
   * Ends the game in failure. Called when player health is 0
   */
  public void endGameDead() {
    showViewsError("You died, game over!");
    resetController();
    update();
  }

  /**
   * Ends the game with success. Called when the player reaches 100,000 Work Cred
   */
  public void endGameWin() {
    showViewsError("You have won the game! You may retire in peace after a remarkable career as a Park Ranger.\nLet's hope the next Park Ranger can continue your legacy.");
    resetController();
    update();
  }

  /**
   * Method to interact with the view
   */
  public void update() {
    notifyViews(gamePlayer);
  }

  /**
   * Method to interact with the view
   * @param infoString - message to be displayed in the view
   */
  public void update(String infoString) {
    notifyViews(gamePlayer, infoString);
  }

  /**
   * Returns a reference to the game player
   * @return a reference to this controller's player
   */
  public Player getPlayer() {
    return gamePlayer;
  }
}
