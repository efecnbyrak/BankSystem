package model;

public class User {
    private String name;
    private String surname;
    private Long SSN; //Social Security Number
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", SSN=" + SSN +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getSSN() {
        return SSN;
    }

    public void setSSN(Long SSN) {
        this.SSN = SSN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String surname, Long SSN, String password) {
        this.name = name;
        this.surname = surname;
        this.SSN = SSN;
        this.password = password;
    }

    public User() {
    }

}
