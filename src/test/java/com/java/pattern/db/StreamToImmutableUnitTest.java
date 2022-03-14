package com.java.pattern.db;


import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class StreamToImmutableUnitTest {

    @Test
    public void whenUsingCollectingToImmutableSet_thenSuccess() {
        List<String> givenList = Arrays.asList("a", "b", "c");
        List<String> result = givenList.stream()
                .collect(collectingAndThen(toSet(), ImmutableList::copyOf));

        System.out.println(result.getClass());
    }

    @Test
    public void whenUsingCollectingToUnmodifiableList_thenSuccess() {
        List<String> givenList = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<String> result = givenList.stream()
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        System.out.println(result.getClass());
    }

}
