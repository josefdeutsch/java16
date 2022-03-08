package com.java.pattern;

import com.java.pattern.generics.Box;
import com.java.pattern.generics.Letter;
import com.java.pattern.generics.Phone;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {
        Box<Phone> box = new Box<>();
        box.set(new Phone("Samsung"));
        System.out.println(box.get());

        Box<Letter> box2 = new Box<>();
        box2.set(new Letter("Amigoscode"));
        System.out.println(box2.get());
    }
}
