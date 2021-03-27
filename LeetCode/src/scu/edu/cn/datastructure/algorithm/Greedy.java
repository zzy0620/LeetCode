package scu.edu.cn.datastructure.algorithm;

import java.util.*;

/**
 * @program: DataStructures
 * @description: 贪心算法
 * @author: zzy
 * @create: 2021-03-16 12:30
 **/
public class Greedy {
    public static void main(String[] args) {
        //创建电台集合
        Map<String, HashSet<String>> broadCasts = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");
        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");
        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");
        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");
        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");
        broadCasts.put("K1",set1);
        broadCasts.put("K2",set2);
        broadCasts.put("K3",set3);
        broadCasts.put("K4",set4);
        broadCasts.put("K5",set5);

        HashSet<String> allAreas = new HashSet<>();
        for (Map.Entry<String,HashSet<String>> entry:broadCasts.entrySet()) {
            allAreas.addAll(entry.getValue());
        }

        //创建ArrayList存放选择的电台集合
        List<String> selects = new ArrayList<>();
        //定义一个临时集合，在遍历过程中，存放遍历过程中的电台覆盖地区和当前还没有覆盖的地区的交集
        HashSet<String> temp = new HashSet<>();
        //保存在一次遍历过程中会，能够覆盖最多未覆盖地区对应的电台的key，如果maxKey不为空，加入到电台集合
        String maxKey;
        while (allAreas.size() != 0){
            maxKey = null;
            for (Map.Entry<String,HashSet<String>> entry:broadCasts.entrySet()) {
                temp.clear();
                String key = entry.getKey();
                HashSet<String> cities = entry.getValue();
                temp.addAll(cities);
                //获取temp和allAreas两个集合的交集，交集的结果会赋给temp
                temp.retainAll(allAreas);
                if (temp.size()>0 && (maxKey == null || temp.size()>broadCasts.get(maxKey).size())){
                    maxKey = key;
                }
            }
            if(maxKey != null){
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区，从allAreas去掉你
                allAreas.removeAll(broadCasts.get(maxKey));
            }
        }
        System.out.println(selects);
    }
}
