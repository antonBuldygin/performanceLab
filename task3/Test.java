package org.example.task3;



import java.util.List;

public class Test {
    private Integer id;
    private String title;
    private String value;

    private List<Test> values;

    public Test(Integer id, String title, String value, List<Test> values) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.values = values;
    }

    public Test(Integer id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public Test() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Test> getValues() {
        return values;
    }

    public void setValues(List<Test> values) {
        this.values = values;
    }
}
