/**
 * FishingSkill is the interface for the FishingSkill decorator pattern
 * @author Finn Lidbetter, Patrick Coyle
 * @version 2.0, 16/11/18
 */
public interface FishingSkill {

  /**
   * getFishingSkill method returns the fishing skill level for the player
   * @return the fishing skill level
   */
  public int getFishingSkill();

  /**
   * getBestRod method returns the best fishing rod that this player has
   * @return the best rod the player has
   */
  public FishingRod getBestRod();
}
