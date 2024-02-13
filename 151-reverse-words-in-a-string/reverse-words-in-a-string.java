class Solution {
    public String reverseWords(String s) {

        String newS = s.trim();

        if(newS.length()==1)
        {
            return s;
        }

        String arr[] = newS.split("\\s+");
      //  System.out.println(arr[0]);
        String retString ="";

        for(int i=arr.length-1;i>=0;i--)
        {
            if(i!=0)
            {
                retString+=arr[i]+" ";
            }else{
                retString+=arr[i];
            }
        }

        return retString;

    }
}