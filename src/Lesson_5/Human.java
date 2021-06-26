package Lesson_5;

import java.util.Date;

public class Human {
    private String name;
    private Date birthDate;

    public Human(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return new Date(birthDate.getTime());
    }
}
