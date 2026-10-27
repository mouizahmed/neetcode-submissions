class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        int[] res = new int[nums.length-k+1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(new int[]{nums[i], i});
            if (i >= k-1) {
                while (maxHeap.peek()[1] < i-k+1) {
                    maxHeap.poll();
                }
                res[index++] = maxHeap.peek()[0];
            }
        }

        return res;

    }
}
