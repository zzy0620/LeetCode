package scu.edu.cn.datastructure.search;

/**
 * @program: DataStructures
 * @description: 二分查找非递归
 * @author: zzy
 * @create: 2021-03-15 14:35
 **/
public class BinarySearchNoRecur {
    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right =arr.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println(binarySearch(arr,1000));
    }
}
