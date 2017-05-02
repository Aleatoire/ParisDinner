package adev.parisdinner.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import adev.parisdinner.R;
import adev.parisdinner.api.model.EventResponse;
import adev.parisdinner.manager.EventManager;
import adev.parisdinner.model.Event;
import adev.parisdinner.model.Language;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventActivity extends AppCompatActivity implements OnMapReadyCallback {
    private final static String TAG = "EventActivity";

    @BindView(R.id.img_detail_cover_event)
    ImageView mCoverEventView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.txt_type_event)
    TextView mTypeView;
    @BindView(R.id.txt_food_type_event)
    TextView mFoodTypeView;
    @BindView(R.id.txt_open_hour_event)
    TextView mOpenHoursView;
    @BindView(R.id.txt_money_detail)
    TextView mMoneyView;
    @BindView(R.id.txt_seats_count)
    TextView mSeatCountView;
    @BindView(R.id.img_user_event)
    ImageView mUserImageView;
    @BindView(R.id.txt_user_name_event)
    TextView mUsernameView;
    @BindView(R.id.rating_details)
    RatingBar mRatingUserView;
    @BindView(R.id.txt_rating_count)
    TextView mRatingCountView;
    @BindView(R.id.txt_user_language)
    TextView mUserLanguageView;
    @BindView(R.id.txt_user_age)
    TextView mAgeView;
    @BindView(R.id.txt_description_event)
    TextView mDescriptionView;
    SupportMapFragment mMapFragment;

    private int mEventId;
    private Event mEvent;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ButterKnife.bind(this);

        mMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mMapFragment.getMapAsync(this);

        setSupportActionBar(toolbar);

        if (getIntent() != null) {
            this.mEventId = getIntent().getIntExtra("event_id", 0);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mEventId != 0)
            getEvent();
    }

    private void getEvent() {
        EventManager.getInstance().getOnlineEvents(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful())
                    setUpView(response.body());
                else
                    setUpView(null);
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                setUpView(null);
            }
        });
    }

    public void setUpView(EventResponse eventResponse) {
        if (eventResponse == null)
            eventResponse = EventManager.getInstance().getOfflineEvents(this);

        mEvent = eventResponse.getEventById(mEventId);

        mCollapsingToolbar.setTitle(mEvent.getTitle());
        mUsernameView.setText(mUsernameView.getContext().getResources().getString(R.string.user_by_format, mEvent.getUser().getFirstname()));
        mRatingUserView.setRating(mEvent.getUser().getRating().getScore());
        mOpenHoursView.setText(mOpenHoursView.getContext().getResources().getString(R.string.open_hour_format, mEvent.getBeginHour(), mEvent.getEndHour()));
        mMoneyView.setText(mMoneyView.getContext().getResources().getString(R.string.price_detail_format, mEvent.getPrice(), mEvent.getCurrency().getSymbol()));
        mSeatCountView.setText(mSeatCountView.getContext().getResources().getQuantityString(R.plurals.seat_count, mEvent.getSeatMax(), mEvent.getSeatMax()));
        mFoodTypeView.setText(mFoodTypeView.getContext().getResources().getString(R.string.food_type, mEvent.getFood().getTitle()));
        mTypeView.setText(mTypeView.getContext().getResources().getString(R.string.place_type, mEvent.getTypeLocalized()));
        mRatingCountView.setText(mRatingCountView.getContext().getResources().getString(R.string.rating_detail_format, mEvent.getUser().getRating().getCount()));

        mDescriptionView.setText(mEvent.getUser().getDescription());
        mAgeView.setText(mEvent.getUser().getAge());

        String iSpeak = "";
        for (Language lang :
                mEvent.getLanguages()) {
            if (lang.isActivated())
                iSpeak += lang.getiSpeak() + "\n";
        }
        mUserLanguageView.setText(iSpeak);

        Picasso.with(getApplicationContext())
                .load(mEvent.getCover().getUrlPath())
                .fit()
                .centerCrop()
                .into(mCoverEventView);

        Picasso.with(getApplicationContext())
                .load(mEvent.getUser().getAvatar().getPath())
                .transform(new RoundedCornersTransformation(90, 3))
                .fit()
                .centerCrop()
                .into(mUserImageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        if (mMap != null)
                            onMapReady(mMap);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (mEvent != null) {
            mEvent.getPlace();

            LatLng eventPlace = new LatLng(mEvent.getPlace().getCoordinates().getLatitude(), mEvent.getPlace().getCoordinates().getLongitude());
            Marker marker = googleMap.addMarker(new MarkerOptions()
                    .position(eventPlace)
                    .title(mEvent.getTitle())
                    .snippet(mEvent.getUser().getFirstname()));

            marker.showInfoWindow();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eventPlace, mEvent.getPlace().getCoordinates().getZoom()));
        }

    }

}
