public class GenericLinkedList<T> {
    Node<T> head;

    GenericLinkedList(){
        this.head=null;
    }

    public void addBack(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void remove(T keys){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }

        if(head.data.equals(keys)){
            head=head.next;
            return;
        }

        Node<T> temp=head;
        while (temp.next!=null && !temp.next.data.equals(keys)){
            temp=temp.next;
        }

        if(temp.next!=null){
          temp.next=temp.next.next;
        }
        else {
            System.out.println("Element not found");
        }
    }

    public void print(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node<T> temp=head;
        while (temp!=null){
            System.out.print(temp.data+ " -> ");
            temp=temp.next;
        }

        System.out.println("null");
    }

    public boolean search(T key){
        Node<T> temp=head;
        while (temp!=null){
            if(temp.data.equals(key)){
            return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        GenericLinkedList<Integer> intList=new GenericLinkedList<>();
        intList.addBack(10);
        intList.addBack(20);
        intList.addBack(30);
        System.out.println("Integer LinkedList");
        intList.print();

        GenericLinkedList<String> stringList=new GenericLinkedList<>();
        stringList.addBack("apple");
        stringList.addBack("Banana");
        stringList.addBack("cherry");
        System.out.println("String LInked List: ");
        stringList.print();

        boolean found=stringList.search("Banana");
        System.out.println("Is Banana found? "+ found);

        stringList.remove("Banana");
        System.out.println("After deleting Banana");
        stringList.print();
    }
}

