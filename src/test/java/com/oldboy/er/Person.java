package com.oldboy.er;


import org.junit.Test;

import java.util.Objects;

public class Person {

    private int age = 1;
    private int height = 1;
    private int weight = 1;
    private int blood = 1;

    public Person() {
    }

    public Person(int age, int height, int weight, int blood) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.blood = blood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    @Override
    public boolean equals(Object o) {
        if(this.hashCode() == o.hashCode()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {

        int i = (age << 24) | (height << 16) | (weight << 8) | blood;

        return i;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", blood=" + blood +
                '}';
    }
}

class Test2 {
    public static void main(String[] args) {
        Person p1 = new Person(21,175,60,1);
        Person p2 = new Person(20,175,60,1);
        System.out.println(p1.equals(p2));

    }
}