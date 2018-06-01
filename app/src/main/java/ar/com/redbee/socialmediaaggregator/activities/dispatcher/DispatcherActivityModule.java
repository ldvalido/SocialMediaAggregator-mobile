package ar.com.redbee.socialmediaaggregator.activities.dispatcher;


import ar.com.redbee.socialmediaaggregator.activities.commons.BaseAppCompatActivityGraph;
import ar.com.redbee.socialmediaaggregator.services.topic.TopicServiceModule;
import dagger.Module;

@Module(
        injects = DispatcherActivity.class,
        includes = {TopicServiceModule.class}
)
public class DispatcherActivityModule {

    /**
     * The Activity.
     */
    final BaseAppCompatActivityGraph activity;

    /**
     * Instantiates a new Dispatcher module.
     *
     * @param activity the activity
     */
    public DispatcherActivityModule(BaseAppCompatActivityGraph activity) {
        this.activity = activity;
    }
}
