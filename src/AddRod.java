/**
 * AddRod is a concrete component class for the FishingSkill decorator pattern
 * @author Finn Lidbetter, Patrick Coyle
 * @version 2.0, 16/11/18
 */
public class AddRod extends FishingSkillDecorator {

  private FishingRod rod;

  public AddRod(FishingSkill skill, FishingRod rod) {
    super(skill);
    this.rod = rod;
  }

  public int getFishingSkill() {
    return super.getFishingSkill() + rod.getFishingSkillGain();
  }

  public FishingRod getBestRod() {
    if (super.getBestRod()==null)
      return rod;
    return (super.getBestRod().ordinal() > rod.ordinal()) ? super.getBestRod() : rod;
  }
}
