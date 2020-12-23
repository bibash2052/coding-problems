//Pascal's triangle is a triangular array of integers constructed with the following formula:
//
//        The first row consists of the number 1.
//        For each subsequent row, each element is the sum of the numbers directly above it, on either side.
//        For example, here are the first few rows:
//             1
//            1 1
//           1 2 1
//          1 3 3 1
//         1 4 6 4 1
package com.company.PascalTriangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row :");
        int row = scanner.nextInt();
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<Integer> result = pascalTriangle.getKthRowOfPascalTriangle(row);
        System.out.println("Row of pascal triangle is: " + result);
    }

    private List<Integer> getKthRowOfPascalTriangle(int k) {
        List<Integer> result = new ArrayList<>();
        if (k == 0) return result;

        int[] arr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0) {
                    arr[i] = 1;
                    if (result.isEmpty()) {
                        result.add(arr[i]);
                    }
                } else {
                    arr[i] = arr[i] * (i - j + 1) / j;
                    if (i == k - 1) {
                        result.add(arr[i]);
                    }
                }
            }
        }
        return result;
    }
}
