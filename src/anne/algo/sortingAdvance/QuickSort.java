package anne.algo.sortingAdvance;

import anne.algo.SortTestHelper;

public class QuickSort {
    private QuickSort(){}

    public static <T extends Comparable> void sort(T[] arr) {
        int n = arr.length-1;
        sort(arr, 0, n);
    }

    private static <T extends Comparable> void sort(T[] arr, int l, int r) {

        if (l >= r){
            return;
        }

        int index = partition(arr, l, r);
        sort(arr, l, index-1);
        sort(arr, index+1, r);

    }

    private static <T extends Comparable> int partition(T[] arr, int l, int r) {
        int mid = (int)(Math.random()*(r-l)) + l;
        SortTestHelper.swap(arr, l, mid);
        T seed = arr[l];
        int i = l;
        for (int j = l + 1; j <= r; j++){
            if (arr[j].compareTo(seed)<0) {
                SortTestHelper.swap(arr, ++i, j);
            }
        }
        SortTestHelper.swap(arr, l, i);
        return i;


    }


}
