package Day5;

public class AVLNode {

    public AVLNode parent;
    public AVLNode leftChild, rightChild;
    public int data;
    private AVLNode root;

    public AVLNode(AVLNode parent, AVLNode leftChild, AVLNode rightChild, int data) {
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public AVLNode(int data) {
        this(null, null, null, data);
    }

    public AVLNode(AVLNode parent, int data) {
        this.parent = parent;
        this.data = data;
    }

    //    右旋转
    public AVLNode rightRotation(AVLNode node) {
//        先确保node不为空
        if (node != null) {
//            分配空间
            AVLNode leftChild = node.leftChild;
//            如果leftChild的右子节点不为空，则先将此右子节点的父节点指向node
            node.leftChild = leftChild.rightChild;
            if (leftChild.rightChild != null) {
                leftChild.rightChild.parent = node;
            }
//            将leftChild的父节点指向node的父节点
            leftChild.parent = node.parent;
            if (node.parent == null) {
//                如果node的父节点为空，则将leftChild的父节点指向根节点
                this.root = leftChild;
//                如果node在其父节点的右子树中，则将其父节点的右子树指向为leftChild
            } else if (node.parent.rightChild == node) {
                node.parent.rightChild = leftChild;
//                反之亦然
            } else if (node.parent.leftChild == node) {
                node.parent.leftChild = leftChild;
            }
//            将leftChild的右节点指向node
            leftChild.rightChild = node;
//            将node的父节点指向leftChild
            node.parent = leftChild;
            return leftChild;
        }
        return null;
    }

    public AVLNode leftRotation(AVLNode node) {
        if (node != null) {
            AVLNode rightChild = node.rightChild;
            node.rightChild = rightChild.leftChild;
            if (rightChild.leftChild != null) {
                rightChild.leftChild.parent = node;
            }
            rightChild.parent = node.parent;
            if (node.parent == null) {
                this.root = rightChild;
            } else if (node.parent.rightChild == node) {
                node.parent.rightChild = rightChild;
            } else if (node.parent.leftChild == node) {
                node.parent.leftChild = rightChild;
            }
            rightChild.leftChild = node;
            node.parent = rightChild;
            return rightChild;
        }
        return null;
    }
}

