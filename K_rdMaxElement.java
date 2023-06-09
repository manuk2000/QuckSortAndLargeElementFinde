package org.example;

import java.util.Arrays;
import java.util.Random;

public class K_thLargestElementFind {
    static Random rand = new Random();

    public static void main(String[] args) {
        int[] arr = initArray(8);
        System.out.println(findElement(arr, 0, arr.length, 2));
    }

    static int findElement(int[] arr, int low, int high, int k) {
        high--;
        if (low == high) {
            return arr[low];
        }
        if (high - low < 1) {
            return -1;
        }
        int p = pivot(arr, low, high);
        if (p == k - 1) {
            return arr[p];
        } else if (k - 1 > p) {
            return findElement(arr, p + 1, high + 1, k);
        }
        return findElement(arr, low, p, k);
    }

    static int pivot(int[] arr, int low, int high) {
        int p = Math.abs(rand.nextInt(low, high));
        swap(arr, p, high);

        int i = low;
        int j = high - 1;
        while (j > i) {
            if (arr[i] > arr[high]) {
                if (arr[j] <= arr[high]) {
                    swap(arr, j, i);
                    i++;
                }
                j--;
            } else {
                i++;
            }
        }
        if (arr[i] <= arr[high]) {
            i++;
        }
        swap(arr, i, high);
        return i;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static int[] initArray(int size) {
        int[] arr = new int[size];
        for (int i = 0, len = arr.length; i < len; i++)
            arr[i] = Math.abs(rand.nextInt()) % 10;
        return arr;
    }
}
