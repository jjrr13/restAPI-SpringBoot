package com.example.restApi.controllers;

import com.example.restApi.models.entity.NumberSort;
import com.example.restApi.service.IServiceNumberSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/numbers")
public class NumberSortRestController {

    @Autowired
    public IServiceNumberSort iServiceNumberSort;

    @GetMapping(value = "/unsort")
    public ResponseEntity<List<Integer>> unsort(){
        return ResponseEntity.ok( iServiceNumberSort.getNumbersUnsorted() );
    }

    @GetMapping(value = "/sort")
    public ResponseEntity<List<Integer>> sort(){
        return ResponseEntity.ok( iServiceNumberSort.getNumbersSorted() );
    }

    @GetMapping(value = "/sortAndRepetToEnd")
    public ResponseEntity<NumberSort> sortAndRepetToEnd(){
        NumberSort numberSort = new NumberSort();
        numberSort.setSorted( iServiceNumberSort.getNumbersRepetToEnd( iServiceNumberSort.getNumbersUnsorted() ));
        return ResponseEntity.ok( numberSort );
    }
}
