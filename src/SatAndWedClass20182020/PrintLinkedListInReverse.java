package SatAndWedClass20182020;

public class PrintLinkedListInReverse
{
    //Node class
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    static Node head;  // head of list

    void printReverse(Node head)
    {
        // TODO
        if (head == null) {
            return;
        }

        printReverse(head.next);

        System.out.print(head.data + " ");
    }


    // Inserts a new Node at front of the list.
    // for creating linked list
    public void insertBefore(int val)
    {
        // TODO
        Node newNode = new Node(val);

        newNode.next = head;

        head = newNode;

    }

    /*Driver function to test the above methods*/
    public static void main(String args[])
    {
        //create linked list 1->2->3->4->null
        PrintLinkedListInReverse linkedList = new PrintLinkedListInReverse();
        linkedList.insertBefore(4);
        linkedList.insertBefore(3);
        linkedList.insertBefore(2);
        linkedList.insertBefore(1);

        linkedList.printReverse(head); // 4 3 2 1
    }
}
/*

        print Linked List in SatAndWedClass20182020.Reverse order.
        You don't need to actually reverse the list.

        use both non-recursive and recursive ways.

        Example :

        input:
        1->2->3->4->5->6->null

        output:

        print "6 5 4 3 2 1"
*/
