import java.io.Reader;
import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;

public class Controller extends AbstractController implements IController {

  String currentInfoString;
  Player gamePlayer;
  Store expensiveStore;
  Store localStore;

  public Controller() {
    super();
    gamePlayer = new Player();
    localStore = StoreFactory.createLocalStore();
    expensiveStore = StoreFactory.createAcrossBorderStore();
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
          } else if (gamePlayer.getTimeToCompleteTask()==0) {
            update("You are still performing a task.");
          } else {
            update("Sorry, you do not have enough work cred to go fishing.");
          }
          break;
        case "Ranger Quest":
          if (gamePlayer.getTimeToCompleteTask()==0) {
            RangerQuest rQuest = new RangerQuest(gamePlayer.getRangerSkill());
            gamePlayer.setCurrentTask(rQuest);
            update(gamePlayer.getCurrentTask().getInfoString());
          } else {
            update("You are still performing a task.");
          }
          break;
        case "Cheap Local Store":
          //Not implemented yet
          //gamePlayer.goToStore(); //insert ref. to Cheap Local Store
          break;
        case "Expensive Across Border Foreign Store":
          //Not implemented yet
          //gamePlayer.goToStore(); // insert ref. to Expensive Store
          break;
        case "Cheap Meds":
          //Not implemented yet
          break;
        case "Antibiotics":
          //Not implemented yet
          break;
        case "Tick Search":
          if (gamePlayer.getTimeToCompleteTask()==0) {
            TickSearch tSearch = new TickSearch();
            gamePlayer.setCurrentTask(tSearch);
            update(gamePlayer.getCurrentTask().getInfoString());
          }
          break;
        case "0":
          System.out.println("Registering!");
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
