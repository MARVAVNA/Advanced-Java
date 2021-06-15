import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private transient String password;
    private int year;
    private boolean isAdmin;
    private Car car;

    public User(String login, String password, int year, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.year = year;
        this.isAdmin = isAdmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", year=" + year +
                ", isAdmin=" + isAdmin +
                ", car=" + car +
                '}';
    }
}
