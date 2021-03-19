package SatAndWedClass20182020;

public class ReverseLinkedListInPlace {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    // non-recursive way
    public Node reverseNonRecursive(Node node) {
        Node prev = null;
        Node current = node;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // recursive way
    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node rest = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public void insertBefore(int val) {
        Node newNode = new Node(val);

        newNode.next = head;

        head = newNode;
    }

    // prints linked list
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // *********** test case 1
        ReverseLinkedListInPlace list = new ReverseLinkedListInPlace();
        list.insertBefore(4);
        list.insertBefore(3);
        list.insertBefore(2);
        list.insertBefore(1);


        list.printList(list.head);
        list.head = list.reverseNonRecursive(list.head);
        System.out.println("");
        System.out.println("Reversed linked list in non-recursive way");
        list.printList(list.head);

        // ********** test case 2

        ReverseLinkedListInPlace list2 = new ReverseLinkedListInPlace();
        list2.insertBefore(8);
        list2.insertBefore(7);
        list2.insertBefore(6);
        list2.insertBefore(5);

        list2.printList(list2.head);
        list2.head = list2.reverseRecursive(list2.head);
        System.out.println("");
        System.out.println("Reversed linked list in recursive way");
        list2.printList(list2.head);
    }
}