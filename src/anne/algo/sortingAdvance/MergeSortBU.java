package anne.algo.sortingAdvance;

public class MergeSortBU {

    private MergeSortBU(){}

    public static <T extends Comparable> void sort(T[] arr){
        int n = arr.length;
        for (int size = 1; size <= n; size += size){
            for (int i = 0; i+size<n; i += 2*size) {
                int l = i;
                int r = l + 2*size-1 >= n ? n-1 : l + 2*size-1;
                int mid = l + (r-l)/2;
                MergeSort.merge(arr, l, mid, r);
            }
        }
    }
}
