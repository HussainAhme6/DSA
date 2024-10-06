public class DoubleLinkedList {
    Node head;

    //addFront name
    void addFirst(String name){
        Node newNode=new Node(name);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    //addFront Node
    void addFirst(Node node){
        if(head==null){
            head=node;
            return;
        }
        node.next=head;
        head.prev=node;
        head=node;
    }
    //addLast name
    void addBack(String name){
        Node newNode=new Node(name);
        if(head==null){
            head=newNode;
            return;
        }
        else {
            Node temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.prev=temp;
        }
    }
    //add last node
    void addBack(Node node){
        if(head==null){
            head=node;
        }
        else {
            Node temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
            node.prev=temp;
        }
    }

    //addName after given parameters
    void addAfterName(String name, Node node){
        Node temp=head;
        while (temp!=null && !temp.name.equals(name)){
            temp=temp.next;
        }
        if(temp!=null){
            Node nextNode = temp.next;
            temp.next = node;
            node.prev = temp;
            node.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = node;
            }
        }
        else {
            System.out.println("Node with name " + name + " not found.");
        }
    }

    //addName before given parameters
    public void addBeforeName(String name, Node node) {
        Node temp = head;
        while (temp != null && !temp.name.equals(name)) {
            temp = temp.next;
        }
        if (temp != null) {
            Node prevNode = temp.prev;
            if (prevNode != null) {
                prevNode.next = node;
                node.prev = prevNode;
            } else {
                head = node;
            }
            node.next = temp;
            temp.prev = node;
        } else {
            System.out.println("Node with name " + name + " not found.");
        }
    }
    // Make the linked list circular
    public void makeCircular() {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head.prev = temp;
    }


    //print list method
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.name + " ");
            temp = temp.next;
        } while (temp != null && temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addFirst("Node1");
        list.addBack("Node3");
        list.addBack("Node4");
        list.addAfterName("Node1", new Node("Node2"));
        list.addBeforeName("Node4", new Node("Node3.5"));

        System.out.println("Doubly Linked List:");
        list.printList();

        list.makeCircular();
        System.out.println("Circular Doubly Linked List:");
        list.printList();
    }
}
