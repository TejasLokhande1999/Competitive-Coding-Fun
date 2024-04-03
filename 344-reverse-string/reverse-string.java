class Solution {
    public void reverseString(char[] s) {
        
        int mid = s.length/2;

        int left = 0;
        int right = s.length-1;
        char temp;
        while(left<right)
        {
            //Swapping characters
            temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;

        }



    }
}