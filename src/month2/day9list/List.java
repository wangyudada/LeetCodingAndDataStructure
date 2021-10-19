package month2.day9list;

public class List {
    private Node head = new Node(0, "头节点");

    public Node getHead() {
        return this.head;
    }

    //    在尾结点添加
    public void append(Node node) {
        Node tempNode = head;
        while (true) {
            if (tempNode.next == null) {
                break;
            }
            tempNode = tempNode.next;
        }
        tempNode.next = node;
    }

    //    展示所有的数据
    public void list() {
        if (head.next == null) {
            System.out.println("空链表");
            return;
        }
        Node tempNode = head;
        while (true) {
            if (tempNode.next == null) {
                break;
            }
            System.out.println(tempNode);
            tempNode = tempNode.next;
        }
    }

    //    随机插入
    public void insert(Node node) {
        Node tempNode = head;
        boolean flag = false;
        while (true) {
            if (tempNode.next == null) {
                return;
            }
            if (tempNode.next.no > node.no) {
                break;
            } else if (tempNode.next.no == node.no) {
                flag = true;
            }
            tempNode = tempNode.next;
        }
        if (flag) {
            System.out.println("已经存在了该节点，不可添加");
        } else {
            node.next = tempNode.next;
            tempNode.next = node;
        }
    }

    public void delete(int no) {
        Node tempNode = head;
        boolean flag = false;
        while (true) {
            if (tempNode.next == null) {
                return;
            }
            if (tempNode.next.no == no) {
                flag = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (flag) {
            tempNode.next = tempNode.next.next;
        } else {
            System.out.println("该" + no + "节点不存在");
        }
    }
}
