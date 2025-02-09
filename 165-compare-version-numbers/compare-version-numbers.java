class Solution {
    public int compareVersion(String version1, String version2) {
        
        String str1[] = version1.split("\\.");
        String str2[] = version2.split("\\.");
        int s1Lgt = str1.length;
        int s2Lgt = str2.length;
        int n = Math.max(str1.length,str2.length);

        for(int i=0;i<n;i++){

            int num1 = s1Lgt<= i ? 0 : Integer.parseInt(str1[i]);
            int num2 = s2Lgt<= i ? 0: Integer.parseInt(str2[i]);

            if(num1<num2){
                return -1;
            }else if(num1>num2){
                return 1;
            }

        }

        return 0;

    }
}