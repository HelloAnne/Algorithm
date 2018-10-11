package anne.algo;

import java.util.Arrays;

public class Test {

    public static void main(String[] args){
        int n = 100000;
        System.out.println("Sort Test: nearly ordered array:");
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(n,10);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("anne.algo.sortingBasic.InsertionSort", arr1);
        SortTestHelper.testSort("anne.algo.sortingBasic.SelectionSort", arr2);
        SortTestHelper.testSort("anne.algo.sortingAdvance.QuickSort", arr3);
        SortTestHelper.testSort("anne.algo.sortingAdvance.MergeSort", arr4);
        SortTestHelper.testSort("anne.algo.heap.HeapSort", arr5);

        System.out.println("Sort Test: random array:");
        arr1 = SortTestHelper.generateRandomArray(n, 0 , n);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("anne.algo.sortingBasic.InsertionSort", arr1);
        SortTestHelper.testSort("anne.algo.sortingBasic.SelectionSort", arr2);
        SortTestHelper.testSort("anne.algo.sortingAdvance.QuickSort", arr3);
        SortTestHelper.testSort("anne.algo.sortingAdvance.MergeSort", arr4);
        SortTestHelper.testSort("anne.algo.heap.HeapSort", arr5);

    }

}
