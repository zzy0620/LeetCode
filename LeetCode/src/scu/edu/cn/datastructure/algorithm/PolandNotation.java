package scu.edu.cn.datastructure.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: DataStructures
 * @description:
 * @author: zzy
 * @create: 2021-03-07 09:49
 **/
public class PolandNotation {
    public static void main(String[] args) {
        //为了使用方便，数字和符号用空格隔开
        String expression = "1+((2+3)*4)-5";
        System.out.println(toInfixExpressionList(expression));
        System.out.println(parseSuffixExpressionList(toInfixExpressionList(expression)));
        System.out.println(calc(parseSuffixExpressionList(toInfixExpressionList(expression))));
    }

    //将中缀表达式转化为list  "10+((2+30)x4)-5" → [1, +, (, (, 2, +, 3, ), x, 4, ), -, 5]
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        int index = 0; //指针，用于遍历字符串
        String str; //对多位数进行拼接
        char c; //存放每次遍历的字符
        do {
            //如果c是非数字，需要加入到ls
            if ( (c=s.charAt(index)) <48 || (c = s.charAt(index)) > 57){
                ls.add(""+c);
                index++;
            }else {
                str = "";
                while (index<s.length() && ((c=s.charAt(index)) >= 48 && (c=s.charAt(index)) <= 57)){
                    str += c;
                    index++;
                }
                ls.add(str);
            }
        }while (index < s.length());
        return ls;
    }

    public static int priority(String oper){
        switch (oper) {
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                System.out.println("不存在该运算符");
                return 0;
        }
    }

    public static List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<>(); //运算符栈
        //s2这个栈在转换过程中，没有出战操作，只有push操作，使用list替代
        List<String> s2 = new ArrayList<>();

        for (String item:ls) {
            //如果是一个数
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                //如果是 左括号(,则直接将此运算符入栈
                s1.push(item);
            }else if (item.equals(")")){
                //如果是右括号),则依次弹出s1栈顶元素并压入s2中，直到遇到左括号为止
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                //此时将这一对括号丢弃
                s1.pop();
            }else {
                //当item的优先级小于栈顶运算符的优先级
                //将s1栈顶的运算符弹出并压入到s2中，再次转到(1.4.1)与s1中新的栈顶运算符比较
                while (s1.size() != 0 && priority(item) <= priority(s1.peek())){
                    s2.add(s1.pop());
                }
                //需要将当前的item压入栈中
                s1.push(item);
            }
        }
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

    public static int calc(List<String> expressionList){
        Stack<String> stack = new Stack<String>();
        for (String s:expressionList) {
            //使用正则表达式匹配数字
            if (s.matches("\\d+")){
                stack.push(s);
            }else {
                //pop出两个数进行运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (s) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
