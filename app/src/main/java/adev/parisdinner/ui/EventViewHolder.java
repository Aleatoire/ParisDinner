package adev.parisdinner.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import adev.parisdinner.model.Event;

public class EventViewHolder extends RecyclerView.ViewHolder {

    private Event mEvent;

    public EventViewHolder(View itemView) {
        super(itemView);

        //thumbnailImgView = (ImageView) itemView.findViewById(R.id.img_thumbnail_user);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(thumbnailImgView.getContext(), DetailsActivity.class);
                intent.putExtra("login", mEvent.getLogin());
                intent.putExtra("contributions", mEvent.getContributions());
                thumbnailImgView.getContext().startActivity(intent);*/
            }
        });
    }

    public void setEvent(Event event) {
        if (event == null)
            return;

        this.mEvent = event;

        /*Picasso.with(thumbnailImgView.getContext())
                .load(mEvent.getAvatar_url())
                .centerCrop()
                .placeholder(R.drawable.ic_user)
                .error(R.drawable.ic_user)
                .noFade()
                .fit()
                .into(thumbnailImgView);*/
    }
}
