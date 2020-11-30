package scu.edu.cn.list;

import java.util.*;

/**
 * @program: leetcode
 * @description: 给定一个字符串s和一些长度相同的单词words。找出 s 中恰好可以由words中所有单词串联形成的子串的起始位置.
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * @author: zzy
 * @create: 2020-11-30 20:15
 **/


//示例 1：
//
//        输入：
//        s = "barfoothefoobarman",
//        words = ["foo","bar"]
//        输出：[0,9]
//        解释：
//        从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//        输出的顺序不重要, [9,0] 也是有效答案。


public class SeriesConnection {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || words.length == 0){
            return result;
        }

        Map<String,Integer> map = new HashMap<>();
        for (String ss : words){
            if(!s.contains(ss)){
                return result;
            }
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }
        int oneLen = words[0].length();
        int wordsLength = oneLen * words.length;

        if (wordsLength > s.length()){
            return result;
        }

//        每次跳一个单词的长度，故有 oneLen-1种开始的情况  0，1 ... words[0].length-1
        for (int i=0;i<oneLen;i++){
            // 左右窗口
            int left = i, right = i, count = 0;
            // 统计每个符合要求的word
            Map<String, Integer> subMap = new HashMap<>();
            // 右窗口不能超出主串长度
            while (right + oneLen <= s.length()) {
                // 得到一个单词
                String word = s.substring(right, right + oneLen);
                // 有窗口右移
                right += oneLen;
                // words[]中没有这个单词，那么当前窗口肯定匹配失败，直接右移到这个单词后面
                if (!map.containsKey(word)) {
                    left = right;
                    // 窗口内单词统计map清空，重新统计
                    subMap.clear();
                    // 符合要求的单词数清0
                    count = 0;
                }else {
                    // 统计当前子串中这个单词出现的次数
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    ++count;
                    // 如果这个单词出现的次数大于words[]中它对应的次数，又由于每次匹配和words长度相等的子串
                    // 如 ["foo","bar","foo","the"]  "|foobarfoobar| foothe"
                    // 第二个bar虽然是words[]中的单词，但是次数抄了，那么右移一个单词长度后 "foo |barfoobarfoo| the"
                    // bar还是不符合，所以直接从这个不符合的bar之后开始匹配，也就是将这个不符合的bar和它之前的单词(串)全移出去
                    while (subMap.getOrDefault(word, 0) > map.getOrDefault(word, 0)) {
                        // 从当前窗口字符统计map中删除从左窗口开始到数量超限的所有单词(次数减一)
                        String w = s.substring(left, left + oneLen);
                        subMap.put(w, subMap.getOrDefault(w, 0) - 1);
                        // 符合的单词数减一
                        --count;
                        // 左窗口位置右移
                        left += oneLen;
                    }
                    // 当前窗口字符串满足要求
                    if (count == words.length) result.add(left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"ab","ba","ba"};
        System.out.println(new SeriesConnection().findSubstring("ababaab",words));
    }
}
