class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int ans = 0;
        int n = s.length();
        int start = 0;
        for(int end = 0; end < n; end++) {
            char current = s.charAt(end);
            if(lastSeen.containsKey(current)) {
                start = Math.max(start, lastSeen.get(current) + 1);
            }
            lastSeen.put(current, end);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;

    }
}