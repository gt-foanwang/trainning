package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ListFunction {

//    public ListNode addNode(ListNode node, int val){
//        if(node==null){
//            node = new ListNode(val);
//            return node;
//        }
//        ListNode head = node;
//        if(node.next == null){
//            node.next = new ListNode(val);
//        }else{
//            addNode(node.next,val);
//        }
//        return head;
//    }


    public int getDecimalValue(ListNode head) {
        Stack<Integer> vals = new Stack<Integer>();
        ListNode temp = head;
        while(temp !=null){
            vals.push(temp.val);
            temp = temp.next;
        }
        int result = 0;
        int count= 0;
        while(!vals.empty()){
            int check = vals.pop();
            if(check ==1){
                result += Math.pow(2, count);
            }
            count+=1;
        }
        return result;
    }

    public boolean hasCycle(ListNode head) {

        if(head==null || head.next==null)
            return false;

        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){

            slow=slow.next;
            fast=fast.next.next;
            System.out.println("slow:"+slow.val+" fast:"+fast.val);
            if(slow==fast){
                return true;
            }
        }

        return false;
    }
    public static ListNode removeElements(ListNode head, int val) {
        if(head==null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            if(curr.val == val){
                if(head == curr){
                    head = head.next;
                }else{
                    prev.next = curr.next;
                    curr = head;
                }
            }
                prev = curr;
                curr = curr.next;
        }
        return head;
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head,
                prev = null,
                reversed = null;

        while (curr != null) {
            ListNode next = curr.next;

            if (curr.next == null) {
                reversed = curr;
            }
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return reversed;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return false;
        }
        Stack<Integer> check = new Stack<Integer>();
        ListNode temp = head;
        while(temp!=null){
            check.push(temp.val);
            temp = temp.next;
        }
        while(!check.empty()){
            if(head.val!=check.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
            if(head==null){
                return false;
            }
            Stack<Integer> check = new Stack<Integer>();
            ListNode temp = head;
            int len = 0;
            while(temp!=null){
                len+=1;
                temp = temp.next;
            }
            for(int i =0;i < len/2;i++){
                System.out.println(head.val);
                check.push(head.val);
                head= head.next;
            }
            if(len%2==1){
                head= head.next;
            }
            while(!check.empty()){
                if(head.val!=check.pop()){
                    return false;
                }
                head = head.next;
            }

            return true;
    }

    public void printNode(ListNode node){
       while(node!=null){
           System.out.print(node.val);
           node = node.next;
           if(node!=null){
               System.out.print("->");
           }
       }
        System.out.println("");
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
       ListNode result = new ListNode();
        result = head;
        Set<Integer> check = new HashSet<>();
        while(head.next!=null){
            if(!check.contains(head.next.val)){
                check.add(head.next.val);
                result.next = head.next;
                result = deleteDuplicates(result.next);
            }else{
                ListNode temp = head.next;
                result.next = temp.next;
                result= deleteDuplicates(result.next);
            }
        }
        return result;
    }

    public static ListNode addlist(int[] arr, int side, ListNode node){
        if (side < arr.length){
            ListNode temp = new ListNode(arr[side]);
            node.next = temp;
            addlist(arr, side+1, node.next);
        }
        return node;
    }

    public String printNode(ListNode node, String result){
        if(result.equals("")){
            result += node.val;
        }else {
            result += " -> " + node.val;
        }
        if(node.next!=null) {
            result = printNode(node.next, result);
        }
        return result;
    }
}
