package scu.edu.cn.datastructure.algorithm;

/**
 * @program: DataStructures
 * @description: 简单的计算器
 * @author: zzy
 * @create: 2021-03-06 20:59
 **/
public class Calculator {
    //优先级使用数字表示，数字越大，优先级越高
    public static int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    public static boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public static  int cal(int num1,int num2,int oper){
        int result = 0; // 用于存放计算的结果
        switch (oper){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        String expression = "111+3*1-3";
        System.out.println("表达式为:"+expression);
        ArrStack2 numStack =  new ArrStack2(10);
        ArrStack2 operStack =  new ArrStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (index < expression.length()){
            ch = expression.charAt(index);
            if (isOper(ch)){ //如果是运算符
                if (!operStack.isEmpty()){
                    //如果当前的操作符优先级小于或者等于栈顶的操作符，就需要从数栈中pop出两个数,再从操作符栈中pop出一个,进行计算，
                    // 将得到的结果入数栈，然后将当前的操作符入符号栈。
                    if (priority(ch) <= priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = cal(num1,num2,oper);
                        if (operStack.peek() == '-'){
                            operStack.pop();
                            operStack.push('+');
                            numStack.push(-res);
                        }else {
                            numStack.push(res);
                        }
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                    //为空直接入栈
                    operStack.push(ch);
                }
            }else {
                //ASCII表中 字符1的值是49，以此类推
//                numStack.push(ch-48);
                keepNum += ch;
                //判断下一位是否是数字
                if (index+1 < expression.length()){
                    if (isOper(expression.charAt(index+1))){
                        //如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum="";
                    }
                }else {
                    //如果是最后一位，直接入栈
                    numStack.push(Integer.parseInt(keepNum));
                }
            }
            index++;
        }
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("最后的结果为:"+numStack.pop());
    }
}

class ArrStack2{
    private int maxSize;//站的大小
    private int[] stack;//
    private int top = -1; // 栈顶，初始化为-1

    public ArrStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满，不能入栈");
            return;
        }
        stack[++top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，不能出栈");
        }
        return stack[top--];
    }
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("栈空，不能出栈");
        }
        return stack[top];
    }

    public void list(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d \t",i,stack[i]);
        }
    }

}
