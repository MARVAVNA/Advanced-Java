public class Human {
    private String name;
    private int year;

    public Human() {}

    public Human(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
