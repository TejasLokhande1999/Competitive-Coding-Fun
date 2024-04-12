class Solution {
    public boolean isAnagram(String s, String t) {
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        
        if(s.length()!=t.length())
        {
            return false;
        }

        char ch;
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            arr1[ch-97]+=1;
        }

         for(int i=0;i<t.length();i++){
            ch = t.charAt(i);
            arr2[ch-97]+=1;
        }

         for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }

        return true;

    }
}