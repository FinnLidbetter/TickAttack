
public interface QuestProperties {
	
public void generateRandomEvents(int skillLevel);

boolean canPerformQuest(int currentWorkCred);

public String getQuestName();
public void setQuestName(String questName);

public String getInfoString(); 
public void setInfoString(String infoString);

public long getStreetCredGain();
public void setStreetCredGain(long streetCredGain); 

public int getWorkCredCost(); 
public void setWorkCredCost(int workCredCost); 

public int getWorkCredGain();
public void setWorkCredGain(int workCredGain);

public int getHealthCost();
public void setHealthCost(int healthCost); 

public int getHealthGain();
public void setHealthGain(int healthGain);

public int getTimeToComplete(); 
public void setTimeToComplete(int timeToComplete); 

public boolean hasTick();
}
