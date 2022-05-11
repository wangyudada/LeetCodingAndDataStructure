package month3.day2;

import month1.day4.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Codec {

    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(list, root);
        String s = list.toString();
        return s.substring(1, s.length() - 1);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] split = data.split(", ");
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < split.length; i++) {
            stack.push(Integer.parseInt(split[i]));
        }
        TreeNode construct = construct(0, 0, stack);
        return construct;
    }

    public void postOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(list, root.left);
        postOrder(list, root.right);
        list.add(root.val);
    }

    public TreeNode construct(int low, int up, Deque<Integer> stack) {
        if (stack.size() == 0 || stack.peek() < low || stack.peek() > up) {
            return null;
        }
        Integer val = stack.pop();
        TreeNode treeNode = new TreeNode(val);
        treeNode.right = construct(val, up, stack);
        treeNode.left = construct(low, val, stack);
        return treeNode;
    }
}
