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
import adev.parisdinner.manager.EventManager;
import adev.parisdinner.model.Event;
import adev.parisdinner.model.Language;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class EventActivity extends AppCompatActivity implements OnMapReadyCallback {

    private int mEventId;
    private Event mEvent;

    private TextView mUsernameView;
    private TextView mOpenHoursView;
    private TextView mSeatCountView;
    private TextView mMoneyView;
    private TextView mFoodTypeView;
    private TextView mTypeView;
    private TextView mUserLanguageView;
    private TextView mRatingCountView;
    private ImageView mCoverEventView;
    private ImageView mUserImageView;
    private RatingBar mRatingUserView;
    private SupportMapFragment mMapFragment;
    private GoogleMap mMap;
    private CollapsingToolbarLayout mCollapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mUsernameView = (TextView) findViewById(R.id.txt_user_name_event);
        mOpenHoursView = (TextView) findViewById(R.id.txt_open_hour_event);
        mSeatCountView = (TextView) findViewById(R.id.txt_seats_count);
        mMoneyView = (TextView) findViewById(R.id.txt_money_detail);
        mFoodTypeView = (TextView) findViewById(R.id.txt_food_type_event);
        mTypeView = (TextView) findViewById(R.id.txt_type_event);
        mRatingCountView = (TextView) findViewById(R.id.txt_rating_count);
        mUserLanguageView = (TextView) findViewById(R.id.txt_user_language);
        mCoverEventView = (ImageView) findViewById(R.id.img_detail_cover_event);
        mUserImageView = (ImageView) findViewById(R.id.img_user_event);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mRatingUserView = (RatingBar) findViewById(R.id.rating_details);
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
            setUpView();
    }

    public void setUpView() {
        mEvent = EventManager.getInstance().getEventById(this, mEventId);

        mCollapsingToolbar.setTitle(mEvent.getTitle());
        mUsernameView.setText(mUsernameView.getContext().getResources().getString(R.string.user_by_format, mEvent.getUser().getFirstname()));
        mRatingUserView.setRating(mEvent.getUser().getRating().getScore());
        mOpenHoursView.setText(mOpenHoursView.getContext().getResources().getString(R.string.open_hour_format, mEvent.getBeginHour(), mEvent.getEndHour()));
        mMoneyView.setText(mMoneyView.getContext().getResources().getString(R.string.price_detail_format, mEvent.getPrice(), mEvent.getCurrency().getSymbol()));
        mSeatCountView.setText(mSeatCountView.getContext().getResources().getQuantityString(R.plurals.seat_count, mEvent.getSeatMax(), mEvent.getSeatMax()));
        mFoodTypeView.setText(mFoodTypeView.getContext().getResources().getString(R.string.food_type, mEvent.getFood().getTitle()));
        mTypeView.setText(mTypeView.getContext().getResources().getString(R.string.place_type, mEvent.getTypeLocalized()));
        mRatingCountView.setText(mRatingCountView.getContext().getResources().getString(R.string.rating_detail_format, mEvent.getUser().getRating().getCount()));

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
                .into(mUserImageView);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
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
