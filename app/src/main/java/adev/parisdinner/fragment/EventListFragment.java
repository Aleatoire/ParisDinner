package adev.parisdinner.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import adev.parisdinner.R;
import adev.parisdinner.adapter.EventAdapter;
import adev.parisdinner.model.Event;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class EventListFragment extends Fragment {

    @BindView(R.id.listView)
    RecyclerView mRecyclerView;
    @BindView(R.id.loader)
    LinearLayout mLoader;

    Unbinder unbinder;
    private EventAdapter mEventAdapter;

    public EventListFragment() {
    }

    public EventListFragment setSection() {
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        GridLayoutManager glm = new GridLayoutManager(getContext(), 2);
        glm.setInitialPrefetchItemCount(8);
        mRecyclerView.setLayoutManager(glm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    private void getEvents() {

        //setupRecycler(events);
    }

    private void setupRecycler(List<Event> events) {
        mEventAdapter = new EventAdapter(events);
        mRecyclerView.setAdapter(mEventAdapter);
        mEventAdapter.notifyDataSetChanged();
        mRecyclerView.invalidate();
        mLoader.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
