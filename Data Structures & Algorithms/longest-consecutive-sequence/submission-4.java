class Solution {
    // nums:    2, 20, 4, 10, 3, 4, 5
    // set:     2, 20, 4, 10, 3, 4, 5

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int longest = 0;

        for (int n : nums) set.add(n);

        for (int n : nums) {
            if (set.contains(n-1)) continue; // not the start of a consecutive sequence
            int length = 0;
            while (set.contains(n+length)) length++;
            longest = Math.max(longest, length);
        }
        

        return longest;
    }
}
