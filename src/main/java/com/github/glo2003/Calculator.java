package com.github.glo2003;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.length() == 1){
           return Integer.parseInt(numbers);
        }
        String[] split = numbers.split(",");
        List<Integer> listOfNumbers = new ArrayList<>();
        for (String element : split) {
            Integer elementInInteger = 0;
            element = element.trim();
            try {
                if (element.length() == 0){
                    elementInInteger = 0;
                }else {
                    elementInInteger = Integer.parseInt(element);
                }
            }
            catch(NumberFormatException e) {
                throw new InvalidNumberFormatException();
            }
            listOfNumbers.add(Integer.parseInt(element));
        }
        return listOfNumbers.stream().reduce(0, Integer::sum);


    }
}
