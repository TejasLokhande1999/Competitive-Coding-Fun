class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int retArr[]= new int[n];
        List<Integer> list = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                list.add(0);
                stack.push(new Pair(arr[i],i));
            }else if(stack.peek().getFirst()>arr[i]){
                list.add(1);
                stack.push(new Pair(arr[i],i));
            }else{
                //stack.top()<=arr[i]

                while(!stack.isEmpty()&&stack.peek().getFirst()<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    list.add(0);
                    stack.push(new Pair(arr[i],i));

                }else{
                    list.add(stack.peek().getSecond()-i);
                    stack.push(new Pair(arr[i],i));
                }
            }
        }


        for(int i=0;i<list.size();i++){
            retArr[n-i-1] = list.get(i);
        }

        return retArr;

    }
}

class Pair{
    int ele;
    int index;

    Pair(int ele, int index){
        this.ele = ele;
        this.index= index;
    }

    public int getFirst(){
        return ele;
    }

    public int getSecond(){
        return index;
    }
}