package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetTree {

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
        if(root == null){
            return false;
        }
        if(subRoot ==null){
            return true;
        }
        return isSameTree(root, subRoot)||isSubtree(root.left, subRoot)||isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot){
        if (subRoot == null)
            return root == null;
        if(root ==null)
            return subRoot == null;
        if (root.val != subRoot.val)
            return false;
        return isSameTree(root.left, subRoot.left)&&isSameTree(root.right, subRoot.right);
    }

    public List<Integer> postorder(Node root) {
        if(root==null){
            return result;
        }
        for(int i =0;i< root.children.size();i++){
            postorder(root.children.get(i));
        }
        result.add(root.val);
        return result;
    }

    public String tree2str(TreeNode root) {
            String result= "";
            if(root ==null){
                return "";
            }
            result +=  String.valueOf(root.val);
            if(root.left==null&&root.right==null){
                return root.val+"";
            }

            if(root.right==null){
                return root.val+"("+tree2str(root.left)+")";
            }
            return root.val+"("+tree2str(root.left)+")"+"("+tree2str(root.right)+")";
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null && root2 != null){
            return root2;
        }

        if(root2 == null && root1 != null){
            return root1;
        }
        TreeNode temp = root1;
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return temp;
    }


    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Double> list = new ArrayList<Double>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for(int i=0;i< size;i++){
                TreeNode curr= queue.poll();
                sum+=curr.val;
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }
            list.add(Double.valueOf(sum/size));
        }
        return list;
    }

    public int maxDepth(TreeNode node, int level){
        if(node==null){
            return level;
        }
        int left = maxDepth(node.left, level+1);
        int right = maxDepth(node.left, level+1);
        return Math.max(left, right);
    }


    List<Integer> list = new ArrayList<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        if(root ==null){
            return false;
        }
        help(root);
        int start = 0;
        int end = list.size() - 1;
        while(start < end)
        {
            int mid = start + (end - start)/2;
            int sum = list.get(start) + list.get(end);
            if(k == sum)
            {
                return true;
            }
            if(sum < k)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return false;
    }

    public void help(TreeNode node){
        if(node == null){
            return;
        }
        if(node.left!=null){
            help(node.left);
        }
        list.add(node.val);
        if(node.right!=null){
            help(node.right);
        }
    }


    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(root.val>val){
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }
    int minDiffinBST= Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root==null){
            return minDiffinBST;
        }
        if(root.left!=null){
            minDiffInBSTHelp(root, root.left);
            minDiffInBST(root.left);
        }
        if(root.right!=null){
            minDiffInBSTHelp(root, root.right);
            minDiffInBST(root.right);
        }
        return minDiffinBST;
    }

    public void minDiffInBSTHelp(TreeNode node1, TreeNode node2){
        minDiffinBST = Math.min(minDiffinBST, Math.abs(node1.val- node2.val));
        if(node2.left!=null){
            minDiffInBSTHelp(node1,node2.left);
        }

        if(node2.right!=null){
            minDiffInBSTHelp(node1,node2.right);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null&&root2==null){
            return true;
        }
        List<Integer> root1list = new ArrayList<>();
        List<Integer> root2list = new ArrayList<>();
        helper(root1, root1list);
        helper(root2, root2list);
        if(root1list.size()!=root2list.size())
            return false;
        for(int i =0; i<root1list.size();i++){
            if(root1list.get(i)!=root2list.get(i)){
                return false;
            }
        }
        return true;
    }

    public void helper(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            list.add(root.val);
        }
        if(root.left!=null){
            helper(root.left, list);
        }
        if(root.right!=null){
            helper(root.right, list);
        }
    }

    public void levelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode current = q.peek();
            q.poll();
            System.out.print(current.val+"->");

            if(current.left!=null){
                q.add(current.left);
            }
            if(current.right!=null){
                q.add(current.right);
            }
        }
    }

    public void inOrderBST(TreeNode node){
        if(node!=null){
            inOrderBST(node.left);
            System.out.println(node.val);
            inOrderBST(node.right);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortHelp(nums, 0, nums.length-1);
    }

    public TreeNode sortHelp(int[] nums,int start, int end){
        if(end < start){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortHelp(nums, start, mid-1);
        root.right = sortHelp(nums, mid+1, end);
        return root;
    }

}
