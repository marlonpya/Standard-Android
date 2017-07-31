package pya.marlon.com.friends.data.db.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by marlonpya on 23/07/17.
 */

public class UserSql extends RealmObject {
    public static final String primaryKey = "id";

    @PrimaryKey
    private int id;
    private String name;
    private String lastName;
    private int year;

    public UserSql() { }

    public UserSql(int id, String name, String lastName, int year) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "UserSql{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + year +
                '}';
    }
}
