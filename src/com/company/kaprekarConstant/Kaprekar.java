//The number 6174 is known as Kaprekar's constant, after the mathematician who discovered an associated property:
// for all four-digit numbers with at least two distinct digits,
// repeatedly applying a simple procedure eventually results in this value.
// The procedure is as follows:
//
//        For a given input x, create two new numbers that consist of the digits in x in ascending and descending order.
//        Subtract the smaller number from the larger number.
//        For example, this algorithm terminates in three steps when starting from 1234:
//
//        4321 - 1234 = 3087
//        8730 - 0378 = 8352
//        8532 - 2358 = 6174
//        Write a function that returns how many steps this will take for a given input N.
//This problem has been solved using recursion.
package com.company.kaprekarConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Kaprekar {
    public static void main(String[] args) {
        Kaprekar kaprekar = new Kaprekar();
        System.out.println("The number of steps taken for input is: " + kaprekar.getNumberOfStepsTakenForNInput(9976, 0));
    }

    public int getNumberOfStepsTakenForNInput(int n, int counter) {
        List<Integer> integerList = separateDigitsFromNumber(n);
        int firstNumber = getNumberInDescendingOrder(integerList);
        int secondNumber = getNumberInAscendingOrder(integerList);

        if (uniqueDigitCount(n) <= 1) return 0;
        if (n == 6174) return counter;

        n = firstNumber - secondNumber;
        counter++;
        return getNumberOfStepsTakenForNInput(n, counter);
    }

    private List<Integer> separateDigitsFromNumber(int n) {
        List<Integer> integerList = new ArrayList<>();
        while (n > 0) {
            integerList.add(n % 10);
            n /= 10;
        }
        return integerList;
    }

    private int getNumberInAscendingOrder(List<Integer> separatedDigits) {
        Collections.sort(separatedDigits);
        return concatDigits(separatedDigits);
    }

    private int getNumberInDescendingOrder(List<Integer> integerList) {
        integerList.sort(Collections.reverseOrder());
        return concatDigits(integerList);
    }

    private int concatDigits(List<Integer> separatedDigits) {
        StringBuilder num = new StringBuilder();
        for (Integer intValue : separatedDigits) {
            num.append(intValue);
        }
        return Integer.parseInt(String.valueOf(num));
    }

    private int uniqueDigitCount(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (n > 0) {
            hashSet.add(n % 10);
            n /= 10;
        }
        return hashSet.size();
    }
}

