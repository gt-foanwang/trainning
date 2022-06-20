package com.company.leetcode;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Node {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    public static ListNode deleteDuplicates(ListNode head) {
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

    public static String printNode(ListNode node, String result){
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

    public static void main(String[] args) throws IOException {
        int[] array1 = new int[]{9};
        int[] array2 = new int[]{1, 1, 2, 3, 3, 4, 4};
        ListNode node = new ListNode(array2[0]);
        addlist(array2, 1, node);
        ListNode temp = deleteDuplicates(node);
        System.out.println(printNode(temp, ""));
    }
}
