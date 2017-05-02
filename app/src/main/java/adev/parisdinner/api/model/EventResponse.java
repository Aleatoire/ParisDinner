package adev.parisdinner.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import adev.parisdinner.model.Event;
import adev.parisdinner.model.Food;
import adev.parisdinner.utils.FoodAscComparator;

/**
 * Created by Aldric ANDRE
 * on 02/05/2017.
 */

public class EventResponse {

    public EventResponse() {
    }

    public EventResponse(List<Event> events) {
        this.events = events;
    }

    private List<Event> events;
    private List<Food> mFoods;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Food> getmFoods() {
        return mFoods;
    }

    public void setmFoods(List<Food> mFoods) {
        this.mFoods = mFoods;
    }

    public List<Event> getEventByFoodType(int foodType) {
        List<Event> parsedEvent = new ArrayList<>();

        if (events == null
                || events.isEmpty())
            return parsedEvent;

        for (Event event : events) {
            if (event.getFood().getId() == foodType)
                parsedEvent.add(event);
        }

        return parsedEvent;
    }

    public List<Food> getFoods() {
        mFoods = new ArrayList<>();

        if (events == null
                || events.isEmpty())
            return mFoods;

        for (Event event :
                events) {
            Food foodEvent = event.getFood();

            if (!isContainInFood(foodEvent))
                mFoods.add(foodEvent);
        }

        Collections.sort(mFoods, new FoodAscComparator());
        return mFoods;
    }

    public Event getEventById(int id) {
        if (events == null
                || events.isEmpty())
            return null;

        for (Event event :
                events) {
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
}
