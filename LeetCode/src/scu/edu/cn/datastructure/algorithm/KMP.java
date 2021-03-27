package scu.edu.cn.datastructure.algorithm;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: KMP字符串匹配
 * @author: zzy
 * @create: 2021-03-16 08:59
 **/
public class KMP {
    public static void main(String[] args) {
//        String source = "BBC ABCDAB ABCDABCDABDE";
//        String pattern = "ABCDABD";
        String source = "ABAAB ABAABC ABAABA";
        String pattern = "ABAABA";
        int[] next = kmpNext(pattern);
        System.out.println(Arrays.toString(next));
        System.out.println(kmpSearch(source,pattern,next));
    }

    public static int kmpSearch(String source,String pattern,int[] next){
        for (int i=0,j=0;i<source.length();i++){
            while (j>0 && source.charAt(i) != pattern.charAt(j)){
                j = next[j-1];
            }

            if (source.charAt(i) == pattern.charAt(j)){
                j++;
            }
            if (j == pattern.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    public static int[] kmpNext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1 ,j=0; i < dest.length(); i++) {
            while (j>0 && dest.charAt(i) != dest.charAt(j)){
                j=next[j-1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
