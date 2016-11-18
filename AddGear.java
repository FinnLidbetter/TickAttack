/**
 * AddGear is the concrete component for the RangerSkill decorator pattern
 * @author Finn Lidbetter, Patrick Coyle
 * @version 2.0, 16/11/18
 */
public class AddGear extends RangerSkillDecorator {

  private RangerGear gear;

  public AddGear(RangerSkill skill, RangerGear gear) {
    super(skill);
    this.gear = gear;
  }

  public int getRangerSkill() {
    return super.getRangerSkill() + gear.getRangerSkillGain();
  }

  public RangerGear getBestGear() {
    if (super.getBestGear()==null)
      return gear;
    return (super.getBestGear().ordinal() > gear.ordinal()) ? super.getBestGear() : gear;
  }
}
