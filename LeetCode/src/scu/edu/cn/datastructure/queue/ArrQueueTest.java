package scu.edu.cn.datastructure.queue;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: 数组模拟队列
 * @author: zzy
 * @create: 2021-03-05 11:23
 **/
public class ArrQueueTest {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            System.out.println("h(peak):查看队列头数据");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        System.out.println("取出的数据是:"+queue.getQueue());
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("头数据是:"+queue.peak());
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//
class ArrayQueue{
    private int maxSize; //表示数组容量
    private int front; //队列头
    private int rear; // 队列尾
    private int[] arr; //模拟队列

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部
        rear = -1;
    }

    //入队列
    public void addQueue(int element){
        if (isFull()){
            System.out.println("Queue is Full");
            return;
        }
        rear++;
        arr[rear] = element;
    }

    //出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        front++;
        return arr[front];
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d \n",i,arr[i]);
        }
    }

    public int peak(){
        if (isEmpty()){
           throw  new RuntimeException("Queue is Empty");
        }
        return arr[front+1];
    }
}
