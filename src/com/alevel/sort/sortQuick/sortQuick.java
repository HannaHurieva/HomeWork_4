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

    // алгоритм быстрой сортировки
    public static int[] quickSort(int[] elements, int left, int right) {
        if (left < right) {
            int part = partition(elements, left, right);
            quickSort(elements, left, part - 1);
            quickSort(elements, part + 1, right);
        }
        return elements;
    }

    // разделяем последовательность на элементы большие и меньшие pivot
    // *выбор опорного элемента методом Ломуто
    public static int partition(int[] elements, int left, int right) {
        int pivot = elements[right];
        int i = left;
        // больший элемент сдвигаем вправо
        for (int j = left; j <= (right - 1); j++)
            if (elements[j] <= pivot) {
                swap(elements, i, j);
                i++;
            }
        // в результате - слева от элемента pivot меньшие его значения, справа - большие
        swap(elements, i, right);
        return i;
    }

    // меняем местами элементы array[i] и array[j]
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}