class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        int start = 0;
        int total = 0;
        backtrack(nums, start, path, total, target);
        return res;  
    }

    private void backtrack(int[] nums, int start, List<Integer> path, int total, int target) {
        if (total == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] + total > target) {
                return;
            }
            path.add(nums[i]);
            backtrack(nums, i, path, nums[i] + total, target);
            path.remove(path.size() - 1);
        }

    }
}
