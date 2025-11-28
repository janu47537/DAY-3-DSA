class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLLMethods {
    private Node head = null;
    private Node tail = null;

    // Add at end
    public void addEnd(int data) {
        Node newNode = new Node(data);

        if (tail == null) {       // list empty
            head = tail = newNode;
            return;
        }

        tail.next = newNode;      // FIXED error here
        newNode.prev = tail;
        tail = newNode;
    }

    // Add at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No data");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display backward
    public void displayBackward() {
        if (tail == null) {
            System.out.println("No data");
            return;
        }

        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // Delete last
    public void deleteLast() {
        if (tail == null) {
            System.out.println("No data");
            return;
        }

        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null;   // list empty now
        }
    }

    // Delete first
    public void deleteFirst() {
        if (head == null) {
            System.out.println("No data");
            return;
        }

        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {

        DoublyLLMethods a = new DoublyLLMethods();

        a.addFirst(10);
        a.addFirst(20);
        a.addFirst(30);

        a.displayForward();   // 30 -> 20 -> 10 -> null
        a.displayBackward();  // 10 -> 20 -> 30 -> null

        a.deleteLast();
        a.deleteFirst();
        a.displayForward();   // 30 -> 20 -> null
    }
}
