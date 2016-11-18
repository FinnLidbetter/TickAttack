public class AddRod extends FishingSkillDecorator {
  private FishingRod rod;
  
  public AddRod(FishingSkill skill, FishingRod rod) {
    super(skill);
    this.rod = rod;
  }

  public int getFishingSkill() {
    return super.getFishingSkill() + rod.getFishingSkillGain();
  }
}
