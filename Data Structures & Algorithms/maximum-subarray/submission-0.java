class Solution {
    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int curSum = 0;                     
        for (int num : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum = curSum + num;
            best = Math.max(best, curSum);
        }

        return best;
    }
}
