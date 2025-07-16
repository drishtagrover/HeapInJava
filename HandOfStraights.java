class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        if(hand.length%groupSize!=0) return false;
        for(int num:hand){
            if(!mp.containsKey(num)){
                mp.put(num,1);
            }
            else{
                mp.put(num,mp.get(num)+1);
            }
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(mp.keySet());
        while(!minHeap.isEmpty()){
            int first=minHeap.peek();
            for(int i=0; i<groupSize;i++){
                int curr=first+i;
                if(!mp.containsKey(curr)|| mp.get(curr)==0){
                    return false;
                }
                mp.put(curr,mp.get(curr)-1);
                if(mp.get(curr)==0){
                    mp.remove(curr);
                    minHeap.remove(curr);
                }
            }
        }
        return true;
    }
}
