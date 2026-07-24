class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[i] >= stack.peek()) {
                int prev = stack.pop();
                answer[i]++;
            }
            if(!stack.isEmpty()) {
                answer[i]++;
            }
            stack.push(heights[i]);
        }
        return answer;
    }
}