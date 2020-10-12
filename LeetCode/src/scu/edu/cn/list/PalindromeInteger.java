package scu.edu.cn.list;

public class PalindromeInteger {
    public boolean isPalindrome(int x) {
        String target = String.valueOf(x);
        if (target.length() == 1){
            return true;
        }
        for (int i=0;i<target.length()/2;i++){
            if (target.charAt(i) != target.charAt(target.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome2(int x) {
        int temp = x;
        int result = 0;
        if (x < 0){
            return false;
        }
        else if (x == 0 || x<10){
            return true;
        }
        while (x != 0){
            int pop = x%10;
            x /= 10;
            result = result * 10 + pop;
        }
        return result == temp;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(new PalindromeInteger().isPalindrome2(x));
    }
}
