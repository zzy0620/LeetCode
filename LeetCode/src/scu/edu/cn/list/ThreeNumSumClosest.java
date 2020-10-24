package scu.edu.cn.list;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
//找出 nums 中的三个整数，使得它们的和与 target 最接近。
//返回这三个数的和。假定每组输入只存在唯一答案。

import java.util.Arrays;

public class ThreeNumSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length -1;
            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeNumSumClosest().threeSumClosest(new int[]{1,1,1,0},-100));
    }
}
