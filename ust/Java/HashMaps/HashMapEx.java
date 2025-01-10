package HashMaps;

import java.util.HashMap;

public class HashMapEx {
    public static void main(String[] args) {
        String str = "Hello";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i <str.length(); i++) {
            char ch = str.toLowerCase().charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1);
            }
            else {
                hm.put(ch, 1);
            }
        }
        for (int i = 0; i <str.length(); i++) {
            char ch = str.toLowerCase().charAt(i);
            if(hm.containsKey(ch)){
                System.out.println(ch + " -> " + hm.get(ch));
                hm.remove(ch);
            }
        }
    }
}
