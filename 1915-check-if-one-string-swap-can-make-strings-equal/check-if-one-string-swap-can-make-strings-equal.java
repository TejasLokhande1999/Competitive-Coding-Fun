class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int index1=-1;
        int index2=-1;
        int count=0;
        for(int i=0;i<n;i++){

            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(ch1!=ch2){
                count+=1;
                if(index1==-1){
                    index1=i;
                }else{
                    index2=i;
                }
                if(count>2){
                    return false;
                }
            }

        }
        if(count==1){
            return false;
        }

        if(count==0){
            return true;
        }
        if(s1.charAt(index1)==s2.charAt(index2) && s1.charAt(index2)==s2.charAt(index1)){
            return true;
        }

        return false;
    }
}