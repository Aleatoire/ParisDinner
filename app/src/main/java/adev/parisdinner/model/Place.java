package adev.parisdinner.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class Place {
    private int id;
    private int userId;
    private String title;
    private String description;
    private String locality;
    @SerializedName("administrative_area_level_1")
    private String adminAreaLevel1;
    @SerializedName("administrative_area_level_2")
    private String adminAreaLevel2;
    private String country;
    @SerializedName("country_iso")
    private String countryIso;
    @SerializedName("postal_code")
    private String postalCode;
    private Coordinates coordinates;
    private String timezone;

    public Place() {
    }

    public Place(int id,
                 int userId,
                 String title,
                 String description,
                 String locality,
                 String adminAreaLevel1,
                 String adminAreaLevel2,
                 String country,
                 String countryIso,
                 String postalCode,
                 Coordinates coordinates,
                 String timezone) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.locality = locality;
        this.adminAreaLevel1 = adminAreaLevel1;
        this.adminAreaLevel2 = adminAreaLevel2;
        this.country = country;
        this.countryIso = countryIso;
        this.postalCode = postalCode;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAdminAreaLevel1() {
        return adminAreaLevel1;
    }

    public void setAdminAreaLevel1(String adminAreaLevel1) {
        this.adminAreaLevel1 = adminAreaLevel1;
    }

    public String getAdminAreaLevel2() {
        return adminAreaLevel2;
    }

    public void setAdminAreaLevel2(String adminAreaLevel2) {
        this.adminAreaLevel2 = adminAreaLevel2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
