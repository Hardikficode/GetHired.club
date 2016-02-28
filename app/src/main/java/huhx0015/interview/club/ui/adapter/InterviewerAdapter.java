package huhx0015.interview.club.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import huhx0015.interview.club.R;
import huhx0015.interview.club.activities.MainActivity;
import huhx0015.interview.club.interfaces.OnInterviewerSelected;
import huhx0015.interview.club.model.Interviewer;

/**
 * Created by Michael Yoon Huh on 9/3/2015.
 */

public class InterviewerAdapter extends RecyclerView.Adapter<InterviewerAdapter.ListViewHolder> {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // ACTIVITY VARIABLES
    private MainActivity activity;

    // LIST VARIABLES
    private List<Interviewer> interviewerList;

    // LOGGING VARIABLES
    private static final String LOG_TAG = InterviewerAdapter.class.getSimpleName();

    /** INITIALIZATION METHODS _________________________________________________________________ **/

    public InterviewerAdapter(List<Interviewer> list, MainActivity act) {
        this.activity = act;
        this.interviewerList = list;
    }

    /** EXTENSION METHODS ______________________________________________________________________ **/

    // onCreateViewHolder: This method is called when the custom ViewHolder needs to be initialized.
    // The layout of each item of the RecyclerView is inflated using LayoutInflater, passing the
    // output to the constructor of the custom ViewHolder.
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_interviewee_row, parent, false);

        ListViewHolder viewHolder = new ListViewHolder(view, new ListViewHolder.OnItemViewHolderClick() {

            @Override
            public void onItemClick(View caller, int position) {
                displayInterviewerProfile(interviewerList.get(position));
            }
        });

        return viewHolder;
    }

    // onBindViewHolder(): Overrides the onBindViewHolder to specify the contents of each item of
    // the RecyclerView. This method is similar to the getView method of a ListView's adapter.
    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

        // Sets the TextView objects.
        holder.intervieweeNameText.setText(interviewerList.get(position).getFullName());
        holder.intervieweeCompanyText.setText(interviewerList.get(position).getCurrentCompany());
        holder.intervieweePositionText.setText(interviewerList.get(position).getPosition());

        int avatarImage = interviewerList.get(position).getAvatar();

        // Loads the referenced image into the ImageView object.
        Picasso.with(activity)
                .load(avatarImage)
                .into(holder.intervieweeAvatar);
    }

    // getItemCount(): Returns the number of items present in the data.
    @Override
    public int getItemCount() {
        return interviewerList.size();
    }

    // onAttachedToRecyclerView(): Overrides the onAttachedToRecyclerView method.
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /** INTERFACE METHODS ______________________________________________________________________ **/

    private void displayInterviewerProfile(Interviewer interviewer) {
        try { ((OnInterviewerSelected) activity).interviewerSelected(interviewer); }
        catch (ClassCastException cce) {} // Catch for class cast exception errors.
    }

    /** SUBCLASSES _____________________________________________________________________________ **/

    public static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /** SUBCLASS VARIABLES _________________________________________________________________ **/

        // LAYOUT VARIABLES:
        CardView intervieweeCardView;
        ImageView intervieweeAvatar;
        TextView intervieweeNameText;
        TextView intervieweeCompanyText;
        TextView intervieweePositionText;

        public OnItemViewHolderClick interviewerItemListener;

        /** SUBCLASS METHODS ___________________________________________________________________ **/

        ListViewHolder(View itemView, OnItemViewHolderClick listener) {

            super(itemView);

            intervieweeCardView = (CardView) itemView.findViewById(R.id.cardview_container);
            intervieweeAvatar = (ImageView) itemView.findViewById(R.id.avatar_image);
            intervieweeNameText = (TextView) itemView.findViewById(R.id.name_text);
            intervieweeCompanyText = (TextView) itemView.findViewById(R.id.company_text);
            intervieweePositionText = (TextView) itemView.findViewById(R.id.position_text);

            if (listener != null) {
                interviewerItemListener = listener;
                itemView.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            int itemPos = getAdapterPosition();
            interviewerItemListener.onItemClick(v, itemPos);
        }

        public interface OnItemViewHolderClick {
            void onItemClick(View caller, int position);
        }
    }
}