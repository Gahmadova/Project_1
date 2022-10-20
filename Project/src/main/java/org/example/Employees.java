package org.example;

import java.util.Objects;

public class Employees {
   private String name;
    private String lastName;
    private String address;
    private String usewrName;
    private String passWord;
    private int id;
   private boolean isAdmin;

    public Employees(int id) {
        this.id = id;
    }

    public static Integer getID() {
        return getID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return id == employees.id && isAdmin == employees.isAdmin && Objects.equals(name, employees.name) && Objects.equals(lastName, employees.lastName) && Objects.equals(address, employees.address) && Objects.equals(usewrName, employees.usewrName) && Objects.equals(passWord, employees.passWord);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", usewrName='" + usewrName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", id=" + id +
                ", isAdmin=" + isAdmin +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, address, usewrName, passWord, id, isAdmin);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsewrName() {
        return usewrName;
    }

    public void setUsewrName(String usewrName) {
        this.usewrName = usewrName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
