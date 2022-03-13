package com.java.pattern.db;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamsConversionsUnitTest {

    @Test
    public void intStreamToArray() {
        int[] actual = IntStream.iterate(0, i -> i + 2)
                .limit(50)
                .toArray();

        int[] expected = new int[50];

        assertEquals(actual.length,expected.length);
    }

    @Test
    public void intStreamToArray2() {
        int[] actual = IntStream.iterate(0, i -> i + 2)
                .limit(50)
                .toArray();

        assertEquals(actual[2],4);
    }

    @Test
    public void intStreamToList() {
        List<Integer> actual = IntStream.range(0, 50)
                .boxed()
                .collect(Collectors.toList());

        assertEquals(actual.stream().count(),50);
    }

    @Test
    public void intStreamToLis2() {
        List<Integer> actual = IntStream.range(0, 50)
                .boxed()
                .collect(Collectors.toList());

        assertEquals(actual.get(2),2);
    }

    @Test
    public void intStreamToString() {
        String actual = IntStream.of(0, 1, 2)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));

        assertEquals(actual,"[0, 1, 2]");
    }
}
