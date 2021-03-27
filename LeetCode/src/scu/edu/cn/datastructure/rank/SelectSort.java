package scu.edu.cn.datastructure.rank;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 选择排序
 * @author: zzy
 * @create: 2021-03-08 13:01
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        for (int i = 0; i < num.length-1; i++) {
            int min = num[i];
            int index=i;
            for (int j = i+1; j < num.length; j++) {
                if (min > num[j]){
                    min = num[j];
                    index = j; //记录最小数的下标
                }
            }
            if (index != i){
                num[index] = num[i];
                num[i] = min;
            }
            System.out.println("第"+(i+1)+"趟排序后结果："+ Arrays.toString(num));
        }
    }
}
