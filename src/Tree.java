public class Tree {
    Node head = null;
    public class Node {
        Node left;
        Node right;
        int value;
        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
        // CASE1 : Node가 하나도 없는 경우
        if(head == null) {
            this.head = new Node(data);
        } else {
            // CASE2 : Node가 하나 이상 들어가 있는 경우
            Node findNode = this.head;
            while (true) {
                // CASE2-1 : 현재 Node의 왼쪽에 데이터 추가
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                } else {
                    // CASE2-2 : 현재 Node의 오른쪽에 데이터 추가
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int data) {
        // CASE1 : Node가 하나도 없는 경우
        if(this.head == null) return null;
        // CASE2 : Node가 하나 이상 들어가 있는 경우
        else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value){
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertNode(1);
        tree.insertNode(2);
        tree.insertNode(3);

        Node testNode = tree.search(2);
        System.out.println(String.valueOf(testNode.right.value));
    }
}
