package scu.edu.cn.list;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//示例：
//
//        输入：n = 3
//        输出：[
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]

public class GenerateBrackets {
    private final List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(new StringBuilder(),0,0,n);
        return result;
    }

    private void generate(StringBuilder sb,int left,int right, int n){
        if (left > n){
            return;
        }
        if (sb.length() == n * 2 && isValid(sb.toString().toCharArray())){
            result.add(sb.toString());
            return;
        }
        if (left == right){
            generate(sb.append("("),left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (left > right){
            generate(sb.append(")"),left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
            generate(sb.append("("),left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    private boolean isValid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateBrackets().generateParenthesis(3));
    }
}
