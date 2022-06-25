package leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        ListNode result = head;
        ListNode temp = head.next, check = head;
        while(temp!=null) {
            if (temp.val != check.val) {
                check.next = temp;
                check = check.next;
            }
            temp = temp.next;
        }
        check.next = null;
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


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode getTreeNode(Integer[] array){
        TreeNode root = new TreeNode(array[0]);
        int i =0;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        while(left <= array.length-1) {
            if (array[left] != null) {
                TreeNode leftNode = new TreeNode(array[left]);
                System.out.println("left:"+array[left]);
                root.left = leftNode;
            }
            if (right < array.length) {
                if (array[right] != null) {
                    TreeNode rightNode = new TreeNode(array[right]);
                    System.out.println("right:"+array[right]);
                    root.left = rightNode;
                }
            }
            i++;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }
        return root;
    }



    public static List<Integer> inorderTraversal(TreeNode root){
        if(root==null){
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        result.add(root.val);
        if(root.left !=null){
            inorderTraversal(root.left);
        }
        if(root.right !=null){
            inorderTraversal(root.right);
        }
        return result;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q== null){
            return true;
        }
        if(p==null && q!=null){
            return false;
        }
        if(p!=null && q==null){
            return false;
        }
        if(p.val!= q.val){
            return false;
        }
        isSameTree(p.left, q.left);
        isSameTree(p.right, q.right);
        return true;
    }



    public static void main(String[] args) throws IOException {
        Integer[] array = new Integer[]{1, 2, 3};
        TreeNode root = getTreeNode(array);
        List<Integer> result = inorderTraversal(root);
        for(Integer i :result){
            System.out.print(i+ "");
        }

    }
}
