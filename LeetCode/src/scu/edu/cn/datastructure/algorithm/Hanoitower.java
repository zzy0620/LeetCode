package scu.edu.cn.datastructure.algorithm;

/**
 * @program: DataStructures
 * @description: 汉诺塔
 * @author: zzy
 * @create: 2021-03-15 14:56
 **/
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(3,'A','B','C');
    }

    public static void hanoitower(int num,char a,char b,char c){
        if (num == 1){
            System.out.println(a+"->"+c);
        }else {
            //先把上面的盘 A->B
            hanoitower(num-1,a,c,b);
            //把最小面的盘A->C
            System.out.println(a+"->"+c);
            //把B塔的盘从B->C
            hanoitower(num-1,b,a,c);
        }
    }
}
