package com.java.pattern;

import com.java.pattern.db.optional.Address;
import com.java.pattern.generics.Box;
import com.java.pattern.generics.Letter;
import com.java.pattern.generics.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {

        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);
        System.out.println(reduced.getAsInt());

        int reducedTwoParams =
                IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
        assertEquals(16, reducedTwoParams);



    }
}
