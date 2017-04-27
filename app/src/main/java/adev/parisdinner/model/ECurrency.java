package adev.parisdinner.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class ECurrency {

    private int id;
    private String title;
    @SerializedName("iso_3")
    private String iso3;
    private String symbol;

    public ECurrency() {
    }

    public ECurrency(int id, String title, String iso3, String symbol) {
        this.id = id;
        this.title = title;
        this.iso3 = iso3;
        this.symbol = symbol;
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

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
