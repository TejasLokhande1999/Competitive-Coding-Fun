class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        List<List<Integer>> aList = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;

            int j = i+1;
            int k=n-1;

            while(j<k){

                int sum = arr[i]+arr[j]+arr[k];

                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{      //sum==0

                    ArrayList<Integer> list = new ArrayList<>();

                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);

                    aList.add(list);

                    j++;
                    k--;

                    //Now even if we incrememnt j and k, tjey might end up being the same so check again
                    while(j<k && arr[j]==arr[j-1]) j++;
                    while(j<k && arr[k]==arr[k+1]) k--;
                }

            }
        }       

        return aList;

    }
}