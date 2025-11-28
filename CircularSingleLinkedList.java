class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularSingleLinkedListMethods {
    private Node head = null;

    // Insert at end
    public void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;   // Circular link
            return;
        }

        Node temp = head;
        while (temp.next != head) {  
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;   // Maintain circle
    }
    //insert at first
     public void insertAtFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;   // Circular link
            return;
        }

        Node temp = head;
        while (temp.next != head) {  
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;  
        head=newNode; // Maintain circle
    }
    //insert by position
   public void insertByposition(int data, int pos) {
    Node newNode = new Node(data);

    if (pos == 1) {
        insertAtFirst(data);
        return;
    }

    Node temp = head;
    for (int i = 1; i < pos - 1; i++) {
        temp = temp.next;
        if (temp == head) {
            System.out.println("Position out of bounds");
            return;
        }
    }

    newNode.next = temp.next;
    temp.next = newNode;
}
// Delete first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        if (head.next == head) { // Only one node
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != head) { // Go to last node
            temp = temp.next;
        }

        head = head.next; // Move head
        temp.next = head; // Update last node to point to new head
    }

    // Delete last node
    public void deleteEndNode() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        if (head.next == head) { // Only one node
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != head) { // Stop at second last node
            temp = temp.next;
        }

        temp.next = head; // Remove last node
    }
    //Delete By Position
    public void deleteByPosition(int position){
        if(head==null){
            System.out.println("No Data");
            return;
        }
        if(head.next==head){
            head=null;
            return;
        }
        Node temp=head;
        int count=0;
        while(count<position-1 && temp.next!=head){
            temp=temp.next;
            count++;

        }
        if(temp.next==head){
            System.out.println("position out of bounds");
            return;
        }
        temp.next=temp.next.next;

    }


    // Display
    public void display() {
        if (head == null) {
            System.out.println("No data");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }
}
public class CircularSingleLinkedList {
    public static void main(String[] args) {
        CircularSingleLinkedListMethods list = new CircularSingleLinkedListMethods();

        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertAtFirst(5);
        list.insertByposition(10,1);
        list.deleteFirst();
        list.deleteEndNode();
        list.deleteByPosition(2);
        list.display();
    }
}