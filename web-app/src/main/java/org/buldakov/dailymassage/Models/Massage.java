package org.buldakov.dailymassage.Models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Massage {

    private int id_massage;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String massage;
    int count = 0;

    public Massage(int id, String massage, int count) {
        this.id_massage = id;
        this.massage = massage;
        this.count = count;
    }

    public Massage() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id_massage;
    }

    public String getMessage() {
        return massage;
    }

    public void setId(int id) {
        this.id_massage = id;
    }

    public void setMessage(String massage) {
        this.massage = massage;
    }
}
