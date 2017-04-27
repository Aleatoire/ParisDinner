package adev.parisdinner.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class Event {

    private int id;
    private String title;
    @SerializedName("min_seats")
    private int seatMin;
    @SerializedName("max_seats")
    private int seatMax;
    private String type;
    @SerializedName("localized_type")
    private String typeLocalized;
    @SerializedName("begins_at")
    private String beginHour;
    @SerializedName("ends_at")
    private String endHour;
    private Cover cover;
    private User user;
    private Place place;
    private Food food;
    private List<Language> languages;
    private int price;
    private ECurrency currency;

    public Event() {
    }

    public Event(int id,
                 String title,
                 int seatMin,
                 int seatMax,
                 int price,
                 String type,
                 String typeLocalized,
                 String beginHour,
                 String endHour,
                 Cover cover,
                 User user,
                 Food food,
                 Place place,
                 ECurrency currency,
                 List<Language> languages) {
        this.id = id;
        this.title = title;
        this.seatMin = seatMin;
        this.seatMax = seatMax;
        this.price = price;
        this.type = type;
        this.typeLocalized = typeLocalized;
        this.beginHour = beginHour;
        this.endHour = endHour;
        this.cover = cover;
        this.user = user;
        this.food = food;
        this.place = place;
        this.currency = currency;
        this.languages = languages;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeatMin() {
        return seatMin;
    }

    public void setSeatMin(int seatMin) {
        this.seatMin = seatMin;
    }

    public int getSeatMax() {
        return seatMax;
    }

    public void setSeatMax(int seatMax) {
        this.seatMax = seatMax;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeLocalized() {
        return typeLocalized;
    }

    public void setTypeLocalized(String typeLocalized) {
        this.typeLocalized = typeLocalized;
    }

    public String getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(String beginHour) {
        this.beginHour = beginHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public ECurrency getCurrency() {
        return currency;
    }

    public void setCurrency(ECurrency currency) {
        this.currency = currency;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}