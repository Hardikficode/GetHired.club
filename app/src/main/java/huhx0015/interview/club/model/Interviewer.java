package huhx0015.interview.club.model;

import java.util.ArrayList;
import java.util.List;
import huhx0015.interview.club.R;

/**
 * Created by Michael Yoon Huh on 2/27/2016.
 */
public class Interviewer {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private String fullName;
    private String position;

    private int avatar;

    private Company currentCompany;

    private List<Company> previousCompanies;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public Interviewer() {
        this.fullName = "";
        this.position = "";
        this.avatar = R.mipmap.ic_launcher;
        this.previousCompanies = new ArrayList<>();
    }

    public Interviewer(String name, Company company, String position, int avatar, List<Company> previousCompanies) {
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

    public Company getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(Company currentCompany) {
        this.currentCompany = currentCompany;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Company> getPreviousCompanies() {
        return previousCompanies;
    }

    public void setPreviousCompanies(List<Company> previousCompanies) {
        this.previousCompanies = previousCompanies;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
