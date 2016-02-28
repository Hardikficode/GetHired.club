package huhx0015.interview.club.model;

import huhx0015.interview.club.R;

/**
 * Created by xfang on 2/27/16.
 */
public class Company {
    private String companyName;
    private String companyNameKey;
    private int companyLogoId;

    public Company(String companyNameKey) {
        this.companyName = getCompanyName(companyNameKey);
        this.companyLogoId = getCompanyLogoId(companyNameKey);
    }

    public int getCompanyLogoId(String companyNameKey){
        switch (companyNameKey){
            case("google"):
                return R.drawable.company_google;
            case("gusto"):
                return R.drawable.company_gusto;
            case("dropbox"):
                return R.drawable.company_dropbox;
            default:
                return R.drawable.company_google;
        }
    }

    public String getCompanyName(String companyNameKey){
        switch (companyNameKey){
            case("google"):
                return "Google";
            case("gusto"):
                return "Gusto";
            case("dropbox"):
                return "Dropbox";
            default:
                return "Google";
        }
    }

    /** GET / SET METHODS ______________________________________________________________________ **/

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNameKey() {
        return companyNameKey;
    }

    public void setCompanyNameKey(String companyNameKey) {
        this.companyNameKey = companyNameKey;
    }

    public int getCompanyLogoId() {
        return companyLogoId;
    }

    public void setCompanyLogoId(int companyLogoId) {
        this.companyLogoId = companyLogoId;
    }
}
