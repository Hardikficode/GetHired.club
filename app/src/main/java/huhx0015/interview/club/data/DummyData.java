package huhx0015.interview.club.data;

import java.util.ArrayList;
import java.util.List;

import huhx0015.interview.club.R;
import huhx0015.interview.club.model.Interviewer;

/**
 * Created by Michael Yoon Huh on 2/27/2016.
 */
public class DummyData {

    /** DUMMY LIST DATA ________________________________________________________________________ **/

    public static List<Interviewer> getInterviewerSet(int setNumber) {

        List<Interviewer> interviewerList = new ArrayList<>();

        switch(setNumber) {

            // ALL:
            case 0:
                interviewerList.add(SALLY_MALIBU());
                interviewerList.add(NICK_BORGE());
                interviewerList.add(DORIS_ESTHER());
                interviewerList.add(DAWN_BELLEPOR());
                interviewerList.add(JENNIFER_MARLOWE());
                interviewerList.add(SHIRLEY_CONNOR());
                interviewerList.add(SONYA_KOSLAVOKA());
                interviewerList.add(MAC_HAMM());
                interviewerList.add(TONY_MCDONALD());
                interviewerList.add(CHARLES_OLSEN());
                interviewerList.add(JANET_HOWELL());
                break;

            // ANDROID:
            case 1:
                interviewerList.add(NICK_BORGE());
                interviewerList.add(MAC_HAMM());
                interviewerList.add(JANET_HOWELL());
                break;

            // IOS:
            case 2:
                interviewerList.add(SALLY_MALIBU());
                interviewerList.add(JENNIFER_MARLOWE());
                interviewerList.add(SHIRLEY_CONNOR());
                break;

            // FRONT-END:
            case 3:
                interviewerList.add(DAWN_BELLEPOR());
                interviewerList.add(TONY_MCDONALD());
                break;

            // BACK-END:
            case 4:
                interviewerList.add(DORIS_ESTHER());
                interviewerList.add(SONYA_KOSLAVOKA());
                interviewerList.add(CHARLES_OLSEN());
                break;

            // DEFAULT: ALL
            default:
                interviewerList.add(SALLY_MALIBU());
                interviewerList.add(NICK_BORGE());
                interviewerList.add(DORIS_ESTHER());
                interviewerList.add(DAWN_BELLEPOR());
                interviewerList.add(JENNIFER_MARLOWE());
                interviewerList.add(SHIRLEY_CONNOR());
                interviewerList.add(SONYA_KOSLAVOKA());
                interviewerList.add(MAC_HAMM());
                interviewerList.add(TONY_MCDONALD());
                interviewerList.add(CHARLES_OLSEN());
                interviewerList.add(JANET_HOWELL());
                break;
        }

        return interviewerList;
    }

    /** DUMMY INTERVIEWER DATA _________________________________________________________________ **/

    public static Interviewer SALLY_MALIBU() {

        Interviewer interviewer = new Interviewer();
        interviewer.setAvatar(R.drawable.blonde_woman_interviewer);
        interviewer.setFullName("Sally Malibu");
        interviewer.setCurrentCompany("Sunset Technologies");
        interviewer.setPosition("Junior iOS Developer");

        return interviewer;
    }

    public static Interviewer NICK_BORGE() {

        Interviewer interviewer = new Interviewer();
        interviewer.setAvatar(R.drawable.contemplating_man_interviewer);
        interviewer.setFullName("Nick Borge");
        interviewer.setCurrentCompany("Uber");
        interviewer.setPosition("Android Developer");

        return interviewer;
    }

    public static Interviewer DORIS_ESTHER() {

        Interviewer interviewer = new Interviewer();
        interviewer.setAvatar(R.drawable.doris_lady_interviewer);
        interviewer.setFullName("Doris Esther");
        interviewer.setCurrentCompany("Microsoft");
        interviewer.setPosition("Senior Back-End Engineer");

        return interviewer;
    }

    public static Interviewer DAWN_BELLEPOR() {

        Interviewer interviewer = new Interviewer();
        interviewer.setAvatar(R.drawable.executive_woman_interviewer);
        interviewer.setFullName("Dawn Bellepor");
        interviewer.setCurrentCompany("Esri");
        interviewer.setPosition("Senior Front-End Engineer");

        return interviewer;
    }

    public static Interviewer JENNIFER_MARLOWE() {

        Interviewer interviewer = new Interviewer();
        interviewer.setAvatar(R.drawable.fitness_girl_avatar);
        interviewer.setFullName("Jennifer Marlowe");
        interviewer.setCurrentCompany("Fitness Buddies");
        interviewer.setPosition("Junior iOS Developer");

        return interviewer;
    }

    public static Interviewer MAC_HAMM() {

        Interviewer interviewer = new Interviewer();
        interviewer.setAvatar(R.drawable.happy_man_interviewer);
        interviewer.setFullName("Mac Hamm");
        interviewer.setCurrentCompany("Lyft");
        interviewer.setPosition("Senior Android Engineer");

        return interviewer;
    }

    public static Interviewer SHIRLEY_CONNOR() {

        Interviewer interviewer = new Interviewer();
        interviewer.setAvatar(R.drawable.happy_woman_interviewer);
        interviewer.setFullName("Shirley Conner");
        interviewer.setCurrentCompany("Tinder");
        interviewer.setPosition("Junior iOS Developer");

        return interviewer;
    }

    public static Interviewer SONYA_KOSLAVOKA() {

        Interviewer interviewer = new Interviewer();
        interviewer.setAvatar(R.drawable.mercenary_woman_interviewer);
        interviewer.setFullName("Sonya Koslavoka");
        interviewer.setCurrentCompany("ArmyGear");
        interviewer.setPosition("Junior Back-end Engineer");

        return interviewer;
    }

    public static Interviewer TONY_MCDONALD() {

        Interviewer interviewer = new Interviewer();
        interviewer.setAvatar(R.drawable.silly_man_interviewer);
        interviewer.setFullName("Tony McDonald");
        interviewer.setCurrentCompany("Google");
        interviewer.setPosition("Junior Front-end Engineer");

        return interviewer;
    }

    public static Interviewer CHARLES_OLSEN() {

        Interviewer interviewer = new Interviewer();
        interviewer.setAvatar(R.drawable.speaker_man_interviewer);
        interviewer.setFullName("Charles Olsen");
        interviewer.setCurrentCompany("Oracle");
        interviewer.setPosition("Senior Back-end Engineer");

        return interviewer;
    }

    public static Interviewer JANET_HOWELL() {

        Interviewer interviewer = new Interviewer();
        interviewer.setAvatar(R.drawable.woman_phone_interviewer);
        interviewer.setFullName("Janet Howell");
        interviewer.setCurrentCompany("Soda'n Candy");
        interviewer.setPosition("Junior Android Developer");

        return interviewer;
    }
}
