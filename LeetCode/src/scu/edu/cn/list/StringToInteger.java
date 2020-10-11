package scu.edu.cn.list;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

//首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
//
//  如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
//  假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
//  该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
//  注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
//
//        在任何情况下，若函数不能进行有效的转换时，请返回 0 。
public class StringToInteger {
    public int myAtoi(String s) {
        s = s.trim();
        String newStr = s.replaceFirst("^0*","");
        s=newStr;
        int result = 0;
        if (s.length() == 0 || !Character.isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+' || s.length() == 1 && !Character.isDigit(s.charAt(0)) ) {
            return result;
        } else {
            if (!Character.isDigit(s.charAt(0))&&!Character.isDigit(s.charAt(1))){
                return result;
            }
            String temp = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                    temp += s.charAt(i);
                    continue;
                }
                if (i>0){
                    break;
                }
            }
            if (temp.length() > 10) {
                if (s.charAt(0) == '-') {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            } else if (temp.length() == 10) {
                int rev = Integer.parseInt(temp.substring(0, 9));
                if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && Integer.parseInt(String.valueOf(temp.charAt(9))) > 7) {
                    if (s.charAt(0) == '-') {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                if (s.charAt(0) == '-'){
                    return Integer.parseInt('-'+temp);
                }
                return Integer.parseInt(temp);
            } else {
                if (s.charAt(0) == '-'){
                    return Integer.parseInt('-'+temp);
                }
                return Integer.parseInt(temp);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("    +0a32"));
    }
}