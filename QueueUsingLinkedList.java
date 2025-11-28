class Node{
    int data;
    Node next;
    Node(int data)
    {
         this.data=data;
         this.next=null;
    }
}
class QueueMethods{
    private Node front=null;
    private Node rear=null;

public void enqueue(int data)
{
    Node newNode=new Node(data);
    if(rear == null){
        rear=front=newNode;
        return;
    }
    rear.next=newNode;
    rear=newNode;
}
public void dequeue(){
    if(front==null){
        System.out.println("Queue is empty");
        return;
    }
    front=front.next;
    if(front==null){
        rear=null;
    }
}
public void display()
    {
        Node temp=front;
        if(front==null)
        {
            System.out.println("Queue is empty");
            return;
        }
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null"+"\n");
    }
}

public class QueueUsingLinkedList {
    public static void main(String[]args){
        QueueMethods a=new QueueMethods();
        a.enqueue(10);
        a.enqueue(20);
        a.enqueue(30);
        a.enqueue(40);
        a.enqueue(50);
        a.dequeue();
        a.dequeue();
        a.display();
    }
    
}
