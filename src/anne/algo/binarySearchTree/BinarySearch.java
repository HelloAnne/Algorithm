package anne.algo.binarySearchTree;

import anne.algo.SortTestHelper;

public class BinarySearch {

    private BinarySearch(){}

    /**
     * 二分查找法,在有序数组arr中,查找target
     * 如果找到target,返回相应的索引index
     * 如果没有找到target,返回-1
     * @return
     */
    public static int find(Comparable[] arr, Comparable target){
        if (arr == null) {
            return -1;
        }
        // 在[l, r]区间查找target
        int l = 0;
        int r = arr.length-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid].equals(target)) {
                return mid;
            }
            if (arr[mid].compareTo(target) > 0) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 100000;
        int target = 10;
        Integer[] arr = SortTestHelper.generateOrderedArray(n);
        System.out.println(find(arr, target));

    }
}
