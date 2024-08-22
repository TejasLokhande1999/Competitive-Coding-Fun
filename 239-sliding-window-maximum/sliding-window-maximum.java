class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        int n = arr.length;

        while(j<n){

            while(!q.isEmpty() && q.peekLast()<arr[j]){
                q.pollLast();
            }

            q.offerLast(arr[j]);

            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                ans.add(q.peek());
                if(q.peek()==arr[i]){
                    q.pollFirst();
                }
                i++;
                j++;
            }

        }

        int retArr[] = new int[ans.size()];

        for(int m=0;m<retArr.length;m++){
            retArr[m] = ans.get(m);
        }

        return retArr;
    }
}