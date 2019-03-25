package com.anne.algo.sortingBasic;

public class InsertionSort {

    private InsertionSort(){}

    public static <T extends  Comparable<T>> void sort(T[] arr){
        for (int i = 1; i < arr.length; i ++){
            T e = arr[i];
            int j = i;
            for (; j > 0 && e.compareTo(arr[j-1])<0; j --){
                arr[j] = arr[j-1];
            }
            arr[j] = e;

        }

    }

    // 将数组arr中的第j个值移动到第i个值处，第i个值到第j-1个值依次后移
    private static <T extends Comparable<T>> void insertElement(T[] arr, int i, int j) {
        T a = arr[j];
        for (int k = j; k>i; k--){
            arr[k] = arr[k-1];
        }
        arr[i] = a;
    }

}
