package com.example.vitbatch2;


public class Employee {
    String name;
    int age;
    String address;

    //ctrl+shift+A -- shortcut for all shortcuts


    public Employee(String name, int age, String address) {
        //    val count: Int = 2
        int count = 2;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

