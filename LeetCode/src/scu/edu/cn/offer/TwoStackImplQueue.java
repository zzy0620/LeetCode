package scu.edu.cn.offer;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 * @author: zzy
 * @create: 2021-03-25 16:17
 **/
public class  TwoStackImplQueue {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

class CQueue {
    private Stack<Integer> addStack = new Stack<>();
    private Stack<Integer> deleteStack = new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        addStack.push(value);
    }

    public int deleteHead() {
        if (addStack.empty()){
            return -1;
        }
        while (addStack.size()>1){
            deleteStack.add(addStack.pop());
        }
        int ret = addStack.pop();
        while (!deleteStack.empty()){
            addStack.add(deleteStack.pop());
        }
        return ret;
    }
}
