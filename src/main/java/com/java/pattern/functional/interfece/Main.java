package com.java.pattern.functional.interfece;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Util util = new Util();

        Function<Integer, Integer> fn =
                parameter -> parameter + 1;

        Integer result = util.add(2, fn);
        System.out.println(result);

        Function<Integer, String> intToString = Object::toString;
        System.out.println(intToString.apply(5));
    }
}
