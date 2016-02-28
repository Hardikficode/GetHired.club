package huhx0015.interview.club.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import huhx0015.interview.club.R;
import huhx0015.interview.club.ui.adapter.DrawerAdapter;

public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private Toolbar mToolBar;
    private SharedPreferences mSharedPreferences;
    private Context mContext = this;

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________ **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        mSharedPreferences = getSharedPreferences(
                getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);

        setUpDrawer();


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
}
