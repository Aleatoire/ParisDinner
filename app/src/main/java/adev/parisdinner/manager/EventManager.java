package adev.parisdinner.manager;

import android.app.Activity;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import adev.parisdinner.api.EventService;
import adev.parisdinner.api.ServiceGenerator;
import adev.parisdinner.api.model.EventResponse;
import retrofit2.Callback;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class EventManager {
    private static final String TAG = "EventManager";

    private static EventManager instance;

    //region Constructor
    private EventManager() {
    }

    /**
     * @return Instance of the API Manager
     */
    public static EventManager getInstance() {
        if (EventManager.instance == null) {
            EventManager.instance = new EventManager();
        }
        return EventManager.instance;
    }
    //endregion

    public EventResponse getOfflineEvents(Activity activity) {
        Gson gson = new Gson();
        return gson.fromJson(loadJSONFromAsset(activity), EventResponse.class);
    }

    public void getOnlineEvents(Callback<EventResponse> callback) {
        EventService eventService = ServiceGenerator.createService(EventService.class);
        eventService.getEvents().enqueue(callback);
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
}
