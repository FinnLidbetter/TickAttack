import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

/**
 * RangerGear enum stores information about each of the available Ranger Gear
 * @author Finn Lidbetter, Michael Bradet-Legris
 * @version 1.0, 16/10/31
 */
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

  /**
   * Initialiser for a RangerGear enum type
   */
  RangerGear(String gearName, String gearInfo, int cost, int skillGain) {
    name = gearName;
    info = gearInfo;
    streetCredCost = cost;
    rangerSkillGain = skillGain;
  }

  /**
   * Gets the name of the RangerGear
   * @return ranger gear name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the info string for this ranger gear
   * @return info string for this ranger gear
   */
  public String getInfo() {
    return info;
  }

  /**
   * Gets the StreetCredCost to buy this RangerGear
   * @return the cost to buy this ranger gear
   */
  public int getStreetCredCost() {
    return streetCredCost;
  }

  /**
   * Gets the increase in the ranger skill given by this ranger gear
   * @return the increase in ranger skill given by this ranger gear
   */
  public int getRangerSkillGain() {
    return rangerSkillGain;
  }

  /**
   * Initialises the mapping for ranger gear names to ranger gear enum types
   * @return the initialised mapping for ranger gear names to ranger gear enum types
   */
  private static Map<String, RangerGear> initializeMapping() {
    Map<String, RangerGear> stringToGearMap = new HashMap<>();
    for (RangerGear gear:RangerGear.values()) {
      stringToGearMap.put(gear.getName(),gear);
    }
    return stringToGearMap;
  }
}
