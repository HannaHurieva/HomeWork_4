package com.alevel.sort.sortQuick;

import java.util.Arrays;

public class sortQuick {
    public static void main(String[] args) {
        int[] array = {5, 7, 1, 6, 10, 3, 2, 9, 8, 4};
        System.out.println("Data array = " + Arrays.toString(array));
        int n = array.length;
        int[] sortArray = quickSort(array, 0, n - 1);
        System.out.println("Sort array /QuickSort method Lomuto split/= " + Arrays.toString(sortArray));
    }

    // quick sort algorithm
    private static int[] quickSort(int[] elements, int left, int right) {
        if (left < right) {
            int part = partition(elements, left, right);
            quickSort(elements, left, part - 1);
            quickSort(elements, part + 1, right);
        }
        return elements;
    }

    // we divide the sequence into elements larger and smaller pivot
    // *selection of the support element by the Lomuto method
    private static int partition(int[] elements, int left, int right) {
        int pivot = elements[right];
        int i = left;
        // the larger element is shifted to the right
        for (int j = left; j <= (right - 1); j++)
            if (elements[j] <= pivot) {
                swap(elements, i, j);
                i++;
            }
        // as a result, smaller values to the left of the pivot element, large values to the right
        swap(elements, i, right);
        return i;
    }

    // swap the elements of array [i] and array [j]
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}