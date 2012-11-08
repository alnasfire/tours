package by.scand.info.model;

/**
 * User: nasgor
 * Date: 10/8/12
 * Time: 10:00 AM
 */
public class Tour {
    private String country = new String();  //
    private String resort = new String();  //
    private String hotel = new String();
    private String departure = new String();
    private String date = new String();   //
    private String duration = new String();    //
    private String price = new String();
    private Firm firm;


    public Tour() {
    }

    public Tour(String country, String resort, String hotel, String departure, String date, String duration, String price, Firm firm) {
        this.country = country;
        this.resort = resort;
        this.hotel = hotel;
        this.departure = departure;
        this.date = date;
        this.duration = duration;
        this.price = price;
        this.firm = firm;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getResort() {
        return resort;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (country != null ? !country.equals(tour.country) : tour.country != null) return false;
        if (date != null ? !date.equals(tour.date) : tour.date != null) return false;
        if (departure != null ? !departure.equals(tour.departure) : tour.departure != null) return false;
        if (duration != null ? !duration.equals(tour.duration) : tour.duration != null) return false;
        if (firm != null ? !firm.equals(tour.firm) : tour.firm != null) return false;
        if (hotel != null ? !hotel.equals(tour.hotel) : tour.hotel != null) return false;
        if (price != null ? !price.equals(tour.price) : tour.price != null) return false;
        if (resort != null ? !resort.equals(tour.resort) : tour.resort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (resort != null ? resort.hashCode() : 0);
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (firm != null ? firm.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "country='" + country + '\'' +
                ", resort='" + resort + '\'' +
                ", hotel='" + hotel + '\'' +
                ", departure='" + departure + '\'' +
                ", date='" + date + '\'' +
                ", duration='" + duration + '\'' +
                ", price='" + price + '\'' +
                ", firm=" + firm +
                '}';
    }
}