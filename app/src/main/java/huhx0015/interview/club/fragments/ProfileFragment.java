package huhx0015.interview.club.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.sinch.android.rtc.calling.Call;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import huhx0015.interview.club.activities.CallScreenActivity;
import huhx0015.interview.club.activities.MainActivity;
import huhx0015.interview.club.constants.InterviewConstants;
import huhx0015.interview.club.model.Company;
import huhx0015.interview.club.services.SinchService;
import huhx0015.interview.club.utils.image.BackgroundUtils;
import huhx0015.interview.club.R;
import huhx0015.interview.club.model.Interviewer;

/**
 * Created by Michael Yoon Huh on 2/27/2016.
 */
public class ProfileFragment extends Fragment {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private Interviewer interviewer;

    private MainActivity activity;

    @Bind(R.id.profile_cover_image) ImageView profileCoverImage;
    @Bind(R.id.profile_text_sub_container_background) ImageView profileContainerBackground;
    @Bind(R.id.profile_image_avatar) RoundedImageView profileAvatar;
    @Bind(R.id.profile_name_text) TextView profileName;
    @Bind(R.id.profile_company_text) TextView profileCompany;
    @Bind(R.id.profile_position_text) TextView profilePosition;
    @Bind(R.id.past_companies_text) TextView pastCompaniesText;
    @Bind(R.id.past_companies_value) TextView pastCompaniesValueText;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public ProfileFragment(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    /** FRAGMENT LIFECYCLE METHODS _____________________________________________________________ **/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (MainActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View interviewer_profile_view = (ViewGroup) inflater.inflate(R.layout.fragment_interviewer_profile, container, false);
        ButterKnife.bind(this, interviewer_profile_view); // ButterKnife view injection initialization.

        initLayout();

        return interviewer_profile_view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this); // Sets all injected views to null.
    }

    /** LAYOUT METHODS _________________________________________________________________________ **/

    // initLayout(): Initializes the layout for the fragment.
    private void initLayout() {

        initInterviewer();
        initTextAttributes();

        // Sets the cover image.
        Picasso.with(getContext())
                .load(BackgroundUtils.setRandomBackground())
                .into(profileCoverImage);
    }

    private void initInterviewer() {

        if (interviewer != null) {
            profileName.setText(interviewer.getFullName());
            profileCompany.setText(interviewer.getCurrentCompany().getCompanyName());
            //profileCompany.setCompoundDrawablesWithIntrinsicBounds(interviewer.getCurrentCompany().getCompanyLogoId(), 0, 0, 0);
            profilePosition.setText(interviewer.getPosition());

            String pastCompanyValues = "Not Available";
            if (interviewer.getPreviousCompanies().size() > 0) {

                pastCompanyValues = "";
                for (Company company : interviewer.getPreviousCompanies()) {
                    pastCompanyValues = pastCompanyValues + company.getCompanyName() + "\n";
                }

            }

            pastCompaniesValueText.setText(pastCompanyValues);

            // Sets the rounded image view transformation for the avatar image.
            Transformation transformation = new RoundedTransformationBuilder()
                    .borderColor(Color.WHITE)
                    .borderWidthDp(1)
                    .cornerRadiusDp(30)
                    .oval(true)
                    .build();

            // Loads the avatar image into the RoundedImageView.
            Picasso.with(getContext())
                    .load(interviewer.getAvatar())
                    .transform(transformation)
                    .into(profileAvatar);
        }

        profileContainerBackground.setAlpha(0.4f);
    }

    private void initTextAttributes() {
        profileName.setShadowLayer(2, 2, 2, Color.BLACK);
        profileCompany.setShadowLayer(2, 2, 2, Color.BLACK);
        profilePosition.setShadowLayer(2, 2, 2, Color.BLACK);
        pastCompaniesText.setShadowLayer(4, 2, 2, Color.BLACK);
    }

    @OnClick(R.id.call_fab_button)
    public void performCallButtonClick() {
        initiateCall(interviewer.getFullName());
    }

    /** SINCH METHODS __________________________________________________________________________ **/

    private void initiateCall(String userName) {

        if (!activity.getSinchServiceInterface().isStarted() && activity.getSinchServiceInterface().getUserName() != InterviewConstants.SINCH_USERNAME_CALLER) {
            activity.getSinchServiceInterface().stopClient(); // Stops the Sinch Service thread.

            activity.currentSinchUsername = InterviewConstants.SINCH_USERNAME_CALLER;

            activity.startSinchServiceThread(true); // Starts the Sinch Service thread.
        }

        else {
            openCallActivity(userName);
        }
    }

    private void openCallActivity(String username) {
        Call call = activity.getSinchServiceInterface().callUserVideo(InterviewConstants.SINCH_USERNAME_RECEIVER);
        String callId = call.getCallId();

        Intent callScreen = new Intent(activity, CallScreenActivity.class);
        callScreen.putExtra(SinchService.CALL_ID, callId);
        callScreen.putExtra(InterviewConstants.SINCH_VIDEO_RECEPIENT, username);
        startActivity(callScreen);
    }
}