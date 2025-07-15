class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        PriorityQueue<Integer> preq= new PriorityQueue<>();
        for(int i=0; i<n; i++){
            ListNode temp=lists[i];
            while(temp!=null){
                preq.add(temp.val);
                temp=temp.next;
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;
        while(!preq.isEmpty()){
            current.next=new ListNode(preq.poll());
            current=current.next;
        }
        return dummy.next;
    }
}
