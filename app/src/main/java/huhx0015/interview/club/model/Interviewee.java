package huhx0015.interview.club.model;

import java.util.ArrayList;
import java.util.List;
import huhx0015.interview.club.R;

/**
 * Created by Michael Yoon Huh on 2/27/2016.
 */
public class Interviewee {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private String fullName;
    private String currentCompany;
    private String position;

    private int avatar;

    private List<String> previousCompanies;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public Interviewee() {
        this.fullName = "";
        this.currentCompany = "";
        this.position = "";
        this.avatar = R.mipmap.ic_launcher;
        this.previousCompanies = new ArrayList<>();
    }

    public Interviewee(String name, String company, String position, int avatar, List<String> previousCompanies) {
        this.fullName = name;
        this.currentCompany = company;
        this.position = position;
        this.avatar = avatar;
        this.previousCompanies = previousCompanies;
    }

    /** GET / SET METHODS ______________________________________________________________________ **/

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<String> getPreviousCompanies() {
        return previousCompanies;
    }

    public void setPreviousCompanies(List<String> previousCompanies) {
        this.previousCompanies = previousCompanies;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
