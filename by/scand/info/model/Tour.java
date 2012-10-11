package by.scand.info.model;

/**
 * User: nasgor
 * Date: 10/8/12
 * Time: 10:00 AM
 */
public class Tour {
    private String name;
    private String country;  //
    private String resort;  //
    private String hotel;
    private String date;   //
    private String days;    //
    private String cost;    //
    private String link;

    public Tour() {
    }

    public Tour(String name, String country, String resort, String hotel, String date, String days, String cost, String link) {
        this.name = name;
        this.country = country;
        this.resort = resort;
        this.hotel = hotel;
        this.date = date;
        this.days = days;
        this.cost = cost;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (cost != null ? !cost.equals(tour.cost) : tour.cost != null) return false;
        if (country != null ? !country.equals(tour.country) : tour.country != null) return false;
        if (date != null ? !date.equals(tour.date) : tour.date != null) return false;
        if (days != null ? !days.equals(tour.days) : tour.days != null) return false;
        if (hotel != null ? !hotel.equals(tour.hotel) : tour.hotel != null) return false;
        if (link != null ? !link.equals(tour.link) : tour.link != null) return false;
        if (name != null ? !name.equals(tour.name) : tour.name != null) return false;
        if (resort != null ? !resort.equals(tour.resort) : tour.resort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (resort != null ? resort.hashCode() : 0);
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", resort='" + resort + '\'' +
                ", hotel='" + hotel + '\'' +
                ", date='" + date + '\'' +
                ", days='" + days + '\'' +
                ", cost='" + cost + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public Tour parseString(String tourString){
        String[] tourFields = tourString.split(",");
        return new Tour(tourFields[0], tourFields[1], tourFields[2], tourFields[3], tourFields[4],
                tourFields[5], tourFields[6], tourFields[7]);
    }
}