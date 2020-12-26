package scu.edu.cn.list;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @author: zzy
 * @create: 2020-12-26 13:47
 **/

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//如果数组中不存在目标值 target，返回 [-1, -1]。

public class FindSEInArr {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums == null || nums.length == 0){
            return result;
        }
        if (nums.length == 1){
            if (nums[0] == target){
                return new int[]{0,0};
            }
            return result;
        }
        int left = 0;
        int right = nums.length-1;

        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                int toRight = mid;
                //往右查找，首先判断是否越界
                while (++toRight < nums.length && nums[toRight] == target);
                //跳出循环后，因为+1后不等于target，因此需要-1
                result[1] = toRight-1;
                while (--mid >=0 && nums[mid] == target);
                result[0] = mid+1;
                return result;
            }else {
                if (nums[mid] > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{5,7,7,8,8,10};
        int[] test = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(new FindSEInArr().searchRange(test, 8)));
    }
}
