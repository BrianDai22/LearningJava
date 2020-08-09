public class MyLinkedListMain {
    public static void main(String[] args) {
        MyNode<String> n1 = new MyNode<>(null, "abc");
        MyLinkedList myLinkedList = new MyLinkedList<>(1, n1);
        //myLinkedList.addFirst("newHead");
        myLinkedList.addLast("newHead");
        myLinkedList.insertBefore("insertbefore", 2);
        myLinkedList.delete("newHead");
        MyNode<String> res =  myLinkedList.search("ac");
        System.out.println(myLinkedList.toString());
        System.out.println(myLinkedList.getSize());
        System.out.println(res.item);
    }
}
