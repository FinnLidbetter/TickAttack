
/**
 * Finn Lidbetter and Michael Bradet-Legris
 * This is an interface for the view. This is based on code given provided with Midterm 1
 */

public interface IView{

    public void update(Player playerInfo);

    public void update(Player playerInfo, String infoDisplay);

    public void showError(String errorMessage);

    public void showMessage(String message);

}
