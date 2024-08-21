class Solution {
    public int[] asteroidCollision(int[] arr) {
        
        Stack<Integer> s= new Stack<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0){
                s.push(arr[i]);
            }else{
                //smaller than 0

            while(!s.isEmpty() && s.peek()>0 && s.peek()<Math.abs(arr[i])){
                    s.pop();
                }

                //cases
                //if s.peek()==arr[i] then pop it as it nullifies
                if(!s.isEmpty() && s.peek()==Math.abs(arr[i])){
                    s.pop();
                }else if(s.isEmpty() || s.peek()<0){
                    s.push(arr[i]);
                }

            }

            
        }

        Collections.reverse(s);

        int retArr[] = new int[s.size()];
            int k=0;
            while(!s.isEmpty()){
                retArr[k]=s.pop();
                k++;
            }
            return retArr;

    }
}