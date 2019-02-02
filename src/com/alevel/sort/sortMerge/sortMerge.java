package com.alevel.sort.sortMerge;

import java.util.Arrays;

public class sortMerge {
    public static void main(String[] args) {
        int[] array = {5, 7, 1, 6, 10, 3, 2, 9, 8, 4};
        System.out.println("Data array = " + Arrays.toString(array));
        int n = array.length;
        mergeSort(array,0,n-1);
        System.out.print("Sort array /MergeSort method/= [");
        for (int k = 0; k < n-1; k++) {
            System.out.print(array[k] + ", ");
        }
        System.out.print(array[n-1]+ "]");
    }
    public static void mergeSort(int[] elements, int low, int high) {
        if (low < high) { // at least two elements
            int mid = (low + high) / 2;
            mergeSort(elements, low, mid); // recursion of the left part of the array
            mergeSort(elements, mid + 1, high); // recursion of the right side of the array
            merge(elements, low, mid, high); // connect the sorted halves of the array
        }
    }

    // merge sort method
    private static void merge(int[] inputArray, int low, int mid, int high) {
        // new array length
        int n = high-low+1;
        int[] arraySort = new int[n];
        // indices of the left part, the right part, the combined array
        int i = low, j = mid + 1;
        int k = 0;

        while (i <= mid || j <= high) {
            if (i > mid) {
                // the left side is over, we write the right side into the combined array
                arraySort[k] = inputArray[j];
                j++;
                k++;
            }
            else if (j > high) {
                // the right side is over, we write the left side in the combined array
                arraySort[k] = inputArray[i];
                i++;
                k++;
            }
            // we define a smaller element - sorting ascending
            else if (inputArray[i] < inputArray[j]) {
                arraySort[k] = inputArray[i];
                i++;
                k++;
            }
            else {
                arraySort[k] = inputArray[j];
                j++;
                k++;
            }
        }
        for (i = 0; i < n; i++)
            inputArray[low + i] = arraySort[i];
    }
}