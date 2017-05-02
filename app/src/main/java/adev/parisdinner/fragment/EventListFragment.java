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

import adev.parisdinner.R;
import adev.parisdinner.adapter.EventAdapter;
import adev.parisdinner.api.model.EventResponse;
import adev.parisdinner.manager.EventManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private int mFoodType;

    public EventListFragment() {
    }

    public EventListFragment setFoodType(int foodType) {
        this.mFoodType = foodType;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        GridLayoutManager glm = new GridLayoutManager(getContext(), 1);
        glm.setInitialPrefetchItemCount(8);
        mRecyclerView.setLayoutManager(glm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        getEvents();
        return rootView;
    }

    private void getEvents() {
        EventManager.getInstance().getOnlineEvents(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful())
                    setupRecycler(response.body());
                else
                    setupRecycler(null);
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                setupRecycler(null);
            }
        });

    }

    private void setupRecycler(EventResponse eventResponse) {
        if (eventResponse == null)
            eventResponse = EventManager.getInstance().getOfflineEvents(getActivity());

        if (getView() != null) {
            EventAdapter mEventAdapter = new EventAdapter(eventResponse.getEventByFoodType(mFoodType));
            mRecyclerView.setAdapter(mEventAdapter);
            mEventAdapter.notifyDataSetChanged();
            mRecyclerView.invalidate();
            mLoader.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
