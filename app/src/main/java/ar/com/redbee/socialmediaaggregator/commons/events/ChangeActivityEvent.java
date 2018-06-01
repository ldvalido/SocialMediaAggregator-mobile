package ar.com.redbee.socialmediaaggregator.commons.events;


import android.app.Activity;

public class ChangeActivityEvent {
    private Activity activity;

    /**
     * Instantiates a new Change activity event.
     *
     * @param activity the activity
     */
    public ChangeActivityEvent(Activity activity) {
        this.activity = activity;
    }

    /**
     * Gets activity.
     *
     * @return the activity
     */
    public Activity getActivity() {
        return activity;
    }
}
