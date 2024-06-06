package stack_and_queue;

import java.util.*;

// Minimum sum of squares of character counts in a given string after removing K characters.

import java.util.HashMap;

public class P36 {
    static int minValue(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 1);

            else
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        while (k > 0) {
            char ch = ' ';
            int max = Integer.MIN_VALUE;
            for (Map.Entry<Character, Integer> m : map.entrySet()) {
                if (m.getValue() >= max) {
                    ch = m.getKey();
                    max = m.getValue();
                }
            }
            map.put(ch, map.get(ch) - 1);
            --k;
        }

        int sum = 0;
        @SuppressWarnings("rawtypes")
        Iterator i = map.entrySet().iterator();
        while (i.hasNext()) {
            @SuppressWarnings("rawtypes")
            Map.Entry e = (Map.Entry) i.next();
            sum += (int) Math.pow((int) e.getValue(), 2);
        }

        return sum;
    }
}