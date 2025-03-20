class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        List<String> letter = new ArrayList<>();

        List<String> digit = new ArrayList<>();

        for(int i=0;i<logs.length;i++){
            String str = logs[i];
            char ch = str.charAt(str.length()-1);
            if(Character.isDigit(ch)){
                digit.add(str);
            }else{
                letter.add(str);
            }
        }

       // Collections.sort(digit);
        List<Pair> pairList = new ArrayList<>();
        for(String str : letter){
            int index = str.indexOf(" ");
            String str1 = str.substring(0,index);
            String str2 = str.substring(index,str.length());
            pairList.add(new Pair(str1,str2));
        
        }

        Collections.sort(pairList, new StringComparator());
        List<String> finalLetterList = new ArrayList<>();

        for(Pair p : pairList){
            String str1 = p.getIdentifier();
            String str2 = p.getContent();

        String finalStr = str1+str2;
        finalLetterList.add(finalStr);

        }

        finalLetterList.addAll(digit);
        String retArr[] = finalLetterList.toArray(new String[finalLetterList.size()]);
        return retArr;
    }
}

class StringComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){
        int result = p1.getContent().compareTo(p2.getContent());

        if(result!=0){
            return result;
        }

        return p1.getIdentifier().compareTo(p2.getIdentifier());
    }

}

public class Pair{

    String identifier;
    String content;

    Pair(String id, String con){
        this.identifier = id;
        this.content = con;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getContent() {
        return content;
    }

}