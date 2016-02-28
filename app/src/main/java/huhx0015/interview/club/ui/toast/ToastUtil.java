package huhx0015.interview.club.ui.toast;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Michael Yoon Huh on 2/28/2016.
 */

public class ToastUtil {

    // toastyPopUp(): Creates and displays a Toast popup.
    public static void toastyPopUp(String message, Context con) {
        Toast.makeText(con, message, Toast.LENGTH_SHORT).show();
    }
}