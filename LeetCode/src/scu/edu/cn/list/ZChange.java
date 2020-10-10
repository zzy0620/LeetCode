package scu.edu.cn.list;

//将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
//
//        比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：
//
//        L   C   I   R
//        E T O E S I I G
//        E   D   H   N
//        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

import java.util.ArrayList;
import java.util.List;

public class ZChange {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }
        int cursor = 0;
        boolean bottom = false;
        for (int i=0;i<s.length();i++){
//            flag == 0 present the order is from top to bottom,1 present from bottom to top
            if (!bottom){
                rows.get(cursor).append(s.charAt(i));
                cursor += 1;
                if (cursor == numRows){
                    bottom = true;
                }
            }else {
                if (cursor == numRows){
                    cursor -= 2;
                    rows.get(cursor).append(s.charAt(i));
                }else {
                    cursor -= 1;
                    rows.get(cursor).append(s.charAt(i));
                }
                if (cursor == 0){
                    cursor += 1;
                    bottom = false;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb:rows){
            result.append(sb);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = new ZChange().convert("LEETCODEISHIRING",4);
        System.out.println(result);
    }
}
