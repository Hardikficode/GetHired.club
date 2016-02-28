package huhx0015.interview.club.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
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
import huhx0015.interview.club.fragments.ProfileFragment;
import huhx0015.interview.club.model.Interviewer;
import huhx0015.interview.club.services.SinchService;
import huhx0015.interview.club.ui.adapter.DrawerAdapter;

public class MainActivity extends BaseActivity implements SinchService.StartFailedListener {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private Toolbar mToolBar;
    private SharedPreferences mSharedPreferences;
    private Context mContext = this;

    @Bind(R.id.main_activity_fragment_container) FrameLayout fragmentContainer;

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
    }

    /*
        Drawer set-up
     */
    private void setUpDrawer(){


        // drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.drawer_list_view);

        String[] drawerTitles = new String[]{"Early Startup", "Funded Startup", "Corporation"};
        String[] prefCompanyKeys = new String[]{
                getString(R.string.pref_key_early_start_up),
                getString(R.string.pref_key_funded_start_up),
                getString(R.string.pref_key_corporation)};


        DrawerAdapter adapter = new DrawerAdapter(this,
                R.layout.drawer_list_item, R.id.drawer_item_title, drawerTitles, prefCompanyKeys);
        mDrawerList.setAdapter(adapter);

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
        Interviewer dummyInterviewer = new Interviewer();
        dummyInterviewer.setAvatar(R.drawable.fitness_girl_avatar);
        dummyInterviewer.setFullName("Jennifer Wayne Doe");
        dummyInterviewer.setCurrentCompany("Fitness Extreme");
        dummyInterviewer.setPosition("Head of Engineering");

        List<String> pastCompanies = new ArrayList<>();
        pastCompanies.add("FitBit");
        pastCompanies.add("MyFitnessPal");
        pastCompanies.add("GPOP Labs");
        pastCompanies.add("Jawbone");

        dummyInterviewer.setPreviousCompanies(pastCompanies);

        addFragment(new ProfileFragment(dummyInterviewer), FragmentConstants.FRAGMENT_PROFILE_TAG);
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
