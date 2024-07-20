class Solution {
    public void moveZeroes(int[] nums) {
        
        //Brute force

        // int arr2[] = new int[nums.length];

        // int index=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=0){
        //         arr2[index] = nums[i];
        //         index++;
        //     }
        // }

        // for(int i=index;i<arr2.length;i++){
        //     arr2[i] = 0;
        // }

        // for(int i=0;i<nums.length;i++){
        //     nums[i] = arr2[i];
        // }


    //2 pointer approach

    
        
    int j=-1;

    if(nums.length==1){
        return;
    }

    for(int i=0;i<nums.length;i++){         //TC = O(n) worst case
        if(nums[i]==0){
            j=i;
            break;
        }
    }

    if(j==-1){      //No 0's found
        return;
    }

    int n = nums.length;
    for(int i=j+1;i<n;i++){         //Tc = O(n-j)
        if(nums[i]!=0){          //swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j++;
        }
    }


    }
}