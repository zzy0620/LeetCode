package scu.edu.cn.list;

//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数

public class TwoArrayMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = null;
        double res;
        if(length1 == 0){
            result = nums2;
        }
        else if (length2 == 0){
            result = nums1;
        }else {
            result = new int[length1+length2];
            int current1 = 0;
            int current2 = 0;
            int i=0;
            while (current1<length1 && current2<length2){
                if (nums1[current1] <= nums2[current2]){
                    result[i] = nums1[current1];
                    current1++;
                }else {
                    result[i] = nums2[current2];
                    current2++;
                }
                i++;
            }
            while (current1 < length1){
                result[i] = nums1[current1];
                i++;
                current1++;
            }
            while (current2 < length2){
                result[i] = nums2[current2];
                i++;
                current2++;
            }
        }
        int len = result.length;
        if(len % 2 != 0){
            res = result[(len - 1) / 2];
        }else{
            res = (result[len / 2] + result[(len / 2) - 1])/2.0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double result = new TwoArrayMedian().findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}
