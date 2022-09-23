package leetcode;

public class TreeNode {
    public TreeNode BTSRoot = null;
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public void BSTInsert(int value){
        BTSRoot =  BSTInsert(BTSRoot, value);
    }
    public TreeNode BSTInsert(TreeNode node, int value){
        if(node == null){
            node = new TreeNode(value);
            return node;
        }else if(node.val > value){
            node.left = BSTInsert(node.left, value);
        } else if (node.val < value) {
            node.right =BSTInsert(node.right, value);
        }
        return node;
    }
    public void printTree(TreeNode root){
        if(root == null){
            System.out.print("null ");
            return;
        }
        System.out.print(root.val+" ");
        if(root.left!=null)
            printTree(root.left);
        if(root.left!=right)
            printTree(root.right);
    }
}