package SatAndWedClass20182020;

public class MyNode<T> { // Generic, T == Integer, or T == String
     T item;
     MyNode<T> next;

    // Constructor
    // 1. No Return type, eg. No void, int, String...
    // 2. The name must be same as class name
    // 3. must be a method
   public MyNode(MyNode next, T item){
       this.item = item;
       this.next = next;
   }

   public MyNode(){}

   // getter and setter
    public T getItem(){
       return item;
    }

    public MyNode getNext(){
       return next;
    }
    public void setItem(T item){
       this.item = item;
    }

    public void setNext(MyNode next){
       this.next = next;
    }



    // not a constructor!!
//    public void MyNode1(WednesdayClass.MyNode<T> next, T item){
//        this.item = item;
//        this.next = next;
//    }
}
