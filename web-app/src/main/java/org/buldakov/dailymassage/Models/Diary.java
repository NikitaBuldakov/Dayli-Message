package org.buldakov.dailymassage.Models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

public class Diary {

    private int id;

    @NotEmpty(message = "Name should not be empty")
    private Date date;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String massage;



    public Diary(int id,Date date, String massage) {
        this.id = id;
        this.date = date;
        this.massage = massage;
    }

    public Diary() {

    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
