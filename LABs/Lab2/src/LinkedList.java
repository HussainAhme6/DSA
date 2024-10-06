class Node{
    int data;

    Node next;
    public Node(int data){
        this.data=data;
        next=null;
        LinkedList.size++;
    }
}
public class LinkedList {
    Node head;
    public static int size=0;

    //Add value from front
    public void addFromFront(int data){
        Node newNode=new Node(data);
        if (head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    //Add value from back
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

    //Printing the list
    public void printList(){
        if(head==null){
            System.out.println(" List is Empty ");
            return;

        }
        Node temp=head;
        while (temp.next!=null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
        System.out.println(temp.data);
    }

    //searching of element
    public void searchForElement(int num){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        Node temp=head;
        int index=0;
        while (temp.next!=null){
            if(num == temp.data){
                System.out.println("Element found at "+index+" index");
                break;
            }
            index++;
            temp=temp.next;
        }
    }

    //length of linked list
    public void lengthOfList(){
        System.out.println("length of Linked_List : "+ size);
    }


}
/*


 */