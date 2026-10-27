class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(), b.getValue()));

        int[] res = new int[k];

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) minHeap.poll();
        }

        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll().getKey();
        }

        return res;
    }
}
