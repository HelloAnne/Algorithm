package anne.algo.heap;

import anne.algo.SortTestHelper;

public class  MaxHeap<T extends  Comparable> {
    private T[] arr;
    private int capacity;
    private int count;

    public MaxHeap(int capacity){
        this.capacity = capacity;
        this.arr = (T[])new Comparable[capacity+1];
    }

    public MaxHeap(T[] arr) {
        int n = arr.length;
        this.arr = (T[])new Comparable[arr.length+1];
        this.capacity = n;

        for (int i=1; i<=capacity; i++) {
            this.arr[i] = arr[i-1];
        }
        this.count = n;
        for (int i = n/2; i>=1; i--){
            shiftDown(i);
        }
    }
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(T t) {
        assert (count + 1 <= capacity);
        arr[count+1] = t;
        count++;
        shiftUp(count);
    }

    private void shiftUp(int index) {
        while(index/2 >0 && arr[index/2].compareTo(arr[index])<0) {
            SortTestHelper.swap(arr, index/2, index);
            index /= 2;
        }
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public T getMax() {
        assert (count>0);
        return arr[1];
    }

    /**
     * 推出堆顶元素
     * @return
     */
    public T extractMax() {
        assert (count>0);
        T ret = arr[1];
        SortTestHelper.swap(arr, 1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int index) {
        while(2*index <= count) {
            int newIndex = 2*index;
            if (newIndex+1<=count && arr[newIndex+1].compareTo(arr[newIndex]) > 0) {
                newIndex++;
            }
            if (arr[index].compareTo(arr[newIndex])>0){
                break;
            }
            SortTestHelper.swap(arr,index,newIndex);
            index = newIndex;
        }
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 10; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );
        System.out.println("heap size: " + maxHeap.size());
        for (int i = 0; i <= N; i++) {
            System.out.println(maxHeap.extractMax());
        }
    }
}
