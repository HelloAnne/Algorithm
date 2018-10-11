package anne.algo.sortingBasic;

import anne.algo.SortTestHelper;

public class SelectionSort {

    // 算法类不允许产生任何实例
    private SelectionSort(){}

    public static <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex])<0){
                    minIndex = j;
                }
            }
            SortTestHelper.swap(arr, minIndex, i);

        }

    }



}
