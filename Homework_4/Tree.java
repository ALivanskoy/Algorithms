import java.util.Random;

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node treeBuild(int n) {
        Node node = null;
        if (n == 0)
            return node;
        else {
            node = new Node(new Random().nextInt(100));
            node.leftChild = treeBuild(n / 2);
            node.rightChild = treeBuild(n - n / 2 - 1);
        }
        return node;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (value < current.data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean search(int value) {
        Node current = root;
        while (current != null) {
            if (current.data == value) {
                return true;
            } else if (current.data > value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return false;
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.leftChild);
            System.out.print(node.data + " ");
            inOrderTraversal(node.rightChild);
        }
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        } else {
            int leftHeight = height(node.leftChild);
            int rightHeight = height(node.rightChild);
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root);
        return sb.toString();
    }

    private class Node {
        int data;
        Node leftChild;
        Node rightChild;

        public Node(int data) {
            this.data = data;
            leftChild = null;
            rightChild = null;
        }
    }
}
