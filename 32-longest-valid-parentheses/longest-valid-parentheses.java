class Solution {
    public int longestValidParentheses(String s) {
        
        int left = 0;
        int right=0;

        int n = s.length();
        int cnt = 0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch=='(') left++;
            else right++;

            if(left==right) cnt = Math.max(cnt,left*2);
            if(right>left) left=right=0;
        }

        left = 0;
        right=0;

        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);

            if(ch==')') right++;
            else left++;

            if(left==right) cnt = Math.max(cnt,left*2);
            if(left>right) left=right=0;
        }

        return cnt;

    }
}