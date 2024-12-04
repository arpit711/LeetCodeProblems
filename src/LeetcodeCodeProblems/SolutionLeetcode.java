package LeetcodeCodeProblems;

import java.util.HashMap;
import java.util.Map;

public class SolutionLeetcode {

    Map<String, Integer> stringMap;
    int maxKey = Integer.MAX_VALUE, minKey = Integer.MIN_VALUE;
    String maxString = "", minString = "";
        public void AllOne() {

            stringMap = new HashMap<String, Integer>();
        }

        public void inc(String key) {
            if (stringMap.get(key) != null) {

                stringMap.put(key, stringMap.get(key) + 1);
                if (maxKey < stringMap.get(key)) {
                    maxKey = stringMap.get(key);
                    maxString = key;
                }
            }
        }

        public void dec(String key) {
            if (stringMap.get(key) != null) {
                stringMap.put(key, stringMap.get(key) - 1);
                if (stringMap.get(key) == 0) {
                    stringMap.remove(key);
                }
                if (stringMap.get(key) != null && minKey > stringMap.get(key)) {
                    minKey = stringMap.get(key);
                    minString = key;
                }

            }
        }

        public String getMaxKey() {
            return maxString;

        }

        public String getMinKey() {
            return minString;
        }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
