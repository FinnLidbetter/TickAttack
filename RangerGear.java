import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public enum RangerGear implements Comparable<RangerGear> {
  BASIC_GEAR("Basic Gear","This gear will really help me with my park ranger duties!"),
  DECENT_GEAR("Decent Gear", "This gear looks even better than the basic gear!"),
  EXCELLENT_GEAR("Excellent Gear","This gear looks even better than the decent gear!"),
  PHENOMENAL_GEAR("Phenomenal Gear","This gear looks even better than the excellent gear!"),
  MASTER_GEAR("Master Gear", "This gear looks better than any gear ever!");

  String gearName;
  String gearInfo;
  static final Map<String, RangerGear> stringToGearMap = Collections.unmodifiableMap(initializeMapping());

  RangerGear(String name, String info) {
    gearName = name;
    gearInfo = info;
  }

  public String getGearName() {
    return gearName;
  }

  public String getGearInfo() {
    return gearInfo;
  }

  private static Map<String, RangerGear> initializeMapping() {
    Map<String, RangerGear> stringToGearMap = new HashMap<>();
    for (RangerGear gear:RangerGear.values()) {
      stringToGearMap.put(gear.getGearName(),gear);
    }
    return stringToGearMap;
  }
}
