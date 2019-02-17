package com.alevel.sort.sortIn;

import java.util.Arrays;

public class SortInsertion {
    public static void main(String[] args) {
        int[] array = {5, 7, 1, 6, 10, 3, 2, 9, 8, 4};
        System.out.println("Data array = " + Arrays.toString(array));
        System.out.println("Sort array /InsertionSort method/= " + Arrays.toString(insertionSort(array)));
    }

    private static int[] insertionSort(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            int key = elements[i];
            int j = i - 1;
            while (j >= 0 && key < elements[j]) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
        return elements;
    }
}