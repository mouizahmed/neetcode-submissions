class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int m = lo + (hi-lo) / 2;

            if (nums[m] > nums[hi]) {
                lo = m + 1;
            } else {
                hi = m;
            }
        }


        return nums[lo];



    }
}
