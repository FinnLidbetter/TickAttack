
public interface QuestProperties {
	
public void generateRandomEvents(int skillLevel);

boolean canPerformQuest(int currentWorkCred);

public String getInfoString(); 

public long getStreetCredGain();

public int getWorkCredCost(); 

public int getWorkCredGain();

public int getHealthCost();

public int getHealthGain();

public boolean hasTick();
}
