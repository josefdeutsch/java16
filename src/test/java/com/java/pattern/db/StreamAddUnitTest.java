package com.java.pattern.db;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamAddUnitTest {

    @Test
    public void assertThat_Stream_concats_Stream_into_List_hasSize_equalTo() {

        Stream<String> stream = Stream.of("a", "b", "c", "d", "e");
        Stream<String> another = Stream.concat(stream, Stream.of("A"));
        List<String> actual = another.collect(Collectors.toList());

        assertEquals("A", actual.get(actual.size() - 1));
    }

    @Test
    public void assertThat_Stream_concats_Stream_findFirst_hasValue_equalTo() {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> actual = Stream.concat(Stream.of(99), stream);

        assertEquals( 99, actual.findFirst().get());
    }

    @Test
    public void assertThat_Stream_into_Stream_hasValue_equalTo() {

        Stream<Double> stream = Stream.of(1.1, 2.2, 3.3);
        Stream<Double> another = insertIntStream(stream, 9.9, 3);
        List<Double> actual = another.collect(Collectors.toList());

        assertEquals( 9.9d, actual.get(3));
    }

    private <T> Stream<T> insertIntStream(Stream<T> stream, T elem, int index) {
        List<T> result = stream.collect(Collectors.toList());
        result.add(index, elem);
        return result.stream();
    }
}
