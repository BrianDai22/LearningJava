//Given a linked list, determine if it has a cycle in it.

import java.util.HashSet;
import java.util.Set;

class ListNodev2 {
      int val;
      ListNodev2 next;
      ListNodev2(int x) {
          val = x;
          next = null;
      }
  }
 
public class CircleList {

    public static boolean hasCycle(ListNodev2 head) {
        ListNodev2 fakeHead = head;
        Set<ListNodev2> duplicateChecker = new HashSet<>();
        while(fakeHead != null) {
            if(duplicateChecker.contains(fakeHead.next)) {
                return true;
            } else {
                duplicateChecker.add(fakeHead.next);
            }
            fakeHead = fakeHead.next;
        }

        return false;
    }

    public static void main(String[] args){
    // create test case by yourself
        ListNodev2 a1 = new ListNodev2(2);
        ListNodev2 a2 = new ListNodev2(2);
        ListNodev2 a3 = new ListNodev2(2);
        ListNodev2 a4 = new ListNodev2(2);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next = a2;

        System.out.println(hasCycle(a1));

    }

}