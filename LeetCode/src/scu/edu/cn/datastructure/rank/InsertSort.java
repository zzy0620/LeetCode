package scu.edu.cn.datastructure.rank;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 插入排序
 * @author: zzy
 * @create: 2021-03-08 13:38
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,20};
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i-1;
            int insertValue = arr[i];
            while (insertIndex>=0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex != i-1){
                arr[insertIndex + 1] = insertValue;
            }
            System.out.println("第"+i+"趟排序后结果："+ Arrays.toString(arr));
        }

    }
}
