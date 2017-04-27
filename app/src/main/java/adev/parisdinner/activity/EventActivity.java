package adev.parisdinner.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import adev.parisdinner.R;
import adev.parisdinner.manager.EventManager;
import adev.parisdinner.model.Event;

public class EventActivity extends FragmentActivity {

    private int mEventId;
    private Event mEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        if (getIntent() != null) {
            this.mEventId = getIntent().getIntExtra("event_id", 0);
            if (mEventId != 0)
                setUpView();
        }
    }

    public void setUpView() {
        mEvent = EventManager.getInstance().getEventById(this, mEventId);
    }

}