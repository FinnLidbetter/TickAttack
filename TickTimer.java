import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.Timer;

public class TickTimer {

	private static final int MILLISECONDS_BETWEEN_ACTIONS = 1000;
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
		for (Tick tick: player.getTicks()){
			if (tick.suckBlood()){
				Collection<Tick> ticks = player.getTicks();
				ticks.remove(tick);
				player.adjustHealth(-10);
				if (tick.hasLymeDisease())
					player.incrementInfectionStage();
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
			else{
				Quest action = (Quest)task;
				player.updateStreetCred(action.getStreetCredGain());
				player.updateWorkCred(action.getWorkCredGain());
				player.adjustHealth(action.getHealthCost()+action.getHealthGain());
				if(action.hasTick())
					player.addTick();
			}
		}

		controller.update();
	}

	public void startTimer(){
		this.timer.start();
	}
}
