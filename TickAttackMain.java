
public class TickAttackMain {

  public static void main(String[] args) {
		SimpleViewer tViewer = new SimpleViewer("Tick Attack","Game Information");
		Controller controller = new Controller();
    tViewer.setController(controller);
    controller.update("");
    TickTimer timer = new TickTimer(controller);
    timer.startTimer();
  }

}
