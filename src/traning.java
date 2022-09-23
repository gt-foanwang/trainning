
import leetcode.*;

import java.io.IOException;
import java.util.Arrays;

public class traning {
    public static void main(String[] args) throws IOException {
        LeetTree treefunction = new LeetTree();
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = treefunction.sortedArrayToBST(nums);
        root.printTree(root);
    }
}
