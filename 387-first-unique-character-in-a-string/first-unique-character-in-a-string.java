class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        char arr[] = s.toCharArray();
        char ch='0';

        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(arr[i]))
            {
                int val = map.get(arr[i]);
                map.put(arr[i],val+1);
            }else{
                map.put(arr[i],1);
            }
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            int val = entry.getValue();
            if(val==1)
            {
             ch = entry.getKey();
                break;
            }
        }

        for(int i=0;i<arr.length;i++)
        {
            if(ch==arr[i])
            {
                return i;
            }
        }


return -1;
    }
}