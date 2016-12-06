import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

/**
 * PotionType enum stores information about each of the Potions
 * @author Finn Lidbetter, Michael Bradet-Legris
 * @version 1.0, 16/12/06
 */
public enum PotionType {
  FISHING_POTION("Fishing Potion", new String[] {"Eye of Newt","Cheap Meds"}, new int[] {2,4}),
  RANGER_POTION("Ranger Potion", new String[] {"Tick Legs","Antibiotics"}, new int[] {3,1}),
  FUSION_POTION("Fusion Potion", new String[] {"Fishing Potion", "Ranger Potion"}, new int[] {1,1});

  String name;
  String[] ingredientNames;
  int[] ingredientMultiplicities;

  static final Map<String, PotionType> stringToPotionMap = Collections.unmodifiableMap(initializeMapping());

  /**
   * Initialiser for a FishingRod Enum type
   */
   PotionType(String potionName, String[] ingredientNames, int[] multiplicities) {
    name = potionName;
    this.ingredientNames = ingredientNames;
    this.ingredientMultiplicities = multiplicities;
  }

  /**
   * Gets the name of the Potion
   * @return potion type name
   */
  public String getName() {
    return name;
  }

  public String[] getIngredientNames() {
    return ingredientNames;
  }

  public int[] getIngredientMultiplicities() {
    return ingredientMultiplicities;
  }

  /**
   * Initialises the map from potion names to potions
   * @return the initial potion name to potion type mapping
   */
  private static Map<String, PotionType> initializeMapping() {
    Map<String, PotionType> stringToPotionMap = new HashMap<>();
    for (PotionType potion:PotionType.values()) {
      stringToPotionMap.put(potion.getName(),potion);
    }
    return stringToPotionMap;
  }
}
