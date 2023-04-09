import java.util.Random;

public class Tree {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public Tree() {
        root = null;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node treeBuild(int n) {
        Node node = null;
        if (n == 0) return node;
        else {
            node = new Node(new Random().nextInt(100));
            node.leftChild = treeBuild(n / 2);
            node.rightChild = treeBuild(n - n / 2 - 1);
        }
        return node;
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

    public void insert(int value) {
        root = insert(root, value);
        root.setBlack();
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            node.leftChild = insert(node.leftChild, value);
        } else if (value > node.data) {
            node.rightChild = insert(node.rightChild, value);
        } else {
            // элемент уже существует
            return node;
        }

        // проверка нарушения свойств красно-чёрного дерева
        if (node.rightChild != null && node.rightChild.isRed() && node.leftChild != null && node.leftChild.isBlack()) {
            node = rotateLeft(node);
        }
        if (node.leftChild != null && node.leftChild.isRed() && node.leftChild.leftChild != null && node.leftChild.leftChild.isRed()) {
            node = rotateRight(node);
        }
        if (node.leftChild != null && node.leftChild.isRed() && node.rightChild != null && node.rightChild.isRed()) {
            flipColors(node);
        }

        return node;
    }

    private Node rotateLeft(Node node) {
        Node x = node.rightChild;
        node.rightChild = x.leftChild;
        x.leftChild = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.leftChild;
        node.leftChild = x.rightChild;
        x.rightChild = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.leftChild.color = BLACK;
        node.rightChild.color = BLACK;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root);
        return sb.toString();
    }

    private class Node {
        int data;
        boolean color;
        Node leftChild;
        Node rightChild;

        public Node(int data) {
            this.data = data;
            leftChild = null;
            rightChild = null;
            color = RED;
        }

        public boolean isRed() {
            return color == RED;
        }

        public boolean isBlack() {
            return color == BLACK;
        }

        public void setRed() {
            color = RED;
        }

        public void setBlack() {
            color = BLACK;
        }
    }
}
