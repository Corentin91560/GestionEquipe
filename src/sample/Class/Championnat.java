package sample.Class;

public class Championnat {

    String division;
    int id;

    public Championnat(String division, int id) {
        this.division = division;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Championnat{" +
                "division='" + division + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

}
