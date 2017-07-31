package pya.marlon.com.friends.domain.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by marlonpya on 23/07/17.
 */

public class UserBean implements Serializable{
    @SerializedName("us_id")
    private int id;
    @SerializedName("us_name")
    private String name;
    @SerializedName("us_last_name")
    private String lastName;
    @SerializedName("us_year")
    private int year;

    public UserBean(){ }

    public UserBean(int id, String name, String lastName, int year) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYear() {
        return year;
    }
}
