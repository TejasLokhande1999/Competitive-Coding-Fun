class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        
        boolean isEven = true;
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(i%2==0){
                    if(isEven){
                        list.add(grid[i][j]);
                        isEven = false;
                    }else if(!isEven){
                        isEven = true;
                    }
                }else{
                    stack.push(grid[i][j]);
                }
                    
                if(j==n-1){
                    while(!stack.isEmpty()){
                        int ele = stack.pop();
                           if(isEven){
                                list.add(ele);
                                isEven = false;
                            }else if(!isEven){
                                isEven = true;
                            }
                    }
                }

                  
               
            }
        }

        return list;
    }

    public void reverse(List<Integer> list, int startIndex, int endIndex){
        while(startIndex<endIndex){
            int first = list.get(startIndex);
            int last = list.get(endIndex);

            int temp = first;
            list.set(startIndex, last);
            list.set(endIndex,temp);

            startIndex++;
            endIndex--;
        }
    }
}