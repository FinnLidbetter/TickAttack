/**
 * BaseFishingSkill is the base class for the FishingSkill decorator pattern
 * @author Finn Lidbetter, Patrick Coyle
 * @version 2.0, 16/11/18
 */
public class BaseFishingSkill implements FishingSkill {

  private final int baseFishingSkill = 1;
  @Override
  public int getFishingSkill() {
    return baseFishingSkill;
  }

  @Override
  public FishingRod getBestRod() {
    return null;
  }
}
