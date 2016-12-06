import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

/**
 * FishingRod enum stores information about each of the Fishing Rods
 * @author Finn Lidbetter, Michael Bradet-Legris
 * @version 1.0, 16/10/31
 */
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

  /**
   * Initialiser for a FishingRod Enum type
   */
  FishingRod(String rodName, String rodInfo, int cost, int skillGain) {
    name = rodName;
    info = rodInfo;
    streetCredCost = cost;
    fishingSkillGain = skillGain;
  }

  /**
   * Gets the name of the FishingRod
   * @return fishing rod name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the info string for the FishingRod
   * @return fishing rod description
   */
  public String getInfo() {
    return info;
  }

  /**
   * Gets the StreetCred cost of the fishing rod
   * @return fishing rod cost
   */
  public int getStreetCredCost() {
    return streetCredCost;
  }

  /**
   * Gets the fishing skill gain that this fishing rod gives
   * @return the increase in the fishing skill given by this fishing rod
   */
  public int getFishingSkillGain() {
    return fishingSkillGain;
  }

  /**
   * Initialises the map from rod names to rods
   * @return the initial rod name to fishing rod mapping
   */
  private static Map<String, FishingRod> initializeMapping() {
    Map<String, FishingRod> stringToRodMap = new HashMap<>();
    for (FishingRod rod:FishingRod.values()) {
      stringToRodMap.put(rod.getName(),rod);
    }
    return stringToRodMap;
  }
}
