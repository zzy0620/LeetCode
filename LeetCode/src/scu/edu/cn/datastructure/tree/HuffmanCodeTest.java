package scu.edu.cn.datastructure.tree;

import java.util.*;

/**
 * @program: DataStructures
 * @description: 哈夫曼编码
 * @author: zzy
 * @create: 2021-03-11 15:25
 **/
public class HuffmanCodeTest {
    //记录哈夫曼编码  形式：2->01 97->100等等
    private static  Map<Byte,String> huffmanCodeMap = new HashMap<>();
    private static  Map<String,Byte> reverseHuffmanCodeMap = new HashMap<>();

    public static void main(String[] args) {
        String ss = "i like like like java do you like a java";
        byte[] contentByte = ss.getBytes(); //40个字节
        System.out.println(Arrays.toString(contentByte));
        List<HNode> nodes = getNodes(contentByte);
        HNode root = createHuffmanTree(nodes);
        createHuffmanCode(root,"",new StringBuilder());
        byte[] zipByte = zip(contentByte,huffmanCodeMap); //17个字节
        System.out.println(Arrays.toString(zipByte));
        byte[] decodeByte = decode(zipByte,reverseHuffmanCodeMap);
        String s = new String(decodeByte);
        System.out.println(s);

    }

    private static List<HNode> getNodes(byte[] bytes){
        List<HNode> nodes = new ArrayList<>();
        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b:bytes) {
            Integer count = counts.get(b);
            if (count == null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }

        for (Map.Entry<Byte,Integer> entry:counts.entrySet()) {
            HNode hNode = new HNode(entry.getKey(),entry.getValue());
            nodes.add(hNode);
        }
        return nodes;
    }

    //创建哈夫曼树
    private static HNode createHuffmanTree(List<HNode> list){
        while (list.size() > 1){
            //将节点从小到大排序
            Collections.sort(list);
            //在森林中选出两个根结点的权值最小的树合并
            HNode left = list.get(0);
            HNode right = list.get(1);
            HNode root = new HNode(null,left.weight+right.weight);
            root.left = left;
            root.right = right;
            //从森林中删除选取的两棵树，并将新树加入森林
            list.remove(left);
            list.remove(right);
            list.add(root);
        }
        return list.get(0);
    }

    /**
    *
    * @Description: 压缩
    * @Param: bytes原始的字符串对应的byte
     *        huffmanCodeMap：哈夫曼编码表
    * @return: 压缩后的 byte[] 机器码
    * @Author: zzy
    * @Date: 2021/3/11 16:19
    */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodeMap){
        StringBuilder builder = new StringBuilder();
        for (byte b:bytes) {
            builder.append(huffmanCodeMap.get(b));
        }
        int len;
        if (builder.length() % 8 ==0){
            len = builder.length()/8;
        }else {
            len = builder.length()/8+1;
        }
        byte[] by = new byte[len];
        int index = 0;
        for (int i = 0; i < builder.length(); i += 8) {//8位对应一个byte
            String strByte;
            if (i+8 > builder.length()){
                strByte = builder.substring(i);
            }else {
                strByte = builder.substring(i,i+8);
            }
            by[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }
        return by;
    }
    
    /**
    *
    * @Description: 将一个byte转成一个二进制字符串
    * @Param: flag:是否需要补高位
     *        b：传入的byte
    * @return: 该byte对应的二进制字符串，按补码返回
    * @Author: zzy
    * @Date: 2021/3/11 16:53
    */
    private static String byteToBitString(boolean flag,byte b){
        int temp = b;
        if (flag){//如果是最后一个字节，不需要补高位
            temp |= 256;
        }
        //这个方法返回的是数字对应的二进制的补码
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    } 

    private static byte[] decode(byte[] bytes,Map<String,Byte> reverseHuffmanCodeMap){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            boolean flag = (i == bytes.length-1);
            builder.append(byteToBitString(!flag,bytes[i]));
        }
        List<Byte> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < builder.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag){
                String key = builder.substring(i,i+count);
                b = reverseHuffmanCodeMap.get(key);
                if (b == null){
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] decodeByte = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            decodeByte[i] = list.get(i);
        }
        return decodeByte;
    }

    /**
    *
    * @Description: 生成哈夫曼编码
    * @Param: node:传入的节点
     *        code:路径 0：左子节点 1：右子节点
     *        stringBuilder：路径拼接
    * @return:
    * @Author: zzy
    * @Date: 2021/3/11 15:56
    */
    private static void createHuffmanCode(HNode node,String code,StringBuilder builder){
        if (node != null){
            builder.append(code);
            //叶子节点
            if (node.data != null){
                huffmanCodeMap.put(node.data,builder.toString());
                reverseHuffmanCodeMap.put(builder.toString(),node.data);
            }else {
                createHuffmanCode(node.left,"0",builder);
                createHuffmanCode(node.right,"1",builder);
            }
            if (builder.length()>0){
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }

    public static void preOrder(HNode node){
        if (node == null){
            return;
        }
        System.out.println(node);
        if (node.left != null){
            preOrder(node.left);
        }
        if (node.right != null){
            preOrder(node.right);
        }
    }
}

class HNode implements Comparable<HNode>{

    Byte data ;
    int weight;
    HNode left;
    HNode right;

    public HNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(HNode o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "HNode[" +
                "data=" + data +
                ", weight=" + weight +
                ']';
    }
}
