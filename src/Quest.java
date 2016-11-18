import javax.swing.Timer;

import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Contains all methods any quest should contain, except the
 * generateRandomEvents() method, which is quest specific.
 * @author Finn Lidbetter, Michael Bradet-Legris
 *
 */
public abstract class Quest implements QuestProperties, Task{

	public static final int TASK_TIME_RANGE = 50;
	public static final double TICK_CHANCE = 0.8;
	
	//added for dialog extension: time to wait for the dialog to start
	public static final int DIALOG_WAIT_TIME = 3500;

	protected static Random random = new Random();

	protected String questName;
	protected String infoString;

	protected long streetCredGain;
	protected int workCredCost;
	protected int workCredGain;
	protected int healthCost;
	protected int healthGain;
	protected int timeToComplete;
	protected int skillLevel;
	protected boolean hasTick;

	//Added for dialog quest functionality.
	protected Controller cont;
	private Timer timer;
	private BufferedReader br;
	private String entireDialog;

	/**
	 * Resets the payoffs and the length of time the quest takes to
	 * complete.  Allows reseting and reusing a quest instead of
	 * creating new objects.
	 */
	protected void resetQuest(){
		streetCredGain = 0L;
		workCredGain = 0;
		workCredCost = 0;
		healthCost = 0;
		healthGain = 0;
		timeToComplete = MIN_TASK_TIME + random.nextInt(TASK_TIME_RANGE);
		infoString = "";
		if (random.nextDouble() <= TICK_CHANCE)
			hasTick = true;
	}
	/**
	 * Fetches the quest file associated with the quest name, and creates a BufferedReader for it.
	 * @return The BufferedReader associated with the quest name.
	*/
	protected BufferedReader getQuestFile(){
		return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("QuestFiles/" + 
				questName + ".tad")));
	}

	/**
	 * Reads in the file and performs the quest actions. For this version of TAC, functionality has been limited to what
	 * is needed for a dialog quest, so it will essentially print out the contents of the file, sequentially, with a set
	 * time between each.
	*/
	public void readFile(){
		br = getQuestFile();
		entireDialog = "";
		if(br == null){
			System.out.println("Invalid quest file!");
			return;
		}
		this.timer = new Timer(DIALOG_WAIT_TIME, new ActionListener() {
				public void actionPerformed(ActionEvent evt){
					int timeToWait = readDialog();
					timer.setDelay(timeToWait);
				}
		});
		timer.start();
	}
	/**
	 * Called by the timer in the readFile method. Gets called every few seconds, denoted by
	 * the timeToWait variable, which reads the line after a dialog line which should contain
	 * and integer.
	 * @return The timeToWait variable, which stores the value of the line after the first line read.
	 * 	Denotes the amount of time to let the previous line stay on-screen.
	 */
	public int readDialog(){
		try{
		String line = br.readLine();
		if(line == null){
			timer.stop();
		}else{
			int timeToWait = Integer.valueOf(br.readLine()) * 1000;
			entireDialog += line + '\n';
			cont.update(entireDialog);
			return timeToWait;
		}
		}catch(IOException e){
			System.out.println("Invalid quest file!");
			System.out.println(e.getMessage());
		}
		return 0;
		
	}
	/**
	 * Starts the process of the dialog
	 * @param cont
	 */
	public void startDialog(Controller cont){
		this.cont = cont;
		readFile();
	}

	/**
	 * Constructor.
	 */
	public Quest(int skillLevel) {
		this.skillLevel = skillLevel;
		resetQuest();
	}

	public String getInfoString() {
		return infoString;
	}

	public long getStreetCredGain() {
		return streetCredGain;
	}

	public int getWorkCredCost() {
		return workCredCost;
	}

	public int getWorkCredGain() {
		return workCredGain;
	}

	public int getHealthCost() {
		return healthCost;
	}

	public int getHealthGain() {
		return healthGain;
	}

	public int getTimeToComplete() {
		return timeToComplete;
	}

	public boolean hasTick() {
		return hasTick;
	}
}
