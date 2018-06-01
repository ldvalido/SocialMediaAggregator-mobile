package ar.com.redbee.socialmediaaggregator;

import android.app.Activity;
import android.app.Application;
import java.util.List;
import ar.com.redbee.socialmediaaggregator.commons.BaseActivity;
import ar.com.redbee.socialmediaaggregator.commons.dialogs.DialogHelper;
import ar.com.redbee.socialmediaaggregator.commons.linq.Action;
import dagger.ObjectGraph;

public abstract class BaseApplication extends Application {

    /**
     * The Current activity.
     */
    protected BaseActivity currentActivity;
    /**
     * The Graph.
     */
    protected ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler (new Thread.UncaughtExceptionHandler()
        {
            @Override
            public void uncaughtException (Thread thread, Throwable e)
            {
                handleUncaughtException (thread, e);
            }
        });
    }

    /**
     * Sets current activity.
     *
     * @param baseActivity the base activity
     */
    public void setCurrentActivity(BaseActivity baseActivity) {
        currentActivity = baseActivity;
    }

    private void handleUncaughtException (Thread thread, Throwable e)
    {
        e.printStackTrace();
        String message = e.getMessage();
        DialogHelper.Build(currentActivity, "ERROR", message, new Action<Activity>() {
            @Override
            public void eval(Activity item) {

            }
        });
    }

    /**
     * Create scoped graph object graph.
     *
     * @param modules the modules
     * @return the object graph
     */
    public ObjectGraph createScopedGraph(Object... modules) {
        return graph.plus(modules);
    }

    /**
     * Gets modules.
     *
     * @return the modules
     */
    protected abstract List<Object> getModules();
}
