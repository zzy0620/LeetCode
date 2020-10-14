package scu.edu.cn.list;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
//在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0)。
//找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
//
//        说明：你不能倾斜容器，且n的值至少为 2。
//示例：
//
//        输入：[1,8,6,2,5,4,8,3,7]
//        输出：49


public class TheMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                int width = j-i;
                int temp = Math.min(height[i],height[j]) * width;
                if (temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }

//    two point method
    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] params = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new TheMostWater().maxArea(params));
    }
}
