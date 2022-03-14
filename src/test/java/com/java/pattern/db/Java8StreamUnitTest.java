package com.java.pattern.db;

import com.java.pattern.db.model.Detail;
import org.junit.Before;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class Java8StreamUnitTest {

    private List<String> list;

    @Before
    public void init() {
        list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");
    }

    @org.junit.Test
    public void assertThat_Array_into_Stream_hasSize_equalTo() {

        String[] arr = new String[] { "a", "b", "c" };
        Stream<String> actual = Arrays.stream(arr);
        assertEquals(3, actual);

    }
    @org.junit.Test
    public void assertThat_StreamOf_hasSize_equalTo() {

        Stream<String> actual = Stream.of("a", "b", "c");
        assertEquals(3, actual);
    }

    @org.junit.Test
    public void assertThat_List_into_Steam_hasDistinct_size_equalTo() {

        long actual = list.stream().distinct().count();
        assertEquals(9, actual);
    }

    @org.junit.Test
    public void assertThat_List_into_Stream_hasConditional_equalTo() {
        Stream<String> actual = list.stream().filter(element -> element.isEmpty());
        assertEquals(2, actual.count());
    }

    @org.junit.Test
    public void assertThat_List_into_Stream_maps_Uri_into_get_hasSize_equaTo() {

        List<String> uris = new ArrayList<>();
        uris.add("C:\\My.txt");
        Stream<Path> actual = uris.stream().map(uri -> Paths.get(uri));
        assertEquals(1, actual.count());

    }

    @org.junit.Test
    public void assertThat_ListA_into_Stream_flatMaps_ListB_hasSize_equalTo() {

        List<Detail> listA = new ArrayList<>();
        listA.add(new Detail());
        listA.add(new Detail());

        Stream<String> actual = listA.stream().flatMap(listB -> listB.getParts().stream());
        assertEquals(actual.count(), 4);
    }

    @org.junit.Test
    public void assertThat_ListA_into_Stream_hasAnyMatch() {

        boolean actual = list.stream().anyMatch(element -> element.contains("h"));
        assertTrue(actual);

    }

    @org.junit.Test
    public void assertThat_ListA_into_Stream_does_not_contain_specified_item() {

        boolean actual = list.stream().allMatch(element -> element.contains("h"));
        assertFalse(actual);

    }

    @org.junit.Test
    public void assertThat_ListA_into_Stream_does_not_contain_nothing() {

        boolean actual = list.stream().noneMatch(element -> element.contains("h"));
        assertFalse(actual);

    }

    @org.junit.Test
    public void assertThat_List_into_Stream_reduce_Value_equalTo() {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        integers.add(1);
        Integer actual = integers.stream().reduce(23, (a, b) -> a + b);
        assertEquals(26,actual.intValue());

    }

    @org.junit.Test
    public void assertThat_List_into_Stream_maps_element_intoUpperCase_collect_toList_hasSize_EqualTo() {

        List<String> resultList = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
        assertTrue(resultList.contains(""));

    }

    @org.junit.Test
    public void assertThat_List_into_Stream_maps_element_intoUpperCase_collect_toList_hasConditional() {

        List<String> resultList = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
        assertTrue(resultList.contains(""));

    }

    @org.junit.Test
    public void checkParallelStream_whenDoWork() {

        list.parallelStream().forEach(element -> doWork(element));

    }

    private void doWork(String string) {
        assertTrue(true); // just imitate an amount of work
    }
}
