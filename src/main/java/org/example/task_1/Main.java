package org.example.task_1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Three", "uch");
        map.put("Two", "ikki");
        map.put("One", "Bir");
        System.out.println(sortMapByKey(map));
    }
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        Map<String, String> sortedMap = new TreeMap<>(map);
        return sortedMap;
    }
}
