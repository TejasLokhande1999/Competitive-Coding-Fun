class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> dq = new ArrayDeque<>();


        for(int i=0;i<n;i++){
            dq.add(i+1);
        }

        int index=0;
        while(dq.size()>1){
                for(int i=0;i<k-1;i++){
                    int ele = dq.poll();
                    dq.add(ele);
                }
                dq.poll();
        }

        int returnEle = dq.poll();
        return returnEle;

    }
}