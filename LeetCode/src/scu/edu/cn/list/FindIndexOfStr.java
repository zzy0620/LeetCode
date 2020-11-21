package scu.edu.cn.list;

//给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
//如果不存在，则返回  -1。

public class FindIndexOfStr {
    public boolean isEmpty(String ss){
        return ss == null || ss.length() == 0;
    }

    public int strStr(String haystack, String needle) {
        if (isEmpty(needle)){
            return 0;
        }
        return haystack.indexOf(needle);
    }

    public int strStr1(String haystack, String needle) {
        if (isEmpty(needle)){
            return 0;
        }
        return myOwnIndexOf(haystack,needle);
    }

    public int myOwnIndexOf(String source,String target){
        int index = -1;
        if (isEmpty(source) || isEmpty(target)){
            return index;
        }
        if (source.length() < target.length()){
            return index;
        }
        for (int i = 0; i < source.length(); i++) {
//            找到第一个字符对应的下标
            if (source.charAt(i) != target.charAt(0))
                continue;
//          如果后面的字符串长度小于目标字符串，直接结束循环
            if (source.length()-i < target.length()){
                break;
            }
            int j = 1;
            int end = i + target.length();
            for (int k = i+1;k<end && source.charAt(k) == target.charAt(j);j++,k++);
            if (j == target.length()){
                index = i;
//                找到第一个即可返回
                return index;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new FindIndexOfStr().strStr("hello","ll"));
        System.out.println(new FindIndexOfStr().strStr("bbbbb","abb"));
        System.out.println(new FindIndexOfStr().strStr1("mississippi","issipi"));
    }
}
