class KthLargest {

    Queue<Integer> pq;
    int capa=0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();

        capa = k;

        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);

            if(pq.size()>capa){
                pq.poll();
            }
        }
        
    }
    
    public int add(int val) {
        pq.add(val);

        if(pq.size()>capa){
            pq.poll();
        }

        if(!pq.isEmpty()){
            return pq.peek();
        }

        return 0;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */