package scu.edu.cn.list;

import java.util.Arrays;

//给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
//
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。


public class TwoNumAdd {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    arr= new int[]{i,j};
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,7,11,5};
        int[] result = new TwoNumAdd().twoSum(nums1,9);
        System.out.println(Arrays.toString(result));
    }
}
