package by.expertsofttesttask.models;

public class Person {
    private String name;
    private String surname;
    private String login;
    private String email;
    private String phoneNumber;

    public Person() {
    }

    public Person(String name, String surname, String login,
                  String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Person))return false;
        Person otherPerson = (Person)other;

        if ((this.name == null) ? (otherPerson.name != null) : !this.name.equals(otherPerson.name)) {
            return false;
        }
        if ((this.surname == null) ? (otherPerson.surname != null) : !this.surname.equals(otherPerson.surname)) {
            return false;
        }
        if ((this.login == null) ? (otherPerson.login != null) : !this.login.equals(otherPerson.login)) {
            return false;
        }
        if ((this.email == null) ? (otherPerson.email != null) : !this.email.equals(otherPerson.email)) {
            return false;
        }
        if ((this.phoneNumber == null) ? (otherPerson.phoneNumber != null) : !this.phoneNumber.equals(otherPerson.phoneNumber)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + (this.surname != null ? this.surname.hashCode() : 0);
        hash = 53 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 53 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 53 * hash + (this.phoneNumber != null ? this.phoneNumber.hashCode() : 0);
        return hash;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
