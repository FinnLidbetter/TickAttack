import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;
import java.io.Reader;

/**
 * Finn Lidbetter
 * This class supplies a bare minimum controller implementation,
 * basically allowing views to be added, removed, and
 * notified of messages, errors, and other controller information.
 * Note that this class was not written by me, although I replaced
 * all instances of the word Model with the word Controller as it is
 * more appropriate for my design
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
