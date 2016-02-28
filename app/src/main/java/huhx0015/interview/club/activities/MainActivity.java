package huhx0015.interview.club.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.sinch.android.rtc.SinchError;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import huhx0015.interview.club.R;
import huhx0015.interview.club.constants.FragmentConstants;
import huhx0015.interview.club.data.DummyData;
import huhx0015.interview.club.fragments.ProfileFragment;
import huhx0015.interview.club.model.Interviewer;
import huhx0015.interview.club.services.SinchService;
import huhx0015.interview.club.ui.adapter.DrawerAdapter;
import huhx0015.interview.club.ui.adapter.InterviewerAdapter;

public class MainActivity extends BaseActivity implements SinchService.StartFailedListener {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolBar;
    private SharedPreferences mSharedPreferences;
    private Context mContext = this;

    @Bind(R.id.main_activity_fragment_container) FrameLayout fragmentContainer;

    @Bind(R.id.recycler_view) RecyclerView recyclerView;

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________ **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        mSharedPreferences = getSharedPreferences(
                getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);

        setUpDrawer();

        setUpFragment();

        setUpRecyclerView();
        // TODO: populate with dummy data
        setRecyclerList(new ArrayList<Interviewer>());
    }

    /*
        Drawer set-up
     */
    private void setUpDrawer(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        setUpDrawerCompanyList();
        setUpDrawerPositionList();

    }

    private void setUpDrawerCompanyList(){
        ListView listView = (ListView) findViewById(R.id.drawer_company_list_view);

        String[] drawerTitles = new String[]{"Early Startup", "Funded Startup", "Corporation"};
        String[] prefCompanyKeys = new String[]{
                getString(R.string.pref_key_early_start_up),
                getString(R.string.pref_key_funded_start_up),
                getString(R.string.pref_key_corporation)};


        DrawerAdapter adapter = new DrawerAdapter(this,
                R.layout.drawer_list_item, R.id.drawer_item_title, drawerTitles, prefCompanyKeys);
        listView.setAdapter(adapter);
    }

    private void setUpDrawerPositionList(){
        ListView listView = (ListView) findViewById(R.id.drawer_position_list_view);

        String[] drawerTitles = new String[]{"Front-end", "Back-end", "Android", "iOS"};
        String[] prefCompanyKeys = new String[]{
                getString(R.string.pref_key_front_end),
                getString(R.string.pref_key_back_end),
                getString(R.string.pref_key_android),
                getString(R.string.pref_key_ios)};


        DrawerAdapter adapter = new DrawerAdapter(this,
                R.layout.drawer_list_item, R.id.drawer_item_title, drawerTitles, prefCompanyKeys);
        listView.setAdapter(adapter);
    }


    /** ACTIVITY OVERRIDE METHODS ______________________________________________________________ **/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /** LAYOUT METHODS _________________________________________________________________________ **/

    private void setUpFragment() {

        // TODO: Setting dummy interviewer for now.
        addFragment(new ProfileFragment(DummyData.getRandomInterviewer()), FragmentConstants.FRAGMENT_PROFILE_TAG);
    }

    /** FRAGMENT METHODS _______________________________________________________________________ **/

    public void addFragment(Fragment fragment, String fragTag) {

        // Initializes the manager and transaction objects for the fragments.
        FragmentManager fragMan = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        fragTrans.replace(R.id.main_activity_fragment_container, fragment, fragTag);
        fragTrans.addToBackStack(fragTag); // Adds fragment to the fragment stack.

        // Makes the changes to the fragment manager and transaction objects.
        fragTrans.commitAllowingStateLoss();
    }

    /** RECYCLERVIEW METHODS ___________________________________________________________________ **/

    private void setUpRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setRecyclerList(List<Interviewer> list){
        InterviewerAdapter recyclerAdapter = new InterviewerAdapter(list, this);
        recyclerView.setAdapter(recyclerAdapter);
    }


    @Override
    protected void onServiceConnected() {
        getSinchServiceInterface().setStartListener(this);
    }

    @Override
    public void onStartFailed(SinchError error) {}

    @Override
    public void onStarted() {

    }
}
