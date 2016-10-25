import java.io.Reader;
import java.util.Collection;
import java.util.Scanner;


public class Controller extends AbstractController implements IController {

  Player gamePlayer;
  ArrayList<Store> stores;

  public Controller() {
    super();
    gamePlayer = new Player();
    stores = new ArrayList<Store>();
    
  }


  @Override
  public void process(Object o) {
    if (o instanceof String) {
      String command = (String) o;
      switch (command) {
        case "Fishing Quest":

        case "Ranger Quest":

        case "Cheap Local Store":

        case "Big Expensive Foreign Store":

        case "Cheap Meds":

        case "Antibiotics":

        case "Tick Search":

      }
    }
  }

  @Override
  public void notifyViews(String output) {

  }

  public Player getPlayer() {
    return gamePlayer;
  }

}
