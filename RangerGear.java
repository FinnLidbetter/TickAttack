import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public enum RangerGear implements Comparable<RangerGear> {
  BASIC_GEAR("Basic Gear","This gear will really help me with my park ranger duties!", 500, 1),
  DECENT_GEAR("Decent Gear", "This gear looks even better than the basic gear!", 5000, 2),
  EXCELLENT_GEAR("Excellent Gear","This gear looks even better than the decent gear!", 50000, 3),
  PHENOMENAL_GEAR("Phenomenal Gear","This gear looks even better than the excellent gear!", 500000, 4),
  MASTER_GEAR("Master Gear", "This gear looks better than any gear ever!", 5000000, 5);

  String name;
  String info;
  int streetCredCost;
  int rangerSkillGain;
  static final Map<String, RangerGear> stringToGearMap = Collections.unmodifiableMap(initializeMapping());

  RangerGear(String gearName, String gearInfo, int cost, int skillGain) {
    name = gearName;
    info = gearInfo;
    streetCredCost = cost;
    rangerSkillGain = skillGain;
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

  public int getRangerSkillGain() {
    return rangerSkillGain;
  }

  private static Map<String, RangerGear> initializeMapping() {
    Map<String, RangerGear> stringToGearMap = new HashMap<>();
    for (RangerGear gear:RangerGear.values()) {
      stringToGearMap.put(gear.getName(),gear);
    }
    return stringToGearMap;
  }
}
