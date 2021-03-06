import java.util.ArrayList;
/**
 * Finn Lidbetter and Michael Bradet-Legris
 * This class supplies a bare minimum controller implementation,
 * basically allowing views to be added, removed, and
 * notified of messages, errors, and other controller information.
 * Note that this class was not written by us. It is code that was
 * provided as part of Midterm 1
 */
public abstract class AbstractController implements IController {
    private ArrayList myViews;

    public AbstractController(){
    	myViews = new ArrayList();
    }

    public void addView(IView view){
    	myViews.add(view);
    }

    public void removeView(IView view){
    	myViews.remove(view);
    }

    public void notifyViews(Player playerInfo){
      for(int k=0; k < myViews.size(); k++){
        IView view = (IView) myViews.get(k);
        view.update(playerInfo);
      }
    }

    public void notifyViews(Player playerInfo, String output){
      for(int k=0; k < myViews.size(); k++){
        IView view = (IView) myViews.get(k);
        view.update(playerInfo, output);
      }
    }

    public void showViewsError(String s){
    	for(int k=0; k <myViews.size(); k++){
        IView view = (IView) myViews.get(k);
        view.showError(s);
    	}
    }

    public void messageViews(String s){
    	for(int k=0; k <myViews.size(); k++){
        IView view = (IView) myViews.get(k);
        view.showMessage(s);
    	}
    }
}
