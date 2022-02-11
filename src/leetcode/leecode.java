package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leecode {
   
	public int numJewelsInStones(String J, String S) {
        int reply = 0;
        Set<Character> jset = new HashSet<Character>();
        for(int i = 0;i < J.length();i++){
            jset.add(J.charAt(i));
        }
        for(int i = 0; i < S.length();i++){
            if(jset.contains(S.charAt(i))){
                reply+=1;
            }
        }
        return reply; 
    }
  
  	public int numUniqueEmails(String[] emails) {
  		Set<String> check =  new HashSet<String>();
  		for(int i = 0; i < emails.length; i++) {
  			String localname = emails[i].substring(0, emails[i].indexOf('@'));
  			String domain = emails[i].substring(emails[i].indexOf('@'), emails[i].length());
  			if(localname.contains("+")) {
  				localname=localname.substring(0, localname.indexOf("+"));
  			}
  			localname = localname.replace(".","");
  			check.add(localname+domain);
  		}
  		for(String parm: check) {
  			System.out.println(parm);
  		} 
  		return check.size();
    }
	public String toLowerCase(String str) {
		
  		return str.toLowerCase();
    }
	
    public int uniqueMorseRepresentations(String[] words) {
    	String[] morse= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    	Set<String> reply = new HashSet<String>();
    	for(String str: words) {
    		char[] chararray = str.toCharArray();
    		String tes ="";
    		for(int i = 0; i< chararray.length; i++) {
    			tes += morse[(int)chararray[i]-(int)'a'];
    		}
    		reply.add(tes);
    	}
    	return reply.size();
    }
    
    public int[] sortArrayByParity(int[] A) {
    	int pos = 0;
    	for(int i = 0;i < A.length; i++){
    		if(A[i] % 2 == 0) {
    			int temp = A[i];
    			A[i] = A[pos];
    			A[pos] = temp;
    			pos+=1;
    		}
    	}
    	return A;
    }
    
    public int hammingDistance(int x, int y) {
    	int count = 0;
		int value = x ^ y;
		while(value != 0) {
			count+=1;
			value &= value -1;
		}
    	return count;
    }    
    
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	if(t1 == null & t2 ==null) {
    		return null;
    	}
    	t1.left = mergeTrees(t1.left == null? null: t1.left, t2.left == null?null:t2.left);
    	t1.right = mergeTrees(t1.right == null? null: t1.right, t2.right == null?null:t2.right);
    	
    	return t1;
    
    }
    
    
   	public List<Integer> selfDividingNumbers(int left, int right) {
   		List<Integer> selflist = new ArrayList<Integer>();
   		for(int i = left; i <= right; i++) {
   			int quot = i;//商
   			int flag = 1;
   			while(quot > 0 && flag == 1) {
   				int target = i % 10;//餘數
   				if(target != 0 && (i % target) == 0){
   					quot /= 10;
   					target = quot%10;
   				}else{
   					flag = 0;
   				}
   			}
   			if(flag ==1) {
   				selflist.add(i);
   			}
   		}
   		return selflist;
    }
    //偶奇偶奇
   	public int[] sortArrayByParityII(int[] A) {
   		int evenindex =  0;
   		int oddindex = 1;
   		int[]  reply  = new int[A.length];
   		for(int i = 0; i < A.length; i++) {
   			if(A[i] %2== 0) {
   				reply[evenindex] = A[i];
   				evenindex+=2;
   			}else {
   				reply[oddindex] = A[i];
   				oddindex+=2;
   			}
   		}
   		return reply;
    }
   	public int[][] transpose(int[][] A) {
   		int[][] reply  = new int[A[0].length][A.length];
   		for(int i = 0; i < A.length; i++) {
   			for(int j = 0; j < A[0].length;j++) {
   				reply[j][i] = A[i][j];
   			}
   		}
   		return reply;
    }
   	
   	public int smallestRangeI(int[] A, int K) {
   		
   		return 1;
    }
   	class Node {
   	    public int val;
   	    public List<Node> children;

   	    public Node() {}

   	    public Node(int _val,List<Node> _children) {
   	        val = _val;
   	        children = _children;
   	    }
   	};
   	
   	public List<Integer> preorder(Node root) {
   		List<Integer> reply = new ArrayList<Integer>();
   		if(root==null) {
   			return reply;
   		}
   		reply.add(root.val);
   		List<Node> childrenlist =root.children;
   		for(int i  = 0; i < childrenlist.size(); i++) {
   			reply = addValueBypreorder(childrenlist.get(i), reply);
   		}
   		return reply;
    }
   	public List<Integer> addValueBypreorder(Node root, List<Integer> list){
   		if(root!=null) {
   			list.add(root.val);
   		}
   		if(null !=root.children) {	
	   		for(int i  = 0; i < root.children.size(); i++) {
	   			list = addValueBypreorder(root.children.get(i), list);
	   		}
   		}
   		return list;
   	}
   	List<Integer> reply = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
    
   		if(root==null) {
   			return reply;
   		}
   		for(Node node: root.children){
   			postorder(node);
   		}
   		reply.add(root.val);
   		return reply;
    }
    
    public TreeNode searchBST(TreeNode root, int val) {
    	if(root == null){
    		return null;
    	}
    	if (root.val == val ) {
    		return root;
    	}
    	TreeNode reply = searchBST(root.left, val);
    	if(reply == null) {
    		return searchBST(root.right, val);
    	}else {
    		return reply;
    	}
    	
    }
    
    public ListNode middleNode(ListNode head) {
    	if(head ==  null) {
    		return null;
    	}
    	int count = 1;
    	ListNode next= head;
    	while(next!=null) {
    		count+=1;
    		next =  next.next;
    	}
    	ListNode reply = head;
    	int mid = count/2;
    	while(count>0){
    		count-=1;
    		reply = reply.next;
    	}
    	
    	return reply;
    }
 
    public String reverseWords(String s) {
    	String[] reply = s.split(" ");
    	final StringBuilder result = new StringBuilder();
    	StringBuilder word = new StringBuilder();
    	Showfunction(reply);
    	for(String temp: reply) {
    		word = new StringBuilder();
    		word.append(temp);
    		word.reverse();
    		result.append(word);
    		result.append(" ");
    	}
    	result.delete(result.length()-1, result.length());
    	return result.toString();
    }
    
    public int[] numberOfLines(int[] widths, String S) {
    	int[] reply = new int[widths.length];
    	
    	return reply;
    }
    
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
	
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(){};    	
    	ListNode(int x) { val = x; }
    }
   	
    public static void ShowfunctionForInt(int[] input) {
    	int count = 0;
    	for(int temp: input) {
    		System.out.println("input["+count+"]: "+ temp);
    		count+=1;
    	}
    }
    
    public static < T > void Showfunction(T[] input) {
    	int count = 0;
    	for(T temp:input) {
    		System.out.println("input["+count+"]: "+ temp);
    		count+=1;
    	}
    }
    
	public static void main(String[] args) {
		leecode temp = new leecode();
		Integer[] intarry = new Integer[]{3,1,2,4};
		System.out.println(temp.reverseWords("Let's take LeetCode contest"));
		
		
	}
}
