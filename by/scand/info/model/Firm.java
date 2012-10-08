package by.scand.info.model;

/**
 * User: nasgor
 * Date: 10/3/12
 * Time: 11:57 AM
 */
public class Firm {
    private String name;
    private String adress;
    private String phones;

    public Firm() {
    }

    public Firm(String name, String adress, String phones) {
        this.name = name;
        this.adress = adress;
        this.phones = phones;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phones='" + phones + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Firm firm = (Firm) o;

        if (adress != null ? !adress.equals(firm.adress) : firm.adress != null) return false;
        if (name != null ? !name.equals(firm.name) : firm.name != null) return false;
        if (phones != null ? !phones.equals(firm.phones) : firm.phones != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (phones != null ? phones.hashCode() : 0);
        return result;
    }
}