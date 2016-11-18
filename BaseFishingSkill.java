public class BaseFishingSkill implements FishingSkill {

  private final int baseFishingSkill = 1;
  @Override
  public int getFishingSkill() {
    return baseFishingSkill;
  }
}
