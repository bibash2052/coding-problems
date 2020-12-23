//Problem Statement
//You are given an array representing the heights of neighboring buildings on a city street, from east to west.
//The city assessor would like you to write an algorithm that returns how many of these buildings have a view of the setting sun,
//in order to properly value the street.
//For example, given the array [3, 7, 8, 3, 6, 1], you should return 3,
//since the top floors of the buildings with heights 8, 6, and 1 all have an unobstructed view to the west.

package com.coding.problems.UnobstructedView;

public class UnObstructedView {
    public static void main(String[] args) {
        int[] arr = {3,7,8,3,6,1};
        UnObstructedView unObstructedView = new UnObstructedView();
        System.out.println("Result: " + unObstructedView.getNumberOfBuildings(arr));
    }

    public int getNumberOfBuildings(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) {
                count++;
            } else if (arr[i] > arr[i+1]) {
                count++;
            }
        }
        return count;
    }
}
