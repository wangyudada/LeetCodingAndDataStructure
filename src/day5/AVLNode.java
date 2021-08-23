package day5;

import java.util.LinkedList;
import java.util.Queue;

public class AVLNode {

    public AVLNode parent;
    public AVLNode leftChild, rightChild;
    public int data;
    private AVLNode root;
    private final int LEFT = 1;
    private final int RIGHT = -1;
    private final int MAX_LEFT = 2;
    private final int MAX_RIGHT = -2;

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

    /**
     * 左旋转
     * @param node
     * @return
     */
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

    public void put(int data) {
        putData(root, data);
    }

    /**
     * 插入数据
     * @param node
     * @param data
     * @return
     */
    private boolean putData(AVLNode node, int data) {
        if (node == null) {
            node = new AVLNode(data);
            root = node;
            return true;
        }
        int i;
        AVLNode p;
        AVLNode temp = node;
        do {
            p = temp;
            i = temp.data - data;
            if (i < 0) {
                temp = temp.rightChild;
            } else if (i > 0) {
                temp = temp.leftChild;
            } else {
                return false;
            }
        } while (temp != null);
        if (i < 0) {
            p.rightChild = new AVLNode(p, data);
        } else if (i > 0) {
            p.leftChild = new AVLNode(p, data);
        }
        rebuild(p);
        return true;
    }

    /**
     * 平衡二叉树的方法
     *
     * @param node
     */
    public void rebuild(AVLNode node) {
        while (node != null) {
            if (calcNodeBalanceValue(node) == MAX_LEFT) {//左子树高
                fixAfterInsertion(node, LEFT);
            } else if (calcNodeBalanceValue(node) == MAX_RIGHT){//右子树高
                fixAfterInsertion(node, RIGHT);
            }
            node = node.parent;
        }
    }

    /**
     * 计算node节点的BF值
     *
     * @param node
     * @return
     */
    public int calcNodeBalanceValue(AVLNode node) {
        if (node != null) {
            return getHeightByNode(node);
        }
        return 0;
    }

    private int getHeightByNode(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return getChildDepth(node.leftChild) - getChildDepth(node.rightChild);
    }

    private int getChildDepth(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getChildDepth(node.leftChild), getChildDepth(node.rightChild));
    }

    /**
     * 调整树的结构
     *
     * @param node
     * @param type
     */
    public void fixAfterInsertion(AVLNode node, int type) {
        if (type == LEFT) {
            AVLNode leftChild = node.leftChild;
            if (leftChild.leftChild != null) {  //右旋
                rightRotation(node);
            } else if (leftChild.rightChild != null) {   //左右旋
                leftRotation(leftChild);
                rightRotation(node);
            }
        } else if (type == RIGHT) {
            AVLNode rightChild = node.rightChild;
            if (rightChild.rightChild != null) {   //左旋
                leftRotation(node);
            } else if (rightChild.leftChild != null) {   //右左旋
                rightRotation(rightChild);
                leftRotation(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void middOrderErgodic() {
        this.middOrderErgodic(this.root);
    }

    public void middOrderErgodic(AVLNode node) {
        if (node != null) {
            this.middOrderErgodic(node.leftChild);
            System.out.print(node.data + ", ");
            this.middOrderErgodic(node.rightChild);
        }
    }

    /**
     * 获得指定节点
     *
     * @param key
     * @return
     */
    public AVLNode getNode(int key) {

        AVLNode node = root;
        int t;
        do {
            t = node.data - key;
            if (t > 0) {
                node = node.leftChild;
            } else if (t < 0) {
                node = node.rightChild;
            } else {
                return node;
            }
        } while (node != null);
        return null;
    }

    /**
     * 层序遍历
     */
    public void sequenceErgodic() {
        if (this.root == null) {
            return;
        }
        Queue<AVLNode> queue = new LinkedList<>();
        AVLNode temp = null;
        queue.add(this.root);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.println("当前节点值：" + temp.data + ", BF：" + calcNodeBalanceValue(temp));
            if (temp.leftChild != null) {
                queue.add(temp.leftChild);
            }
            if (temp.rightChild != null) {
                queue.add(temp.rightChild);
            }
        }
    }

    /***
     * 获得指定节点的后继
     * 找到node节点的后继节点
     * 1、先判断该节点有没有右子树，如果有，则从右节点的左子树中寻找后继节点，没有则进行下一步
     * 2、查找该节点的父节点，若该父节点的右节点等于该节点，则继续寻找父节点，
     *   直至父节点为Null或找到不等于该节点的右节点。
     * 理由:
     *      后继节点一定比该节点大，若存在右子树，则后继节点一定存在右子树中，这是第一步的理由
     *      若不存在右子树，则也可能存在该节点的某个祖父节点(即该节点的父节点，或更上层父节点)的右子树中，
     *      对其迭代查找，若有，则返回该节点，没有则返回null
     * @param node
     * @return
     */
    public AVLNode getSuccessor(AVLNode node) {
        if (node.rightChild != null) {
            AVLNode rightChild = node.rightChild;
            while (rightChild.leftChild != null) {
                rightChild = rightChild.leftChild;
            }
            return rightChild;
        }
        AVLNode parent = node.parent;
        while (parent != null && (node == parent.rightChild)) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    /**
     * 删除指定val值的节点
     *
     * @param val
     * @return
     */
    public boolean delete(int val) {
        AVLNode node = getNode(val);
        if (node == null) {
            return false;
        }
        boolean flag = false;
        AVLNode p = null;
        AVLNode parent = node.parent;
        AVLNode leftChild = node.leftChild;
        AVLNode rightChild = node.rightChild;
        if (leftChild == null && rightChild == null) {
            if (parent != null) {
                if (parent.leftChild == node) {
                    parent.leftChild = null;
                } else if (parent.rightChild == node) {
                    parent.rightChild = null;
                }
            } else {
                this.root = null;
            }

            p = parent;
            node = null;
            flag = true;
        } else if (leftChild == null && rightChild != null) {
            if (parent != null && parent.data > val) {
                parent.leftChild = rightChild;
            } else if (parent != null && parent.data < val) {
                parent.rightChild = rightChild;
            } else {
                this.root = rightChild;
            }
            p = parent;
            node = null;
            flag = true;
        } else if (leftChild != null && rightChild == null) {
            if (parent != null && parent.data > val) {
                parent.leftChild = leftChild;
            } else if (parent != null && parent.data < val) {
                parent.rightChild = leftChild;
            } else {
                this.root = leftChild;
            }

            p = parent;
            node = null;
            flag = true;
        } else if (leftChild != null && rightChild != null) {
            AVLNode successor = getSuccessor(node);
            int tempData = successor.data;
            if (delete(tempData)) {
                node.data = tempData;
            }
            p = successor;
            successor = null;
            flag = true;
        }

        if (flag) {
            this.rebuild(p);
        }
        return flag;
    }
}

