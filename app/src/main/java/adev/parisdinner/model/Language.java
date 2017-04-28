package adev.parisdinner.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class Language {

    private int id;
    private boolean translated;
    private boolean activated;
    private String title;
    @SerializedName("i_speak")
    private String iSpeak;
    private String alpha2;
    @SerializedName("alpha3-b")
    private String alpha3;
    private String locale;

    public Language() {
    }

    public Language(int id,
                    boolean translated,
                    boolean activated,
                    String title,
                    String iSpeak,
                    String alpha2,
                    String alpha3,
                    String locale) {
        this.id = id;
        this.translated = translated;
        this.activated = activated;
        this.title = title;
        this.iSpeak = iSpeak;
        this.alpha2 = alpha2;
        this.alpha3 = alpha3;
        this.locale = locale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTranslated() {
        return translated;
    }

    public void setTranslated(boolean translated) {
        this.translated = translated;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getiSpeak() {
        return iSpeak;
    }

    public void setiSpeak(String iSpeak) {
        this.iSpeak = iSpeak;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
