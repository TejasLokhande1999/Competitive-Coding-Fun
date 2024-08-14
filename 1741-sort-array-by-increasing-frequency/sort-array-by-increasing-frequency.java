class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

    //Npw we have the frequesncy

    ArrayList<Pair> list = new ArrayList<>();

    //. <ele, freqy>
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        list.add(new Pair(entry.getKey(),entry.getValue()));
    }

    Collections.sort(list, new PairComparator());
    //[(ele, freq),(ele,freq)]
    // [(),()]

    int arr[] = new int[nums.length];
    int index=0;
    for(int i=0;i<list.size();i++){
        Pair p1 = list.get(i);
        int ele = p1.ele;
        int freq = p1.freq;

        for(int j=0;j<freq;j++){
            arr[index] = ele;
            index++;
        }
    }

    return arr;
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

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){

        if(p1.freq>p2.freq){
            return 1;
        }else if(p1.freq<p2.freq){
            return -1;
        }else{      //p1.freq==p2.freq
                //nor sprt in descending order of their value

                if(p1.ele>p2.ele){
                    return -1;
                }else if(p1.ele<p2.ele){
                    return 1;
                }else{      //p1.ele ==p2.ele
                    return 0;
                }

        }

    }
}