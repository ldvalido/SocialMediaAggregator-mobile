package ar.com.redbee.socialmediaaggregator.commons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ar.com.redbee.socialmediaaggregator.BaseApplication;

public abstract class BaseActivity extends AppCompatActivity {

    Integer allowIdleTime = 300 * 1000;
    Long lastActivity = null;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((BaseApplication)this.getApplication()).setCurrentActivity(this);
        Long currentTime = System.currentTimeMillis();
        if (lastActivity == null || (currentTime - lastActivity)  <= allowIdleTime) {
            lastActivity = System.currentTimeMillis() ;
        }else{
            onLongInactivity();
        }

    }

    protected void onLongInactivity(){}
    @Override
    public void onPause() {
        super.onPause();
        lastActivity = System.currentTimeMillis();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

}