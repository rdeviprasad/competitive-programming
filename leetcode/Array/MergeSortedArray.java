class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n - 1;
        int right1 = m - 1;
        int right2 = n - 1;

        while(right2 >= 0) {
            if(right1 >= 0 && nums1[right1] >= nums2[right2]) {
                nums1[total] = nums1[right1];
                right1--;
            } else {
                nums1[total] = nums2[right2];
                right2--;
            }
            total--;
        }
    }
}