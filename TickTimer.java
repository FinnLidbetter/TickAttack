import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class TickTimer {

	private static final int MILLISECONDS_BETWEEN_ACTIONS = 100;
	private Timer timer;
	private Controller controller;
	private Player player;

	public TickTimer(Controller controller){
		this.controller = controller;
		this.player = controller.getPlayer();
		this.timer = new Timer(MILLISECONDS_BETWEEN_ACTIONS, new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				update();
			}
		});
	}

	private void update(){
		player.incrementPerSecondStreetCred();
		player.incrementPerSecondHealth();
		player.incrementInfectionStage();
		ArrayList<Tick> ticks = player.getTicks();
		for (int i=0; i<ticks.size(); i++){
			if (ticks.get(i).suckBlood()) {
				if (ticks.get(i).hasLymeDisease()) {
					player.infect();
				}
				ticks.remove(i);
				i--;
				player.adjustHealth(-10);
				controller.showViewsError("You just found a big tick on you and may have been infected with Lyme disease. (-10 Health)");
			}
		}

		if (!player.isAlive())
			controller.endGame();

		Task task = player.decrementTimeToCompleteTask();
		if (task != null){
			if (task instanceof TickSearch){
				TickSearch action = (TickSearch)task;
				action.attemptRemovingTicks(player.getTicks(), player.useTickTest());
			}
			else {
				Quest action = (Quest)task;
				action.generateRandomEvents();
				player.updateStreetCred(action.getStreetCredGain());
				player.updateWorkCred(action.getWorkCredGain());
				player.adjustHealth(action.getHealthGain()-action.getHealthCost());
				if(action.hasTick())
					player.addTick();
			}
			controller.update(task.getInfoString());
		}
		else {
			controller.update();
		}
	}

	public void startTimer(){
		this.timer.start();
	}
}
