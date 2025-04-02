class Solution {
    public String fractionToDecimal(int nume, int deno) {

        if (nume == 0) return "0";

        StringBuilder str = new StringBuilder();
        int sign = 1;

        if(nume<0 && deno<0)
        {
            sign =1;
        }else if(nume<0 || deno<0){
            sign=-1;
        }
               // Convert to long to avoid overflow
        long num = Math.abs((long) nume);
        long den = Math.abs((long) deno);

        if(sign==-1)
            str.append("-");
        str.append(num/den);
        long rem = num%den;

        if(rem==0)
            return str.toString();

        
        str.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while(rem!=0){

            if(map.containsKey(rem)){
                
                int index = map.get(rem);
                str.insert(index,"(");

                str.append(")");
                break;
            }
            map.put(rem,str.length());
            rem =rem*10;
            str.append(rem/den);
            rem = rem%den;

        }

        

        return str.toString();
    }
}