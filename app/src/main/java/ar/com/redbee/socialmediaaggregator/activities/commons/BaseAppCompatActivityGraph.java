package ar.com.redbee.socialmediaaggregator.activities.commons;


import android.os.Bundle;

import java.util.List;

import ar.com.redbee.socialmediaaggregator.BaseApplication;
import ar.com.redbee.socialmediaaggregator.commons.BaseActivity;
import dagger.ObjectGraph;

public abstract class BaseAppCompatActivityGraph extends BaseActivity {

    private ObjectGraph activityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityGraph = ((BaseApplication) getApplication()).createScopedGraph(getModules().toArray());
        activityGraph.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityGraph = null;
    }

    /**
     * Gets modules.
     *
     * @return the modules
     */
    protected abstract List<Object> getModules();


}