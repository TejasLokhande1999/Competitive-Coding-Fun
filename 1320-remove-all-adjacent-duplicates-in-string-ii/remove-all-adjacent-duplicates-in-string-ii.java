class Solution {
    public String removeDuplicates(String string, int k) {

     Stack<int[]> s = new Stack<>(); //char, count;


    for(char ch : string.toCharArray()){

        if(!s.isEmpty() && s.peek()[0]==ch){
            s.peek()[1]++;
        }else{

            s.push(new int[]{ch,1});

        }

        if(s.peek()[1]==k){
            s.pop();
        }

    }

    StringBuilder str = new StringBuilder();

        while(!s.isEmpty()){
            int arr[] = s.pop();
            char ch = (char)arr[0];
            int freq = arr[1];

            for(int i=0;i<freq;i++){
                str.append(ch);
            }

        }
        return str.reverse().toString();


    }
}