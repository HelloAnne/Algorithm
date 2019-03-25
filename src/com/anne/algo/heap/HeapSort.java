package com.anne.algo.heap;


import com.anne.algo.SortTestHelper;

import java.util.Arrays;

public class HeapSort {
    private HeapSort() {}

    /**
     *  对整个arr数组使用HeapSort1排序
     *  HeapSort1, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
     *  无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
     *  整个堆排序的整体时间复杂度为O(nlogn)
     */
    public static void sort1(Comparable[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = 1; i <= arr.length; i++) {
            arr[i-1] = maxHeap.extractMax();
        }
    }
    public static void sort(Comparable[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr);
        for (int i = 1; i <= arr.length; i++) {
            arr[i-1] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int m = 100; // 取值范围
        int n = 10; // 元素个数
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, m);

        System.out.println("---------HeapSort1--------");
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        sort1(arr1);
        SortTestHelper.printArr(arr1);

        System.out.println("---------HeapSort2--------");
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        sort(arr2);
        SortTestHelper.printArr(arr2);
    }
}
