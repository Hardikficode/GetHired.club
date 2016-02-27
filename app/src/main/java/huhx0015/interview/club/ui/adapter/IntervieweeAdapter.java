package huhx0015.interview.club.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import huhx0015.interview.club.R;
import huhx0015.interview.club.model.Interviewee;

/**
 * Created by Michael Yoon Huh on 9/3/2015.
 */

public class IntervieweeAdapter extends RecyclerView.Adapter<IntervieweeAdapter.ListViewHolder> {

    /**
     * CLASS VARIABLES ________________________________________________________________________
     **/

    // ACTIVITY VARIABLES
    private Activity activity;

    // LIST VARIABLES
    private List<Interviewee> intervieweeList;

    // LOGGING VARIABLES
    private static final String LOG_TAG = IntervieweeAdapter.class.getSimpleName();

    /**
     * INITIALIZATION METHODS _________________________________________________________________
     **/

    public IntervieweeAdapter(List<Interviewee> list, Activity act) {
        this.activity = act;
        this.intervieweeList = list;
    }

    /**
     * EXTENSION METHODS ______________________________________________________________________
     **/

    // onCreateViewHolder: This method is called when the custom ViewHolder needs to be initialized.
    // The layout of each item of the RecyclerView is inflated using LayoutInflater, passing the
    // output to the constructor of the custom ViewHolder.
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Inflates the layout given the XML layout file for the item view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_interviewee_row, parent, false);

        return new ListViewHolder(view);
    }

    // onBindViewHolder(): Overrides the onBindViewHolder to specify the contents of each item of
    // the RecyclerView. This method is similar to the getView method of a ListView's adapter.
    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

        // Sets the TextView objects.
        holder.intervieweeNameText.setText(intervieweeList.get(position).getFullName());
        holder.intervieweeCompanyText.setText(intervieweeList.get(position).getCurrentCompany());
        holder.intervieweePositionText.setText(intervieweeList.get(position).getPosition());

        int avatarImage = intervieweeList.get(position).getAvatar();

        // Loads the referenced image into the ImageView object.
        Picasso.with(activity)
                .load(avatarImage)
                .into(holder.intervieweeAvatar);
    }

    // getItemCount(): Returns the number of items present in the data.
    @Override
    public int getItemCount() {
        return intervieweeList.size();
    }

    // onAttachedToRecyclerView(): Overrides the onAttachedToRecyclerView method.
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /** SUBCLASSES _____________________________________________________________________________ **/

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        /** SUBCLASS VARIABLES _________________________________________________________________ **/

        // LAYOUT VARIABLES:
        CardView intervieweeCardView;
        ImageView intervieweeAvatar;
        TextView intervieweeNameText;
        TextView intervieweeCompanyText;
        TextView intervieweePositionText;

        /** SUBCLASS METHODS ___________________________________________________________________ **/

        ListViewHolder(View itemView) {

            super(itemView);

            intervieweeCardView = (CardView) itemView.findViewById(R.id.cardview_container);
            intervieweeAvatar = (ImageView) itemView.findViewById(R.id.avatar_image);
            intervieweeNameText = (TextView) itemView.findViewById(R.id.name_text);
            intervieweeCompanyText = (TextView) itemView.findViewById(R.id.company_text);
            intervieweePositionText = (TextView) itemView.findViewById(R.id.position_text);
        }
    }
}