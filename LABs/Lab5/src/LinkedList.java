public class LinkedList {
    Node head;

    //Add from back
    public void addFromBack(int data){
        Node newNode=new Node(data);
        if (head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    //reverse Nodes
    void reversed(){
        Node previous=null;
        Node current=head;
        Node next=null;
        if(head==null){
            System.out.println("List id empty");
            return;
        }
        while(current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head=previous;
    }

    void print(){
        if (head==null){
            return;
        }
        Node temp=head;
        while (temp!=null){
            System.out.print(", "+temp.data);
            temp=temp.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        LinkedList ll=new LinkedList();

        ll.addFromBack(12);
        ll.addFromBack(21);
        ll.addFromBack(5);
        ll.addFromBack(3);
        ll.print();

        ll.reversed();
        ll.print();
    }

}
