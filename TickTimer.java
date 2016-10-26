import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.Timer;

public class TickTimer {

	private static final int MILLISECONDS_BETWEEN_ACTIONS = 100;
	private Timer timer;
	private IController controller;
	private Player player;
	
	public TickTimer(IController controller, Player player){
		this.controller = controller;
		this.player = player;
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
			else {
			//else if (player.getTimeToCompleteTask()==0){
				Quest action = (Quest)task;
				player.updateStreetCred(action.getStreetCredGain());
				player.updateWorkCred(action.getWorkCredGain());
				player.adjustHealth(action.getHealthCost()+action.getHealthGain());
				if(action.hasTick())
					player.addTick();
			//}
			}
			controller.update(task.getInfoString());
		}
		else {
			controller.update(controller.getCurrentInfoString());
		}
<<<<<<< HEAD
=======
		
>>>>>>> 7b1fc7ee5b20abc126740daa1d2c9dcc972ceaf0
	}
	
	public void startTimer(){
		this.timer.start();
	}
}
