package com.alevel.sort.sortQuickHoar;

import java.util.Arrays;

public class sortHoar {
    public static void main(String[] args) {
        int[] array = {5, 7, 1, 6, 10, 3, 2, 9, 8, 4};
        System.out.println("Data array = " + Arrays.toString(array));
        int n = array.length;
        int[] sortArray = quickSort(array, 0, n - 1);
        System.out.println("Sort array /QuickSort method Hoare split/= " + Arrays.toString(sortArray));
    }

    // quick sort algorithm
    public static int[] quickSort(int[] elements, int left, int right) {
        if (left < right) {
            int part = partition(elements, left, right);
            quickSort(elements, left, part - 1);
            quickSort(elements, part + 1, right);
        }
        return elements;
    }

    // we divide the sequence into elements larger and smaller pivot
    // * selection of the support element by the Choar method
    private static int partition(int[] elements, int left, int right) {
        int pivot = elements[left];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do {
                i++;
            } while (elements[i] < pivot);
            do {
                j--;
            } while (elements[j] > pivot);
            if (i >= j) return j;
            swap(elements, i, j);
        }
    }

    // swap the elements of array [i] and array [j]
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}