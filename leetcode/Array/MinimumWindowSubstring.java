class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int INF = (int)1e9+7;
        int minLen = INF;
        int beginIdx = 0;
        Map<Character, Integer> currentMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        for(char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        int have = 0;
        int need = targetMap.size();

        for(int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            currentMap.put(endChar, currentMap.getOrDefault(endChar, 0) + 1);
            if(targetMap.containsKey(endChar) && currentMap.get(endChar).equals(targetMap.get(endChar))) {
                have++;
            }

            while(have == need) {
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    beginIdx = start;
                }
                char startChar = s.charAt(start);
                currentMap.put(startChar, currentMap.get(startChar) - 1);
                if(targetMap.containsKey(startChar) && currentMap.get(startChar) < targetMap.get(startChar)) {
                    have--;
                }
                start++;
            }
        }

        return minLen == INF ? "" : s.substring(beginIdx, beginIdx + minLen);
    }

    boolean minimumWindow(Map<Character, Integer> mapA, Map<Character, Integer> mapB) {
        for(Character ch : mapB.keySet()) {
            if(mapA.getOrDefault(ch, 0) < mapB.get(ch)) return false;
        }
        return true;
    }
}