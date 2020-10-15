package scu.edu.cn.list;

public class RomanToInteger {
    public int romanToInt(String s) {
        String[] romans = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int i=0;
        int result = 0;
        while (s != "" && i<romans.length){
            if (s.startsWith(romans[i])){
                result += nums[i];
                if (romans[i].length() == 1){
                    s = s.substring(1);
                }else {
                    s = s.substring(2);
                }
                continue;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("LVIII"));
    }
}
