import java.io.Reader;
import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;

public class Controller extends AbstractController implements IController {

  String currentInfoString;
  Player gamePlayer;
  Store acrossBorderStore;
  Store localStore;

  public Controller() {
    super();
    gamePlayer = new Player();
    localStore = StoreFactory.createLocalStore();
    acrossBorderStore = StoreFactory.createAcrossBorderStore();
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
              update(acrossBorderStore.getStoreContents());
            } else {
              showViewsError("Sorry, you need to spend "+acrossBorderStore.getWorkCredAccessCost()+" to access this store.");
            }
          } else {
            showViewsError("You are still performing a task");
          }
          break;
        case "Cheap Meds":
          //Not implemented yet
          break;
        case "Antibiotics":
          //Not implemented yet
          break;
        case "Tick Search":
          if (gamePlayer.getTimeToCompleteTask()==0) {
            TickSearch tSearch = new TickSearch(gamePlayer.useTickTest());
            gamePlayer.setCurrentTask(tSearch);
            update(gamePlayer.getCurrentTask().getInfoString());
          }
          break;
        case "0":

          break;
        case "1":
          System.out.println("Registering!");

          break;
        case "2":
          System.out.println("Registering!");

          break;
        case "3":
          System.out.println("Registering!");

          break;
        case "4":
          System.out.println("Registering!");

          break;
        case "5":
          System.out.println("Registering!");

          break;
        case "6":
          System.out.println("Registering!");

          break;
        case "7":
          System.out.println("Registering!");

          break;
        case "8":
          System.out.println("Registering!");

          break;
        case "9":
          System.out.println("Registering!");

          break;
      }
    }
  }

  public void endGame() {

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
