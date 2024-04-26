package Entite;

public class Event {

        private String title;
        private String description;
        private String date;
        private String location;
        private double discount;


    public Event(String title, String description, String date, String location, double discount) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
// Getters and setters...
    }


