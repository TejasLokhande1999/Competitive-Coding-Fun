class Solution {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];

        Arrays.sort(nums);

        int i=0;
        int j=1;

        while(j<n){
            swap(i,j,n,nums);
            i+=2;
            j+=2;
        }

        return nums;

    }

    public void swap(int i, int j, int n, int arr[]){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}