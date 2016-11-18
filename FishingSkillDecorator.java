public abstract class FishingSkillDecorator implements FishingSkill {

  protected FishingSkill skillToDecorate;

  public FishingSkillDecorator(FishingSkill skill) {
    this.skillToDecorate = skill;
  }

  public int getFishingSkill() {
    return skillToDecorate.getFishingSkill();
  }
}
