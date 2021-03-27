package scu.edu.cn.datastructure.search;

/**
 * @program: DataStructures
 * @description: 二分查找
 * @author: zzy
 * @create: 2021-03-09 13:28
 **/
public class BinarySearch {
    //分查找要求数组是有序的
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        int index = binarySearch(arr,0,arr.length-1,1000);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr,int left,int right,int target){
        int middle = (left+right)/2;
        if (left<=right){
            if (arr[middle] == target){
                return middle;
            }else if (target > arr[middle]){
                return binarySearch(arr,middle+1,right,target);
            }else {
                return binarySearch(arr,left,middle-1,target);
            }
        }else {
            return -1;
        }
    }
}
