class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        //int arr[] = {3,1,3,2,2};

        //int area = maxAreaOfhistogram(arr);
        int maxArea =0;
        //return area;

        int m = matrix.length;
        int n = matrix[0].length;

        int arr[] = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(matrix[i][j]=='1'){
                    arr[j]=1+arr[j];
                }else{
                    arr[j]=0;
                }

            }

            int area = maxAreaOfhistogram(arr);
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;

    }

    public int maxAreaOfhistogram(int arr[]){

        int n = arr.length;
        //Calculate the index of NSL (Nearest smaller to left
        System.out.println("The array is : ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();


        Stack<Pair> stack = new Stack<>();
        ArrayList<Integer> nsl = new ArrayList<>();

        for(int i=0;i<n;i++){

            if(stack.isEmpty()){

                nsl.add(-1);
            }else if(stack.peek().ele<arr[i]){
                nsl.add(stack.peek().index);
            }else{
                //stack.peek().ele>=arr[i]

                while(!stack.isEmpty() && stack.peek().ele>=arr[i]){
                    stack.pop();
                }

                //if stakc is empty then the smallest element is index -1
                if(stack.isEmpty()){
                    nsl.add(-1);
                }else{
                    //we found an element who height is smallest than arr[i]
                    nsl.add(stack.peek().index);         
                }
            }

            stack.push(new Pair(arr[i],i));

        }


        stack.clear();
        ArrayList<Integer> nsr = new ArrayList<>();
        //get the right one

        for(int i=n-1;i>=0;i--){

            if(stack.isEmpty()){
                nsr.add(n);
            }else if(stack.peek().ele<arr[i]){
                nsr.add(stack.peek().index);
            }else{
                //stack.peek().ele>=arr[i]

                while(!stack.isEmpty() && stack.peek().ele>=arr[i]){
                    stack.pop();
                }

                //if stakc is empty then the smallest element is index -1
                if(stack.isEmpty()){
                    nsr.add(n);
                }else{
                    //we found an element who height is smallest than arr[i]
                    nsr.add(stack.peek().index);         
                }
            }

            stack.push(new Pair(arr[i],i));

        }

        Collections.reverse(nsr);

        //cal maxArea;
        int maxArea = 0;

        for(int i=0;i<n;i++){
            System.out.print(nsl.get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(nsr.get(i)+" ");
        }

        System.out.println();



        for(int i=0;i<n;i++){
            int leftIdx = nsl.get(i);
            int rightIdx = nsr.get(i);
            int area = arr[i]*(rightIdx-leftIdx-1);
            maxArea = Math.max(maxArea,area);

        }

        return maxArea;

    }
}
class Pair{

    int ele;
    int index;

    Pair(int ele, int index){
        this.ele = ele;
        this.index = index;
    }
}