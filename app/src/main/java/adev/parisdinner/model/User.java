package adev.parisdinner.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class User {
    private int id;
    private String civility;
    private String firstname;
    @SerializedName("description_title")
    private String descriptionTitle;
    private String description;
    private String age;
    private ERating rating;
    private Avatar avatar;

    public User() {
    }

    public User(int id,
                String civility,
                String firstname,
                String descriptionTitle,
                String description,
                String age,
                ERating rating,
                Avatar avatar) {
        this.id = id;
        this.civility = civility;
        this.firstname = firstname;
        this.descriptionTitle = descriptionTitle;
        this.description = description;
        this.age = age;
        this.rating = rating;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getDescriptionTitle() {
        return descriptionTitle;
    }

    public void setDescriptionTitle(String descriptionTitle) {
        this.descriptionTitle = descriptionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ERating getRating() {
        return rating;
    }

    public void setRating(ERating rating) {
        this.rating = rating;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }
}
