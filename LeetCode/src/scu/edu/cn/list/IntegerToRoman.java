package scu.edu.cn.list;

public class IntegerToRoman {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public String intToRoman2(int x){
        String[] romans = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<nums.length;i++){
            if (x >= nums[i]){
                int temp = x / nums[i];
                x = x - temp * nums[i];
                for (int j=0;j<temp;j++){
                    sb.append(romans[i]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        int data = 999;
        System.out.println(integerToRoman.intToRoman(data).equals(integerToRoman.intToRoman2(data)));
    }
}
