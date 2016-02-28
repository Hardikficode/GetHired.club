package huhx0015.interview.club.utils.image;

import java.util.Random;
import huhx0015.interview.club.R;

/**
 * Created by Michael Yoon Huh on 2/27/2016.
 */

public class BackgroundUtils {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private static int backgroundID;

    /** BACKGROUND FUNCTIONALITY _______________________________________________________________ **/

    // setRandomBackground(): Returns a randomly selected background image resource.
    public static int setRandomBackground() {

        int randInt;
        Random randValue = new Random();
        randInt = randValue.nextInt(11);

        switch (randInt) {
            case 0:
                backgroundID = R.drawable.bay_bridge_night_background;
                break;
            case 1:
                backgroundID = R.drawable.cherry_spoon_background;
                break;
            case 2:
                backgroundID = R.drawable.chicago_night_background;
                break;
            case 3:
                backgroundID = R.drawable.duluth_night_background;
                break;
            case 4:
                backgroundID = R.drawable.golden_gate_bridge_background;
                break;
            case 5:
                backgroundID = R.drawable.minneapolis_background;
                break;
            case 6:
                backgroundID = R.drawable.seoul_night_background;
                break;
            case 7:
                backgroundID = R.drawable.st_paul_background;
                break;
            case 8:
                backgroundID = R.drawable.target_field_background;
                break;
            case 9:
                backgroundID = R.drawable.umn_background;
                break;
            case 10:
                backgroundID = R.drawable.winter_background;
                break;
            default:
                throw new IllegalArgumentException("ERROR: ILLEGALARGUMENTEXCEPTION ENCOUNTERED WHILE LOADING BACKGROUND IMAGES.");
        }
        return backgroundID; // Returns the background ID.
    }
}