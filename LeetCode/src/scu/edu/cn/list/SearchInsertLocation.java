package scu.edu.cn.list;

/**
 * @program: leetcode
 * @description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 *               如果目标值不存在于数组中，返回它将会被按顺序插入的位置。  你可以假设数组中无重复元素。
 * @author: zzy
 * @create: 2021-01-09 16:42
 **/

/**
示例 1:

        输入: [1,3,5,6], 5
        输出: 2
        示例 2:

        输入: [1,3,5,6], 2
        输出: 1
        示例 3:

        输入: [1,3,5,6], 7
        输出: 4
        示例 4:

        输入: [1,3,5,6], 0
        输出: 0
*/

public class SearchInsertLocation {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums[0] > target){
            return 0;
        }
        if (nums[nums.length-1] < target){
            return nums.length;
        }
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target){
                if (mid>=1 && nums[mid-1]<target){
                    return mid;
                }
                right = mid-1;
            }
            if (nums[mid] < target){
                if (mid <= nums.length-2 && nums[mid+1] > target){
                    return mid+1;
                }
                left = mid+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        System.out.println(new SearchInsertLocation().searchInsert(nums,2));
    }
}
