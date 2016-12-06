/**
 * FishingSkillDecorator is the abstract class for the FishingSkill decorator pattern
 * @author Finn Lidbetter, Patrick Coyle
 * @version 2.0, 16/11/18
 */
public abstract class FishingSkillDecorator implements FishingSkill {

  protected FishingSkill skillToDecorate;

  public FishingSkillDecorator(FishingSkill skill) {
    this.skillToDecorate = skill;
  }

  public int getFishingSkill() {
    return skillToDecorate.getFishingSkill();
  }

  public FishingRod getBestRod() {
    return skillToDecorate.getBestRod();
  }
}
