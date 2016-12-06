/**
 * AddFishingItem is a concrete component class for the FishingSkill decorator pattern
 * @author Finn Lidbetter, Patrick Coyle
 * @version 2.0, 16/12/06
 */
public class AddFishingItem extends FishingSkillDecorator {

  private Item item;

  public AddFishingItem(FishingSkill skill, Item item) {
    super(skill);
    this.item = item;
  }

  public int getFishingSkill() {
    return super.getFishingSkill() + item.getFishingSkillGain();
  }

  public FishingRod getBestRod() {
    return super.getBestRod();
  }
}
