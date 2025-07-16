class MedianFinder {
    private PriorityQueue<Integer> low;  
    private PriorityQueue<Integer> high;
    public MedianFinder() {
      low = new PriorityQueue<>(Collections.reverseOrder()); 
      high = new PriorityQueue<>();  
    }
    
    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());
        
        if (low.size() < high.size()) {
            low.add(high.poll());
        }
    }
    
    public double findMedian() {
         if (low.size() > high.size()) {
            return low.peek();
        } else {
            return (low.peek() + high.peek()) / 2.0;
        }
    }
}
