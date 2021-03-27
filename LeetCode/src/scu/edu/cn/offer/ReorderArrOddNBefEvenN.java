package scu.edu.cn.offer;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 调整数组顺序使奇数位于偶数前面
 * @author: zzy
 * @create: 2021-03-25 21:34
 **/
public class ReorderArrOddNBefEvenN {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(Arrays.toString(exchange(nums)));
    }
    public static int[] exchange(int[] nums) {
        int l=0,r=nums.length-1;
        while (l < r){
            //找到一位偶数
            while (l<nums.length && nums[l] % 2 != 0) l++;
            if (l>=r) break;
            //找到第一位奇数
            while (r>=0 && nums[r] % 2 == 0) r--;
            if (l>=r) break;
            //交换
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }
}
