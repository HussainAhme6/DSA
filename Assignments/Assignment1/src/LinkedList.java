public class LinkedList {
    Node head;

    // Method 1: Find the nth node from the end of the linked list
    public int nthFromLast(int n) {
        if (head == null) {
            return -1; // LIST_EMPTY case
        }

        Node first = head, second = head;

        // Move the first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first == null) {
                return -1; // If n is greater than the number of nodes
            }
            first = first.next;
        }

        // Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.data; // The second pointer is at the nth node from the end
    }

    // Method 2: Sort the linked list by swapping nodes
    public void sort() {
        if (head == null) {
            System.out.println("LIST_EMPTY"); // Case-1: List is empty
            return;
        }

        boolean swapped;
        Node ptr1;
        Node lptr = null; // Last node that was already sorted

        // Bubble sort algorithm by swapping nodes
        do {
            swapped = false;
            ptr1 = head;

            while (ptr1.next != lptr) {
                if (ptr1.data > ptr1.next.data) {
                    // Swap the nodes
                    int temp = ptr1.data;
                    ptr1.data = ptr1.next.data;
                    ptr1.next.data = temp;
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        } while (swapped);
    }

    // Method 3: Reverse the linked list
    public void reverse() {
        if (head == null) {
            System.out.println("LIST_EMPTY"); // Case-1: List is empty
            return;
        }

        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move pointers one position ahead
            current = next;
        }
        head = prev; // Update head to the new first node
    }

    // Method 4: Remove duplicates from the linked list
    public void removeDuplicates() {
        if (head == null) {
            System.out.println("LIST_EMPTY"); // Case-1: List is empty
            return;
        }

        Node current = head;

        while (current != null) {
            Node runner = current;

            // Compare current node with the rest of the list
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next; // Remove duplicate
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    // Helper function to add nodes to the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Helper function to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(50);
        list.add(40);
        list.add(30);
        list.add(20);
        list.add(10);

        System.out.println("Original List:");
        list.printList();

        // Method 1: Finding the 2nd node from the end
        int n = 2;
        int result = list.nthFromLast(n);
        if (result != -1) {
            System.out.println("The " + n + "th node from the end is: " + result);
        } else {
            System.out.println("List is empty or n is greater than the number of nodes.");
        }

        // Method 2: Sorting the list
        list.sort();
        System.out.println("Sorted List:");
        list.printList();

        // Method 3: Reversing the list
        list.reverse();
        System.out.println("Reversed List:");
        list.printList();

        // Adding duplicates to demonstrate Method 4
        list.add(20);
        list.add(10);
        list.add(30);

        System.out.println("List with duplicates:");
        list.printList();

        // Method 4: Removing duplicates
        list.removeDuplicates();
        System.out.println("List after removing duplicates:");
        list.printList();
    }
}
