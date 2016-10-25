import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.Timer;

public class TickTimer {

	private static final int MILLISECONDS_BETWEEN_ACTIONS = 1000;
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
				Collection ticks = player.getTicks();
				ticks.remove(tick);
				player.adjustHealth(-10);
				if (tick.hasLymeDisease())
					player.incrementInfectionStage();
			}
		}
		controller.updateStreetCred();
		controller.updateHealth();
		controller.updateInfectionState();
		if (!player.isAlive())
			controller.endGame();
	}
	
	public void startTimer(){
		this.timer.start();
	}
}
