package adev.parisdinner.manager;

import android.app.Activity;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import adev.parisdinner.model.Event;
import adev.parisdinner.model.Food;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class EventManager {
    private static final String TAG = "EventManager";

    private static EventManager instance;
    private static ArrayList<Event> mEvents;
    private static List<Food> mFoods;

    //region Constructor
    private EventManager() {
    }

    /**
     * @return Instance of the API Manager
     */
    public static EventManager getInstance() {
        if (EventManager.instance == null) {
            EventManager.instance = new EventManager();
            EventManager.mEvents = new ArrayList<>();
            EventManager.mFoods = new ArrayList<>();
        }
        return EventManager.instance;
    }
    //endregion


    public List<Event> getAllEvents(Activity activity) {
        if (mEvents == null
                || mEvents.isEmpty())
            loadEvents(activity);

        return mEvents;
    }

    public List<Event> getEventByFoodType(Activity activity, int foodType) {
        List<Event> listEvents = new ArrayList<>();

        if (mEvents == null
                || mEvents.isEmpty())
            loadEvents(activity);

        for (Event event : mEvents) {
            if (event.getFood().getId() == foodType)
                listEvents.add(event);
        }

        return listEvents;
    }

    public List<Food> getFoods(Activity activity) {
        if (mEvents == null
                || mEvents.isEmpty())
            loadEvents(activity);

        for (Event event :
                mEvents) {
            Food foodEvent = event.getFood();

            if (!isContainInFood(foodEvent))
                mFoods.add(foodEvent);
        }
        return mFoods;
    }

    public Event getEventById(Activity activity, int id) {
        if (mEvents == null
                || mEvents.isEmpty())
            loadEvents(activity);

        for (Event event :
                mEvents) {
            if (event.getId() == id)
                return event;
        }

        return null;
    }

    private boolean isContainInFood(Food eventFood) {
        if (mFoods.isEmpty())
            return false;
        else {
            int i = 0;
            while (i < mFoods.size()) {
                Food food = mFoods.get(i);
                if (food.getId() == eventFood.getId()) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

    private void loadEvents(Activity activity) {
        Gson gson = new Gson();
        EventResponse eventResponse = gson.fromJson(loadJSONFromAsset(activity), EventResponse.class);
        mEvents.addAll(eventResponse.getEvents());
    }

    private String loadJSONFromAsset(Activity activity) {
        String json = null;
        try {
            InputStream is = activity.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    class EventResponse {
        public EventResponse() {
        }

        public EventResponse(List<Event> events) {
            this.events = events;
        }

        List<Event> events;

        public List<Event> getEvents() {
            return events;
        }

        public void setEvents(List<Event> events) {
            this.events = events;
        }
    }
}
