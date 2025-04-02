class Solution {
    public int[] frequencySort(int[] nums) {
         Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        int n = nums.length;

    ArrayList<Pair> list = new ArrayList<>();

    
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(new Pair(entry.getKey(),entry.getValue()));
        }

    Collections.sort(list, (a,b)->{

        if(a.freq!=b.freq){
            return a.freq-b.freq;
        }
        //else 

        return b.ele-a.ele;

    });

    int retArr[] = new int[n];

    int index = 0;

    for(int i=0;i<list.size();i++){
        Pair p = list.get(i);
        int freq =p.freq;
        int ele = p.ele;
        for(int j=0;j<freq;j++){
            retArr[index] = ele;
            index+=1;
        }
    }
    

    return retArr;

    }
}

class Pair{
    int ele;
    int freq;
    Pair(int ele, int freq){
        this.ele = ele;
        this.freq= freq;
    }
}