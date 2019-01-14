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
        if (low < high) { // хотя бы два элемента
            int mid = (low + high) / 2;
            mergeSort(elements, low, mid); // рекурсия левой части массива
            mergeSort(elements, mid + 1, high); // рекурсия правой части массива
            merge(elements, low, mid, high); // соединяем отсортированные половинки массива
        }
    }

    // метод сортировки слиянием
    private static void merge(int[] inputArray, int low, int mid, int high) {
        // длина нового массива
        int n = high-low+1;
        int[] arraySort = new int[n];
        // индексы левой части, правой части, объединенного массива
        int i = low, j = mid + 1;
        int k = 0;

        while (i <= mid || j <= high) {
            if (i > mid) {
                // закончилась левая часть, записываем правую часть в объединенный массив
                arraySort[k] = inputArray[j];
                j++;
                k++;
            }
            else if (j > high) {
                // закончилась правая часть, записываем левую часть в объединенный массив
                arraySort[k] = inputArray[i];
                i++;
                k++;
            }
            // определяем меньший элемент - сортировка по возрастанию
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