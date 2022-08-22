package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    public class TreeNode {
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




  List<Integer> result = new ArrayList<Integer>();
  public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        if(root.left!=null){
            inorderTraversal(root.left);
        }
        result.add(root.val);
        if(root.right !=null){
            inorderTraversal(root.right);
        }
        return result;
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q ==null){
            return true;
        }

        if(p == null&& q!=null){
            return false;
        }
        if(q ==null && p!=null ){
            return false;
        }

        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left , q.left) && isSameTree(p.right , q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        return checkSymmetric(root.right, root.left);
    }
        public boolean checkSymmetric(TreeNode p, TreeNode q){
        if(p == null && q ==null){
            return true;
        }

        if(p == null&& q!=null){
            return false;
        }
        if(q ==null && p!=null ){
            return false;
        }

        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left , q.left) && isSameTree(p.right , q.right);
    }

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
    public int maxDepth(TreeNode node, int level){
        if(node==null){
            return level;
        }
        int left = maxDepth(node.left, level+1);
        int right = maxDepth(node.left, level+1);
        return Math.max(left, right);
    }
    boolean isBalance;
    public boolean isBalanced(TreeNode root) {
        isBalance = true;
        height(root, 0);
        return isBalance;
    }

    public int height(TreeNode node, int level){
        if(node==null){
            isBalance = false;
        }
        if(node.left==null){
            isBalance = false;
        }

        if(node.right==null){
            isBalance = false;
        }

        int left = height(node.left, level+1);
        int right = height(node.right, level+1);
        if(Math.abs(left-right)> 1){
            isBalance = false;
        }
        return Math.max(left, right);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        findPaths(root, list, "");
        return list;
    }

    public void findPaths(TreeNode root, List<String> list, String path) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            path = path + root.val;
            list.add(path);
            return;
        }
        findPaths(root.left, list, path+root.val+"->");
        findPaths(root.right, list, path+root.val+"->");
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = findDeep(root.left, 0);
        int right = findDeep(root.right, 0);
        return right+left;
    }
    public int findDeep(TreeNode node, int len){
        if(node==null){
            return len;
        }
        int left = findDeep(node.left, len);
        int right = findDeep(node.right, len);
        len = Math.max(len, right+left);
        return Math.max(left, right)+1;
    }

    //Maximum Depth of N-ary Tree
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        return dfs(root);
    }

    public int dfs(Node root){
        if(root == null){
            return 0;
        }
        int res = 1;
        int t = 0;
        for(Node node : root.children){
            t = Math.max(t, dfs(node));
        }
        return res + t;
    }

    public int findTilt(TreeNode root) {
        int s=tilt(root);
        return tilt;
    }
    int tilt =0;
    public int tilt(TreeNode root){
        if(root==null){
            return 0;
        }

        int l = tilt(root.left);
        int r = tilt(root.right);

        tilt+=Math.abs(r-l);
        return root.val +l+r;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean isSubtree = false;
        if(root == null){
            return false;
        }
        if(root.val==subRoot.val){
            if(root.left==null&& subRoot.left!=null){
                return false;
            }

            if(root.right!=null&& subRoot.right!=null){
                return false;
            }
        }
        if(root.left!=null){
            isSubtree(root.left, subRoot);
        }else{
            return false;
        }

        if(root.right!=null){
            isSubtree(root.right, subRoot);
        }else{
            return false;
        }

        return true;
    }


}
