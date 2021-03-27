package scu.edu.cn.datastructure.rank;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 归并排序
 * @author: zzy
 * @create: 2021-03-09 09:33
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        mergerSort(arr,0,arr.length-1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergerSort(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid = (left+right)/2;
            mergerSort(arr,left,mid,temp);
            mergerSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr,int left ,int mid,int right,int[] temp ){
        int i = left; // 左有序序列索引
        int j = mid+1;// 右有序序列索引
        int t = 0; // 指向temp数组当前索引
        //直到左右两边的有序序列有一个处理完毕
        while (i<=mid && j<=right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                i++;
            }else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        //将有剩余的有序序列的数据依次填充到temp
        while (i<=mid){
            temp[t++] = arr[i];
            i++;
        }
        while (j<=right){
            temp[t++] = arr[j];
            j++;
        }
        //将temp拷贝到temp
        t=0;
        while (left <= right){
            arr[left++] = temp[t++];
        }
    }
}
