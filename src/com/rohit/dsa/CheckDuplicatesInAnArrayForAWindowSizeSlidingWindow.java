package com.rohit.dsa;

import java.util.Set;
import java.util.HashSet;

public class CheckDuplicatesInAnArrayForAWindowSizeSlidingWindow {
    public static void main(String[] args) {
        //int [] nums = {1,2,3,2,3,4};  FALSE
        //int [] nums = {1,2,3,2,3,3};  TRUE
        //int [] nums = {1,2,3,2,4,3,4,67,7,7}; // TRUE
        int [] nums = {1,2,3,2,4,3,4,67,7}; // FALSE

        boolean containsDup = checkDuplicates(nums, 2);
        System.out.println("Contains duplicate - " + containsDup);
    }

    // Time Complexity - O(n)
    public static boolean checkDuplicates(int [] nums, int windowSize) {

        Set<Integer> numSet = new HashSet<>();

        int leftPointer = 0;
        int rightPointer = 0;

        for (; rightPointer < nums.length; rightPointer++) {

            // check and remove in set is about to add an element more than window size
            if (rightPointer - leftPointer + 1 > windowSize) {
                numSet.remove(nums[leftPointer]);
                leftPointer++;
            }

            // Check if the number already contains
            if (numSet.contains(nums[rightPointer])) {
                return true;
            }
            else
                numSet.add(nums[rightPointer]);

        }
        return false;
    }
}
