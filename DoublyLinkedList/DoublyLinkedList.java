package DoublyLinkedList;

public class DoublyLinkedList {
    Node head =  null;

    void addToEnd(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = n;
            n.prev = curr;
        }
    }

    void addToStart(int data) {
        Node n = new Node(data);
        if (head != null) {
            head.prev = n;
            n.next = head;
        }
        head = n;
    }

    void deleteLast() {
        Node toDelete = head;
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        while (toDelete.next != null) {
            toDelete = toDelete.next;
        }
        toDelete.prev.next = null;
    }

    void deleteStart() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void displayList() {
        Node curr = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Print Doubly Linked List: ");

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addToEnd(10);
        dll.addToEnd(15);
        dll.addToEnd(5);
        dll.addToEnd(25);

        dll.displayList();

        dll.addToStart(20);
        dll.addToStart(2);

        dll.displayList();
        dll.deleteLast();
        dll.displayList();
        dll.deleteStart();
        dll.displayList();
    }
}
