package scu.edu.cn.datastructure.search;

/**
 * @program: DataStructures
 * @description: 插值查找
 * @author: zzy
 * @create: 2021-03-09 13:55
 **/
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
//        int[] arr = {2,2,2};
        int index = insertValueSearch(arr,0,arr.length-1,77);
//        int index = insertValueSearch(arr,0,arr.length-1,2);
        System.out.println(index);
    }

    public static int insertValueSearch(int[] arr,int left,int right,int target){
        if (left >right || target < arr[left] || target > arr[right]){
            return -1;
        }
        //防止 /zero错误
        if ((arr[right]-arr[left]) == 0){
            return target == arr[left] ? right:-1;
        }
        int findIndex = left + (right-left)*(target-arr[left])/(arr[right]-arr[left]);
        if (arr[findIndex] > target){
            return insertValueSearch(arr,left,findIndex-1,target);
        }else if (arr[findIndex] < target){
            return insertValueSearch(arr,findIndex+1,right,target);
        }else {
            return findIndex;
        }
    }
}
