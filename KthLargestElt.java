class KthLargest {
    PriorityQueue<Integer> pq;
    int l;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        l=k;
        for(int a:nums){
            add(a);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>l){
            pq.poll();
        }
        return pq.peek();
    }
}
