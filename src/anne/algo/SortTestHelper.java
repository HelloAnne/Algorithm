package anne.algo;

import java.lang.reflect.Method;

public  class SortTestHelper {
    // 不允许产生任何实例
    private SortTestHelper(){}

    public static Object[] swap(Object[]arr, int i, int j){
        Object a = arr[j];
        arr[j] = arr[i];
        arr[i] = a;
        return arr;
    }

    // 生成n各元素的随机数组，范围为[rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){

        Integer[] arr = new Integer[n];
        for (int i = 0; i<n; i++){
            arr[i] = (int)(Math.random()*(rangeR-rangeL)) + rangeL;
        }
        return arr;
    }

    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes){

        Integer[] arr = new Integer[n];
        for (int i = 0; i<n; i++){
            arr[i] = i;
        }
        for (int i = 0; i < swapTimes; i++){
            int posX = (int)(Math.random()*n);
            int posY = (int)(Math.random()*n);
            swap(arr, posX, posY);
        }
        return arr;
    }

    public static Integer[] generateOrderedArray(int n){

        Integer[] arr = new Integer[n];
        for (int i = 0; i<n; i++){
            arr[i] = i;
        }
        return arr;
    }

    // 打印数组
    public static void printSort(Object arr[]){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }

    // 判断数组是否有序
    public static Boolean isSorted(Comparable[] arr){
        for (int i=0; i<arr.length-1; i++){
            if (arr[i].compareTo(arr[i+1])>0){
                return false;
            }
        }
        return true;
    }

    // 测试sortNameClass对应的排序算法排序arr数组的运算时间和正确性
    public static void testSort(String sortClassName, Comparable[] arr){
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            //            printSort(arr);
            System.out.print(sortClass.getSimpleName() + ": " + (endTime - startTime) + "ms");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void printArr(Comparable[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

}
