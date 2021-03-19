package SatAndWedClass20182020;

public class MyLinkedList<T> {
    /*
    private int size; // 1
    private WednesdayClass.MyNode head; // n1

    // Define Constructor
    public MyLinkedList(int size, WednesdayClass.MyNode head) { // (1, n1)
        this.size = size; // 1
        this.head = head; // n1
    }

    // getter and setter
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public WednesdayClass.MyNode<T> getHead() {
        return head;
    }

    public void setHead(WednesdayClass.MyNode head) {
        this.head = head;
    }

    // Add First
    public void addFirst( T item){
        WednesdayClass.MyNode newHead = new WednesdayClass.MyNode<T>(head, item);
        head = newHead;
        size++;
    }
    // Add Last
    public void addLast(T item){
        if(head == null){
            addFirst(item);
        } else {
            WednesdayClass.MyNode<T> tmp = head;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new WednesdayClass.MyNode<T>(null, item);
        }
        size++;
    }

    // Insert Before
    public void insertBefore(T item, int position){
        if(position < 0 || position > size) {
            throw new RuntimeException("invalid position");
        }
        WednesdayClass.MyNode<T> tmp = head;
        int index = 0;
        while(index<position-1 ) {
            tmp = tmp.next;
            index++;
        }
        if(tmp != null){
            tmp.next = new WednesdayClass.MyNode<T>(tmp.next, item);
            size++;
        }

    }
    // Insert After
    public void insertAfter(T item, int position){
        if(position<0 || position > size) {
            throw new RuntimeException("invalid position");
        }

        WednesdayClass.MyNode<T> tmp = head;
        int index = 0;
        while(tmp != null && index<position ) {
            tmp = tmp.next;
            index++;
        }
        if(tmp != null) {
            tmp.next = new WednesdayClass.MyNode<T>(tmp.next, item);
            size++;
        }
    }
    // Delete, delete first node which matched
    public void delete(T target){
        if(head == null) {
            throw new RuntimeException("cannot delete");
        }
        if( head.item.equals(target) ) {
            head = head.next;
            size--;
            return;
        }
        WednesdayClass.MyNode<T> cur  = head;
        WednesdayClass.MyNode<T> prev = null;

        while(cur != null && !cur.item.equals(target) ) {
            prev = cur;
            cur = cur.next;
        }

        if(cur == null) {
            throw new RuntimeException("cannot delete");
        }

        //delete cur node
        prev.next = cur.next;
        size--;
    }
    // Search
    public WednesdayClass.MyNode<T> search(T item){
        if(head == null) {
            throw new RuntimeException("empty list.");
        }
        WednesdayClass.MyNode<T> temp = head;
        while(temp != null){
            if(temp.item.equals(item)){
                return temp;
            }
            temp = temp.next;
        }
        return new WednesdayClass.MyNode(null, null);
    }

    // for output format
    public String toString(){
        WednesdayClass.MyNode<T> temp = head;
        StringBuilder sb = new StringBuilder();
        while(temp != null){
            //System.out.print(temp.item.toString() + " -> ");
            sb.append(temp.item.toString());
            sb.append(" -> ");
            temp = temp.next;
        }
        sb.append("null");
        return sb.toString();
    }

     */
}
