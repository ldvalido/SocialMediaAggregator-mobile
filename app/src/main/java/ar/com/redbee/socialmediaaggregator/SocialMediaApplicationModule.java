package ar.com.redbee.socialmediaaggregator;

import android.content.Context;

import dagger.Module;

@Module(injects = SocialMediaApplication.class)
public class SocialMediaApplicationModule {


    /**
     * The App context.
     */
    public final Context appContext;

    /**
     * Instantiates a new Fixed assets application module.
     *
     * @param appContext the app context
     */
    public SocialMediaApplicationModule(BaseApplication appContext) {
        this.appContext = appContext;
    }
}
