import java.util.Random;

/**
 * Tick object that can latch onto a player.
 *
 */
public class Tick {
	
	private final double INFECTED_CHANCE = 0.5;
	private final double INFECTION_TRANSFER_CHANCE = 0.00144; //Approx 50% chance to infect in 8 minutes
	private final double GROWTH_RATE = 0.00208; //Approx 8 mins to fully engorge
	private boolean visible;
	private boolean infected;
	private boolean fullyEngorged;
	private double engorgedSize;
	
	private static Random random;
	
	/**
	 * Constructor.
	 */
	public Tick(){
		visible = false;
		engorgedSize = 0;
		if (random.nextDouble() <= INFECTED_CHANCE)
			infected = true;
		else
			infected = false;
	}
	
	/**
	 * Checks if the tick is visible.	
	 * @return True if the tick is visible.
	 */
	public boolean isVisible(){
		return visible;
	}
	
	/**
	 * Sets the tick to visible.
	 */
	public void makeVisible(){
		visible = true;
	}
	
	/**
	 * Checks if the tick has Lyme Disease.
	 * @return True if the tick has Lyme Disease.
	 */
	public boolean hasLymeDisease(){
		return infected;
	}
	
	/**
	 * Checks if the tick is fully engorged.
	 * @return True if the tick is fully engorged.
	 */
	public boolean isFullyEngorged(){
		return fullyEngorged;
	}
	
	/**
	 * Increases the size of the tick and has a change to transmit Lyme disease
	 * if the tick is infected.  If the tick becomes fully engorged and has Lyme
	 * disease, Lyme disease is automatically contracted.
	 * @return
	 */
	public boolean suckBlood(){
		if (engorgedSize < 1)
			engorgedSize += GROWTH_RATE;
		if (engorgedSize >= 1){
			visible = true;
			fullyEngorged = true;
			if (infected == true)
				return true;
		}
		if (random.nextDouble() <= INFECTION_TRANSFER_CHANCE)
			return true;
		return false;
	}
	
	/**
	 * Returns the size of the tick, between 0 and 1, where 0 is a new tick, 
	 * and a fully engorged tick has size 1.
	 * @return the size of the tick.
	 */
	public double engorgedSize(){
		return engorgedSize;
	}
}
