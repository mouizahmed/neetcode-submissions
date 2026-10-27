class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(map.entrySet());

        sorted.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = sorted.get(i).getKey();
        }


        return res;
    }
}
