package SinglyLinkedList;

public class CircularSinglyLinkedList {
    Node last = null;

    void addToStart(int data) {
        Node n = new Node(data);
        if (last == null) {
            n.next = n;
            last = n;
        } else {
            n.next = last.next;
            last.next = n;
        }
    }

    void addToEnd(int data) {
        Node n = new Node(data);
        if (last == null) {
            n.next = n;
        } else {
            n.next = last.next;
            last.next = n;
        }
        last = n;
    }

    Node deleteLast() {
        Node toDelete = last;
        if (last == null || last.next == last) {
            last = null;
            return toDelete;
        }
        Node prev = last.next;
        while (prev.next != last) {
            prev = prev.next;
        }
        prev.next = last.next;
        last = prev;
        return toDelete;
    }

    Node deleteStart() {
        Node toDelete = last;
        if (last == null || last.next == last) {
            last = null;
            return toDelete;
        }
        toDelete = last.next;
        last.next = toDelete.next;
        return toDelete;
    }

    public void displayList() {
        System.out.println("Print Singly Linked List: ");
        if (last == null) {
            System.out.println("null");
            return;
        }
        Node temp = last.next;
        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (temp != last.next);
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.addToEnd(5);
        csll.addToEnd(2);
        csll.addToStart(14);
        csll.displayList();
//        csll.addToEnd(6);
//        csll.addToStart(1);
//        csll.deleteLast();
        csll.deleteStart();

        csll.displayList();
    }
}
