package scu.edu.cn.list;

import java.util.Arrays;


//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//        必须 原地 修改，只允许使用额外常数空间。

//我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。
// 比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
//        我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
//        在尽可能靠右的低位进行交换，需要从后向前查找
//        将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
//        将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列。
//        以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。
//        显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
//        以上就是求“下一个排列”的分析过程
public class NextBiggerRank {
    public void nextPermutation(int[] nums) {
        int left = nums.length-2;
        while (left>=0 && nums[left] >= nums[left+1]){
            left--;
        }
        if (left >= 0){
            int right = nums.length-1;
            while (right > left && nums[left] >= nums[right]){
                right--;
            }
//            交换节点
           swap(nums,left,right);
        }
        reverse(nums, left + 1);
    }
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,1,1};
        new NextBiggerRank().nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}
