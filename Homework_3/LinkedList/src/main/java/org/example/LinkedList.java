package org.example;

import java.util.Iterator;

public class LinkedList {

    private Node head;
    private Node tail;


    private static class Node implements Iterator {
        private final Integer value;
        private Node nextNode;
        private Node previousNode;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }

        @Override
        public boolean hasNext() {

            if (nextNode != null)
                return true;
            else return false;
        }

        @Override
        public Node next() {
            return nextNode;
        }
    }

    public Node findNode(int value) {
        Node node = head;
        while (node.nextNode != null) {
            node = node.nextNode;
            if (node.value == value) {
                return node;
            }
        }
        return null;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.nextNode = node;
            node.previousNode = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) {
        Node next = node.nextNode;
        Node newNode = new Node(value);
        node.nextNode = newNode;
        if (next == null) {
            tail = newNode;
        } else {
            next.previousNode = newNode;
            newNode.nextNode = next;
        }
    }

    public void revert() {

        Node node = head;

        while (node != null) {
            System.out.println("чпок");

            Node next = node.nextNode;
            Node previous = node.previousNode;
            node.nextNode = previous;
            node.previousNode = next;
            if (previous == null) tail = node;
            if (next == null) head = node;
            node = next;
        }
    }

    @Override
    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder("[");

        do {
            sb.append(node);
            if (node.nextNode != null) sb.append(", ");
            node = node.nextNode;
        } while (node.hasNext());

        sb.append("]");
        return sb.toString();
    }
}
