import java.util.Random;

/**
 * Tick object that can latch onto a player.
 * @author Finn Lidbetter, Michael Bradet-Legris
 *
 */
public class Tick {

	protected final static double INFECTED_CHANCE = 0.5;
	protected final static double INFECTION_TRANSFER_CHANCE = 0.00144; //Approx 50% chance to infect in 8 minutes
	protected final static double GROWTH_RATE = 0.00208; //Approx 8 mins to fully engorge
	private boolean infected;
	private boolean fullyEngorged;
	private double engorgedSize;

	private static Random random = new Random();

	/**
	 * Constructor.
	 */
	public Tick(){
		engorgedSize = 0;
		if (random.nextDouble() <= INFECTED_CHANCE)
			infected = true;
		else
			infected = false;
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
