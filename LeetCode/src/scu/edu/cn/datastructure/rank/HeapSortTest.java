package scu.edu.cn.datastructure.rank;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 堆排序
 * @author: zzy
 * @create: 2021-03-11 12:39
 **/
public class HeapSortTest {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9,-1,98,36};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        int temp = 0;
        //将无序列表构建成一个堆
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }

        //
        for (int j=arr.length-1;j>0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }

    /**
    *
    * @Description:
    * @Param:  arr:待调整的数组  i:非叶子节点在数组中的索引  length:表示对多少个元素继续调整
    * @return:
    * @Author: zzy
    * @Date: 2021/3/11 12:40
    */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for (int j = i*2+1; j < length; j=j*2+1) {
            if (j+1<length && arr[j] < arr[j+1]){
                j++;
            }
            if (arr[j] > temp){
                arr[i] = arr[j];
                i=j;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
