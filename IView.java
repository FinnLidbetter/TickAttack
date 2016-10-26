import java.util.Collection;

/**
 * Finn Lidbetter
 * This is an interface for the view.
 */

public interface IView{

    public void update(Player playerInfo, String infoDisplay);

    public void showError(String errorMessage);

    public void showMessage(String message);

}
