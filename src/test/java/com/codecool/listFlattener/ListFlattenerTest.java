package com.codecool.listFlattener;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ListFlattenerTest {
    private List<Object> multidimensionalListSetup() {
        List<Object> list = new ArrayList<>();
        List<Object> firstNested = new ArrayList<>();
        firstNested.add("age");
        firstNested.add(5);
        List<Object> fourthNested = new ArrayList<>();
        fourthNested.add(4);
        fourthNested.add(5);
        List<Object> thirdNested = new ArrayList<>();
        thirdNested.add(3);
        thirdNested.add(fourthNested);
        thirdNested.add("codecool");
        List<Object> secondNested = new ArrayList<>();
        secondNested.add(1);
        secondNested.add(thirdNested);
        secondNested.add(6);
        secondNested.add(7);

        list.add(1);
        list.add(3);
        list.add(firstNested);
        list.add("Krakow");
        list.add(secondNested);

        return list;
    }

    private List<Object> multidimensionalResultSetup() {
        List<Object> result = new ArrayList<>();
        result.add(1);
        result.add(3);
        result.add("age");
        result.add(5);
        result.add("Krakow");
        result.add(1);
        result.add(3);
        result.add(4);
        result.add(5);
        result.add("codecool");
        result.add(6);
        result.add(7);

        return result;
    }

    private List<Object> singledimensionalListSetup() {
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add("codecool");
        list.add(5);
        list.add(8);

        return list;
    }

    @Test
    void multidimensionalListTest() {
        ListFlattener flattener = new ListFlattener();
        List<Object> resultList = multidimensionalResultSetup();
        assertEquals(resultList, flattener.getFlattened(multidimensionalListSetup()));
    }

    @Test
    void singledimensionalListTest() {
        ListFlattener flattener = new ListFlattener();
        List<Object> resultList = singledimensionalListSetup();
        assertEquals(resultList, flattener.getFlattened(resultList));
    }
}
