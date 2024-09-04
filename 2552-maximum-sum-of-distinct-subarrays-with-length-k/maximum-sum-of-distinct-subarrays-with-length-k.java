class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int n = arr.length;

        Set<Integer> set =new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        int j=0;
        int i=0;
        long sum=0;
        long max = 0;
        while(j<n){
            sum+=arr[j];
            set.add(arr[j]);
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                if(map.size()==k){
                    max = Math.max(max,sum);
                }
                sum-=arr[i];
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i])==0){
                    map.remove(arr[i]);
                }
                i++;
                j++;
            }

        }
        return max;
    }
}