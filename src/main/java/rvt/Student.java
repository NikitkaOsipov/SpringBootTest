package rvt;

public class Student {
    public String name;
    public String surname;
    public String email;
    public String group;


    public Student(String name, String surname, String email, String group) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String[] toArray() {
        return new String[] {
            this.name,
            this.surname,
            this.email,
            this.group
        };
    } 
}
