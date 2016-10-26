import java.io.Reader;
import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;

public class Controller extends AbstractController implements IController {

  String currentInfoString;
  Player gamePlayer;
  ArrayList<Store> stores;

  public Controller() {
    super();
    gamePlayer = new Player();

    stores = new ArrayList<Store>();
    //stores.add(buildCheapStore());
    //stores.add(buildExpensiveStore());
  }


  @Override
  public void process(Object o) {
    if (o instanceof String) {
      String command = (String) o;
      switch (command) {
        case "Fishing Quest":

          FishingQuest fQuest = new FishingQuest(gamePlayer.getFishingSkill());
          gamePlayer.setCurrentTask(fQuest);

          break;
        case "Ranger Quest":
          if (gamePlayer.getTimeToCompleteTask()==0) {
            RangerQuest rQuest = new RangerQuest(gamePlayer.getRangerSkill());
            gamePlayer.setCurrentTask(rQuest);
            update(gamePlayer.getCurrentTask().getInfoString());
          }
          break;
        case "Cheap Local Store":
          //Not implemented yet
          //gamePlayer.goToStore(); //insert ref. to Cheap Local Store
          break;
        case "Big Expensive Foreign Store":
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
          //Not implemented yet
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
