class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++) {
           ans += expandFromCenter(s, i, i);
           ans += expandFromCenter(s, i, i + 1);
        }
        return ans;
    }

    int expandFromCenter(String s, int left, int right) {
        int ans = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ans++;
            left--;
            right++;
        }
        return ans;
    }
}