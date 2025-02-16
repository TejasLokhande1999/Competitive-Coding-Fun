class Solution {
    public int numUniqueEmails(String[] emails) {
        Map<String,Set<String>> map = new HashMap<>();

        for(String email: emails){

            String[] arr = email.split("@");
            String domainName = arr[1];
            String localName = arr[0];

            String realLocalName = getLocalName(localName);

            map.putIfAbsent(domainName, new HashSet<>());
            map.get(domainName).add(realLocalName);
        }

        int count=0;
        for(Map.Entry<String, Set<String>> entry : map.entrySet()){
            Set<String> set = entry.getValue();
            count+=set.size();
        }

        return count;
    }

    public String getLocalName(String name){

        String str="";

        for(char ch : name.toCharArray()){

            if(ch=='.'){
                continue;
            }else if(ch=='+'){
                return str;
            }else{
                str+=ch;
            }

        }

        return str;


    }
}