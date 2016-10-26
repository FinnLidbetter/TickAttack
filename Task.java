
/**
 * Interface for any action that takes a certain amount of
 * time to complete.
 *
 */
public interface Task {

	public static final int MIN_TASK_TIME = 20;

	/**
	 * Indicates how long (in seconds) the task takes to complete.
	 * @return the number of seconds.
	 */
	public int getTimeToComplete();

	/**
	 * Gives some information to be displayed about the task.
	 */
	public String getInfoString();
}
