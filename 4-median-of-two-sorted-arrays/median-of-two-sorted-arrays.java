class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // int k = nums1.length + nums2.length;

        // int i=0;
        // int j=0;
        // int n1 = nums1.length;
        // int n2 = nums2.length;

        // int index1 = (n1+n2)/2;
        // int index2 = index1-1;      
        // int ele1 = -1;
        // int ele2 = -1;  

        // int count=0;

        // while(i<n1 && j<n2){

        //     if(nums1[i]<nums2[j]){
        //         if(count==index1){
        //             ele1 = nums1[i];
        //         }
        //         if(count==index2){
        //             ele2 = nums1[i];
        //         }
        //         i++;
        //         count++;        
        //     }else{
        //         if(count==index1){
        //             ele1 = nums2[j];
        //         }
        //         if(count==index2){
        //             ele2 = nums2[j];
        //         }
        //         j++;
        //         count++;        
        //     }

        // }

        // while (i < n1) {
        //     if (count == index1) ele1 = nums1[i];
        //     if (count == index2) ele2 = nums1[i];
        //     count++;
        //     i++;
        // }
        // while (j < n2) {
        //     if (count == index1) ele1 = nums2[j];
        //     if (count == index2) ele2 = nums2[j];
        //     count++;
        //     j++;
        // }

        // if((n1+n2)%2==1){
        //     return (double)ele1;
        // }

        // return (double)(ele1+ele2)/2;



        int i=0;
        int j=0;
        int n1 = nums1.length;
        int n2 = nums2.length;    
                int arr[] = new int[n1+n2];


    int k=0;
        while(i<n1 && j<n2){

            if(nums1[i]<=nums2[j]){
                arr[k] = nums1[i];
                i++;
            }else{
                arr[k]=nums2[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k]=nums1[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k] = nums2[j];
            j++;
            k++;
        }

        if((n1+n2)%2==1){
            return (double)arr[(n1+n2)/2];
        }else{
            int in = (n1+n2)/2;
            return (double)(arr[in] +arr[in-1])/2;

        }



    }
}