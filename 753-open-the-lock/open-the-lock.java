class Pair{
    String str;
    int turns;

    Pair(String str, int turns){
        this.str=str;
        this.turns=turns;
    }

    public String getString(){
        return str;
    }

    public int getTurns(){
        return turns;
    }


}

class Solution {

    public ArrayList<String> getChildren(Pair pair){

        String str = pair.getString();
        int turns = pair.getTurns();

        String str1="";
        String str2="";

        ArrayList<String> list = new ArrayList<String>();

        for(int i=0;i<4;i++){
            char ch = str.charAt(i);
            int num=Character.getNumericValue(ch);
            int num1 = (num+1)%10;
            int num2 = (num-1+10)%10;

            if(i==0){
                 str1 = (char) (num1+'0')+ str.substring(1,str.length());
                 str2 = (char) (num2 +'0') + str.substring(1,str.length());   
            }else{
                str1 = str.substring(0, i) + (char)(num1+'0') + str.substring(i+1);
                str2 = str.substring(0,i) + (char)(num2+'0') + str.substring(i+1);
            }
            list.add(str1);
            list.add(str2);

        }


            return list;


    }


    public int openLock(String[] deadends, String target) {

        Set<String> visit = new HashSet<String>();
        int turns = 0;

        for (int i = 0; i < deadends.length; i++) {
            if (deadends[i].equals("0000")) {
               return -1;
            }
        }
        
            //else part
            visit.add("0000");

            for(int i=0;i<deadends.length;i++)
                visit.add(deadends[i]);


            Queue<Pair> queue = new ArrayDeque<Pair>();
            queue.add(new Pair("0000",0));

            String curr="";
            while(!queue.isEmpty()){
                Pair pair = queue.poll();
                curr= pair.getString();
                turns=pair.getTurns();

                if(curr.equals(target))
                    return turns;

                ArrayList<String> arr = getChildren(pair);

               for(String s:arr){
                   if(!visit.contains(s)){
         //           System.out.print(s+" ");
                          visit.add(s);
                          queue.add(new Pair(s,turns+1));
                    }
                 }
        }

        return -1;


    }
}