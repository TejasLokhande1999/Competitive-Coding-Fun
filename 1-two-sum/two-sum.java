class Solution {
    public int[] twoSum(int[] nums, int k) {

        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // int retArr[] = new int[2];
        // for(int i=0;i<nums.length;i++){
        //     if(map.containsKey(k-nums[i])){     //we have the target-ele
        //         retArr[0] = map.get(k-nums[i]);
        //         retArr[1] = i;

        //         return retArr;

        //     }

        //     if(!map.containsKey(nums[i])){
        //         map.put(nums[i],i);
        //     }
        // }

        // return retArr;


        ArrayList<Pair> list = new ArrayList<Pair>();
        for(int i=0;i<nums.length;i++){
            list.add(new Pair(nums[i],i));
        }


        Collections.sort(list, new PairComparator());

        int i=0;
        int n = nums.length;
        int j=n-1;

        int retArr[] = new int[2];
        while(i<j){
            int sum = list.get(i).ele + list.get(j).ele;

            if(sum==k){
                retArr[0] = list.get(i).index;
                retArr[1] = list.get(j).index;
                return retArr;
            }else if(sum>k){
                j--;
            }else{  //sum<k
                i++;
            }

        }

        return retArr;


       
    }
}

class Pair{

    int ele;
    int index;

    Pair(int ele, int index){
        this.ele = ele;
        this.index=index;
    }

}

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){
        if(p1.ele>p2.ele){
            return 1;
        }else if(p1.ele<p2.ele){
            return -1;
        }else{
            return 0;
        }
    }
}
