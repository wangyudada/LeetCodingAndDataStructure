package Day4;

public class Tree {
    private Node root;

    /**
     * 插入二叉树
     *
     * @param iData
     * @param dData
     */
    public void insert(int iData, double dData) {
        Node node = new Node();
        node.iData = iData;
        node.dData = dData;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (iData < current.iData) {
                    current = current.leftNode;
                    if (current == null) {
                        parent.leftNode = node;
                        return;
                    }
                } else {
                    current = current.rightNode;
                    if (current == null) {
                        parent.rightNode = node;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 查找关键字
     *
     * @param key
     * @return
     */
    public Node find(int key) {
        Node current = root;
        while (root.iData != key) {
            if (current != null) {
                if (key < current.iData) {
                    current = current.leftNode;
                } else {
                    current = current.rightNode;
                }
                if (root == null) {
                    return null;
                }
            } else {
                return null;
            }
        }
        return current;
    }

    /**
     * 最值查找
     *
     * @return
     */
    public Node[] mVal() {
        Node minNode = null;
        Node maxNode = null;
        Node[] nodes = new Node[2];
        Node current = root;
        while (current != null) {
            minNode = current;
            current = current.leftNode;
        }
        nodes[0] = minNode;
        current = root;
        while (current != null) {
            maxNode = current;
            current = current.rightNode;
        }
        nodes[1] = maxNode;
        return nodes;
    }


}
