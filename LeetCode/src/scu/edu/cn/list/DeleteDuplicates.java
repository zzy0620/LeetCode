package scu.edu.cn.list;

import java.util.Arrays;

//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
//        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

//示例 1:
//
//        给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//        函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//        你不需要考虑数组中超出新长度后面的元素。

public class DeleteDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums ==null || nums.length == 0){
            return 0;
        }
        int curr=0;
        int next = 0;
        Arrays.sort(nums);
        while (next < nums.length-1) {
            while (nums[next] == nums[next+1] ){
                next++;
                if (next == nums.length-1)
                    break;
            }
            if (next == nums.length-1)
                break;
            next++;
            nums[++curr] = nums[next];
        }
        return ++curr;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return ++i;
    }


    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4};
//        System.out.println(new DeleteDuplicates().removeDuplicates(test));
        System.out.println(new DeleteDuplicates().removeDuplicates2(test));
    }
}
