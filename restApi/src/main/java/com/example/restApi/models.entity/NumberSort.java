package com.example.restApi.models.entity;

import java.util.Arrays;
import java.util.List;

public class NumberSort {

    private Integer unsorted[] = { 3,5,5,6,8,3,4,4,7,7,1,1,2 };
    private List<Integer> sorted;

    public NumberSort() {
    }

    public NumberSort(Integer unsorted[] ) {
        this.unsorted = unsorted;
    }

    public Integer[] getUnsorted() {
        return unsorted;
    }

    public void setUnsorted(Integer[] unsorted) {
        this.unsorted = unsorted;
    }

    public List<Integer> getSorted() {
        return sorted;
    }

    public void setSorted(List<Integer> sorted) {
        this.sorted = sorted;
    }

    @Override
    public String toString() {
        return "NumberSort{" +
                "unsorted=" + Arrays.toString(unsorted) +
                ", sorted=" + sorted +
                '}';
    }
}
