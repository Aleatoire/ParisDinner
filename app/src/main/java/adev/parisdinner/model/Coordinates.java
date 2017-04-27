package adev.parisdinner.model;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class Coordinates {

    private double latitude;
    private double longitude;
    private int zoom;
    private int radius;

    public Coordinates() {
    }

    public Coordinates(double latitude,
                       double longitude,
                       int zoom,
                       int radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.zoom = zoom;
        this.radius = radius;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
