/**
 * BaseRangerSkill is the base class for the RangerSkill decorator pattern
 * @author Finn Lidbetter, Patrick Coyle
 * @version 2.0, 16/11/18
 */
public class BaseRangerSkill implements RangerSkill {

  private final int baseRangerSkill = 1;
  
  @Override
  public int getRangerSkill() {
    return baseRangerSkill;
  }

  @Override
  public RangerGear getBestGear() {
    return null;
  }
}
