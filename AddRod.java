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
