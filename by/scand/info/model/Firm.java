package by.scand.info.model;

/**
 * User: nasgor
 * Date: 10/3/12
 * Time: 11:57 AM
 */
public class Firm {
    private String name = "";
    private String phones = "";

    public Firm() {
    }

    public Firm(String name, String phones) {
        this.name = name;
        this.phones = phones;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public String getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "name='" + name + '\'' +
                ", phones='" + phones + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Firm firm = (Firm) o;

        if (name != null ? !name.equals(firm.name) : firm.name != null) return false;
        if (phones != null ? !phones.equals(firm.phones) : firm.phones != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phones != null ? phones.hashCode() : 0);
        return result;
    }
}