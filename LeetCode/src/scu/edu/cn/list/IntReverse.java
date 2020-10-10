package scu.edu.cn.list;
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
//示例 1:
//
//        输入: 123
//        输出: 321
//        输入: -123
//        输出: -321
//        输入: 120
//        输出: 21

public class IntReverse {
    public String getReverseString(String target){
        StringBuilder sb = new StringBuilder();
        for (int i=target.length()-1;i>=0;i--){
            sb.append(target.charAt(i));
        }
        return sb.toString();
    }
//    just use when the number's size not overflow
    public int reverse(int x) {
        String s = String.valueOf(x);
        String result = "";
        if (s.charAt(0) == '-'){
            result = "-"+getReverseString(s.substring(1));
        }else {
            result = getReverseString(s);
        }
        try{
            return Integer.parseInt(result);
        }catch (NumberFormatException e ){
            return 0;
        }
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new IntReverse().reverse(1534236469));
    }
}
