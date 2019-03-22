package file.set;

import java.util.concurrent.ConcurrentHashMap;

public class MyConCurrentMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("key","value");
    }
}
