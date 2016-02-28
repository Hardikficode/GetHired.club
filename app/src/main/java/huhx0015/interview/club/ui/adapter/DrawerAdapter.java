package huhx0015.interview.club.ui.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import huhx0015.interview.club.R;

public class DrawerAdapter extends ArrayAdapter{

    private static final String LOG_TAG = DrawerAdapter.class.getSimpleName();
    private static final boolean DEBUG = true;

    private Context mContext;
    private TextView mTextView;
    private Switch mSwitch;
    private String[] mTitles;
    private HashMap<Integer, String> DRAWER_IEM_MAP_TO_PREF_KEY = new HashMap<>();
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSharedPreferencesEditor;

    public DrawerAdapter(Context context, int resource, int textViewResourceId, String[] titles) {
        super(context, resource, textViewResourceId, titles);
        mContext = context;
        mTitles = titles;
        mSharedPreferences = context.getSharedPreferences(
                context.getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);
        mSharedPreferencesEditor = mSharedPreferences.edit();

        // map the index of drawer list item to its corresponding preference key
        DRAWER_IEM_MAP_TO_PREF_KEY.put(0, mContext.getString(R.string.pref_key_early_start_up));
        DRAWER_IEM_MAP_TO_PREF_KEY.put(1, mContext.getString(R.string.pref_key_funded_start_up));
        DRAWER_IEM_MAP_TO_PREF_KEY.put(2, mContext.getString(R.string.pref_key_corporation));
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.drawer_list_item, parent, false);
        //}

        mTextView = (TextView) convertView.findViewById(R.id.drawer_item_title);
        mTextView.setText(mTitles[position]);
        mSwitch = (Switch) convertView.findViewById(R.id.drawer_item_switch);

        mSwitch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String prefKey = DRAWER_IEM_MAP_TO_PREF_KEY.get(position);

                boolean oldVal = mSharedPreferences.getBoolean(prefKey, false);
                mSharedPreferencesEditor.putBoolean(prefKey, !oldVal);
                mSharedPreferencesEditor.commit();

                if (DEBUG) {
                    Toast toast = Toast.makeText(mContext,
                            "clicked on position " + position + ", " + prefKey +
                                    " old: " + oldVal,
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        return convertView;
    }
}
