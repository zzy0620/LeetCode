package scu.edu.cn.list;

//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
//        不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
//        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

public class DeleteElement {
    //采用双指针的思想，从第一相同的val，让最后一个不同于val的元素替换
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            if (nums[left] == val){
                while (nums[right] == val && left<right){
                    right--;
                }
                nums[left] = nums[right];
                if (right!=0){
                    right--;
                }else {
                    return left;
                }
                if (left > right){
                    return left;
                }
            }
            left++;
        }
        return left;
    }

//    双指针优雅版
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

//    当 nums[j] 与给定的值相等时，递增 j 以跳过该元素。
//    只要 nums[j] != val，我们就复制 nums[j]nums[j] 到 nums[i]nums[i] 并同时递增两个索引。
//    重复这一过程，直到 jj 到达数组的末尾，该数组的新长度为 ii

    public int removeElement3(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
//        int[] nums = new int[]{3,2,2,3};
        int[] nums = new int[]{4,5};
        System.out.println(new DeleteElement().removeElement(nums,4));
        System.out.println(new DeleteElement().removeElement2(nums,4));
        System.out.println(new DeleteElement().removeElement3(nums,4));
    }
}
