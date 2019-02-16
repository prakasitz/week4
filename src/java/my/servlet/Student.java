package my.servlet;

public class Student {
    private String id;
    private String name;
    private String lastname;

    public Student(String id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
    
}
