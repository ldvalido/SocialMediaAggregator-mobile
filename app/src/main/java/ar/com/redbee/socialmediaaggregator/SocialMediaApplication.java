package ar.com.redbee.socialmediaaggregator;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import ar.com.redbee.socialmediaaggregator.commons.BaseActivity;
import ar.com.redbee.socialmediaaggregator.commons.events.ChangeActivityEvent;
import dagger.ObjectGraph;

public class SocialMediaApplication extends BaseApplication {

    private static SocialMediaApplication Application;

    /**
     * Gets application.
     *
     * @return the application
     */
    public static SocialMediaApplication getApplication() {
        return Application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Application = this;

        graph = ObjectGraph.create(getModules().toArray());
        graph.inject(this);
    }


    @Override
    protected List<Object> getModules() {
        SocialMediaApplicationModule module = new SocialMediaApplicationModule(this);
        ArrayList<Object> returnValue = new ArrayList<Object>();
        returnValue.add(module);
        return returnValue;
    }

    /**
     * On event async.
     *
     * @param event the event
     */
    public void onEventAsync(ChangeActivityEvent event) {
        currentActivity = (BaseActivity) event.getActivity();
    }

    /**
     * Gets current activity.
     *
     * @return the current activity
     */
    public Activity getCurrentActivity() {
        return currentActivity;
    }
}
