package scu.edu.cn.datastructure.rank;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 快速排序
 * @author: zzy
 * @create: 2021-03-08 16:14
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70,-1,20,999,64};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //以第一个数作为基数
    public static void quickSort(int[] arr,int left,int right){
        if (left < right){ //递归边界条件
            int l = left;
            int r = right;
            int baseVal = arr[left]; //基数的值
            while (l<r){
                while (l<r && arr[r] > baseVal){
                    //从右向左找到一个小于基数的数
                    r--;
                }
                if (l<r){
                    arr[l] = arr[r];
                    l++;
                }
                while (l<r && arr[l] < baseVal){
                    //从左向右找到一个大于基数的数
                    l++;
                }
                if (l<r){
                    arr[r] = arr[l];
                    r--;
                }
            }
            arr[l] = baseVal;
            quickSort(arr,left,l-1);
            quickSort(arr,l+1,right);
        }
    }
}
