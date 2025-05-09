class Solution {
    public int largestRectangleArea(int[] heights) {

        //storing indexes
        List<Integer> smallestToLeft = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){

            if(stack.isEmpty()){
                stack.add(new Pair(heights[i],i));
                smallestToLeft.add(-1);
            }else if(stack.peek().ele<heights[i]){
                smallestToLeft.add(stack.peek().index);
            }else{
                while(!stack.isEmpty() && stack.peek().ele>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    //index of ele smallest to left
                    smallestToLeft.add(-1);
                }else{
                    smallestToLeft.add(stack.peek().index);

                }
            }

            stack.push(new Pair(heights[i],i));

        }

        stack.clear();
         List<Integer> smallestToRight = new ArrayList<>();

        for(int i=heights.length-1;i>=0;i--){

            if(stack.isEmpty()){
                stack.add(new Pair(heights[i],i));
                smallestToRight.add(heights.length);
            }else if(stack.peek().ele<heights[i]){
                smallestToRight.add(stack.peek().index);
            }else{
                while(!stack.isEmpty() && stack.peek().ele>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    //index of ele smallest to left
                    smallestToRight.add(heights.length);
                }else{
                    smallestToRight.add(stack.peek().index);

                }
            }

            stack.push(new Pair(heights[i],i));

        }
        Collections.reverse(smallestToRight);

        int maxArea = 0;

        int n = heights.length;

        for(int i=0;i<smallestToLeft.size();i++){
            int lIdx = smallestToLeft.get(i)+1;
            int rIdx = smallestToRight.get(i)-1;

            maxArea = Math.max(maxArea, heights[i]*(rIdx-lIdx+1));

        }

        return maxArea;
    }
}

class Pair{
    int ele;
    int index;

    Pair(int ele,int index){
        this.ele = ele;
        this.index = index;
    }
}