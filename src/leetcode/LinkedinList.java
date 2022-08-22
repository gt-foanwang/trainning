package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class LinkedinList {

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode temp = new ListNode(head.val);
        ListNode result = temp;
        while(head.next!=null){
            System.out.println("result.val:"+temp.val+"  head.next.val"+head.next.val);
            if(temp.val != head.next.val){
                temp.next = new ListNode(head.next.val);
                temp = temp.next;
            }
            head.next = head.next.next;
        }
        return result;
    }
    public static boolean hasCycle(ListNode head) {

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

        ListNode node = head,
                prev = null,
                reversed = null;

        while (node != null) {
            ListNode next = node.next;

            if (node.next == null) {
                reversed = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }

        return reversed;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head,
                prev = null,
                reversed = null;

        while (node != null) {
            ListNode next = node.next;

            if (node.next == null) {
                reversed = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }
        return reversed;
    }

    public static boolean isPalindrome(ListNode head) {
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

    public static boolean isPalindrome2(ListNode head) {
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

    public static void printNode(ListNode node){
       while(node!=null){
           System.out.print(node.val);
           node = node.next;
           if(node!=null){
               System.out.print("->");
           }
       }
    }

    public static void main(String[] args) {
            ListNode temp = new ListNode(1);
            temp.next =  new ListNode(0);
            temp.next.next =  new ListNode(1);
//            temp.next.next.next =  new ListNode(1);
//            temp.next.next.next.next =  new ListNode(1);
//            temp.next.next.next.next.next.next = new ListNode(6);
//            printNode( isPalindrome(temp));
        System.out.println(isPalindrome2(temp));
    }
}
