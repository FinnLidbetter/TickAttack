import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public enum FishingRod implements Comparable<FishingRod> {
  OLD_ROD("Old Rod","This rod looks ok"),
  GOOD_ROD("Good Rod", "This rod looks better than the old rod"),
  SUPER_ROD("Super Rod","This rod looks even better than the good rod!"),
  GREAT_ROD("Great Rod","This rod looks even better than the super rod!"),
  HYPER_ROD("Hyper Rod", "This rod looks even better than the great rod!"),
  MASTER_ROD("Master Rod", "This rod looks better than any rod ever!");

  String rodName;
  String rodInfo;
  static final Map<String, FishingRod> stringToRodMap = Collections.unmodifiableMap(initializeMapping());

  FishingRod(String name, String info) {
    rodName = name;
    rodInfo = info;
  }

  public String getRodName() {
    return rodName;
  }

  public String getRodInfo() {
    return rodInfo;
  }

  private static Map<String, FishingRod> initializeMapping() {
    Map<String, FishingRod> stringToRodMap = new HashMap<>();
    for (FishingRod rod:FishingRod.values()) {
      stringToRodMap.put(rod.getRodName(),rod);
    }
    return stringToRodMap;
  }
}
