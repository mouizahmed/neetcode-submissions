
// 0 -> nums[0] = 1 -> nums[1] = 2 -> (nums[2] = 3 -> nums[3] = 2 -> nums[2] = 3 -> nums[3] = 2) CYCLE
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // just checks if there is a cycle
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) break;
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];

            if (slow == slow2) break;
        }


        return slow;
    }
}
