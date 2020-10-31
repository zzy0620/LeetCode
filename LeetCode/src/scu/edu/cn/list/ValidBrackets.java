package scu.edu.cn.list;

import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        注意空字符串可被认为是有效字符串
//
//        示例 :
//        输入: "()"
//        输出: true
//
//        输入: "()[]{}"
//        输出: true
public class ValidBrackets {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}")){
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.size() > 0){
                if (s.charAt(i) == ')' && stack.peek() == '('){
                    stack.pop();
                    continue;
                }
                if (s.charAt(i) == '}' && stack.peek() == '{'){
                    stack.pop();
                    continue;
                }
                if (s.charAt(i) == ']' && stack.peek() == '['){
                    stack.pop();
                    continue;
                }
            }
            stack.add(s.charAt(i));
        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        System.out.println(new ValidBrackets().isValid("(){}}{"));
    }
}