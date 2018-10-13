package com.codecool.listFlattener;

import java.util.ArrayList;
import java.util.List;

public class ListFlattener {
    private List<Object> flattened = new ArrayList<>();

    private void flatten(List<Object> list) {
        for (Object item : list) {
            if (item instanceof ArrayList) {
                flatten((List)item);
            }
            else {
                this.flattened.add(item);
            }
        }
    }

    public List<Object> getFlattened(List<Object> list) {
        flatten(list);
        return this.flattened;
    }
}
