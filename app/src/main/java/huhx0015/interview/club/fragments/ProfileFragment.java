package huhx0015.interview.club.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import butterknife.Bind;
import butterknife.ButterKnife;
import huhx0015.interview.club.utils.image.BackgroundUtils;
import huhx0015.interview.club.R;
import huhx0015.interview.club.model.Interviewer;

/**
 * Created by Michael Yoon Huh on 2/27/2016.
 */
public class ProfileFragment extends Fragment {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private Interviewer interviewer;

    @Bind(R.id.profile_text_container) LinearLayout profileTextContainer;
    @Bind(R.id.profile_cover_image) ImageView profileCoverImage;
    @Bind(R.id.profile_image_avatar) ImageView profileAvatar;
    @Bind(R.id.profile_name_text) TextView profileName;
    @Bind(R.id.profile_company_text) TextView profileCompany;
    @Bind(R.id.profile_position_text) TextView profilePosition;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public ProfileFragment(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    /** FRAGMENT LIFECYCLE METHODS _____________________________________________________________ **/

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
            profileCompany.setText(interviewer.getCurrentCompany());
            profilePosition.setText(interviewer.getPosition());

            Picasso.with(getContext())
                    .load(interviewer.getAvatar())
                    .into(profileAvatar);
        }

        profileTextContainer.setAlpha(0.8f);
    }

    private void initTextAttributes() {
        profileName.setShadowLayer(2, 2, 2, Color.BLACK);
        profileCompany.setShadowLayer(2, 2, 2, Color.BLACK);
        profilePosition.setShadowLayer(2, 2, 2, Color.BLACK);
    }
}
