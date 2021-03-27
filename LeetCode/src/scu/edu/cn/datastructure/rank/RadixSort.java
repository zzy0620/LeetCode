package scu.edu.cn.datastructure.rank;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 基数排序
 * @author: zzy
 * @create: 2021-03-09 10:27
 **/
public class RadixSort {
    public static int num = 1;
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr){
        //定义一二维数组代表十个桶
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少数据，定义一个一维数组来表示每个桶放入的数据个数
        int[] bucketElementCounts = new int[10];
        int max = arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();

        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            for (int j=0;j<arr.length;j++){
                //取出每个元素对应的位  第一次是各位，第二次是十位，第三次是百位，以此类推
                int digitOfElement = arr[j]/n%10;

                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照桶的顺序
            int index = 0;
            for (int k=0;k<bucketElementCounts.length;k++){
                //桶中有数据
                if (bucketElementCounts[k] >0){
                    //循环第k个桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                    //每一轮结束后将bucketElementCounts[k]置0
                    bucketElementCounts[k] = 0;
                }
            }
            System.out.println("第"+(num++)+"轮后的数据是："+ Arrays.toString(arr));
        }
    }
}
