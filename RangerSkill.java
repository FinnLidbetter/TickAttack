/**
 * RangerSkill is the interface for the RangerSkill decorator pattern
 * @author Finn Lidbetter, Patrick Coyle
 * @version 2.0, 16/11/18
 */
public interface RangerSkill {

  /**
   * getRangerSkill method returns the ranger skill level for the player
   * @return the ranger skill level
   */
  public int getRangerSkill();

  /**
   * getBestGear method returns the best ranger gear that this player has
   * @return the best gear the player has
   */
  public RangerGear getBestGear();
}
