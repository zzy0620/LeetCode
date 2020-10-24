package scu.edu.cn.list;

import java.util.ArrayList;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//例：
//输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public class NumAlphabetCombination {
    String[] content = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
//        判断输入为空的情况
        if (digits == null || digits.length() == 0){
            return result;
        }
//        找到每个数字对应的字母组合
        backTrace(digits,0,new StringBuilder());
        return result;
    }
//采用回溯法，相当于遍历树
    private void backTrace(String digits,int index,StringBuilder sb){
        if (digits.length() == index){
            result.add(sb.toString());
            return;
        }
        String temp = content[Integer.parseInt(String.valueOf(digits.charAt(index)))-2];
        for (char c:temp.toCharArray()) {
            sb.append(c);
            backTrace(digits,index+1,sb);
            sb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        System.out.println(new NumAlphabetCombination().letterCombinations(""));
    }
}
