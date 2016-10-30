
public class TickAttackMain {

  public static void main(String[] args) {
		SimpleViewer tViewer = new SimpleViewer("Tick Attack","Game Information");
		Controller controller = new Controller();
    while (true) {
      if (!controller.gamePlaying) {
        tViewer.setController(controller);
        controller.update("");
        TickTimer timer = new TickTimer(controller);
        timer.startTimer();
        controller.gamePlaying = true;
      }
    }
  }

}
