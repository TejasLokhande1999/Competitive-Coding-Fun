class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> retArr = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int i=0,j=0;

        while(j<n){

            int ele = nums[j];
            
            while(!q.isEmpty() && q.peekLast()<ele){
                q.pollLast();
            }
            q.add(ele);
            if(j-i+1<k){
                j++;
            }else{
                retArr.add(q.peek());

                int first = nums[i];
                if(first==q.peek()){
                    q.pollFirst();
                }
                i++;
                j++;
            }

        }

        int[] result = new int[retArr.size()];
        for (int x = 0; x < retArr.size(); x++) {
            result[x] = retArr.get(x);
        }

        return result;
    }
}