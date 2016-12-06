import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

/**
 * Controller handling events that happen at a set time interval or
 * when some time constraint has been satisfied.
 * @author Finn Lidbetter, Michael Bradet-Legris
 *
 */
public class TickTimer {

	private static final int MILLISECONDS_BETWEEN_ACTIONS = 500; //half a second.
	private Timer timer;
	private Controller controller;
	private Player player;

	/**
	 * Constructor.  User must specify a Controller that the TickTimer can update
	 * the View with and that has access to a player (model).
	 * @param controller
	 */
	public TickTimer(Controller controller){
		this.controller = controller;
		this.player = controller.getPlayer();
		this.timer = new Timer(MILLISECONDS_BETWEEN_ACTIONS, new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				update();
			}
		});
	}

	/**
	 * Resets the timer, presumably after a game has ended.  This also updates the
	 * player to the new player after the game has restarted.
	 */
	public void resetTimer() {
		this.player = controller.getPlayer();
		this.timer = new Timer(MILLISECONDS_BETWEEN_ACTIONS, new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				update();
			}
		});
	}

	/**
	 * Performs all actions that need to be performed at each time increment.
	 */
	private void update(){
		player.incrementPerSecondStreetCred();
		player.incrementPerSecondHealth();
		player.incrementInfectionStage();

		updateTicks();
		updateCurrentTask();
		checkEndGameConditions();
	}

	/**
	 * All ticks on the player suck blood and grow larger.  There is a chance
	 * that the tick damages the user and transmits Lyme disease if it is carrying it.
	 * In this case, the tick is removed automatically, since it has been
	 * "discovered" by the user (presumably because it had grown too large to go
	 * unnoticed).
	 */
	private void updateTicks(){
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
	}

	/**
	 * Decrements the time remaining to complete the current task.  If the time
	 * reaches 0, apply the payoffs of the task.
	 */
	private void updateCurrentTask(){
		Task task = player.decrementTimeToCompleteTask();
		if (task != null){
			if (task instanceof TickSearch){
				TickSearch action = (TickSearch)task;
				action.attemptRemovingTicks(player.getTicks(), player.removeItem("Tick Test",1));
			} else {
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

	/**
	 * Checks if the game is over or not.  If the game is over, display this
	 * to the user and reset the game.
	 */
	private void checkEndGameConditions(){
		if (!player.isAlive()) {
			controller.endGameDead();
			resetTimer();
		}
		if (player.getWorkCred()>100000) {
			controller.endGameWin();
			resetTimer();
		}
	}

	/**
	 * Starts the timer.
	 */
	public void startTimer(){
		this.timer.start();
	}
}
