package leetcode;

import java.util.*;

public class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    public ListNode addNode(ListNode node, int val){
        if(node==null){
            node = new ListNode(val);
            return node;
        }
        ListNode head = node;
        if(node.next == null){
            node.next = new ListNode(val);
        }else{
            addNode(node.next,val);
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 1; i <=n; i++){
            fast  = fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode result = new ListNode(0, l1);
        int flag = 0;
        while(l1!=null&&l2!=null){
            int total = l1.val+l2.val+flag;
            flag = total/10;
            l1.val = total%10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            System.out.println("l1 not null");
            int total = l1.val+flag;
            flag = total/10;
            l1.val = total%10;
            l1 = l1.next;
        }

        while(l2!=null){
            System.out.println("l2 not null");
            int total = l2.val+flag;
            flag = total/10;
            ListNode temp =  new ListNode(total%10);
            l1 = temp;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(flag == 1){
            l1= new ListNode(1);
        }
        return result.next;
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while(current!=null&&current.next!=null){
            ListNode tmp = current.next;
            if(previous==null){
                head = tmp;
            }else {
                previous.next = tmp;
            }
            current.next = tmp.next;
            tmp.next = current;
            previous = current;
            current = current.next;
        }
        return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next ==null){
            return head;
        }
        int size =0;
        ListNode start = head;
        while(start!=null){
            start= start.next;
            size++;
        }
        k= k%size;
        for(int i = 1 ;i<=k;i++) {
            ListNode current = head;
            ListNode tail = null;
            ListNode newlast = null;
            while (current != null && current.next != null) {
                newlast = current;
                tail = current.next;
                current = current.next;
            }
            newlast.next = null;
            tail.next = head;
            head = tail;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null){
            return null;
        }
        ListNode temp = new ListNode(0 , head);
        ListNode curr = head;
        ListNode prev= temp;
        while(curr!=null){
            while(curr.next!=null && curr.val==curr.next.val){
                curr = curr.next;
            }
            if(prev.next == curr){
                prev= prev.next;
            }
            else{
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        curr = temp.next;
        return curr;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode start = null;
        ListNode prev = null;
        ListNode reverse = null;
        int count =0;
        while(curr !=null){
            count+=1;
            if(count == left){
                start = curr;
                prev = curr.next;
            }
            if(count ==right){
                reverse =curr;
                prev = curr.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
