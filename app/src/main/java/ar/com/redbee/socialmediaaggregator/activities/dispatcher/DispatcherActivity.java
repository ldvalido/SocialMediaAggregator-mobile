package ar.com.redbee.socialmediaaggregator.activities.dispatcher;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import ar.com.redbee.socialmediaaggregator.R;
import ar.com.redbee.socialmediaaggregator.activities.commons.BaseAppCompatActivityGraph;
import ar.com.redbee.socialmediaaggregator.activities.dispatcher.grid.TopicAdapter;
import ar.com.redbee.socialmediaaggregator.commons.Callback;
import ar.com.redbee.socialmediaaggregator.domain.dto.TopicDto;
import ar.com.redbee.socialmediaaggregator.domain.dto.UserFeedDto;
import ar.com.redbee.socialmediaaggregator.services.topic.TopicService;
import ar.com.redbee.socialmediaaggregator.services.topic.TopicServiceModule;

public class DispatcherActivity extends BaseAppCompatActivityGraph
        implements NavigationView.OnNavigationItemSelectedListener {


    private static final int NUMBER_OF_COLUMNS = 1;

    RecyclerView gridViewUsers;

    @Inject
    TopicService topicService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        startUi();
        startEvents();
    }

    void startUi(){
        gridViewUsers= (RecyclerView) findViewById(R.id.rvTopicsUsers);

    }

    void startEvents(){
        initializeGridView();
    }
    void initializeGridView()
    {
        final GridLayoutManager layoutManager = new GridLayoutManager(getBaseContext(), NUMBER_OF_COLUMNS);
        gridViewUsers.setHasFixedSize(true);
        gridViewUsers.setLayoutManager(layoutManager);
        doSearch();
    }
    void doSearch() {

        topicService.getByUserName("Sampaoli", new Callback.HttpService<UserFeedDto>() {
            @Override
            public void execute(int status, UserFeedDto data) {
                List<TopicDto> lst = data.getUserTopics();
                lst.addAll(data.getInterestTopics());

                final TopicAdapter adapterUser = new TopicAdapter(lst, getBaseContext());
                gridViewUsers.setAdapter(adapterUser);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dispatcher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    protected List<Object> getModules() {
        return Arrays.asList(new DispatcherActivityModule(this), new TopicServiceModule(this));
    }
}
