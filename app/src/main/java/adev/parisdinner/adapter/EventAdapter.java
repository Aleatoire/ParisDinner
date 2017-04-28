package adev.parisdinner.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import adev.parisdinner.R;
import adev.parisdinner.model.Event;
import adev.parisdinner.ui.EventViewHolder;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private List<Event> mEvents;

    public EventAdapter(List<Event> events) {
        this.mEvents = events;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.event_grid_item, viewGroup, false);

        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder myViewHolder, int position) {
        Event event = mEvents.get(position);
        myViewHolder.setEvent(event);
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

}
