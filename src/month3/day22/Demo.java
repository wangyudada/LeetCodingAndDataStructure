package month3.day22;

import month2.day7.TreeNode;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn1 = new TreeNode(1,tn2,tn3);
        List<List<Integer>> list = new Solution().pathSum(tn1, 5);
        System.out.println();
    }
}
