
public class DoubleLinkedListWithTail {
    Node head, tail;

    public DoubleLinkedListWithTail() {
        head = null;
        tail = null;
    }

    // Insert node at the beginning
    public void insertAtBeginning(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert node at the end
    public void insertAtEnd(String name) {
        Node newNode = new Node(name);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove node from the beginning
    public void removeFromBeginning() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // List became empty
            }
        }
    }

    // Remove node from the end
    public void removeFromEnd() {
        if (tail == null) {
            System.out.println("The list is empty.");
        } else {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null; // List became empty
            }
        }
    }
    // Print all nodes
    public void printAll() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.name + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        DoubleLinkedListWithTail list = new DoubleLinkedListWithTail();
        // Testing the list
        list.insertAtBeginning("Node1");
        list.insertAtEnd("Node2");
        list.insertAtEnd("Node3");
        System.out.println("List after insertions:");
        list.printAll(); // Output: Node1 Node2 Node3
        list.removeFromBeginning();
        System.out.println("List after removing from beginning:");
        list.printAll(); // Output: Node2 Node3
        list.removeFromEnd();
        System.out.println("List after removing from end:");
        list.printAll(); // Output: Node2
    }
}
