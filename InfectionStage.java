
public enum InfectionStage {
  HEALTHY("Healthy"),
  FIRST_STAGE("Early stage infection"),
  SECOND_STAGE("Middle stage infection"),
  THIRD_STAGE("Late stage infection");
  
  
  private String stageName;
  
  InfectionStage(String name) {
    stageName = name;
  }
  
  public String getStageName() {
    return stageName;
  }
}
