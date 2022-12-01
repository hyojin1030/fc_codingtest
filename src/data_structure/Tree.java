package data_structure;

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

    public boolean delete(int value) {
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        // 예외 케이스1 : Node가 하나도 없을 때
        if (this.head == null){
            return false;
        } else {
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                // 예외 케이스2 : Node가 하나만 있고 해당 Node가 삭제할 Node일 때
                this.head = null;
                return true;
            }

            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if (searched == false) {
                return false;
            }
        }

        if (currNode.left == null && currNode.right == null) {
            // Case1: 삭제할 Node가 Leaf Node인 경우
            if (value < currParentNode.value) {
                currParentNode.left = null;
                currNode = null;
            } else {
                currParentNode.right = null;
                currNode = null;
            }
            return true;
        } else if (currNode.left != null && currNode.right == null) {
            // Case2-1 : 삭제할 Node가 Child Node를 1개 가지고 있는 경우 - left
            if (value < currParentNode.value) {
                currParentNode.left = currNode.left;
                currNode = null;
            } else {
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
        } else if (currNode.left == null && currNode.right != null) {
            // Case2-2 : 삭제할 Node가 Child Node를 1개 가지고 있는 경우 - right
            if (value < currParentNode.value) {
                currParentNode.left = currNode.right;
                currNode = null;
            } else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;
        } else {
            // Case3 : 삭제할 Node가 Child data_structure.Node 2개 다 가지고 있음
            if (value < currParentNode.value) {
            // Case3-1 : 삭제할 Node가 부모 Node의 왼쪽
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;

                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode= changeNode.left;
                }

                // changeNode에는 삭제할 Node의 오른쪽 data_structure.Node 중에서 가장 작은 값을 가진 Node가 들어있음
                if (changeNode.right != null) {
                    // Case3-1-1 : changeNode의 오른쪽 childNode가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case3-1-2 : changeNode의 childNode가 없을 때
                    changeParentNode.left = null;
                }

                //currParentNode의 왼쪽 child Node에 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode를 연결
                currParentNode.left = changeNode;
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;

                currNode = null;

            } else {
                // Case3-1 : 삭제할 Node가 부모 Node의 오른쪽
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;

                while(changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                if (changeNode.right != null) {
                    changeParentNode.left = changeNode.right;
                } else {
                    changeParentNode.left = null;
                }

                currParentNode.right = changeNode;
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;

                currNode = null;

            }
        }

        return searched;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertNode(10);
        tree.insertNode(7);
        tree.insertNode(6);
        tree.insertNode(8);
        tree.insertNode(15);
        tree.insertNode(13);
        tree.insertNode(11);
        tree.insertNode(14);
        tree.insertNode(18);
        tree.insertNode(16);
        tree.insertNode(17);
        tree.insertNode(19);

        tree.delete(15);

        System.out.println(String.valueOf(tree.head.right.value));
    }
}
