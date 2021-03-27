package scu.edu.cn.datastructure.recursion;

/**
 * @program: DataStructures
 * @description: 八皇后
 * @author: zzy
 * @create: 2021-03-07 14:55
 **/
public class EightQueue {
    //有多少个皇后
    int max = 8;
    int count = 0;
    //定义一个数组,保存皇后放置位置的结果
    //arr[i] = val 表示第i+1个皇后放在第i+1行的第val+1列
    int[] array = new int[max];

    public static void main(String[] args) {
        EightQueue queue = new EightQueue();
        queue.check(0);
        System.out.println(queue.count);
    }

    //放置第n个皇后
    private void check(int n){
        if (n == max){ //n == 8，代表皇后已经放好了
            print();
            return;
        }
        //依次放出皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后放到该行的第一列
            array[n] = i;
            //判断放置了第n个皇后到第i列时，时候冲突
            if (judge(n)){
                //接着放第n+1个
                check(n+1);
            }
            //如果冲突就继续执行 array[n] = i;
        }
    }

    //检测当前放置的位置和前面摆放的皇后是否冲突
    // n 表示第n个皇后
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n]){
                //处于同一列
                return false;
            }else if ((n-i) == Math.abs(array[n] - array[i])){
                //处于同一对角线（同一斜线的条件是行数相减等于列数相减）
                return false;
            }
        }
        return true;
    }

    private void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        count++;
        System.out.println();
    }
}
