package scu.edu.cn.datastructure.search;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 斐波那契查找
 * @author: zzy
 * @create: 2021-03-09 14:50
 **/
public class FibonacciSearch {
    private static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        int index = fibSearch(arr,10);
        System.out.println(index);
    }

    //非递归方式获取斐波那契数列
    public static int[] fib(){
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    //非递归方式
    public static int fibSearch(int[] arr,int target){
        int low = 0;
        int high = arr.length - 1;
        int k=0; //表示斐波那契分割数值的下标
        int mid;
        int[] f = fib();
        //表示斐波那契分割数值的下标
        while (high > f[k]-1){
            k++;
        }
        //由于f[k]值肯可能大于arr长度，因此需要构造一个新数组
        int[] temp = Arrays.copyOf(arr,f[k]);
        //实际上，需要使用arr数组最后的数填充temp
        for (int i = high+1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high){
            mid = low + f[k-1]-1;
            if (target < temp[mid]){
                //在左边查找
                high = mid-1;
                //全部元素 = 左边 + 右边
                //继续拆分 f[k-1] = f[k-2] + f[k-3]
                //在f[k-1]继续查找，k-- 即下次循环 mid = f[k-1-1]-1
                k--;
            }else if (target > temp[mid]){
                low = mid+1;
                //全部元素 = 左边 + 右边
                //继续拆分 f[k-2] = f[k-3] + f[k-4]
                //f[k-2]继续查找 ,即 k=k-2即 mid = f[k-1-2]-1
                k -= 2;
            }else {
                return Math.min(mid, high);
            }
        }
        return -1;
    }
}
