import java.util.Random;

public class Tick {
	
	private final double INFECTED_CHANCE = 0.5;
	private final double INFECTION_TRANSFER_CHANCE = 0.00144; //Approx 50% chance to infect in 8 minutes
	private final double GROWTH_RATE = 0.00208; //Approx 8 mins to fully engorge
	private boolean visible;
	private boolean infected;
	private boolean fullyEngorged;
	private double engorgedSize;
	
	private static Random random;
	
	public Tick(){
		visible = false;
		engorgedSize = 0;
		if (random.nextDouble() <= INFECTED_CHANCE)
			infected = true;
		else
			infected = false;
	}
	public boolean isVisible(){
		return visible;
	}
	
	public void makeVisible(){
		visible = true;
	}
	
	public boolean hasLymeDisease(){
		return infected;
	}
	
	public boolean isFullyEngorged(){
		return fullyEngorged;
	}
	
	public boolean suckBlood(){
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
	
	public double engorgedSize(){
		return engorgedSize;
	}
}
