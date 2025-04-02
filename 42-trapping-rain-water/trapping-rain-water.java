class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ngl[] = new int[n];
        int ngr[] = new int[n];

        Stack<Integer> s1 = new Stack<>();

        for(int i=0;i<n;i++){
            int ele = height[i];


            if(s1.isEmpty()){
                ngl[i] = 0;
                s1.push(ele);
            }else{

                if(s1.peek()>ele){
                    ngl[i] = s1.peek();
                    //don't push
                    //this is the greatest on the left
                }else{
                    ngl[i] = 0;
                    s1.push(ele);
                }
            }

        }
        // for(int i=0;i<n;i++){
        //     System.out.print(ngl[i]+" ");
        // }

        s1.clear();
        
        for(int i=n-1;i>=0;i--){

            int ele = height[i];
            if(s1.isEmpty()){
                ngr[i] = 0;
                s1.push(ele);
            }else{
                if(s1.peek()>ele){
                    ngr[i] = s1.peek();
                    //don't push
                    //this is the greatest on the left
                }else{
                    ngr[i] = 0;
                    s1.push(ele);
                }
            }
        }

        // System.out.println();

        // for(int i=0;i<n;i++){
        //     System.out.print(ngr[i]+" ");
        // }

        int maxArea = 0;


        for(int i=0;i<n;i++){

            int hgt = Math.min(ngl[i],ngr[i]);
            if(hgt==0){
                continue;
            }else{
                maxArea += hgt-height[i];
            }

        }


        return maxArea;
    }
}