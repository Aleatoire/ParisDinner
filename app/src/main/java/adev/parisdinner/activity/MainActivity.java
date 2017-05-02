package adev.parisdinner.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import adev.parisdinner.R;
import adev.parisdinner.adapter.SectionPagerAdapter;
import adev.parisdinner.api.model.EventResponse;
import adev.parisdinner.manager.EventManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.pager)
    ViewPager mViewPager;
    @BindView(R.id.loader)
    LinearLayout mLoadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mViewPager = (ViewPager) findViewById(R.id.pager);

        EventManager.getInstance().getOnlineEvents(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful())
                    setupView(response.body());
                else
                    setupView(null);

            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                setupView(null);
            }
        });

    }

    private void setupView(EventResponse eventResponse) {
        if (eventResponse == null)
            eventResponse = EventManager.getInstance().getOfflineEvents(this);

        mViewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager(), eventResponse.getFoods()));
        showProgress(false);
    }

    private void showProgress(boolean isVisible) {
        mLoadView.setVisibility((isVisible) ? View.VISIBLE : View.GONE);
    }

}