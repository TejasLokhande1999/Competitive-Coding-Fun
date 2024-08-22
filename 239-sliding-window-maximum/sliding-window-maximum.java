class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        int n = arr.length;

        while(j<n){

            // while(!q.isEmpty() && q.peekLast()<arr[j]){
            //     q.pollLast();
            // }

            // q.push(arr[j]);

            // if(j-i+1<k){
            //     j++;
            // }else if(j-i+1==k){
            //     if(q.peek()==arr[i]){
            //         ans.add(q.peek());
            //         q.poll();
            //     }else{
            //         ans.add(q.peek());
            //     }
            //     i++;
            //     j++;
            // }

                    // Maintain decreasing order in deque and store values
        while (!q.isEmpty() && q.peekLast() < arr[j]) {
            q.pollLast();
        }

        // Add the current element to the deque
        q.offerLast(arr[j]);

        if (j - i + 1 < k) {
            j++;
        } else if (j - i + 1 == k) {
            // The element at the front of the deque is the maximum in the current window
            ans.add(q.peekFirst());

            // Remove the element at index i if it is the maximum and out of the window
            if (q.peekFirst() == arr[i]) {
                q.pollFirst();
            }

            // Slide the window
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