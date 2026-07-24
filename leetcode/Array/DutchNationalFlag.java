class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int medium = 0;
        int high = n - 1;
        while(medium <= high) {
            if(nums[medium] == 0) {
                swap(nums, low, medium);
                low++;
                medium++;
            } else if (nums[medium] == 2) {
                swap(nums, medium, high);
                high--;
            } else {
                medium++;
            }
        }
    }

    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}