class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> sorted = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            sorted.add(new int[] {entry.getKey(), entry.getValue()});
        }
        sorted.sort((a, b) -> b[1] - a[1]);

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = sorted.get(i)[0];
        }

        return res;
    }
}
