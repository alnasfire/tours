package by.scand.info.model;

/**
 * User: nasgor
 * Date: 10/4/12
 * Time: 12:44 PM
 */
public class FullFirmInfo {
    private String[] phones;
    private String city;
    private String district;
    private String station;
    private String webSite;
    private String workTime;
    private String[] icqs;
    private String[] skypes;

    public FullFirmInfo() {
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String[] getIcqs() {
        return icqs;
    }

    public void setIcqs(String[] icqs) {
        this.icqs = icqs;
    }

    public String[] getSkypes() {
        return skypes;
    }

    public void setSkypes(String[] skypes) {
        this.skypes = skypes;
    }
}