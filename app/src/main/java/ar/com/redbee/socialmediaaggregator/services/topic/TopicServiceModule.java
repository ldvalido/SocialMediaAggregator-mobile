package ar.com.redbee.socialmediaaggregator.services.topic;

import android.content.Context;

import javax.inject.Singleton;

import ar.com.redbee.socialmediaaggregator.services.topic.impl.TopicServiceImpl;
import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class TopicServiceModule {

    private Context context;

    public TopicServiceModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public TopicService provideAuthenticationServiceModule() {
        return new TopicServiceImpl(context);
    }
}
