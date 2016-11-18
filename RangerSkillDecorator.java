/**
 * RangerSkillDecorator is the abstract class for the RangerSkill decorator pattern
 * @author Finn Lidbetter, Patrick Coyle
 * @version 2.0, 16/11/18
 */
public abstract class RangerSkillDecorator implements RangerSkill {

  protected RangerSkill skillToDecorate;

  public RangerSkillDecorator(RangerSkill skill) {
    this.skillToDecorate = skill;
  }

  public int getRangerSkill() {
    return skillToDecorate.getRangerSkill();
  }

  public RangerGear getBestGear() {
    return skillToDecorate.getBestGear();
  }
}
