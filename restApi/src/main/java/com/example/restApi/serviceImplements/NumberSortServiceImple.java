package com.example.restApi.serviceImplements;

import com.example.restApi.models.entity.NumberSort;
import com.example.restApi.service.IServiceNumberSort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NumberSortServiceImple implements IServiceNumberSort {

    public NumberSort numberSort = new NumberSort();

    @Override
    public List<Integer> getNumbersUnsorted() {
        return Arrays.asList(numberSort.getUnsorted());
    }

    @Override
    public List<Integer> getNumbersSorted() {
        List<Integer> numbersOrder = Arrays.asList(numberSort.getUnsorted());
        return sortNumber(numbersOrder);
    }

    @Override
    public List<Integer> getNumbersRepetToEnd(List<Integer> unsorted) {
        /*for(Integer number :  numbers){
            System.out.print(number + ", ");
        }*/

        //System.out.println("\n antes de deleteRepetElements");

        List<Integer> tempNumbers = deleteRepetElements(unsorted);

        /*for(Integer number :  tempNumbers){
            System.out.print(number + ", ");
        }*/

        /*System.out.println("\n antes de sortNumber");*/
        tempNumbers = sortNumber(tempNumbers);

        /*for(Integer number :  tempNumbers){
            System.out.print(number + ", ");
        }*/

        /*System.out.println("\n antes de getRepetElements");*/
        for(Integer numberRepet :  getRepetElements(unsorted)){
            tempNumbers.add(numberRepet);
        }

        /*System.out.println("\n antes de return");
        for(Integer number :  tempNumbers){
            System.out.print(number + ", ");
        }*/

        return tempNumbers;
    }

    @Override
    public List<Integer> getNumbersSortedAndUnsorted() {
        return new ArrayList<>();
    }

    private List<Integer> sortNumber(List<Integer> unsortNumbers ){
        List<Integer> sortNumbers = unsortNumbers;

        if ( sortNumbers.size() > 0 ){
            Boolean repetirCiclo = true;

            while(repetirCiclo){
                repetirCiclo = false;

                //{ 3,5,5,6,8,3,4,4,7,7,1,1,2 }

                for ( int j = 0; j < sortNumbers.size()-1; j++ ){
                    if (sortNumbers.get( j ) > sortNumbers.get(j+1)){
                        Integer izquierdo = sortNumbers.get(j);
                        sortNumbers.set(j, sortNumbers.get(j+1));
                        sortNumbers.set(j+1, izquierdo);
                        repetirCiclo = true;
                        continue;
                    }
                }
            }
        }
        return sortNumbers;
    }

    private List<Integer> getRepetElements(List<Integer> sortNumbers ){
        List<Integer> repetNumbers = new ArrayList<Integer>();
        List<Integer> duplicate =  new ArrayList<Integer>() ;

        for ( int j = 0; j < sortNumbers.size(); j++ ){
            duplicate.add(j, sortNumbers.get(j));
        }

        if ( duplicate.size() > 0 ){
            Boolean repetirCiclo = true;

            while(repetirCiclo){
                repetirCiclo = false;

                //{ 3,5,5,6,8,3,4,4,7,7,1,1,2 }
                for ( int j = 0; j < duplicate.size()-1; j++ ){
                    if (isRepet(duplicate,  duplicate.get(j))){
                        repetNumbers.add( duplicate.get(j) );
                        duplicate.remove( (j) );

                        repetirCiclo = true;
                        continue;
                    }
                }

            }
        }
        return repetNumbers;
    }

    private List<Integer> deleteRepetElements(List<Integer> sortNumbers ){
        List<Integer> duplicate =  new ArrayList<Integer>() ;

        for ( int j = 0; j < sortNumbers.size(); j++ ){
            duplicate.add(j, sortNumbers.get(j));
            //System.out.println(sortNumbers.get(j));
        }

        if ( duplicate.size() > 0 ){
            Boolean repetirCiclo = true;

            while(repetirCiclo){
                repetirCiclo = false;

                //{ 3,5,5,6,8,3,4,4,7,7,1,1,2 }
                for ( int j = 0; j < duplicate.size()-1; j++ ){
                    if (isRepet(duplicate,  duplicate.get(j))){
                        duplicate.remove( (j ) );
                        repetirCiclo = true;
                        continue;
                    }
                }

            }
        }
        return duplicate;
    }


    private boolean isRepet(List<Integer> unsortNumbers, Integer valorEvaluar){
        int contador = 0;
        for ( Integer numberSort: unsortNumbers){
            if (numberSort == valorEvaluar){
                //System.out.println(numberSort +" == "+ valorEvaluar);
                contador++;
            }
        }
        return (contador > 1 );
    }
}
