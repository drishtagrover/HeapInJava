class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> preq= new PriorityQueue<>();
        for(int i=0; i<k;i++){
            preq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]>preq.peek()){
                preq.poll();
                preq.add(nums[i]);
            }
        }
        return preq.peek();
    }
}
