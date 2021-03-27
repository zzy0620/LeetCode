package scu.edu.cn.datastructure.rank;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 冒泡排序
 * @author: zzy
 * @create: 2021-03-08 11:52
 **/
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,20};
        int temp;
        boolean flag = false; //表示是否进行交换
        for (int i = 0; i < arr.length-1; i++) {//需要n-1趟排序
            for (int j = 0;j<arr.length-i-1;j++){
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
            System.out.println("第"+(i+1)+"趟排序后结果："+ Arrays.toString(arr));
        }
    }
}
