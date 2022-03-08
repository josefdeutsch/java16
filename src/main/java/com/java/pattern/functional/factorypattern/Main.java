package com.java.pattern.functional.factorypattern;

import com.java.pattern.functional.factorypattern.model.Person;

public class Main {

    public static void main(String[] args) {

        Container<Person> it =
                new Container<>(Person::new);

    }
}
