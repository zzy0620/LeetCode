package scu.edu.cn.offer;

/**
 * @program: leetcode
 * @description: 替换空格
 * 把字符串 s 中的每个空格替换成"%20"。
 * @author: zzy
 * @create: 2021-03-25 14:14
 **/
public class ReplaceSpaces {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c:chars) {
            if (c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
