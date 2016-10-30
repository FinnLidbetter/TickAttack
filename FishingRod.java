import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public enum FishingRod implements Comparable<FishingRod> {
  OLD_ROD("Old Rod","This rod looks ok",100,1),
  GOOD_ROD("Good Rod", "This rod looks better than the old rod",500,2),
  SUPER_ROD("Super Rod","This rod looks even better than the good rod!",5000,3),
  GREAT_ROD("Great Rod","This rod looks even better than the super rod!", 50000,4),
  HYPER_ROD("Hyper Rod", "This rod looks even better than the great rod!", 500000,5),
  MASTER_ROD("Master Rod", "This rod looks better than any rod ever!", 5000000,6);

  String name;
  String info;
  int streetCredCost;
  int fishingSkillGain;
  static final Map<String, FishingRod> stringToRodMap = Collections.unmodifiableMap(initializeMapping());

  FishingRod(String rodName, String rodInfo, int cost, int skillGain) {
    name = rodName;
    info = rodInfo;
    streetCredCost = cost;
    fishingSkillGain = skillGain;
  }

  public String getName() {
    return name;
  }

  public String getInfo() {
    return info;
  }

  public int getStreetCredCost() {
    return streetCredCost;
  }

  public int getFishingSkillGain() {
    return fishingSkillGain;
  }

  private static Map<String, FishingRod> initializeMapping() {
    Map<String, FishingRod> stringToRodMap = new HashMap<>();
    for (FishingRod rod:FishingRod.values()) {
      stringToRodMap.put(rod.getName(),rod);
    }
    return stringToRodMap;
  }
}
