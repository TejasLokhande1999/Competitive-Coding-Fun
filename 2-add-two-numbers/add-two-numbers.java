/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        String num11="";
        String num22="";
        while(l1!=null){
            int num;
            num = l1.val;
            num11+=String.valueOf(num);
            l1=l1.next;
        }

        while(l2!=null){
            int num;
            num = l2.val;
            num22+=String.valueOf(num);
            l2=l2.next;
        }

           String num1 = reverse(num11);
         String num2 = reverse(num22);

    System.out.println(num1+" "+num2);
        ListNode head = null;
        ListNode node = null;

        int length=0;
        int carry=0;
        int num;
        if(num1.length()>num2.length()){
            length=num2.length()-1;
            for(int i=num1.length()-1;i>=0;i--){
                if(length>=0)
                    num=Character.getNumericValue(num1.charAt(i)) +  Character.getNumericValue(num2.charAt(length))+carry;
                else
                    num=Character.getNumericValue(num1.charAt(i)) + carry;
                if(num>=10){
                    num=num%10;
                     ListNode new_node = new ListNode(num);
                    if(head==null){
                        head=new_node;
                        node=new_node;
                    }else{
                        node.next=new_node;
                        node = new_node;
                    }
                    carry=1;
                }else{
                    ListNode new_node = new ListNode(num);
                    if(head==null){
                        head=new_node;
                        node=new_node;
                    }else{
                        node.next=new_node;
                        node = new_node;
                    }
                    carry=0;
                }

                length-=1;

            }
            if(carry==1){
                ListNode new_node = new ListNode(carry);
                    if(head==null){
                        head=new_node;
                        node=new_node;
                    }else{
                        node.next=new_node;
                        node = new_node;
                    }
            }

        }else{      //num2>num1(length)
            
            length=num1.length()-1;
            for(int i=num2.length()-1;i>=0;i--){
                if(length>=0)
                    num=Character.getNumericValue(num1.charAt(length)) +  Character.getNumericValue(num2.charAt(i))+carry;
                else
                    num=Character.getNumericValue(num2.charAt(i)) + carry;
                if(num>=10){
                    num=num%10;
                     ListNode new_node = new ListNode(num);
                    if(head==null){
                        head=new_node;
                        node=new_node;
                    }else{
                        node.next=new_node;
                        node = new_node;
                    }
                    carry=1;
                }else{
                    ListNode new_node = new ListNode(num);
                    if(head==null){
                        head=new_node;
                        node=new_node;
                    }else{
                        node.next=new_node;
                        node = new_node;
                    }
                    carry=0;
                }

                length-=1;

            }
                if(carry==1){
                ListNode new_node = new ListNode(carry);
                    if(head==null){
                        head=new_node;
                        node=new_node;
                    }else{
                        node.next=new_node;
                        node = new_node;
                    }
            }

        }

    return head;

        // String rev1 = reverse(num1);
        // String rev2 = reverse(num2);

        // BigInteger num11 = new BigInteger(rev1);
        // BigInteger num22 = new BigInteger(rev2);

        // BigInteger num3 = num11.add(num22);

        // String strTemp = reverse(String.valueOf(num3));

        // ListNode head=null;
        // ListNode node=null;

        // for(int i=0;i<strTemp.length();i++){

        //     char ch = strTemp.charAt(i);
        //     int val = Integer.parseInt(String.valueOf(ch));
        //     ListNode new_node = new ListNode(val);
        //     if(head==null){
        //         head=new_node;
        //         node=new_node;
        //     }else{
        //         node.next=new_node;
        //         node = new_node;
        //     }

        // }

        // return head;


    }

    // public String reverse(String str){
    //     String retStr="";

    //     for(int i=0;i<str.length();i++){
    //         char ch = str.charAt(i);
    //         retStr+= ch+retStr;
    //     }
    //     return retStr;
    // }

    public String reverse(String str) {
    StringBuilder retStr = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
        retStr.append(str.charAt(i));
    }
    return retStr.toString();
}
}