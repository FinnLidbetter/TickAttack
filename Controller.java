import java.io.Reader;
import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;

public class Controller extends AbstractController implements IController {

  String currentInfoString;
  Player gamePlayer;
  Store acrossBorderStore;
  Store localStore;
  boolean gamePlaying;


  public Controller() {
    super();
    gamePlayer = new Player();
    localStore = StoreFactory.createLocalStore();
    acrossBorderStore = StoreFactory.createAcrossBorderStore();
    gamePlaying = false;
  }


  @Override
  public void process(Object o) {
    if (o instanceof String) {
      String command = (String) o;
      switch (command) {
        case "Fishing Quest":
          FishingQuest fQuest = new FishingQuest(gamePlayer.getFishingSkill());
          if (gamePlayer.getTimeToCompleteTask()==0 && fQuest.canPerformQuest(gamePlayer.getWorkCred()))  {
            gamePlayer.updateWorkCred(-1*fQuest.getWorkCredCost());
            gamePlayer.setCurrentTask(fQuest);
            update(gamePlayer.getCurrentTask().getInfoString());
          } else if (gamePlayer.getTimeToCompleteTask()!=0) {
            showViewsError("You are still performing a task");
          } else {
            showViewsError("Sorry, you do not have enough work cred to go fishin'");
          }
          break;
        case "Ranger Quest":
          if (gamePlayer.getTimeToCompleteTask()==0) {
            RangerQuest rQuest = new RangerQuest(gamePlayer.getRangerSkill());
            gamePlayer.setCurrentTask(rQuest);
            update(gamePlayer.getCurrentTask().getInfoString());
          } else {
            showViewsError("You are still performing a task");
          }
          break;
        case "Cheap Local Store":
          if (gamePlayer.getTimeToCompleteTask()==0) {
            gamePlayer.goToStore(localStore);
            update(localStore.getStoreContents());
          } else {
            showViewsError("You are still performing a task");
          }
          break;
        case "Expensive Across Border Store":
          if (gamePlayer.getTimeToCompleteTask()==0) {
            if (gamePlayer.getWorkCred()>=acrossBorderStore.getWorkCredAccessCost()) {
              gamePlayer.goToStore(acrossBorderStore);
              gamePlayer.spendWorkCred(acrossBorderStore.getWorkCredAccessCost());
              update(acrossBorderStore.getStoreContents());
            } else {
              showViewsError("Sorry, you need to spend "+acrossBorderStore.getWorkCredAccessCost()+" WorkCred to access this store.");
            }
          } else {
            showViewsError("You are still performing a task");
          }
          break;
        case "Cheap Meds":
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
          break;
        case "Antibiotics":
          used = gamePlayer.useAntibiotics();
          if (used) {
            update("Antibiotics used, you are fighting off Lyme disease");
          } else {
            if (gamePlayer.getNumAntibiotics()==0) {
              showViewsError("You don't have any Antibiotics available to use");
            } else {
              showViewsError("You do not have any Lyme disease to treat");
            }
          }
          break;
        case "Tick Search":
          if (gamePlayer.getTimeToCompleteTask()==0) {
            TickSearch tSearch = new TickSearch(gamePlayer.useTickTest());
            gamePlayer.setCurrentTask(tSearch);
            update(gamePlayer.getCurrentTask().getInfoString());
          } else {
            showViewsError("You are still performing a task");
          }
          break;
      }
    }
    else if (o instanceof Integer) {
      if (gamePlayer.getTimeToCompleteTask()==0) {
        Store currentStore = gamePlayer.getCurrentStore();
        for (Item item:currentStore.getAvailableItems()) {
          if (item.getID()==(int)o) {
            if (FishingRod.stringToRodMap.containsKey(item.getName())) {
              FishingRod wantToBuy = FishingRod.stringToRodMap.get(item.getName());
              FishingRod currentRod = gamePlayer.getBestRod();
              if (item.isUnlocked() && ((currentRod==null && wantToBuy.ordinal()==0) || (currentRod!=null && wantToBuy.ordinal()==gamePlayer.getBestRod().ordinal()+1))) {
                long itemStreetCredCost = item.getStreetCredCost();
                long itemWorkCredCost = item.getWorkCredCost();
                if (gamePlayer.getStreetCred()>=itemStreetCredCost) {
                  if (gamePlayer.getWorkCred()>=itemWorkCredCost) {
                    gamePlayer.spendStreetCred(itemStreetCredCost);
                    gamePlayer.spendWorkCred(itemWorkCredCost);
                    gamePlayer.incrementFishingSkill(item.getFishingSkillGain());
                    gamePlayer.setBestRod(wantToBuy);
                  } else {
                    showViewsError("You don't have enough WorkCred to purchase this item");
                  }
                } else {
                  showViewsError("You don't have enough StreetCred to purchase this item");
                  System.out.println("Printing here");
                }
              } else {
                showViewsError("Sorry, this item is not yet unlocked for purchase");
              }
              break;
            }
            else if (RangerGear.stringToGearMap.containsKey(item.getName())) {
              RangerGear wantToBuy = RangerGear.stringToGearMap.get(item.getName());
              RangerGear currentGear = gamePlayer.getBestGear();
              if (item.isUnlocked() && ((currentGear==null && wantToBuy.ordinal()==0) || (currentGear!=null && wantToBuy.ordinal()==gamePlayer.getBestGear().ordinal()+1))) {
                long itemStreetCredCost = item.getStreetCredCost();
                long itemWorkCredCost = item.getWorkCredCost();
                if (gamePlayer.getStreetCred()>=itemStreetCredCost) {
                  if (gamePlayer.getWorkCred()>=itemWorkCredCost) {
                    gamePlayer.spendStreetCred(itemStreetCredCost);
                    gamePlayer.spendWorkCred(itemWorkCredCost);
                    gamePlayer.incrementRangerSkill(item.getRangerSkillGain());
                    gamePlayer.setBestGear(wantToBuy);
                  } else {
                    showViewsError("You don't have enough WorkCred to purchase this item");
                  }
                } else {
                  showViewsError("You don't have enough StreetCred to purchase this item");
                  System.out.println("Printing here");
                }
              } else {
                showViewsError("Sorry, this item is not yet unlocked for purchase");
              }
              break;
            }
            else if (item.isUnlocked()) {
              long itemStreetCredCost = item.getStreetCredCost();
              long itemWorkCredCost = item.getWorkCredCost();
              if (gamePlayer.getWorkCred()>=itemWorkCredCost) {
                if (gamePlayer.getStreetCred()>=itemStreetCredCost) {
                  gamePlayer.spendWorkCred(itemWorkCredCost);
                  gamePlayer.spendStreetCred(itemStreetCredCost);
                  if (item.getName().equals("Antibiotics")) {
                    gamePlayer.incrementNumAntibiotics(1);
                  } else if (item.getName().equals("Cheap Meds")) {
                    gamePlayer.incrementNumCheapMeds(1);
                  } else if (item.getName().equals("Tick Test")) {
                    gamePlayer.incrementNumTickTests(1);
                  }
                } else {
                  showViewsError("You don't have enough StreetCred to purchase this item");
                }
              } else {
                showViewsError("You don't have enough WorkCred to purchase this item");
              }
            } else {
              showViewsError("Sorry, you haven't yet unlocked the ability to purchase this item");
            }
            break;
          }
        }
      } else {
        showViewsError("You are still performing a task");
      }
    }
  }

  public void endGame() {
    showViewsError("You died, game over!");

    update();
  }

  public void update() {
    notifyViews(gamePlayer);
  }

  public void update(String infoString) {
    currentInfoString = infoString;
    notifyViews(gamePlayer, infoString);
  }

  public String getCurrentInfoString() {
    return currentInfoString;
  }

  public Player getPlayer() {
    return gamePlayer;
  }

}
