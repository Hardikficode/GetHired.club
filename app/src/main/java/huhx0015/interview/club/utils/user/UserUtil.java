package huhx0015.interview.club.utils.user;

import android.app.Activity;
import android.database.Cursor;
import android.provider.ContactsContract;

/**
 * Created by Michael Yoon Huh on 2/28/2016.
 */
public class UserUtil {

    // getDeviceOwnerName(): Returns this device's owner name.
    public static String getDeviceOwnerName(Activity activity) {

        String ownerName = "Chris Komarin";

        Cursor c = activity.getApplication().getContentResolver().query(ContactsContract.Profile.CONTENT_URI, null, null, null, null);
        c.moveToFirst();

        if (c.getCount() > 0) { ownerName = c.getString(c.getColumnIndex("display_name")); }
        c.close();

        return ownerName;
    }
}
