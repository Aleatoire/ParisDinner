package adev.parisdinner.ui;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import adev.parisdinner.R;
import adev.parisdinner.activity.EventActivity;
import adev.parisdinner.model.Event;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class EventViewHolder extends RecyclerView.ViewHolder {

    private Event mEvent;
    private ImageView mCoverView;
    private ImageView mImageUserView;
    private TextView mTitleEvent;
    private TextView mUsername;
    private TextView mRatingCount;
    private TextView mPrice;
    private RatingBar mRatingStar;

    public EventViewHolder(View itemView) {
        super(itemView);

        mCoverView = (ImageView) itemView.findViewById(R.id.img_event_grid);
        mImageUserView = (ImageView) itemView.findViewById(R.id.img_user);
        mTitleEvent = (TextView) itemView.findViewById(R.id.txt_event_title);
        mUsername = (TextView) itemView.findViewById(R.id.txt_user_name);
        mRatingCount = (TextView) itemView.findViewById(R.id.txt_rating_count);
        mPrice = (TextView) itemView.findViewById(R.id.txt_money);
        mRatingStar = (RatingBar) itemView.findViewById(R.id.rating_event);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mCoverView.getContext(), EventActivity.class);
                intent.putExtra("event_id", mEvent.getId());
                mCoverView.getContext().startActivity(intent);
            }
        });
    }

    public void setEvent(Event event) {
        if (event == null)
            return;

        this.mEvent = event;

        mTitleEvent.setText(mEvent.getTitle());
        mUsername.setText(mCoverView.getContext().getResources().getString(R.string.user_by_format, mEvent.getUser().getFirstname()));
        mRatingCount.setText(mCoverView.getContext().getResources().getString(R.string.rating_format, mEvent.getUser().getRating().getCount()));
        mPrice.setText(mCoverView.getContext().getResources().getString(R.string.price_format, mEvent.getPrice(), mEvent.getCurrency().getSymbol()));
        mRatingStar.setRating(mEvent.getUser().getRating().getScore());

        Picasso.with(mImageUserView.getContext())
                .load(mEvent.getUser().getAvatar().getPath())
                .centerCrop()
                .transform(new RoundedCornersTransformation(90, 3))
                .noFade()
                .fit()
                .into(mImageUserView);

        Picasso.with(mCoverView.getContext())
                .load(mEvent.getCover().getUrlPath())
                .transform(new RoundedCornersTransformation(30, 3))
                .centerCrop()
                .noFade()
                .fit()
                .into(mCoverView);
    }
}
