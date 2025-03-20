class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int i=0;
        int j=0;
        int m = nums1.length;
        int n = nums2.length;
        int maxLen = 0;

        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){


                while(i<m && j<n && nums1[i]<=nums2[j]){
                    j++;
                }
                maxLen = Math.max(maxLen,j-i-1);
                i++;

            }else{
                i++;
                j++;
            }
        }

        return maxLen;
    }
}