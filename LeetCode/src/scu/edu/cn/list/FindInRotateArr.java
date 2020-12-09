package scu.edu.cn.list;

/**
 * @program: leetcode
 * @description: 整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。
 * 在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。时间复杂度为nlogn
 * @author: zzy
 * @create: 2020-12-08 21:29
 **/


//可以发现的是，我们将数组从中间分开成左右两部分的时候，一定有一部分的数组是有序的
//我们可以在常规二分搜索的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r]哪个部分是有序的，
//并根据有序的那个部分确定我们该如何改变二分搜索的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分：


public class FindInRotateArr {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        if (nums.length == 1){
            return nums[0] == target ? 0:-1;
        }

        int left = 0,right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            }
//          从nums[0] -> nums[mid]是有序的
            if (nums[0] <= nums[mid]){
//              如果，nums[left] <= target && target < nums[mid]，那么target就在left与mid之间
                if (nums[0] <= target && target < nums[mid]){
//                  值在左半边
                    right = mid - 1;
                }else {
//                  值在右半边
                    left = mid + 1;
                }
//          从nums[mid] -> nums[nums.length-1]是有序的
            }else {
//              target的值在右半边
                if (nums[mid] < target && target <= nums[nums.length-1]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,3};
        System.out.println(new FindInRotateArr().search(arr,3));
    }
}
