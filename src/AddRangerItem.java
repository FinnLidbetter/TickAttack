/**
 * AddRangerItem is a concrete component class for the RangerSkill decorator pattern
 * @author Finn Lidbetter, Patrick Coyle
 * @version 2.0, 16/12/06
 */
public class AddRangerItem extends RangerSkillDecorator {

  private Item item;

  public AddRangerItem(RangerSkill skill, Item item) {
    super(skill);
    this.item = item;
  }

  public int getRangerSkill() {
    return super.getRangerSkill() + item.getRangerSkillGain();
  }

  public RangerGear getBestGear() {
    return super.getBestGear();
  }
}
