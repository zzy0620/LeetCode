package scu.edu.cn.datastructure.search;

/**
 * @program: DataStructures
 * @description: 顺序查找
 * @author: zzy
 * @create: 2021-03-09 13:18
 **/
public class SequentSearch {
    public static void main(String[] args) {
        int[] arr = {1,9,-11,12,34,89};
        int index =sequentSearch(arr,-12);
        if (index == -1){
            System.out.println("没有找到");
        }else {
            System.out.println("所查找数的下标为："+index);
        }
    }

    public static int sequentSearch(int[] arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
