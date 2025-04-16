class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;

        List<String> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(String.valueOf(nums[i]));
        }

        Collections.sort(list, new StringComparator());

        StringBuilder retStr = new StringBuilder();

        if (list.get(0).equals("0")) {
            return "0";
        }
        for(int i=0;i<n;i++){
            retStr.append(list.get(i));
        }

        return retStr.toString();
    }
}

class StringComparator implements Comparator<String>{

    public int compare(String s1, String s2){
        String a = s1+s2;
        String b = s2+s1;
        return b.compareTo(a);
    }

}