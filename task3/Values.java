package org.example.task3;

public class Values {
    public Values(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

   private Integer id;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
