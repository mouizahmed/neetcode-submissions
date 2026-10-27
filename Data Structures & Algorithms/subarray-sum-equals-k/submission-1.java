class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, curSum = 0;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);

        for (int n : nums) {
            curSum += n;
            int diff = curSum - k;
            res += prefixMap.getOrDefault(diff, 0);
            prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
}