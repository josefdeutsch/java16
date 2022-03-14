package com.java.pattern.db;

import com.java.pattern.db.model.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamOperateAndRemoveUnitTest {

    private static List<Item> itemList;

    @BeforeAll
    public static void setup() {

        itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemList.add(new Item(i));
        }
    }

    @Test
    public void givenAListOf10Items_whenFilteredForQualifiedItems_thenFilteredListContains5Items() {

        final List<Item> filteredList = itemList.stream()
                .filter(item -> item.isQualified())
                .collect(Collectors.toList());

        assertEquals(5, filteredList.size());
    }

    @Test
    public void givenAListOf10Items_whenOperateAndRemoveQualifiedItemsUsingRemoveIf_thenListContains5Items() {

        final Predicate<Item> isQualified = item -> item.isQualified();
        itemList.stream().filter(isQualified).forEach(item -> item.operate());
        itemList.removeIf(isQualified);

        assertEquals(5, itemList.size());
    }

    @Test
    public void givenAListOf10Items_whenOperateAndRemoveQualifiedItemsUsingRemoveAll_thenListContains5Items() {

        final List<Item> operatedList = new ArrayList<>();
        itemList.stream().filter(item -> item.isQualified()).forEach(item -> {
            item.operate();
            operatedList.add(item);
        });
        itemList.removeAll(operatedList);

        assertEquals(5, itemList.size());
    }



}
