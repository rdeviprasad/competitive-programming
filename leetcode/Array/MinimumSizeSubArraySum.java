class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int INF = (int)1e9+7;
        int minLen = INF;
        int currentSum = 0;
        for(int end = 0; end < nums.length; end++) {
            currentSum += nums[end];
            while(currentSum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                currentSum -= nums[start++];
            }
        }
        return minLen == INF ? 0 : minLen;
    }
}