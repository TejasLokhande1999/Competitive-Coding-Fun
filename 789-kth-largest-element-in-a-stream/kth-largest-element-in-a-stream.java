class KthLargest {

    int k;
    PriorityQueue<Integer> minh = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;

        for(int i=0;i<nums.length;i++){
            minh.add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(minh.size()<k){
            minh.add(val);
        }else{

            while(minh.size()>k){
                minh.poll();
            }
            minh.add(val);
            minh.poll();
        }

        return minh.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */