package adev.parisdinner.api;

import adev.parisdinner.api.model.EventResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Aldric ANDRE
 * on 02/05/2017.
 */

public interface EventService {

    @GET("2m53033iadq34a8/events.json ")
    Call<EventResponse> getEvents();

}
