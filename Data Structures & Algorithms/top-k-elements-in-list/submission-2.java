class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(count.entrySet());
       
        sorted.sort((a, b) -> b.getValue() - a.getValue());

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = sorted.get(i).getKey();
        }

        return res;
    }
}
