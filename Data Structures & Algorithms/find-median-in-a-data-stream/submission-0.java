class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;


    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        large = new PriorityQueue<>(); // min-heap
    }
    
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        if (large.size() > small.size()) small.offer(large.poll());
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else {
            return ((long) (small.peek() + large.peek())) / 2.0;
        }
    }
}
