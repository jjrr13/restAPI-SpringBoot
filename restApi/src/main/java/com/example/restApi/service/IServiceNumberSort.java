package com.example.restApi.service;


import java.util.List;

public interface IServiceNumberSort {
    public List<Integer> getNumbersUnsorted();

    public List<Integer> getNumbersSorted();

    public List<Integer> getNumbersRepetToEnd(List<Integer> numbers);

    public List<Integer> getNumbersSortedAndUnsorted();

}
