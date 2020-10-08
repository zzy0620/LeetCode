package scu.edu.cn.list;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//输入: "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        String s1= "";
        int maxlength=0;
        int i = 0;
        while (i<s.length()){
            int flag = s1.indexOf(String.valueOf(s.charAt(i)));
            if (flag == -1){
                s1 = s1 + s.charAt(i);
            }else {
                s1 = s1.substring(flag+1)+ s.charAt(i);
            }
            if (s1.length()>maxlength){
                maxlength = s1.length();
            }
            i++;
        }
        return maxlength;
    }

    public static void main(String[] args) {
        int result = new LongestSubString().lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }
}
