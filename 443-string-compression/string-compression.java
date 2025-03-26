class Solution {
    public int compress(char[] chars) {
        
        if(chars.length==1){
            return 1;
        }
        int i=0;
        int j=0;
        int n  = chars.length;
        int thirdIndex = 0;
        String str="";
        while(j<n){

            if(chars[i]==chars[j]){
                j++;
            }else{
                //we don't habe the specified val;

                int index = j-1;

                if(index-i+1==1){
                    str+=chars[i];
                    i=j;
                }else{
                    int freq = index-i+1;
                    str+=chars[i];
                    str+=String.valueOf(freq);
                    i=j;
                }

            }

        }
                    int index = j-1;

                    int freq = index-i+1;
                    if (freq == 1) {
                        str += chars[i];
                    } else {
                        str += chars[i];
                        str += String.valueOf(freq);
                    }

                    // str+=chars[i];
                    // str+=String.valueOf(freq);
                    System.out.println(str);
                    for(int k=0;k<str.length();k++){
                        chars[k] = str.charAt(k);
                    }
                    return str.length();

    }
}