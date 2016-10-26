import java.util.Collection;
import java.io.Reader;
import java.util.Scanner;

/**
 * Finn Lidbetter
 * This is an interface for a controller.
 * I did not write this code. However, I adapted it to
 * an MVC design instead of a Model/View framework. As
 * such many things that used to be called "Model" are
 * now "Controller".
 */

public interface IController{
	
    /**
     * Add a view to the controller, views are updated 
     * based on application-specific basis.
     * @param view is added to this controller's views
     * @see IView
     */
    public void addView(IView view);
    
    /**
     * Remove a view from this controller, it may be an error
     * to remove a view not previously added to the controller.
     * @param view is removed from this controller's views
     */
    public void removeView(IView view);
    
    /**
     * Process an Object in some controller-specific way. Typically
     * the user might interact with the controller, making a change
     * via the object. Views would be notified if the model
     * changes, for example.
     * @param o is the Object processed by this model
     */
    public void process(Object o);
    
    /**
     * Notify this controller's views of the relevant model-state
     * passed to views in the collection
     * @param elements represents views to be displayed
     * @see IView
     */
    public void notifyViews(String output);    
    
    /**
     * Send a message to each of this controller's views.
     * @param s is the message sent to all views
     */
    public void messageViews(String s);
    
    /**
     * Send an error-message to this controller's views.
     * @param s is the error message displayed in each view
     */
    public void showViewsError(String s);
}
