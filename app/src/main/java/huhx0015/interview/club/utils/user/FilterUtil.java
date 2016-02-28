package huhx0015.interview.club.utils.user;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;
import huhx0015.interview.club.R;
import huhx0015.interview.club.data.DummyData;
import huhx0015.interview.club.model.Interviewer;

/**
 * Created by Michael Yoon Huh on 2/28/2016.
 */
public class FilterUtil {

    public static List<Interviewer> filterList(Context context) {

        SharedPreferences interviewPreferences =
                context.getSharedPreferences(context.getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);
        boolean isEarlyStartup = interviewPreferences.getBoolean(context.getString(R.string.pref_key_early_start_up), false);
        boolean isFundedStartup = interviewPreferences.getBoolean(context.getString(R.string.pref_key_funded_start_up), false);
        boolean isCorporate = interviewPreferences.getBoolean(context.getString(R.string.pref_key_corporation), false);
        boolean isFrontEnd = interviewPreferences.getBoolean(context.getString(R.string.pref_key_front_end), false);
        boolean isBackEnd = interviewPreferences.getBoolean(context.getString(R.string.pref_key_back_end), false);
        boolean isIOS = interviewPreferences.getBoolean(context.getString(R.string.pref_key_ios), false);
        boolean isAndroid = interviewPreferences.getBoolean(context.getString(R.string.pref_key_android), false);

        List<Interviewer> interviewerList = DummyData.getInterviewerSet(0); // Get all interviewers.
        List<Interviewer> newInterviewerList = new ArrayList<>();

        if (isEarlyStartup || isFundedStartup || isCorporate || isFrontEnd || isBackEnd || isIOS || isAndroid) {

            for (int i = 0; i < interviewerList.size(); i++) {

                boolean isAlreadyAdded = false;

                // EARLY STARTUP:
                if (isEarlyStartup && !isAlreadyAdded) {

                    if (interviewerList.get(i).getCurrentCompany().getCompanyType() == 0) {
                        newInterviewerList.add(interviewerList.get(i));
                        isAlreadyAdded = true;
                    }
                }

                // FUNDED STARTUP:
                if (isFundedStartup && !isAlreadyAdded) {

                    if (interviewerList.get(i).getCurrentCompany().getCompanyType() == 1) {
                        newInterviewerList.add(interviewerList.get(i));
                        isAlreadyAdded = true;
                    }
                }

                // CORPORATE:
                if (isCorporate && !isAlreadyAdded) {

                    if (interviewerList.get(i).getCurrentCompany().getCompanyType() == 2) {
                        newInterviewerList.add(interviewerList.get(i));
                        isAlreadyAdded = true;
                    }
                }

                // FRONT-END:
                if (isFrontEnd && !isAlreadyAdded) {

                    if (interviewerList.get(i).getPositionType() == 0) {
                        newInterviewerList.add(interviewerList.get(i));
                        isAlreadyAdded = true;
                    }
                }

                // BACK-END:
                if (isBackEnd && !isAlreadyAdded) {

                    if (interviewerList.get(i).getPositionType() == 1) {
                        newInterviewerList.add(interviewerList.get(i));
                        isAlreadyAdded = true;
                    }
                }

                // IOS:
                if (isIOS && !isAlreadyAdded) {

                    if (interviewerList.get(i).getPositionType() == 2) {
                        newInterviewerList.add(interviewerList.get(i));
                        isAlreadyAdded = true;
                    }
                }

                // ANDROID:
                if (isAndroid && !isAlreadyAdded) {

                    if (interviewerList.get(i).getPositionType() == 3) {
                        newInterviewerList.add(interviewerList.get(i));
                        isAlreadyAdded = true;
                    }
                }
            }

            return newInterviewerList;
        } else {
            return interviewerList;
        }
    }
}
