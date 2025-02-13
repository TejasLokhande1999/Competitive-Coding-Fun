class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> indices = new ArrayList<>();


        for(int i=0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1!=ch2){
                indices.add(i);
            }
        }

        if(indices.size()>2 || indices.size()==1){
            return false;
        }

        if(indices.size()==0){
            return true;
        }

        //indices.length==2
        int i = indices.get(0);
        int j = indices.get(1);

        if(s1.charAt(i)==s2.charAt(j) && s1.charAt(j)==s2.charAt(i)){
            return true;
        }


        return false;

    }
}