package com.java.pattern.db.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public final class Streams {

    public static void main(String[] args) {

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        stream = Stream.of("a", "b", "c");

        Stream<String> streamEmpty = Stream.empty();
        //We often use the empty() method upon creation to avoid returning null for streams with no element:

    }
}
