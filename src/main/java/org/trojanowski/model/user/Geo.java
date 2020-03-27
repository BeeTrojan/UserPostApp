package org.trojanowski.model.user;

public class Geo {
    Double lat;
    Double lng;

    public Geo(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Geo() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
