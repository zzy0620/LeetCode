package scu.edu.cn.datastructure.rank;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 希尔排序
 * @author: zzy
 * @create: 2021-03-08 14:14
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        byMove(arr);
    }

    public static void bySwap(int[] arr){
        int count = 0;
        int temp = 0;
        for (int i = arr.length/2; i > 0; i=i/2) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j-i; k >= 0 ; k-=i) {
                    if (arr[k] > arr[k+i]){
                        temp = arr[k];
                        arr[k] = arr[k+i];
                        arr[k+i]=temp;
                    }
                }
            }
            System.out.println("第"+(++count)+"趟排序后结果："+ Arrays.toString(arr));
        }
    }

    public static void byMove(int[] arr){
        int count = 0;
        for (int gap = arr.length/2; gap > 0; gap=gap/2) {
            for (int i = gap;i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                while (j -gap >=0 && temp <arr[j-gap]){
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            System.out.println("第"+(++count)+"趟排序后结果："+ Arrays.toString(arr));
        }
    }
}
